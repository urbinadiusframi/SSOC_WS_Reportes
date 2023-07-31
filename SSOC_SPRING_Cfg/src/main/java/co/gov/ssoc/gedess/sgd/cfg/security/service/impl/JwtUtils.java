package co.gov.ssoc.gedess.sgd.cfg.security.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.JwtResponse;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	private static final long JWT_TOKEN_VALIDITY = 3600000; //60 * 60 * 1000;
//	private static final String FORMAT_JWT_EXPIRE_DATE= "yyyy-MM-dd hh:mm a";
	private static final String FORMAT_JWT_EXPIRE_DATE= "yyyy-MM-dd'T'HH:mm:ss";

	@Value("${cdencia.jwt.secret}")
	private String jwtSecret;

	@Value("${cdencia.jwt.hoursValidity}")
	private int hoursValidity;

	public JwtResponse generateJwtToken(Authentication authentication, Map<String, Object> claims) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Date expirationDate = new Date(System.currentTimeMillis() + this.hoursValidity * JWT_TOKEN_VALIDITY);
		DateFormat dateFormat = new SimpleDateFormat(FORMAT_JWT_EXPIRE_DATE);  
//		System.out.println("--->ExpirationDate JWT: " + dateFormat.format(expirationDate));
		String jwt = Jwts.builder().setClaims(claims).setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		return new JwtResponse(jwt, dateFormat.format(expirationDate));
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("<<< Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("<<< JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}
}
