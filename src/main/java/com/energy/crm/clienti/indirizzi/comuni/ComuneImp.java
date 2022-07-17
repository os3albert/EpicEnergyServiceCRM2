package com.energy.crm.clienti.indirizzi.comuni;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
@Entity
@Table(name = "comuni")
public class ComuneImp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long comuneId;
//	@Column(unique = true)
	private String nomeComune;
	@OneToMany(mappedBy = "comune")
	@JsonIgnoreProperties
	@ToString.Exclude
	private List<IndirizzoImp> indirizziList;
	

}
