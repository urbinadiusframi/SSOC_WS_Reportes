package co.gov.ssoc.gedess.sgd.cfg.page;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Paginacion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Pattern(regexp = "[\\s]*[\\d]*[1-9]+", message = "Tamaño de pagina debe ser positivo")
	private Integer pageSize;
	@Pattern(regexp = "[\\s]*[0-9]*[1-9]+", message = "Número de la página iniciando en 0")
	private Integer pageNumber;
}
