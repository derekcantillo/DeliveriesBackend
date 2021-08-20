package edu.unimagdalena.domicilios.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.unimagdalena.domicilios.modelo.Mensajero;
import edu.unimagdalena.domicilios.repository.MensajeroRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:3000"})
public class MensajeroController {
	
	@Autowired
	private MensajeroRepository mensajeroRepositorio;
	
	@GetMapping("/mensajeros")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Mensajero>> getTodosMensajeros(){
		List<Mensajero> listaMensajeros = mensajeroRepositorio.findAll();
		if(listaMensajeros.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listaMensajeros, HttpStatus.OK);
	}
	
	@GetMapping("/mensajeros/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Mensajero> getMensajero(@PathVariable("id") Long id){
		Optional<Mensajero> mensajero = mensajeroRepositorio.findById(id);
		if(mensajero.isPresent()) {
			return new ResponseEntity<>(mensajero.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/mensajeros")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Mensajero> createMensajero(@RequestBody Mensajero m){
		try {
			Mensajero mensajero = mensajeroRepositorio.save(m);
			return new ResponseEntity<>(mensajero, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/mensajeros/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Mensajero> updateMensajero(@PathVariable("id") Long id, @RequestBody Mensajero m){
		
		Optional<Mensajero> datosMensajero = mensajeroRepositorio.findById(id);
		if(datosMensajero.isPresent()) {
			Mensajero mensajero = datosMensajero.get();
			mensajero.setNombre(m.getNombre());
			mensajero.setCorreo(m.getCorreo());
			mensajero.setNumeroContacto(m.getNumeroContacto());
			mensajero.setNumLicencia(m.getNumLicencia());
			Mensajero nuevoMensajero = mensajeroRepositorio.save(mensajero);
			
			return new ResponseEntity<>(nuevoMensajero, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@DeleteMapping("/mensajeros/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<HttpStatus> deleteMensajero(@PathVariable("id") Long id){
		try {
			mensajeroRepositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
