package com.energy.crm.clienti.indirizzi;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.energy.crm.clienti.ClienteImp;
import com.energy.crm.clienti.indirizzi.comuni.ComuneImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "indirizzi")
public class IndirizzoImp {
	
	@Id
	@GeneratedValue
	private Long indirizzoId;
	
	private String via;
	private String civico;
	private String localita;
	private String cap;
	
//	@ManyToOne
//	@JsonIgnoreProperties
//	@ToString.Exclude
//	private ClienteImp clienteIndirizzo;
	
	@ManyToOne
	@ToString.Exclude
	private ComuneImp comune;

}
