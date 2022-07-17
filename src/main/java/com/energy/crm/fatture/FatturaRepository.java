package com.energy.crm.fatture;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatturaRepository extends PagingAndSortingRepository<FatturaImp, Long> {

}
