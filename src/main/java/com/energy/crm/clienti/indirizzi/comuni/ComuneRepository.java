package com.energy.crm.clienti.indirizzi.comuni;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComuneRepository extends PagingAndSortingRepository<ComuneImp, Long> {
	
	public boolean existsByNomeComune(String nomeComune);
	
	public boolean existsByNomeComuneAndComuneId(String nomeComune, Long comuneId);
	
	public List<ComuneImp>findByNomeComune(String nomeComune);

//	public void save(ComuneDTO comuneDTO);

}
