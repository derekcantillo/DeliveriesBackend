 package edu.unimagdalena.domicilios;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import edu.unimagdalena.domicilios.repository.DomicilioRepository;
import edu.unimagdalena.domicilios.repository.MensajeroRepository;

@SpringBootApplication
public class DbDomiciliosApplication {
	private static final Logger mylog = LoggerFactory.getLogger(DbDomiciliosApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DbDomiciliosApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(MensajeroRepository  mRepository, DomicilioRepository domiRepository) {
		return (args)->{

			
		};
	}

}
