package co.gov.ssoc.gedess.sgd.cfg.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumNamePatternValidator implements ConstraintValidator<EnumNamePattern, Enum<?>> {
    
	private Pattern pattern;

    @Override
    public void initialize(EnumNamePattern annotation) {
        try {
            pattern = Pattern.compile(annotation.regexp(),Pattern.CASE_INSENSITIVE);
        } catch (PatternSyntaxException pse) {
            throw new IllegalArgumentException("-_-PatternSyntaxException, given regex is invalid", pse);
        }
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        Matcher mat = pattern.matcher(value.name());
//        System.out.println("Resultado de REGEX:"+mat.matches()+", PARA EL VALOR:"+value);
        return mat.matches();
    }
}