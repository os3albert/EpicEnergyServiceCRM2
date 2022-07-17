package com.energy.crm.clienti.contatti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contatti")
public class ContattoImp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long contattoId;
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;

}
