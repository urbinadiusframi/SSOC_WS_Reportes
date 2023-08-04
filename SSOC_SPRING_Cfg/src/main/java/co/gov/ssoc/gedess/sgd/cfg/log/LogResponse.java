package co.gov.ssoc.gedess.sgd.cfg.log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface LogResponse {

	String value() default "Logging response from controller";

}
