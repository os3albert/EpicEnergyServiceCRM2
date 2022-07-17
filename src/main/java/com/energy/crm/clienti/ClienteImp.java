package com.energy.crm.clienti;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.energy.crm.clienti.contatti.ContattoImp;
import com.energy.crm.clienti.indirizzi.IndirizzoImp;
import com.energy.crm.fatture.FatturaImp;
import com.energy.crm.stati.StatoFattura;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clienti_business")
public class ClienteImp {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE )
	private Long ClienteId;
	
	private String ragioneSociale;
	private String partitaIva;
	private Date dataInserimento;
	private Date dataUltimoContatto;
	private double fatturatoAnnuale;
	private String pec;
	private String telefono;
	
	@OneToOne
	@ToString.Exclude
	private ContattoImp contatto;
	
//	@OneToOne
//	private StatoFattura stato;
	
//	@JsonIgnoreProperties
//	@ToString.Exclude
//	@OneToMany(mappedBy = "clienteImp")
//	private List<IndirizzoImp> indirizziList;
//	
//	@JsonEnumDefaultValue
//	private ClienteEnum Tipo;
//	
//	@JsonIgnoreProperties
//	@ToString.Exclude
//	@OneToMany(mappedBy = "clienteFattura")
//	private List<FatturaImp> fattureList;

}
