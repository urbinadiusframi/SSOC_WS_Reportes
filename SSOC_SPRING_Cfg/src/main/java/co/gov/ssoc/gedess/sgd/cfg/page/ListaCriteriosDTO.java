package co.gov.ssoc.gedess.sgd.cfg.page;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListaCriteriosDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private Paginacion page;
	private List<SearchCriteriaData> criteria;

}
