package Daritn.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.SimulationCredit;
import Daritn.spring.repository.ContratAchatRepository;

@Service
public class ContratAchatService  {
	
	@Autowired 
	ContratAchatRepository ContratAchatRepository;

	
	
	public List<ContratAchat> retrieveAllContratAchat() {
		List<ContratAchat> ContratAchats= ContratAchatRepository.findAll();
		for (ContratAchat ContratAchat: ContratAchats) {
			System.out.println("Achat :" + ContratAchat);
		}
		return ContratAchats;
	}
	
	public ContratAchat addContratAchat(ContratAchat ca) {

		return ContratAchatRepository.save(ca);

	}

	
	public ContratAchat updateContratAchat(ContratAchat ca) {
		return ContratAchatRepository.save(ca);

	}

	public ContratAchat retrieveContratAchat(Long id) {
		ContratAchat ContratAchat = ContratAchatRepository.findById(id).orElse(null);
		System.out.println("Contrat d'Achat :" + ContratAchat);
		return ContratAchat;
	}

	
	public void removeContratAchat(Long id) {
		ContratAchatRepository.deleteById(id);
		
	}
	 public List<ContratAchat> SearchContratAchat(String etat, String reglement) {
	        if (etat != null && reglement !=null) {
	            return ContratAchatRepository.search(etat, reglement);
	        }
	        return ContratAchatRepository.findAll();
	    }
	 
		public List<ContratAchat> retrieveAllJContratAchatByUserID(Long id) {
			List<ContratAchat> ContratAchats= ContratAchatRepository.findAllContratByUserID(id);
			
			return ContratAchats;
		}
		public int Validate(EnumeratedEtat etat,Long id)
		{
			return ContratAchatRepository.updateEtat(etat, id);
		}
		
		public Integer statContrat(String etat)
		{
			return ContratAchatRepository.statContrat(etat);
		}
}


