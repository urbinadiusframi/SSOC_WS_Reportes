package co.gov.ssoc.gedess.sgd.cfg.jwt.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginJWTRequestDTO implements Serializable {

	private static final long serialVersionUID = 16581L;

	@NotBlank
	@ApiModelProperty(notes = "username", required = true)
	private String username;

	@NotBlank
	@ApiModelProperty(notes = "password debe un SHA-256", required = true)
	private String password;

}
