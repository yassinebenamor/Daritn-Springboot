package Daritn.spring.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table( name = "SimulationCredit")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class SimulationCredit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@PositiveOrZero(message = "le salaire doit etre positive ou egale a 0")
	@Column(name="salaire",nullable =false)
	private float salaire;
	
	@PositiveOrZero(message = "l'autofinancement doit etre positive ou egale a 0")
	@Column(name="autofinancement",nullable =false)
	private float autofinancement;
    
	@Positive(message = "le plafond doit etre positive")
	@Column(name="plafond",nullable =false)
	private float plafond;
	
	@Min(1)
	@Max(30)
	@Column(name="annee",nullable =false)
	private int annee;
	
	
	private float mensualite;
	
	@OneToOne
	private User acheteur;

	public Long getId() {return id;}

	public float getSalaire() {return salaire;}

	public void setSalaire(float salaire) {this.salaire = salaire;}

	public float getAutofinancement() {return autofinancement;}

	public void setAutofinancement(float autofinancement) {this.autofinancement = autofinancement;}

	public float getPlafond() {return plafond;}

	public void setPlafond(float plafond) {this.plafond = plafond;}

	public int getAnnee() {return annee;}

	public int setAnnee(int annee) {return this.annee = annee;}

	public User getAcheteur() {return acheteur;}

	public void setAcheteur(User acheteur) {this.acheteur = acheteur;}

	

	
	
	public SimulationCredit(float salaire, float autofinancement, float plafond, int annee, User acheteur) {
		this.salaire = salaire;
		this.autofinancement = autofinancement;
		this.plafond = plafond;
		this.annee = annee;
		this.acheteur = acheteur;
	}
	
	
}
