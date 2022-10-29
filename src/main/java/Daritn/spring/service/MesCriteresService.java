package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Annonce;
import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.MesCriteres;
import Daritn.spring.repository.AnnonceRepository;
import Daritn.spring.repository.MesCriteresRepository;

@Service
public class MesCriteresService {
	
	@Autowired  
	MesCriteresRepository MesCriteresRepository;
	@Autowired  

    AnnonceRepository AnnonceRepository;
    
	public List<MesCriteres> retrieveAllMesCriteres() {
		List<MesCriteres> Criteres= MesCriteresRepository.findAll();
		for (MesCriteres MesCriteres: Criteres) {
			System.out.println("Simulation Credit :" + MesCriteres);
		}
		return Criteres;
	}

	public MesCriteres addMesCriteres(MesCriteres sc) {
		return MesCriteresRepository.save(sc);
	}

	public MesCriteres updateMesCriteres(MesCriteres sc) {
		return MesCriteresRepository.save(sc);

	}

	
    public void removeMesCriteres(Long id) {
	MesCriteresRepository.deleteById(id);
	}

    public List<Annonce> SearchMescritere(int prixmin, int prixmax, int prixm2min, int prixm2max, int surfacemin, int surfacemax, String region) {
       
            return AnnonceRepository.selectedAd(prixmin, prixmax, prixm2min, prixm2max, surfacemin, surfacemax, region);      
    }
    
    public void deleteMesCriteres() {
    	MesCriteresRepository.deleteAll();
    	}
    
    public MesCriteres afficherMesCriteres() {
		MesCriteres Criteres= MesCriteresRepository.allmescriteres();
		
		return Criteres;
	}
}
