package Daritn.spring.controller;

import java.util.Date;

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

import Daritn.spring.config.SmsConfig;
import Daritn.spring.entity.ContratLocation;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.service.ContratLocationService;

@RestController
@RequestMapping("contratlocation")
@CrossOrigin("*")
public class ContratLocationController {
	@Autowired
	private ContratLocationService contratLocationService;

	
	@GetMapping("/")
	@ResponseBody
	public List<ContratLocation> getContratLs()
	{	
		return contratLocationService.getContratLs();
	}
	@GetMapping("/getAllContrat")
	@ResponseBody
	public List<ContratLocation> getAllContratLs()
	{	
		return contratLocationService.getAllContratLs();
	}
	
	@GetMapping(value="/retrievecl")
	@ResponseBody
	public ContratLocation RetrieveContratL(@RequestParam Long id)
	{
		return contratLocationService.retrieveContratLocation(id);
	}
	
	@PostMapping(value = "/savecontratL")
	public ContratLocation AddContratL(@RequestBody ContratLocation clo)
	{	
		clo.setDateDebut(new Date());
		clo.setEtat(EnumeratedEtat.Waiting);
		return contratLocationService.addContratLocation(clo);
	}
	
	@PutMapping(value = "/updateContratL")
	public ContratLocation EditContratL(@RequestBody ContratLocation clo)
	{	
		return contratLocationService.EditContratLocation(clo);
	}
	@PutMapping(value = "/updateContrat")
	public ContratLocation EditContrat(@RequestBody ContratLocation clo,@RequestParam long id)
	{	
		clo.setId(id);
		return contratLocationService.EditContratLocation(clo);
	}
	
	@PutMapping(value="/validate")
	public int Validate(@RequestParam Long id)
	{
		return contratLocationService.Validate(EnumeratedEtat.Confirmed, id);	
	}
	@PutMapping(value="/refuse")
	public int Refuse(@RequestParam Long id)
	{
		return contratLocationService.Validate(EnumeratedEtat.Refused, id);	
	}
	@DeleteMapping(value = "/deleteContratL")
	public void DeleteContratL(@RequestParam Long id)
	{	
		contratLocationService.DeleteContratLocation(id);
	}
	@GetMapping(value="/orderbyetatdate")
	@ResponseBody
	public List<ContratLocation> SortByEtat()
	{
		return contratLocationService.TrieByEtatPrix();
	}
	
	
	@GetMapping(value="/contratbyuser")
	@ResponseBody
	public List<ContratLocation> getContratsByLocataire(@RequestParam int id)
	{
		return contratLocationService.getContratLsUser(id);
	}
	
}
