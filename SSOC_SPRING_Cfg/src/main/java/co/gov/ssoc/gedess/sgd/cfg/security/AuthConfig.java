package co.gov.ssoc.gedess.sgd.cfg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationProvider;

import co.gov.ssoc.gedess.sgd.cfg.security.service.impl.UserDetailsServiceImpl;

@Configuration
public class AuthConfig {

	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Value("${spring.profiles.active:}")
	private String activeProfile;

	@Bean
	public AuthenticationManager configure(HttpSecurity auth) throws Exception {

		PreAuthenticatedAuthenticationProvider preAuthenticatedAuthenticationProvider = new PreAuthenticatedAuthenticationProvider();
		preAuthenticatedAuthenticationProvider
				.setPreAuthenticatedUserDetailsService(new SingleSignOnUserDetailsService());
		auth.authenticationProvider(preAuthenticatedAuthenticationProvider);

		auth.userDetailsService(userDetailsService);
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

		AuthenticationManagerBuilder authenticationManagerBuilder = auth
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.authenticationProvider(preAuthenticatedAuthenticationProvider);

		return authenticationManagerBuilder.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
//		return new org.springframework.security.crypto.password.MessageDigestPasswordEncoder("SHA-256");
		PasswordEncoder passwordEncoder = new PasswordEncoder() {
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				return rawPassword.equals(encodedPassword);
			}

			@Override
			public String encode(CharSequence rawPassword) {
				return null;
			}
		};
		return passwordEncoder;
	}

}
