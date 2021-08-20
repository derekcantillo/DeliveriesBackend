package edu.unimagdalena.domicilios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.unimagdalena.domicilios.modelo.Domicilio;
@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
	List<Domicilio> findByMensajeroId(Long mensajeroId);
}
