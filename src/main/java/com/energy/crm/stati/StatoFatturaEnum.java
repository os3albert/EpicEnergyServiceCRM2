package com.energy.crm.stati;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@AllArgsConstructor
@FieldNameConstants
public enum StatoFatturaEnum {
	
	@FieldNameConstants.Include PAGATA("pagata"),
	@FieldNameConstants.Include NON_PAGATA("non pagata"),
	@FieldNameConstants.Include ANNULLATA("annullata");
	
	private String descrizione;
	

}
