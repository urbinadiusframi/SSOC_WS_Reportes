package co.gov.ssoc.gedess.sgd.cfg.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import co.gov.ssoc.gedess.sgd.cfg.jwt.SingleSignOnUser;

public class SingleSignOnUserDetailsService
		implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

	@Override
	public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
		return Optional.ofNullable(token.getPrincipal()).map(SingleSignOnUser::fromPrincipal).orElse(null);
	}

}
