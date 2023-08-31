package co.gov.ssoc.gedess.sgd.cfg.audit.impl;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import co.gov.ssoc.gedess.sgd.cfg.audit.AuditRevisionListener;

@Aspect
@Component
public class ApiOperationLoggingAspect {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiOperationLoggingAspect.class);

	@After("@annotation(io.swagger.annotations.ApiOperation)")
	public void afterApiOperation(JoinPoint joinPoint) {
		try {
			MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
			String methodName = methodSignature.getMethod().getName();
			String declaringTypeName = methodSignature.getDeclaringTypeName();
			String fullMethodName = declaringTypeName + "." + methodName;
			MDC.put(AuditRevisionListener.AUDIT_COMPONENT, fullMethodName);
		} catch (Exception e) {
			LOGGER.error("log-audit-vars", e);
		}
	}
}
