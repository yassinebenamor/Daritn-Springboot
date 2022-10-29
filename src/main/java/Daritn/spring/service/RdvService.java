package Daritn.spring.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;
import Daritn.spring.repository.RdvRepository;

@Service
public class RdvService {
	
	@Autowired
	RdvRepository rdvRepository;
	
	public List<RendezVous> getRdv(){
		List<RendezVous> RendezVous=rdvRepository.findAll();
		for (RendezVous rdv: RendezVous) {
			System.out.println("Contrat :" + rdv);
		}
		return RendezVous;
	}
	public RendezVous addRdv(RendezVous rdv) {
		rdv.setEtat(EnumeratedEtat.Waiting);
		return rdvRepository.save(rdv);
	}
	public RendezVous EditRdv(RendezVous rdv) {
		rdv.setEtat(EnumeratedEtat.Waiting);
		return rdvRepository.save(rdv);
	}
	public void DeleteRdv(int id) {
		rdvRepository.deleteById(id);
	}
	public RendezVous retrieveRdv(int id) {
		RendezVous RendezVous = rdvRepository.findById(id).orElse(null);
		System.out.println("RendezVous :" + RendezVous);
		return RendezVous; 
	}
	public List<RendezVous> getRecherche(String Etat,String region,int iduser){
		List<RendezVous> RendezVous=rdvRepository.RechercheMulti(Etat,region,iduser);
		for (RendezVous rdv: RendezVous) {
			System.out.println("Contrat :" + rdv);
		}
		return RendezVous;
	}
	public int Validate(EnumeratedEtat etat,int id)
	{
		return rdvRepository.updateEtat(etat, id);
	}

	public List<RendezVous> getTodaysRdv(int userid){	
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(formater.format(new Date()));
		return rdvRepository.getTodaysRdvByuser(userid, formater.format(new Date()));	
	}
	public List<RendezVous> getRdvByUser(int userid)
	{
		return rdvRepository.GetRdvByUser(userid);
	}
}
