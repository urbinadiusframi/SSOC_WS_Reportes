package co.gov.ssoc.gedess.sgd.cfg.p8;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Component
//@Configuration
public class P8GlobalConfig {

//	@Value("#{systemProperties['p8.content.osName']}")
//	private String systemPropertiesP8OsName;
//	@Value("#{systemProperties['p8.pwd']}")
//	private String systemPropertiesP8Pwd;
//	@Value("#{systemProperties['p8.stanza']}")
//	private String systemPropertiesP8Stanza;
//	@Value("#{systemProperties['p8.url']}")
//	private String systemPropertiesP8Url;
//	@Value("#{systemProperties['p8.usr']}")
//	private String systemPropertiesP8Usr;
//	@Value("#{systemProperties['p8.contentPathBase']}")
//	private String systemPropertiesP8ContentPathBase;
//	@Value("#{systemProperties['p8.recordsPathBase']}")
//	private String systemPropertiesP8RecordsPathBase;
//	@Value("#{systemProperties['p8.records.file-plan']}")
//	private String systemPropertiesP8RecordsFilePlan;
//	@Value("#{systemProperties['p8.records.osName']}")
//	private String systemPropertiesP8RecordsNombreOS;
//	@Value("#{systemProperties['p8.maxLongitudNameRecord']}")
//	private Integer systemPropertiesP8MaxLongitudNameRecord;
//
//	@Value("${p8.content.osName}")
//	private String p8ContentOSName;
//	@Value("${p8.pwd}")
//	private String p8Pwd;
//	@Value("${p8.stanza}")
//	private String p8Stanza;
//	@Value("${p8.url}")
//	private String p8Url;
//	@Value("${p8.usr}")
//	private String p8Usr;
//	@Value("${p8.contentPathBase}")
//	private String p8ContentPathBase;
//	@Value("${p8.recordsPathBase}")
//	private String p8RecordsPathBase;
//	@Value("${p8.records.file-plan}")
//	private String p8RecordsFilePlan;
//	@Value("${p8.records.osName}")
//	private String p8RecordsNombreOS;
//	@Value("${p8.maxLongitudNameRecord}")
//	private Integer p8MaxLongitudNameRecord;
//
//	@Bean
//	FilenetConectionPropertiesAdmin filenetConectionProperties() {
//		if (systemPropertiesP8OsName == null || systemPropertiesP8OsName.isEmpty()) {
//			return FilenetConectionPropertiesAdmin.builder().contentNombreOS(p8ContentOSName).clave(p8Pwd)
//					.stanza(p8Stanza).uri(p8Url).usuario(p8Usr).contentPathBase(p8ContentPathBase)
//					.maxLongitudNameRecord(p8MaxLongitudNameRecord).recordsFilePlan(p8RecordsFilePlan)
//					.recordsNombreOS(p8RecordsNombreOS).recordsPathBase(p8RecordsPathBase).build();
//		}
//		return FilenetConectionPropertiesAdmin.builder().contentNombreOS(systemPropertiesP8OsName)
//				.clave(systemPropertiesP8Pwd).stanza(systemPropertiesP8Stanza).uri(systemPropertiesP8Url)
//				.usuario(systemPropertiesP8Usr).contentPathBase(systemPropertiesP8ContentPathBase)
//				.maxLongitudNameRecord(systemPropertiesP8MaxLongitudNameRecord)
//				.recordsFilePlan(systemPropertiesP8RecordsFilePlan).recordsNombreOS(systemPropertiesP8RecordsNombreOS)
//				.recordsPathBase(systemPropertiesP8RecordsPathBase).build();
//	}
}
