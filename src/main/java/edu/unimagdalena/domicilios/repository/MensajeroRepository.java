package edu.unimagdalena.domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.domicilios.modelo.Mensajero;
@Repository 
public interface MensajeroRepository extends JpaRepository<Mensajero, Long> {

}
