package Daritn.spring.entity;
import java.io.Serializable;
import java.sql.Date;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table( name = "Achat")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Achat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
    private Date date;
    
    
	@Enumerated(EnumType.STRING)
    private EnumeratedEtat etat;
	
	@OneToOne
	private Annonce annonce;
	
	@OneToOne
	private User acheteur;	
         
	public Long getId() {return id;}

	
}
	
	
