package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.twiml.voice.Sms;

import Daritn.spring.entity.SimulationCredit;
import Daritn.spring.entity.User;
import Daritn.spring.service.SimulationCreditService;

@RestController
@RequestMapping("simulationCredit")
@CrossOrigin("*")
public class SimulationCreditControler {
	
     @Autowired
	private SimulationCreditService simulationCrediService;
	
	@GetMapping("/allSimulationCredit")
	@ResponseBody
	List<SimulationCredit> retrieveAllSimulationCredit() {
		
		return simulationCrediService.retrieveAllSimulationCredit();
	}
/*
	@PostMapping(value = "/addSimulationCredit")

	SimulationCredit addSimulationCredit () {
		SimulationCredit sc = new SimulationCredit(2000,2500,10000,2020,new User(1L)) ;
		
		return simulationCrediService.addSimulationCredit(sc);
	}*/

	@PostMapping(value = "addSimulationCredit")
	
	
	SimulationCredit addSimulationCredit (@RequestBody SimulationCredit sc) {
		
		
		sc.setMensualite((float) ((sc.getPlafond()*1.02)/(12*sc.getAnnee())));
        System.out.println("auto" + sc.getAutofinancement());
        System.out.print("anee" + sc.getAnnee());
		return simulationCrediService.addSimulationCredit(sc);
	}

	/*@PutMapping(value = "/updateSimulationCredit")

	SimulationCredit updateSimulationCredit () {
		SimulationCredit sc = new SimulationCredit(1L,7000,2500,10000,2020,new User(1L)) ;
		
		return simulationCrediService.updateSimulationCredit(sc);
	}*/

	@PutMapping(value = "updateSimulationCredit")
	SimulationCredit updateSimulationCredit (@RequestBody SimulationCredit sc) {

		return simulationCrediService.updateSimulationCredit(sc);
	}
    
	/*@GetMapping("/allSimulationCredit")

	SimulationCredit retrieveSimulationCredit (Long id) {
		return null;
	}*/
	
	@DeleteMapping(value = "deleteSimulationCredit")
	void removeSimulationCredit (@RequestParam Long id) {
		simulationCrediService.removeSimulationCredit(id);
	}
	
	@GetMapping("/SearchSimulationCredit")
	@ResponseBody
	List<SimulationCredit> SearchSimulationCredit(@RequestParam int keyword) {
		return simulationCrediService.SearchSimulationCredit(keyword);
	}
	
	@GetMapping("/trieSimulationCredit")
	@ResponseBody
	List<SimulationCredit> TrieSimulationCredit() {
		return simulationCrediService.TrieSimulationCredit();
	}
	@GetMapping("/trieMSimulationCredit")
	@ResponseBody
	List<SimulationCredit> TrieMSimulationCredit() {
		return simulationCrediService.TrieMSimulationCredit();
	}
}
