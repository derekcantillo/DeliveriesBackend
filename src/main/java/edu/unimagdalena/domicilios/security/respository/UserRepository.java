package edu.unimagdalena.domicilios.security.respository;
//tomado de https://www.bezkoder.com/spring-boot-jwt-authentication/

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.domicilios.security.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
