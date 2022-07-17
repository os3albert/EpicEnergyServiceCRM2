package com.energy.crm.fatture;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.energy.crm.clienti.ClienteImp;
import com.energy.crm.stati.StatoFattura;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fatture")
public class FatturaImp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long fatturaId;
	private Integer anno;
	private Date data;
	private BigDecimal importo;
	
//	@OneToOne
//	private StatoFattura stato;
	
//	@JsonIgnoreProperties
//	@ToString.Exclude
//	@ManyToOne
//	private ClienteImp clienteFattura;

}
