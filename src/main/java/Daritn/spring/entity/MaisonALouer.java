package Daritn.spring.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MaisonALouer {
	
	private String region;
	private String nature;
	private String type;
	private String prix;
	private String Modifier;
	

}
