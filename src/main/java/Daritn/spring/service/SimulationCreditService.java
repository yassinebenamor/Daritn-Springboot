package Daritn.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Daritn.spring.entity.SimulationCredit;
import Daritn.spring.repository.SimulationCreditRepository;

@Service
public class SimulationCreditService {

	@Autowired  
	SimulationCreditRepository SimulationCreditRepository;

	public List<SimulationCredit> retrieveAllSimulationCredit() {
		List<SimulationCredit> SimulationCredits= SimulationCreditRepository.findAll();
		for (SimulationCredit SimulationCredit: SimulationCredits) {
			System.out.println("Simulation Credit :" + SimulationCredit);
		}
		return SimulationCredits;
	}

	public SimulationCredit addSimulationCredit(SimulationCredit sc) {
		return SimulationCreditRepository.save(sc);

	}

	public SimulationCredit updateSimulationCredit(SimulationCredit sc) {
		return SimulationCreditRepository.save(sc);

	}

	public SimulationCredit retrieveSimulationCredit(Long id) {
		SimulationCredit SimulationCredit = SimulationCreditRepository.findById(id).orElse(null);
		System.out.println("Simulation Credit :" + SimulationCredit);
		return SimulationCredit;
	}

    public void removeSimulationCredit(Long id) {
	SimulationCreditRepository.deleteById(id);
	}
    
    public List<SimulationCredit> SearchSimulationCredit(int keyword) {
        if (keyword != 0) {
            return SimulationCreditRepository.search(keyword);
        }
        return SimulationCreditRepository.findAll();
    }
    public List<SimulationCredit> TrieSimulationCredit() {
		List<SimulationCredit> SimulationCredits= SimulationCreditRepository.findByOrderBySalaireAsc();
		for (SimulationCredit SimulationCredit: SimulationCredits) {
			System.out.println("Simulation Credit :" + SimulationCredit);
		}
		return SimulationCredits;
	}

    public List<SimulationCredit> TrieMSimulationCredit() {
		List<SimulationCredit> SimulationCredits= SimulationCreditRepository.findAll(Sort.by("salaire").descending().and(Sort.by("plafond")));
		for (SimulationCredit SimulationCredit: SimulationCredits) {
			System.out.println("Simulation Credit :" + SimulationCredit);
		}
		return SimulationCredits;
	}

}
