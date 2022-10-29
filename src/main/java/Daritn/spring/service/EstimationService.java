package Daritn.spring.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Estimation;
import Daritn.spring.entity.MaisonALouer;
@Service
public class EstimationService {
	public int getEstimationLocation(Estimation e)
	{
		double Estimation;
		if(e.getRegion().toString().equals("Tunis") || e.getRegion().toString().equals("Sfax")) {
			Estimation=1.5;
		}else if(e.getRegion().toString().equals("Nabeul") || e.getRegion().toString().equals("Sousse") || e.getRegion().toString().equals("Mahdia") || e.getRegion().toString().equals("Monastir")) {
			if(e.isPeriode()) {
				Estimation=1.45;
			}else {
				Estimation=1.25;
			}
		}
			else if(e.getRegion().toString().equals("Bizerte")) {
				if(e.isPeriode())
					Estimation=1.3;
				else
					Estimation=1.15;
		}else if(e.getRegion().toString().equals("Ariana") || e.getRegion().toString().equals("Manouba") || e.getRegion().toString().equals("BenArous")){
			Estimation=1.35;
		}else {
			Estimation=1;
		}
		if(e.isAppartement()==true) {
			if(e.isStanding())
			{
				Estimation*=e.getSurface()*13;
			}
			else {
				Estimation*=e.getSurface()*10;
			}
		}
		else {
			if(e.isStanding())
			{
				Estimation*=e.getSurface()*17.5;
			}
			else
			{
				Estimation*=e.getSurface()*15;
			}
		}
		
		if(e.getAnnee()<2000)
		{
			Estimation-=105;
		}
		if(e.isMeubles())
		{
			Estimation+=85;
		}
		if(e.isTravaux())
		{
			Estimation-=70;
		}
		if(e.getNbchambres()==1) Estimation+=25;
		if(e.getNbchambres()==2 || e.getNbchambres()==3) Estimation+=e.getNbchambres()*40;
		if(e.getNbchambres()>3) Estimation+=e.getNbchambres()*50;
		return (int)(Estimation-Estimation%10);
	}


	public Double estimationAchat(Estimation estimation) {
		
		Double e;
		
		if(estimation.getRegion().toString().equals("Tunis" ) || estimation.getRegion().toString().equals("Sfax")) {
			e=1.6;}
		else if(estimation.getRegion().toString().equals("Mahdia" ) || estimation.getRegion().toString().equals("Sousse") || estimation.getRegion().toString().equals("Mestir") || estimation.getRegion().toString().equals("Bizerte")|| estimation.getRegion().toString().equals("Nabeul"))
			e=1.4;
		else if(estimation.getRegion().toString().equals("Ariana" ) || estimation.getRegion().toString().equals("BenArous") || estimation.getRegion().toString().equals("Mestir") || estimation.getRegion().toString().equals("Bizerte"))
		    e=1.3;
			else {
			e=1.0;
			
		}
		
		if(estimation.isAppartement()) {
			System.out.println("appartement");
			if(estimation.isStanding())
			{
				System.out.println("1e="+e);
			
			e*=estimation.getSurface()*1800;
			System.out.println("2e="+e);

			}
			else
			e*=estimation.getSurface()*1500;
		}
		else {
			System.out.println("!appartement");

			if(estimation.isStanding())
			e*=estimation.getSurface()*2000;
			else
			e*=estimation.getSurface()*1700;
		}
		    
		  if(estimation.getAnnee()<2000)
			  e-=estimation.getSurface()*500;
         
		  if(estimation.isTravaux())
			  e-=estimation.getSurface()*175;
		  
		  if(estimation.isMeubles())
			  e+=200;
		  
		  if(estimation.getNbchambres()<=2)
			  e+=estimation.getSurface()*200;
		  else
		       e+=estimation.getSurface()*250;
		  
		  
			  
		  return e;	
	}
	
	public List<MaisonALouer> getPage(String region) throws MalformedURLException, IOException
	{
		int i=0;
		List<MaisonALouer> ListMaison = new ArrayList<>();
		List<MaisonALouer> subListMaison = new ArrayList<>();
		String url;
		if(region.equals("Ariana"))
		url="http://www.tunisie-annonce.com/AnnoncesImmobilier.asp?rech_cod_pay=TN&rech_cod_vil=10201&rech_cod_loc=1020101";
		if(region.equals("Tunis"))
		url="http://www.tunisie-annonce.com/AnnoncesImmobilier.asp?rech_cod_pay=TN&rech_cod_vil=10107&rech_cod_loc=1010703";
		else
		url="http://www.tunisie-annonce.com/AnnoncesImmobilier.asp?rech_cod_pay=TN&rech_cod_vil=11714&rech_cod_loc=1171427";
		Document doc = Jsoup.connect(url).get();
		Elements body = doc.select("tbody");
		for(Element tr : body.select("tr.Tableau1"))
		{
			MaisonALouer MAL = new MaisonALouer();
			for(Element td : tr.select("td"))
			{
				
				if(!td.text().isEmpty()) {
					//System.out.println("------------------");
					if(i==0){MAL.setRegion(td.text().substring(2, td.text().length()));}
					if(i==1){MAL.setNature(td.text().substring(2, td.text().length()));}
					
					if(i==2){MAL.setType(td.text().substring(2, td.text().length()));}
					
					if(i==4){MAL.setPrix(td.text());}
					if(i==5){MAL.setModifier(td.text().substring(2, td.text().length()));
					ListMaison.add(MAL);
					}/*
					System.out.println(i);
					System.out.println(td.text());
					System.out.println("------------------");
					 */
					i++;
					}
			}
		i=0;
		}
	for(int j=0;j<ListMaison.size();j++)
	{
		if(ListMaison.get(j).getNature().equals("Location")) {
			subListMaison.add(ListMaison.get(j));
		}
		
	}
		return subListMaison;
	}

}
