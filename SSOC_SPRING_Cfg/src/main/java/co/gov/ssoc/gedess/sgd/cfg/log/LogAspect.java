package co.gov.ssoc.gedess.sgd.cfg.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@Aspect
@Component
public class LogAspect {
	private static final Logger LOGGER_RESPONSE = LoggerFactory.getLogger("response");

	@Autowired
	ObjectMapper objectMapper;

	@Around("@annotation(io.swagger.annotations.ApiOperation)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = joinPoint.proceed();
		LOGGER_RESPONSE.info("{}  {}", joinPoint.getSignature(), objectMapper.writeValueAsString(result));
		return result;
	}
}
