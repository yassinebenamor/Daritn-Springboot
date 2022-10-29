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

import Daritn.spring.entity.Achat;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.service.AchatService;

@RestController
@RequestMapping("achat")
@CrossOrigin("*")
public class AchatControler {
	
	@Autowired
    private AchatService achatService;
	@Autowired
	private JavaMailSender emailSender;
	
	@GetMapping("/allAchat")
	@ResponseBody
	public List<Achat> retrieveAllAchat() {
		
		return achatService.retrieveAllAchat();
	}

	@PostMapping(value = "addAchat")
	public Achat addAchat (@RequestBody Achat a) {
		a.setEtat(EnumeratedEtat.Waiting);

		
		return achatService.addAchat(a);
	}
	
	/*@PostMapping(value = "/addAchat")

	Achat addAchat () {
		Achat a = new Achat(1L,new ContratAchat(2L)) ;
		
		return achatService.addAchat(a);
	}*/
	
	@PutMapping(value = "updateAchat")
	public Achat updateAchat (@RequestBody Achat a) {
		a.setEtat(EnumeratedEtat.Waiting);

		return achatService.updateAchat(a);
	}
	
	@DeleteMapping(value = "/deleteAchat")
	void removeAchat (@RequestParam Long id) {
		achatService.removeAchat(id);
	}
	@ResponseBody
    @RequestMapping("/sendEmail")
    public String sendSimpleEmail(@RequestParam String FRIEND_EMAIL) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(FRIEND_EMAIL);
        message.setSubject("Bravo!");
        message.setText("votre achat a ete effactuer avec succes");

        this.emailSender.send(message);

        return "Email Sent!";
	}
	
   /*@PutMapping(value = "/updateAchat")

	Achat updateAchat () {
		Achat a = new Achat(1L,new ContratAchat(3L)) ;
	
		return achatService.updateAchat(a);
	}

	public Achat retrieveAchat (Long id) {
		return null;
	}*/
	
	
	
}
