package co.gov.ssoc.gedess.sgd.cfg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import co.gov.ssoc.gedess.sgd.cfg.security.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;
	@Value("${spring.profiles.active:}")
	private String activeProfile;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	private RequestHeaderAuthenticationFilter createSsoFilter(AuthenticationManager authenticationManager)
			throws Exception {
		final RequestHeaderAuthenticationFilter ssoFilter = new RequestHeaderAuthenticationFilter();
		// We use the presence of x-auth-user for SSO authentication
		// Our platform doesn't allow the manual setting of this header from the outside
		ssoFilter.setPrincipalRequestHeader("x-auth-user");
		ssoFilter.setExceptionIfHeaderMissing(false); // allow basic authentication if no header present
		ssoFilter.setAuthenticationManager(authenticationManager);
		return ssoFilter;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager)
			throws Exception {
		httpSecurity.cors().and().addFilter(createSsoFilter(authenticationManager)).csrf().disable().exceptionHandling()
				.authenticationEntryPoint(unauthorizedHandler).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/auth/api/v1/**").permitAll().antMatchers("/correspondencia/api/v1/**").permitAll()
				.antMatchers("/instrumentos-archivisticos/api/v1/**").permitAll()
				.antMatchers("/tramitesRelaciones/api/v1/**").permitAll()
				.antMatchers("/contentManager/api/v1/**").permitAll()
				.antMatchers("/recordsManager/api/v1/**").permitAll()
				.antMatchers("/trdMasive/api/v1/**").permitAll()
				.antMatchers("/consultas-radicados/api/v1**").permitAll().antMatchers("/filenet/api/v1/**").permitAll()
				.antMatchers("/personaNJ/api/v1/**").permitAll().antMatchers("/firma/api/v1/**").permitAll()
				.antMatchers("/tramites/api/v1/**").permitAll().antMatchers("/portal-services/api/v3/**").permitAll()
				.antMatchers("/swagger-ui.html").permitAll().antMatchers("/webjars/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll().antMatchers("/v2/*").permitAll().antMatchers("/v3/*")
				.permitAll().antMatchers("/h2-console/**").permitAll()
//      .antMatchers("/csrf").permitAll()
//      .antMatchers("/").permitAll()
				.anyRequest().authenticated();

		httpSecurity.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		return httpSecurity.build();
	}
}
