package co.gov.ssoc.gedess.sgd.cfg.security;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.gov.ssoc.gedess.sgd.cfg.security.service.AuthService;

@Component
@Configuration
public class RestServicesSecurityInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = LogManager.getLogger(getClass());

	private static final String AUTH_HEADER_PARAMETER_AUTHERIZATION = "authorization";

	@Value("${sgd.admin.authentication.basic.username}")
	private String userName;

	@Value("${sgd.admin.authentication.basic.password}")
	private String password;

	@Autowired
	private AuthService authService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Boolean isValidBasicAuthRequest = true;
		try {
			// Grab basic header value from request header object.
//			String basicAuthHeaderValue = request.getHeader(AUTH_HEADER_PARAMETER_AUTHERIZATION);
//			log.info("header request ----->" + basicAuthHeaderValue + "<------" + userName + ":" + password);
			// Process basic authentication
//			isValidBasicAuthRequest = authService.validateBasicAuthentication(userName, password,basicAuthHeaderValue);
			// If this is invalid request, then set the status as UNAUTHORIZED.
//			return isValidBasicAuthRequest;
//			if (!isValidBasicAuthRequest && !request.getMethod().equalsIgnoreCase("OPTIONS")) {
//				log.info("[Inside PRE Handle interceptor -- UNAUTHORIZED]" + "[" + request.getMethod() + "]"
//						+ request.getRequestURI());
//				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
//				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//
//				final HashMap<String, Object> body = new HashMap<>();
//				body.put("status", HttpServletResponse.SC_UNAUTHORIZED);
//				body.put("error", HttpStatus.UNAUTHORIZED.name());
//				body.put("message", "No autorizado, credenciales no validas");
//				body.put("path", request.getServletPath());
//				body.put("timestamp", new SimpleDateFormat("yyyy/MM/dd hh:mm a").format(new Date()));
//
//				final ObjectMapper mapper = new ObjectMapper();
//				mapper.writeValue(response.getOutputStream(), body);
//			}
//			RequestContextHolder.currentRequestAttributes().setAttribute("Username", userName, SCOPE_REQUEST);
		} catch (Exception e) {
			log.error("Error occured while authenticating request : " + e.getMessage());
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
		}
		return isValidBasicAuthRequest;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
//		log.info("[Inside POST Handle Interceptor]" + request.getRequestURI());
	}

}
