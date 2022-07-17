package com.energy.crm.clienti.indirizzi.comuni;

import java.util.List;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.energy.crm.clienti.indirizzi.IndirizzoImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComuneDTO {
	
//	@NotBlank
//	@Length(min = 2, max = 100)
	private String nomeComune;
	@OneToMany(mappedBy = "comune")
	@JsonIgnoreProperties
	@ToString.Exclude
	private List<IndirizzoImp> indirizziList;
}
