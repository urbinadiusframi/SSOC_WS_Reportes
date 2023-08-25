package co.gov.ssoc.gedess.sgd.cfg.jwt.dto;

import java.io.Serializable;
import java.util.Set;

import javax.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupJWTRequestDTO implements Serializable {

	private static final long serialVersionUID = 123123L;

	@NotBlank
	@Size(min = 3, max = 20)
	private String username;

	@NotEmpty
	private String platform;

	@NotNull
	private Set<String> role;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

	@NotBlank
	@Size(min = 6, max = 40)
	private String confirmPassword;

}
