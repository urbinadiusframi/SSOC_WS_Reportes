package co.gov.ssoc.gedess.sgd.cfg.jwt.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1871L;
	private String token;
	private String type = "Bearer";
	private List<String> roles;
	private String expirationDate;

	public JwtResponse(String accessToken, String expirationDate) {
		this.token = accessToken;		
		this.expirationDate = expirationDate;
	}

}
