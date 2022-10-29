package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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


import Daritn.spring.entity.MesCriteres;
import Daritn.spring.entity.SimulationCredit;
import Daritn.spring.service.MesCriteresService;

@RestController
@RequestMapping("MesCriteres")
@CrossOrigin("*")
public class MesCriteresController {
	
     @Autowired
	private MesCriteresService mesCriteresService;
	
	@GetMapping("/allMesCriteres")
	@ResponseBody
	List<MesCriteres> retrieveAllMesCriteres() {
		return mesCriteresService.retrieveAllMesCriteres();
	}
/*
	@PostMapping(value = "/addSimulationCredit")

	SimulationCredit addSimulationCredit () {
		SimulationCredit sc = new SimulationCredit(2000,2500,10000,2020,new User(1L)) ;
		
		return simulationCrediService.addSimulationCredit(sc);
	}*/

	@PostMapping(value = "addMesCriteres")
	MesCriteres addMesCriteres (@RequestBody MesCriteres sc) {
	/*if(!mesCriteresService.retrieveAllMesCriteres().isEmpty())
	mesCriteresService.deleteMesCriteres();*/
		return mesCriteresService.addMesCriteres(sc);
	
	}

	/*@PutMapping(value = "/updateSimulationCredit")

	SimulationCredit updateSimulationCredit () {
		SimulationCredit sc = new SimulationCredit(1L,7000,2500,10000,2020,new User(1L)) ;
		
		return simulationCrediService.updateSimulationCredit(sc);
	}*/

	@PutMapping(value = "updateMesCriteres")
	MesCriteres updateMesCriteres (@RequestBody MesCriteres sc) {
		return mesCriteresService.updateMesCriteres(sc);
	}
    
	/*@GetMapping("/allSimulationCredit")

	SimulationCredit retrieveSimulationCredit (Long id) {
		return null;
	}*/
	
	@DeleteMapping(value = "deleteMesCriteres")
	void removeMesCriteres (@RequestParam Long id) {
		mesCriteresService.removeMesCriteres(id);
	}
	
	/*
	@Scheduled(fixedRate = 10000)
	public void cronMethod() {
		
	MesCriteres critere = mesCriteresService.afficherMesCriteres();
	System.out.println(critere);
	System.out.println((int)critere.getMinPrix());
	
	mesCriteresService.SearchMescritere(critere.getMinPrix(), critere.getMaxPrix(), critere.getMinPrixm2(), critere.getMaxPrixm2(), critere.getMinSurface(), critere.getMaxSurface(), critere.getRegion());
	
	
	System.out.println(	mesCriteresService.SearchMescritere(critere.getMinPrix(), critere.getMaxPrix(), critere.getMinPrixm2(), critere.getMaxPrixm2(), critere.getMinSurface(), critere.getMaxSurface(), critere.getRegion()));

	}*/
}