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

import edu.unimagdalena.domicilios.modelo.Domicilio;
import edu.unimagdalena.domicilios.modelo.Mensajero;
import edu.unimagdalena.domicilios.repository.DomicilioRepository;
import edu.unimagdalena.domicilios.repository.MensajeroRepository;



@RestController
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:3000"})
@RequestMapping("/api/domicilios")
public class DomicilioController {
	@Autowired
	private DomicilioRepository domicilioRepositorio;
	@Autowired
	private MensajeroRepository mensajeroRepositorio;
	@GetMapping
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Domicilio>> getTodosDomicilios(){
		List<Domicilio> listaDomicilios = domicilioRepositorio.findAll();
		if(listaDomicilios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(listaDomicilios, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/mensajeros/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Domicilio>> getDomiciliosByMensajero(@PathVariable("id") Long idMensajero){
		List<Domicilio> domicilios = domicilioRepositorio.findByMensajeroId(idMensajero);
		if(domicilios.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(domicilios, HttpStatus.OK);
		}
	}
	
	@PostMapping("/mensajeros/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Domicilio> createDomicilio(@PathVariable("id") Long idMensajero, @RequestBody Domicilio domicilio ){
			Optional<Mensajero> mensajero = mensajeroRepositorio.findById(idMensajero);
			
			if(mensajero.isPresent()) {
				domicilio.setMensajero(mensajero.get());
				Domicilio nuevoDomicilio = domicilioRepositorio.save(domicilio);
				return new ResponseEntity<>(nuevoDomicilio, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
			}
	}
	
	@PutMapping("/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Domicilio> updateDomicilio(@PathVariable("id") Long id, @RequestBody Domicilio domi){
		Optional<Domicilio> datosDomicilio = domicilioRepositorio.findById(id);
		if(datosDomicilio.isPresent()) {
			Domicilio domicilio = datosDomicilio.get();
			domicilio.setValor(domi.getValor());
			domicilio.setDireccionOrigen(domi.getDireccionOrigen());
			domicilio.setDireccionDestino(domi.getDireccionDestino());
			domicilio.setNombreClienteOrigen(domi.getNombreClienteOrigen());
			domicilio.setNombreClienteDestino(domi.getNombreClienteDestino());
			domicilio.setEstado(domi.isEstado());
			domicilio.setFechaDomicilio(domi.getFechaDomicilio());
			Domicilio nuevoDomicilio = domicilioRepositorio.save(domicilio);
			return new ResponseEntity<>(nuevoDomicilio, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
		}
	}
	
	@DeleteMapping("/{id}")
	//@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Domicilio> deleteDomicilio (@PathVariable("id") Long id){
		try {
			domicilioRepositorio.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
