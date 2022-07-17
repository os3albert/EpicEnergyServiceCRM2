package com.energy.crm.app.clienti.indirizzi.comuni;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.energy.crm.clienti.indirizzi.comuni.ComuneDTO;
import com.energy.crm.clienti.indirizzi.comuni.ComuneImp;
import com.energy.crm.clienti.indirizzi.comuni.ComuneRepository;
import com.energy.crm.utils.TestBaseController;

import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:url.properties")
@Slf4j
public class ComuneControllerTest extends TestBaseController{
	
	@Autowired
	private ComuneRepository comuneRepository;
	
	@Value("${url.entry.point}/comune")
	private String URL;
	
	
	@Test
	@DisplayName("Inserisco comune SUCCESS")
	public void testInsertSuccess() {
		ComuneDTO comuneDTOMock = new ComuneDTO("Annibali", null);
		ComuneImp prova = new ComuneImp(2595l, "imp", null);
		ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(URL, comuneDTOMock, String.class);
		
		assertThat( responseEntity.getStatusCode() ).isEqualTo( HttpStatus.OK );
		
		log.info( "INFO ---- " + comuneRepository.findByNomeComune( "Annibali" ));
		log.info( "INFO ---- " + comuneRepository.findByNomeComune(comuneDTOMock.getNomeComune() ) );
		ComuneImp comuneImpTest = (ComuneImp) comuneRepository.findByNomeComune( comuneDTOMock.getNomeComune() );
		
		
		assertThat( comuneImpTest.getComuneId() ).isNotNull();
		assertThat( comuneImpTest.getNomeComune() ).isEqualTo( comuneDTOMock.getNomeComune() );
	}

	@Test
	@DisplayName("inserimento comune già esistente -> BAD_REQUEST")
	public void insertFailWithEntityExistsException() {
		ComuneImp comuneImpMock = new ComuneImp(null,"Marco",null);
		comuneRepository.save(comuneImpMock);
		
		ComuneDTO comuneDTOTest = new ComuneDTO("Marco",null);
		ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(URL, comuneDTOTest, String.class);
		
		assertThat( responseEntity.getStatusCode() ).isEqualTo( HttpStatus.BAD_REQUEST );
	}

	@Test
	@DisplayName("Provo ad inserire un comune ma il nome è vuoto e ottengo status BAD_REQUEST")
	public void insertFailWithValidationErrors() {
		ComuneDTO comuneDTO = new ComuneDTO("", null);
		ResponseEntity<String> responseEntity = getRestTemplate().postForEntity(URL, comuneDTO, String.class);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo( HttpStatus.BAD_REQUEST );
		
		
	}

	@Test
	@DisplayName("Cerco e trovo un comune by id")
	public void findByIdSuccess() {
		ComuneImp comuneImpMock = new ComuneImp(null, "Floris", null);
		comuneRepository.save(comuneImpMock);
		comuneImpMock = comuneRepository.findById(1l).get();
		
		ResponseEntity<ComuneImp> responseEntity = getRestTemplate().getForEntity(URL+"/"+comuneImpMock.getComuneId(), ComuneImp.class);
		
		log.info( URL+"/"+comuneImpMock.getComuneId() );
		
		assertThat( responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK );
		ComuneImp comuneImpTest = responseEntity.getBody();
		
		log.info( responseEntity.getBody().toString() );
		
		assertThat( comuneImpTest.getNomeComune() ).isEqualTo( comuneImpMock.getNomeComune() );
		
	}
	
	@Test
	@DisplayName("Cerco un comune inesistente e ottengo status NOT_FOUND")
	public void findByIdFail() {
		ResponseEntity<String> r = getRestTemplate().getForEntity(URL+"/100000", String.class);
		assertThat(  r.getStatusCode() ).isEqualTo( HttpStatus.NOT_FOUND );
	}

	@Test
	@DisplayName("cerco l'elenco dei comune")
	public void testGetAll() {
		
		// aggiungo un mock di test per la visualizzazione
		ComuneImp comuneImpMock = new ComuneImp(100l,"rimini", null);
		comuneRepository.save(comuneImpMock);
		
		
		ResponseEntity<String> responseEntity = getRestTemplate().getForEntity(URL, String.class);
		assertThat( responseEntity.getStatusCode() ).isEqualTo(  HttpStatus.OK );
		
	}
	

}
