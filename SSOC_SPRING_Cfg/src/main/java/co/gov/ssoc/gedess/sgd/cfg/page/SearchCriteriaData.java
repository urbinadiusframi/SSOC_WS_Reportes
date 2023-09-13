package co.gov.ssoc.gedess.sgd.cfg.page;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SearchCriteriaData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8875064113348190928L;
	private String key;
	private Object value;
	private SearchOperation operation;

	public enum SearchOperation {
		GREATER_THAN, LESS_THAN, GREATER_THAN_EQUAL, LESS_THAN_EQUAL, NOT_EQUAL, EQUAL, EQUAL_IGNORE_CASE, MATCH,
		MATCH_END, IS, AND, IN_MANY_TO_MANY, STARTS_WITH, IN, LESS_THAN_EQUAL_DATE, GREATER_THAN_EQUAL_DATE

	}

}
