package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.JwtUser;


@Repository
public interface JWTUserRepository extends JpaRepository<JwtUser, Long> {
	
  Optional<JwtUser> findByUsernameAndPasswordAndState(String username,String password,Boolean state);
  Optional<JwtUser> findByUsername(String username);
  Boolean existsByUsername(String username);

}
