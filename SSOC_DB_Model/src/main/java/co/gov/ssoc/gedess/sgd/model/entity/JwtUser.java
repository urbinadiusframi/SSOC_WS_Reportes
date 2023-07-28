package co.gov.ssoc.gedess.sgd.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@org.hibernate.envers.Audited
@Table(name = "Jwt_Users", schema = "correspondencia", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username") })
public class JwtUser implements Serializable {

	private static final long serialVersionUID = 9136416864955956404L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 120)
	private String password;// SHA-256

	@NotEmpty
	private String platform;

	private Boolean state;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Jwt_User_Roles", schema = "correspondencia", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<JwtRole> roles = new HashSet<>();

	public JwtUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

}
