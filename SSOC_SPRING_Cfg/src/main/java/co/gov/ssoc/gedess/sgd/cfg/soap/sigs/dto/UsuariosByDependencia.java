
package co.gov.ssoc.gedess.sgd.cfg.soap.sigs.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariosByDependencia implements Serializable{

	private static final long serialVersionUID = 1983271297391L;
	
	protected BigDecimal numeroDocumento;
    protected String nombre;
    protected String username;
}
