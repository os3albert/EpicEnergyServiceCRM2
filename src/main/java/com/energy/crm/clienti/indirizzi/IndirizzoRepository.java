package com.energy.crm.clienti.indirizzi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndirizzoRepository extends PagingAndSortingRepository<IndirizzoImp, Long> {

}
