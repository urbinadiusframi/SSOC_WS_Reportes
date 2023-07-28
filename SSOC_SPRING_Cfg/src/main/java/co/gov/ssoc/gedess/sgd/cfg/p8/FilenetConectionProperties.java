package co.gov.ssoc.gedess.sgd.cfg.p8;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties(prefix = "p8")
public class FilenetConectionProperties {

	private String recordsPathBase;
	private String recordsFilePlan;
	private String recordsNombreOS;

	private String usuario;
	private String pwd;
	private String stanza;
	private String url;
	private String contentNombreOS;
	private String contentPathBase;

	private Integer maxLongitudNameRecord;

}
