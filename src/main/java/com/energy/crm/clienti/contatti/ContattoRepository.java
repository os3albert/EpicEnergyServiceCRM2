package com.energy.crm.clienti.contatti;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContattoRepository extends PagingAndSortingRepository<ContattoImp, Long> {

}
