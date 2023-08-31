package co.gov.ssoc.gedess.sgd.cfg.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.gov.ssoc.gedess.sgd.cfg.audit.AuditRevisionListener;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.JwtResponse;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.LoginJWTRequestDTO;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.MessageResponse;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.SignInJWTRequestDTO;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.SignupJWTRequestDTO;
import co.gov.ssoc.gedess.sgd.cfg.jwt.dto.UserDetailsImpl;
import co.gov.ssoc.gedess.sgd.cfg.security.service.impl.JwtUtils;
import co.gov.ssoc.gedess.sgd.model.entity.EJwtRole;
import co.gov.ssoc.gedess.sgd.model.entity.JwtRole;
import co.gov.ssoc.gedess.sgd.model.entity.JwtUser;
import co.gov.ssoc.gedess.sgd.model.entity.repository.JWTRoleRepository;
import co.gov.ssoc.gedess.sgd.model.entity.repository.JWTUserRepository;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.OPTIONS }, allowedHeaders = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth/api/v1")
public class AuthController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JWTUserRepository userRepository;

	@Autowired
	JWTRoleRepository roleRepository;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/sign-in")
	public ResponseEntity<?> signIn(@Valid @RequestBody SignInJWTRequestDTO loginRequest,
			HttpServletRequest httpRequest) {
		try {
			Optional<JwtUser> usrExt = this.userRepository.findByUsernameAndPasswordAndState(loginRequest.getUsername(),
					loginRequest.getPassword(), true);
			if (!usrExt.isPresent()) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Error: the credentials are not valid or inactive user"));
			}
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			Map<String, Object> claims = new HashMap<>();
			String remoteAddr = this.getIp(httpRequest);
			claims.put("host", remoteAddr);
			claims.put(AuditRevisionListener.AUDIT_APLICATION, loginRequest.getComponent());

			JwtResponse JwtResponse = jwtUtils.generateJwtToken(authentication, claims);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			JwtResponse.setRoles(roles);
			return ResponseEntity.ok(JwtResponse);
		} catch (Exception e) {
			LOGGER.error(" authenticate-user ", e);
			return ResponseEntity.badRequest().build();
		}
	}

	@Deprecated
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginJWTRequestDTO loginRequest,
			HttpServletRequest httpRequest) {
		try {
			Optional<JwtUser> usrExt = this.userRepository.findByUsernameAndPasswordAndState(loginRequest.getUsername(),
					loginRequest.getPassword(), true);
			if (!usrExt.isPresent()) {
				return ResponseEntity.badRequest()
						.body(new MessageResponse("Error: the credentials are not valid or inactive user"));
			}
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			Map<String, Object> claims = new HashMap<>();
			String remoteAddr = this.getIp(httpRequest);
			claims.put("host", remoteAddr);

			JwtResponse JwtResponse = jwtUtils.generateJwtToken(authentication, claims);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());
			JwtResponse.setRoles(roles);
			return ResponseEntity.ok(JwtResponse);
		} catch (Exception e) {
			LOGGER.error(" authenticate-user ", e);
			return ResponseEntity.badRequest().build();
		}
	}

	// Servicio construido a demanda por BPM
	@GetMapping("/verifyJWT")
	@ApiOperation(value = "verifyJWT", hidden = true)
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> verifyJWT(@RequestHeader(value = "Authorization") String authorizationHeader) {
		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")
				&& authorizationHeader.length() > 7) {
			boolean validJwt = this.jwtUtils
					.validateJwtToken(authorizationHeader.substring(7, authorizationHeader.length()));
			return new ResponseEntity<>(validJwt, validJwt ? HttpStatus.OK : HttpStatus.FORBIDDEN);
		} else {
			return new ResponseEntity<>(
					"El token no es correcto debe tener comenzar con Bearer mas un espacio y el JWT",
					HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signup")
	@ApiOperation(value = "signup", hidden = true)
	public ResponseEntity<?> registerUser(@RequestHeader(value = "Authorization") String authorizationHeader,
			@Valid @RequestBody SignupJWTRequestDTO signUpRequest) {
		if (authorizationHeader.isEmpty() || !authorizationHeader.equals("K3y__2021")) {
			return new ResponseEntity<>("NO AUTORIZADO", HttpStatus.UNAUTHORIZED);
		}
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (signUpRequest.getPassword().trim().isEmpty() || signUpRequest.getConfirmPassword().trim().isEmpty()
				|| !signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Passwords not equals!"));
		}

		String pwdSha256hex = DigestUtils.sha256Hex(signUpRequest.getPassword());

		// Create new user's account
		JwtUser user = new JwtUser(signUpRequest.getUsername(), pwdSha256hex);
		user.setPlatform(signUpRequest.getPlatform());
		user.setState(true);
		Set<String> strRoles = signUpRequest.getRole();
		Set<JwtRole> roles = new HashSet<>();

		if (strRoles == null || strRoles.isEmpty()) {
			ResponseEntity.badRequest().body(new MessageResponse("You have not defined a role"));
		} else {
			strRoles.forEach(role -> {
				switch (role.toLowerCase()) {
				case "admin":
					JwtRole adminRole = roleRepository.findByName(EJwtRole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);
					break;
				case "moderator":
					JwtRole modRole = roleRepository.findByName(EJwtRole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);
					break;
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	private String getIp(HttpServletRequest httpRequest) {
		String remoteAddr = null;
		if (httpRequest != null) {
			remoteAddr = httpRequest.getRemoteAddr();
			if (remoteAddr == null || "".equals(remoteAddr)) {
				remoteAddr = httpRequest.getHeader("X-FORWARDED-FOR");
			}
		}
		return remoteAddr;
	}

}
