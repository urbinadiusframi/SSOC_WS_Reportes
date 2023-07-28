package org.springframework.samples.petclinic.api.cfg;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Admin {
	String value() default "";

	int count() default 0;
}
