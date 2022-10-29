package Daritn.spring.service;

import java.util.List;






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.ContratLocation;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.repository.ContratLocationRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ContratLocationService {
	
	@Autowired
	private ContratLocationRepository contratLocationRepository;
	
	public List<ContratLocation> getContratLs(){
		List<ContratLocation> ContratLocations=contratLocationRepository.findAllContrat();
		for (ContratLocation Contrat: ContratLocations) {
			System.out.println("Contrat :" + Contrat);
		}
		return ContratLocations;
	}
	public List<ContratLocation> getAllContratLs(){
		List<ContratLocation> ContratLocations=contratLocationRepository.findAll();
		for (ContratLocation Contrat: ContratLocations) {
			System.out.println("Contrat :" + Contrat);
		}
		return ContratLocations;
	}
	public ContratLocation addContratLocation(ContratLocation cl) {
		cl.setEtat(EnumeratedEtat.Waiting);
		return contratLocationRepository.save(cl);
	}
	public ContratLocation EditContratLocation(ContratLocation cl) {
		cl.setEtat(EnumeratedEtat.Waiting);
		return contratLocationRepository.save(cl);
	}
	public void DeleteContratLocation(Long id) {
		contratLocationRepository.deleteById(id);
	}
	public ContratLocation retrieveContratLocation(Long id) {
		ContratLocation ContratLocation = contratLocationRepository.findById(id).orElse(null);
		System.out.println("Contrat de Location :" + ContratLocation);
		return ContratLocation; 
	}
	public List<ContratLocation> TrieByEtatPrix(){
		return contratLocationRepository.findAll(Sort.by("dateDebut").descending().and(Sort.by("etat")));
	}
	
	public int Validate(EnumeratedEtat etat,Long id)
	{
		return contratLocationRepository.updateEtat(etat, id);
	}
	public List<ContratLocation> getContratLsUser(int iduser)
	{
		 return contratLocationRepository.findAllByLocataires(iduser);
	}

}
