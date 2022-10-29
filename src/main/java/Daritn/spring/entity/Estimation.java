package Daritn.spring.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Estimation {
	
	private boolean appartement; //appartement ou maison
	
	private EnumeratedRegion region;
	
	@Min(10)
	@Max(500)
	private int surface;
	
	@Min(1)
	@Max(10)
	private int nbchambres;
	
	@Min(1940)
	@Max(2022)
	private int annee;
	
	private boolean travaux;
	
	private boolean standing;
	
	private boolean meubles;   //meublé ou non
	
	private boolean periode;   //Periode d'été ou 2eme periode(hors été)
	
	

}
