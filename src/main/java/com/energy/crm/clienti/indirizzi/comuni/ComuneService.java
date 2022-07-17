package com.energy.crm.clienti.indirizzi.comuni;

import java.security.DrbgParameters.NextBytes;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import lombok.extern.slf4j.Slf4j;

@Service
@Validated
@Slf4j
public class ComuneService {

	@Autowired
	ComuneRepository comuneRepository;

	/**
	 * @param id
	 * @return ComuneDTO
	 */
	public ComuneDTO find(@Valid Long id) {
		if (!comuneRepository.existsById(id)) {
			throw new EntityNotFoundException(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);
		}

		ComuneImp comuneImp = comuneRepository.findById(id).get(); // se va tutto bene ritorna il comune cercato,
																	// altrimenti lancia un eccezione
																	// che gestiamo con crm.errors > ErrorHandler

		ComuneDTO comuneDTO = new ComuneDTO();

		BeanUtils.copyProperties(comuneImp, comuneDTO);

		return comuneDTO;
	}

	/**
	 * @param id
	 * @return ComuneDTO
	 */
	public List<ComuneImp> findAll() {

		return (List<ComuneImp>) comuneRepository.findAll(); // se va tutto bene ritorna i comuni,

//		return comuneDTOList;
	}

	public ComuneImp findWithId(@Valid Long id) {
		if (!comuneRepository.existsById(id)) {
			throw new EntityNotFoundException(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);
		}

		ComuneImp comuneImp = comuneRepository.findById(id).get(); // se va tutto bene ritorna il comune cercato,
																	// altrimenti lancia un eccezione

		return comuneImp;
	}

	public void insert(@Valid ComuneDTO comuneDTO) {

		log.info("SONO DENTRO INSERT");
//		if (!comuneRepository.existsByNomeComune(comuneDTO.getNomeComune())) {
//			throw new EntityExistsException(ComuneErrorEnum.Fields.COMUNE_GIA_ESISTENTE);
//		} else {

		ComuneImp comuneImp = new ComuneImp();
		
		log.info(comuneDTO.toString());
		
		comuneImp.setNomeComune(comuneDTO.getNomeComune());

//		BeanUtils.copyProperties(comuneDTO, comuneImp);

		comuneRepository.save(comuneImp);
		
		log.info(comuneImp.toString());
//			return comuneRepository.save(comuneImp).getComuneId();
//			comuneRepository.save(comuneDTO);
//		}

	}

	public void insert(@Valid ComuneImp comuneImp) {

//		if (comuneRepository.existsByNomeComune(comuneImp.getNomeComune())) {
//			throw new EntityExistsException(ComuneErrorEnum.Fields.COMUNE_GIA_ESISTENTE);
//		} else {

		comuneRepository.save(comuneImp);

//		}

	}

	public void delete(@Valid Long id) {

		if (!comuneRepository.existsById(id)) {
			throw new EntityNotFoundException(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);
		}
		comuneRepository.deleteById(id);

	}

	public ComuneImp deleted(@Valid Long id) {

		if (!comuneRepository.existsById(id)) {
			throw new EntityNotFoundException(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);
		}

		ComuneImp comuneImp = comuneRepository.findById(id).get();

		comuneRepository.deleteById(id);

		return comuneImp;
	}

	public void update(ComuneDTO comuneDTO, Long id) {

		if (!comuneRepository.existsById(id)) {

			throw new EntityNotFoundException(ComuneErrorEnum.Fields.COMUNE_NON_ESISTENTE);

		} else if (comuneRepository.existsByNomeComuneAndComuneId(comuneDTO.getNomeComune(), id)) {

			throw new EntityExistsException(ComuneErrorEnum.Fields.COMUNE_GIA_ESISTENTE);

		}

		ComuneImp comuneImpToUpdate = comuneRepository.findById(id).get();

		BeanUtils.copyProperties(comuneDTO, comuneImpToUpdate);

		comuneRepository.save(comuneImpToUpdate);

	}

}
