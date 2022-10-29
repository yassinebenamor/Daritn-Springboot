package Daritn.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;
import Daritn.spring.service.RdvService;

@RestController
@RequestMapping("rdv")
@CrossOrigin("*")
public class RdvController {
	
	@Autowired
	private RdvService RdvService;
	@Autowired
	private JavaMailSender emailSender;
	

	@GetMapping("/")
	@ResponseBody
	public List<RendezVous> getRdv()
	{	
	return RdvService.getRdv();
	}
	
	@GetMapping("/today")
	@ResponseBody
	public List<RendezVous> getTodayRdv(@RequestParam int userid)
	{	
	return RdvService.getTodaysRdv(userid);
	}
	
	@GetMapping(value="/retrieverdv")
	@ResponseBody
	public RendezVous Retrieverdv(@RequestParam int id)
	{
		return RdvService.retrieveRdv(id);
	}
	@PostMapping(value = "/saverdv")
	public RendezVous Addrdv(@RequestBody RendezVous RendezVous)
	{	
		return RdvService.addRdv(RendezVous);
	}
	@PutMapping(value = "/updaterdv")
	public RendezVous Editrdv(@RequestBody RendezVous RendezVous)
	{	
		return RdvService.EditRdv(RendezVous);
	}
	@DeleteMapping(value = "/deleterdv")
	public void Deleterdv(@RequestParam int id)
	{	
		RdvService.DeleteRdv(id);
	}
	@GetMapping(value = "/r")
	public List<RendezVous> Rechercherdv(@RequestParam int id,@RequestParam String etat,@RequestParam String region)
	{	
		return RdvService.getRecherche(etat,region,id);
	}
	@PutMapping(value="/validate")
	public int Validate(@RequestParam int id)
	{
		SmsConfig.sendSMS("Rendez vous a été valider ");
		return RdvService.Validate(EnumeratedEtat.Confirmed, id);	
	}
	@PutMapping(value="/refuse")
	public int Refuse(@RequestParam int id)
	{
		SmsConfig.sendSMS("Rendez vous a été Refuser ");
		return RdvService.Validate(EnumeratedEtat.Refused, id);	
	}
	@GetMapping(value="/getbyuser")
	public List<RendezVous> getRdvByUser(int iduser)
	{
		return RdvService.getRdvByUser(iduser);
	}
	
	

}
