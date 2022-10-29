package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.Achat;
import Daritn.spring.repository.AchatRepository;;



@Service
public class AchatService {

	@Autowired 
	AchatRepository achatRepository;

	public List<Achat> retrieveAllAchat() {
		
		
		return achatRepository.findAll();
	}

	
	public Achat addAchat(Achat a) {
		return achatRepository.save(a);

	}

	public Achat updateAchat(Achat a) {
		return achatRepository.save(a);

	}

    public Achat retrieveAchat(Long id) {
		Achat achat = achatRepository.findById(id).orElse(null);
		System.out.println("Achat :" + achat);
		return achat; 
	}

	public void removeAchat(Long id) {
	achatRepository.deleteById(id);
		
	}
}

