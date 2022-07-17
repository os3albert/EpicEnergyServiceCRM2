package com.energy.crm.clienti.indirizzi.comuni;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldNameConstants;

@Getter
@AllArgsConstructor
@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum ComuneErrorEnum {
	
	@FieldNameConstants.Include COMUNE_GIA_ESISTENTE("Comune già esistente"),
	@FieldNameConstants.Include COMUNE_NON_ESISTENTE("Comune non esistente");
	private String descrizione;

}
