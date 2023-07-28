package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.EJwtRole;
import co.gov.ssoc.gedess.sgd.model.entity.JwtRole;

@Repository
public interface JWTRoleRepository extends JpaRepository<JwtRole, Long> {
  Optional<JwtRole> findByName(EJwtRole name);
}
