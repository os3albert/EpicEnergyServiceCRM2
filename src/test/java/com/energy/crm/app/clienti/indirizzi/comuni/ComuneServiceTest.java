package com.energy.crm.app.clienti.indirizzi.comuni;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.energy.crm.clienti.indirizzi.comuni.ComuneDTO;
import com.energy.crm.clienti.indirizzi.comuni.ComuneErrorEnum;
import com.energy.crm.clienti.indirizzi.comuni.ComuneImp;
import com.energy.crm.clienti.indirizzi.comuni.ComuneRepository;
import com.energy.crm.clienti.indirizzi.comuni.ComuneService;
import com.energy.crm.messages.Messages;
import com.energy.crm.utils.TestBase;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComuneServiceTest extends TestBase {
	
	@Autowired
	private Environment env;

	@Autowired
	ComuneRepository comuneRepository;

	@Autowired
	ComuneService comuneService;

	@Test
	@DisplayName("ricerca comune SUCCESS")
	public void findByIdOK() {

		ComuneImp comuneImpMock = new ComuneImp( null, "Rimini", null);
		
		log.info(env.getProperty("comune.update.success"));

		comuneRepository.save(comuneImpMock);

		ComuneImp comuneImpTest = comuneService.findWithId(comuneImpMock.getComuneId());
		
		assertThat(comuneImpTest).isNotNull();
		assertThat( comuneImpTest.getComuneId()).isEqualTo(comuneImpMock.getComuneId() );
		
	}

	@Test
	@DisplayName("ricerca comune inesistente FAIL -> ENTITYNOTFOUND")
	public void findByIdKO() {

		assertThatThrownBy( () -> comuneService.find(100000L) )
		.isInstanceOf(EntityNotFoundException.class)
		.hasMessage(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);

	}
	
	@Test
	@DisplayName("Inserimento comune SUCCESS")
	public void testInsertComune() {
		
//		Mocks
		ComuneImp comuneImpMock = new ComuneImp(null,"comune", null);
		comuneService.insert(comuneImpMock);
		ComuneImp comuneImpTest = comuneRepository.findById(comuneImpMock.getComuneId()).get();
		
		log.info(comuneImpTest.getNomeComune());
		log.info(comuneImpTest.getComuneId().toString());
		log.debug("STO DEBUGGANDO");
		
//		Test
		assertThat(comuneImpMock.getNomeComune()).isEqualTo(comuneImpTest.getNomeComune());
		
		
	}
	
	@Test
	@DisplayName("Inserimento comune FAIL -> WrongValues")
	public void testInsertWithWrongValues( ) {
		ComuneDTO comuneDTO = new ComuneDTO("1", null);
		assertThatThrownBy( () -> comuneService.insert(comuneDTO)  )
		.isInstanceOf(ConstraintViolationException.class)
		.hasMessageContaining("nomeComune");

	}
	
	@Test
	@DisplayName("inserimento comune FAIL -> EntityExistsException")
	public void testInsertKoEntityExistsException()  {
		
//		creo il comune nel db
		ComuneImp comuneImpMock = new ComuneImp(null, "0987654321asdfgh", null);
		comuneRepository.save(comuneImpMock);
		
		ComuneDTO comuneDTOtest = new ComuneDTO( comuneImpMock.getNomeComune(), comuneImpMock.getIndirizziList());
		
//		Test
		assertThatThrownBy( () ->  comuneService.insert(comuneDTOtest)  )
		.isInstanceOf(EntityExistsException.class)
		.hasMessage(ComuneErrorEnum.Fields.COMUNE_GIA_ESISTENTE) ;
		log.info(ComuneErrorEnum.COMUNE_GIA_ESISTENTE.getDescrizione());
		
	}
	
	@Test
	@DisplayName("rimozione comune SUCCESS")
	public void testDeleteOK() {
		
//		creo il comune nel db
		ComuneImp comuneImpMock = new ComuneImp(null, "0987654fgh", null);
		comuneRepository.save(comuneImpMock);
		
		comuneService.delete(comuneImpMock.getComuneId());
		
//		Test
		assertThatThrownBy(() -> comuneService.find(comuneImpMock.getComuneId()))
		.isInstanceOf(EntityNotFoundException.class)
		.hasMessageContaining(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);	
		
	}

}
