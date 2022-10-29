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
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "DepotDeGaranties")
public class DepotDeGaranties implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="moisLoyers")
	private int moisLoyers;
	
	
	@Column(name = "somme")
	private int Somme;
	
	
	@Column(name="numeroPayment")
	private int numeroPayment;
	
	@Temporal(TemporalType.DATE)
	private Date editedAt;
	
	@Enumerated(EnumType.STRING)
	private EnumeratedEtat etat;
	
	@OneToOne
	private User user;
	
	
}

/*
@Size(min = 3,message = "")
@Size(max = 255,message="")
@Column(name="caution")
private String caution;

private String docType;

@Lob
private byte[] data;
*/
