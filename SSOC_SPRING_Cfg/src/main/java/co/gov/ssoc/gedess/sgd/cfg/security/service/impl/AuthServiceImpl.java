package co.gov.ssoc.gedess.sgd.cfg.security.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import co.gov.ssoc.gedess.sgd.cfg.IEnumCommonConstants;
import co.gov.ssoc.gedess.sgd.cfg.security.service.AuthService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

@Service
public class AuthServiceImpl implements AuthService {
//
//	@Value("${aia.jwt.secret}")
//	private String jwtSecret;

	@Value("${sgd.keystore.secret}")
	private String jwtSecret;

//	@Value("${sgd.keystore.keystoreFilename}")
//	private String keystoreFilename;

	public Boolean validateBasicAuthentication(String basicAuthHeaderValue) {

//		if (StringUtils.hasText(basicAuthHeaderValue)
//				&& basicAuthHeaderValue.toLowerCase().startsWith(IEnumCommonConstants.PREFIX_AUTH)) {
//			// Authorization: Basic base64credentials
//			String base64Credentials = basicAuthHeaderValue.substring(IEnumCommonConstants.PREFIX_AUTH.length()).trim();
//			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
//			String credentials = new String(credDecoded, StandardCharsets.UTF_8);
//			// credentials = username:password
//			final String[] values = credentials.split(":", 2);
//
//			if (values != null && values.length == 2) {
//				String username = values[0];
//				String password = values[1];
//				try {
//
//					KeyStore ks = KeyStore.getInstance("pkcs12");
//					char[] pwdArray = "jwtSecret.toCharArray()".toCharArray();
//					FileInputStream fis = new FileInputStream(keystoreFilename);
//					ks.load(fis, pwdArray);
//					fis.close();
//
//					KeyStore.Entry entry = ks.getEntry(username,
//							new KeyStore.PasswordProtection(password.toCharArray()));
//					return true;
//				} catch (Exception e) {
//					return false;
//				}
//			}
//		} else if (StringUtils.hasText(basicAuthHeaderValue)
//				&& basicAuthHeaderValue.toLowerCase().startsWith(IEnumCommonConstants.PREFIX_AUTH_BEARER)) {
//			String bearerJwt = basicAuthHeaderValue.substring(IEnumCommonConstants.PREFIX_AUTH_BEARER.length()).trim();
//			String jwt = getUserNameFromJwtToken(bearerJwt);
//			return (jwt != null && !jwt.isEmpty());
//		}
		return false;
	}

	@Override
	public Boolean validateBasicAuthentication(String appUserName, String appPassword, String basicAuthHeaderValue) {
		if (StringUtils.hasText(basicAuthHeaderValue)
				&& basicAuthHeaderValue.toLowerCase().startsWith(IEnumCommonConstants.PREFIX_AUTH)) {
			String base64Credentials = basicAuthHeaderValue.substring(IEnumCommonConstants.PREFIX_AUTH.length()).trim();
			byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
			String credentials = new String(credDecoded, StandardCharsets.UTF_8);
			final String[] values = credentials.split(":", 2);
			if (values != null && values.length == 2) {
				String username = values[0];
				String password = values[1];
				if (appUserName.equals(username) && appPassword.equals(password)) {
					return true;
				}
			}
		} else if (StringUtils.hasText(basicAuthHeaderValue)
				&& basicAuthHeaderValue.toLowerCase().startsWith(IEnumCommonConstants.PREFIX_AUTH_BEARER)) {
			String bearerJwt = basicAuthHeaderValue.substring(IEnumCommonConstants.PREFIX_AUTH_BEARER.length()).trim();
			String jwt = getUserNameFromJwtToken(bearerJwt);
			return (jwt != null && !jwt.isEmpty());
		}
		return false;
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public Jws<Claims> getUserRolesFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret)
				.parseClaimsJws(token.substring(IEnumCommonConstants.PREFIX_AUTH_BEARER.length()).trim());
	}

}
