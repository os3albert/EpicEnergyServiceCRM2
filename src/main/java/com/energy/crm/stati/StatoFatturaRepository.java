package com.energy.crm.stati;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatoFatturaRepository extends PagingAndSortingRepository<StatoFattura, Long>{

}
