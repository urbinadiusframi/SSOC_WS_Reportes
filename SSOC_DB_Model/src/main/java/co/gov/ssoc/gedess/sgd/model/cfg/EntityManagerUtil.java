package co.gov.ssoc.gedess.sgd.model.cfg;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Component;

@Component
public class EntityManagerUtil {

	@Autowired
	private EntityManager mainDatabase;

	public EntityManager getEm() {
		return mainDatabase;
	}

	public JpaRepositoryFactory getJpaFactory() {
		return new JpaRepositoryFactory(getEm());
	}

}
