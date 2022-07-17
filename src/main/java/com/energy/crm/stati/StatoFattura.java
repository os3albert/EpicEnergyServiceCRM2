package com.energy.crm.stati;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.energy.crm.clienti.ClienteImp;
import com.energy.crm.fatture.FatturaImp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stati_fattura")
public class StatoFattura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long statoFatturaId;
	private String statoFattura;
	
	@OneToOne
	private FatturaImp fattura;	// le fatture possono avere un solo stato tra pagata, non pagata, annullata
	
	@OneToOne
	private ClienteImp cliente;	// allo stato della fattura di un cliente e' associata uno ed un unico cliente e viceversa
	
	
	
	

}
