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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table( name = "mes_criteres")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MesCriteres implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@PositiveOrZero(message = "le min prix doit etre positive ou egale a 0")
	@Column(name="minPrix",nullable =false)
	private int minPrix;
	
	@PositiveOrZero(message = "le max prix doit etre positive ou egale a 0")
	@Column(name="maxPrix",nullable =false)
	private int maxPrix;
	
	@PositiveOrZero(message = "le min Surface doit etre positive ou egale a 0")
	@Column(name="minSurface",nullable =false)
	private int minSurface;
	
	@PositiveOrZero(message = "le maxSurface doit etre positive ou egale a 0")
	@Column(name="maxSurface",nullable =false)
	private int maxSurface;
	
	@PositiveOrZero(message = "le minPrixm2 doit etre positive ou egale a 0")
	@Column(name="minPrixm2",nullable =false)
	private int minPrixm2;
	
	@PositiveOrZero(message = "le maxPrixm2 doit etre positive ou egale a 0")
	@Column(name="maxPrixm2",nullable =false)
	private int maxPrixm2;
	
	@NotNull(message = "vous devez entrer votre region")
	@Column(name="region",length = 1500,nullable =false)
	private String region;
	
	@OneToOne
	private User acheteur;

}
