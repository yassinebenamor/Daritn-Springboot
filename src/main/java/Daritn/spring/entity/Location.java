package Daritn.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table( name = "Location")
public class Location implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idLocation")
	private Long id;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Debut",nullable =true)
	private Date dateDebut;
	
	@Future(message = "la date doit être supperieur a la date d'aujourd'hui")
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Fin",nullable =false)
	private Date dateFin;
	
	@Enumerated(EnumType.STRING)
	private EnumeratedTypeTemporel typelocation; 
	
	@Enumerated(EnumType.STRING)
	private EnumeratedEtat etat;
	
	@OneToOne
	private DepotDeGaranties garanties ;
	
	@OneToOne
	private Annonce bien;
	
	@OneToOne
	private User locataire;
	
}
