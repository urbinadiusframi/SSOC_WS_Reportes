package co.gov.ssoc.gedess.sgd.cfg.security;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import co.gov.ssoc.gedess.sgd.cfg.Constantes;
import co.gov.ssoc.gedess.sgd.cfg.security.service.AuthService;
import co.gov.ssoc.gedess.sgd.cfg.security.service.impl.JwtUtils;
import co.gov.ssoc.gedess.sgd.cfg.security.service.impl.UserDetailsServiceImpl;

public class AuthTokenFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthTokenFilter.class);
	private static final Logger LOGGER_RESPONSE = LoggerFactory.getLogger("response");

	public static final String AUDIT_ORIGIN_IP_ADDRESS = "originIpAddress";
	public static final String AUDIT_GUID_PROCESS = "guidProcess";
	public static final String AUDIT_ENTIDAD = "AUDIT_ENTIDAD";
	public static final String AUDIT_VALUE = "AUDIT_VALUE";
	public static final String AUDIT_COMPONENT = "AUDIT_COMPONENT";
	public static final String AUDIT_USER = "AUDIT_USER";
	public static final String AUDIT_USER_ID = "AUDIT_USER_ID";

	@Autowired
	private JwtUtils jwtUtils;
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthService authService;

	@Value("${sgd.admin.authentication.basic.username}")
	private String userName;

	@Value("${sgd.admin.authentication.basic.password}")
	private String password;

//	@Value("cdencia.jwt.keystore.keystoreType")
//	private String keystoreType;
//	@Value("cdencia.jwt.keystore.keystoreFilename")
//	private String keystoreFilename;
//	@Value("cdencia.jwt.keystore.keystorePassword")
//	private String keyStorePassword;
//	@Value("cdencia.jwt.keystore.alias")
//	private String alias;
//	@Value("cdencia.jwt.keystore.cnString")
//	private String cnString;
//	@Value("cdencia.jwt.keystore.rsaKeylength")
//	private Integer rsaKeylength;
//	@Value("cdencia.jwt.keystore.certificateSignatureAlgorithm")
//	private String certificateSignatureAlgorithm;
//	@Value("cdencia.jwt.keystore.certificateValidityDays")
//	private Integer certificateValidityDays;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		long start = System.currentTimeMillis();
		try {
			MDC.put(AUDIT_GUID_PROCESS, java.util.UUID.randomUUID().toString());
			MDC.put(AUDIT_ORIGIN_IP_ADDRESS, request.getRemoteAddr());
		} catch (Exception e) {
			LOGGER.error("log-audit-vars", e);
		}
		try {
			this.parseJwt(request);
		} catch (Exception e) {
			LOGGER.error("-_-Cannot set user authentication JWT", e);
		}
		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.remove(AUDIT_GUID_PROCESS);
			MDC.remove(AUDIT_ORIGIN_IP_ADDRESS);
			MDC.remove(AUDIT_USER);
			MDC.remove(AUDIT_USER_ID);
			MDC.remove(AUDIT_COMPONENT);
			LOGGER_RESPONSE.debug("[fin] {}ms", System.currentTimeMillis() - start);
		}
	}

	private void parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			String jwt = headerAuth.substring(7, headerAuth.length());
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				MDC.put(AUDIT_COMPONENT, request.getHeader(AUDIT_COMPONENT));
				MDC.put(AUDIT_USER, username);
				MDC.put(AUDIT_USER_ID, username);
			}
		} else if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Basic ")) {
			if (authService.validateBasicAuthentication(userName, password, headerAuth)) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				MDC.put(AUDIT_COMPONENT, request.getHeader(AUDIT_COMPONENT));
				MDC.put(AUDIT_USER, userName);
				MDC.put(AUDIT_USER_ID, userName);
			}
		}
	}

//	private boolean validPassword(String alias, String passwordToBeValidated) {
//		try {
//			KeyStore ks = KeyStore.getInstance(keystoreType);
//			char[] pwdArray = keyStorePassword.toCharArray();
//			FileInputStream fis = new FileInputStream(keystoreFilename);
//			ks.load(fis, pwdArray);
//			fis.close();
//			KeyStore.Entry entry = ks.getEntry(alias,
//					new KeyStore.PasswordProtection(passwordToBeValidated.toCharArray()));
//			LOGGER.info("login {} {}", alias, entry.toString());
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//
//	}
}
