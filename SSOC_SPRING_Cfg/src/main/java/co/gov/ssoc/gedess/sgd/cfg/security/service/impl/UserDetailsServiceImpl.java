package co.gov.ssoc.gedess.sgd.cfg.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.UserDetailsImpl;
import co.gov.ssoc.gedess.sgd.model.entity.JwtUser;
import co.gov.ssoc.gedess.sgd.model.entity.repository.JWTUserRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	JWTUserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}

}
