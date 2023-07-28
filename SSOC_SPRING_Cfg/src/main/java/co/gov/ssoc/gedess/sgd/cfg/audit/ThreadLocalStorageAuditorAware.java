package co.gov.ssoc.gedess.sgd.cfg.audit;

import static org.springframework.web.context.request.RequestAttributes.SCOPE_REQUEST;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

@Component
public class ThreadLocalStorageAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(
				(String) RequestContextHolder.currentRequestAttributes().getAttribute("Username", SCOPE_REQUEST));
	}

}