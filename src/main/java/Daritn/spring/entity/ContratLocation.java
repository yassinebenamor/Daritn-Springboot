package Daritn.spring.entity;

import java.io.Serializable;


import java.util.Date;

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
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "ContratLocation")
public class ContratLocation implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idContrat")
	private Long id;
	
	@Size(min = 1,max = 255)
	@Column(name="nom")
	private String nom;
	
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Debut",nullable =true)
	private Date dateDebut;
	
	@Future(message = "la date doit être supperieur a la date d'aujourd'hui")
	@Temporal (TemporalType.DATE)
	@Column(name="Date_Fin",nullable =false)
	private Date dateFin;
	
	@Size(min=10,message = "La longueur doit être supperieur a 200 caracteres ")
	@Size(max=1500,message="La longueur ne doit pas depasser 1500 caracteres ")
	@Column(name="Reglement",length = 1500,nullable =false)
	private String reglement;
	
	@Enumerated(EnumType.STRING)
	private EnumeratedEtat etat;
	
	@OneToOne
	private User Locataire; 
	
}
