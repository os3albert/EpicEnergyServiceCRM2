package com.energy.crm.clienti;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<ClienteImp, Long> {

}
