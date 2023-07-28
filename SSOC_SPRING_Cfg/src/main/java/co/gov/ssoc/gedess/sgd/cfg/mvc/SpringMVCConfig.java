package co.gov.ssoc.gedess.sgd.cfg.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.gov.ssoc.gedess.sgd.cfg.security.RequestInterceptor;
import co.gov.ssoc.gedess.sgd.cfg.security.RestServicesSecurityInterceptor;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

	@Autowired
	private RestServicesSecurityInterceptor restSecurityInterceptor;
	@Autowired
	private RequestInterceptor taxiFareRequestInterceptor;

	/**
	 * Add Spring MVC lifecycle interceptors for pre- and post-processing of
	 * controller method invocations and resource handler requests. Interceptors can
	 * be registered to apply to all requests or be limited to a subset of URL
	 * patterns.
	 */
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(restSecurityInterceptor).excludePathPatterns("/swagger-resources/**", "/webjars/**",
				"/v2/**", "/swagger-ui.html/**", "/actuator/**", "/auth/api/v1/**");
		registry.addInterceptor(taxiFareRequestInterceptor).excludePathPatterns("/swagger-resources/**", "/webjars/**",
				"/v2/**", "/swagger-ui.html/**", "/actuator/**", "/auth/api/v1/**");

	}
}
