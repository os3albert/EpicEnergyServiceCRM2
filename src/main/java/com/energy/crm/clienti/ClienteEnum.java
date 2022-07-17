package com.energy.crm.clienti;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@AllArgsConstructor
@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum ClienteEnum {
	
	@FieldNameConstants.Include CLIENTE_SPA("s.p.a."),
	@FieldNameConstants.Include CLIENTE_SAS("s.a.s."),
	@FieldNameConstants.Include CLIENTE_SRL("s.r.l"),
	@FieldNameConstants.Include CLIENTE_SNC("s.n.c."),
	@FieldNameConstants.Include CLIENTE_PA("p.a.");
	private String descrizione;
	
	
	

}
