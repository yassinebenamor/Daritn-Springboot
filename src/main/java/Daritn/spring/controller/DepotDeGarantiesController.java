package Daritn.spring.controller;

import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Daritn.spring.entity.DepotDeGaranties;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.Location;
import Daritn.spring.entity.MaisonALouer;
import Daritn.spring.service.DepotDeGarantiesService;
import Daritn.spring.service.LocationService;


@RestController
@RequestMapping("DepotDeGaranties")
@CrossOrigin("*")
public class DepotDeGarantiesController {
	@Autowired
	private DepotDeGarantiesService dpgs;
	@Autowired
	private LocationService ls;
	
	@Autowired
	private JavaMailSender emailSender;
	
	

	@GetMapping("/")
	@ResponseBody
	public List<DepotDeGaranties> getDepots(int id)
	{	
		return  dpgs.getDepot(id);
	}
	
	@GetMapping("/getAllDepot")
	@ResponseBody
	public List<DepotDeGaranties> getAllDepots()
	{	
		return dpgs.getAllDepot();
	}
	
	@PostMapping(value = "/saveDepot")
	public DepotDeGaranties AddDepot(@RequestBody DepotDeGaranties ddg)
	{	ddg.setEditedAt(new Date());
		return dpgs.addDepot(ddg);
	}
	
	@PutMapping(value = "/updateDepot")
	public DepotDeGaranties EditDepot(@RequestBody DepotDeGaranties depot)
	{	
		depot.setEditedAt(new Date());
		return dpgs.EditDepotDeGarantie(depot);
	}
	
	@PutMapping(value="/validate")
	public int Validate(@RequestParam int id)
	{
		return dpgs.Validate(EnumeratedEtat.Confirmed, id);	
	}
	@PutMapping(value="/refuse")
	public int Refuse(@RequestParam int id)
	{
		return dpgs.Validate(EnumeratedEtat.Refused, id);	
	}
	@DeleteMapping(value = "/deleteDepot")
	public void DeleteDepot(@RequestParam int id)
	{	
		dpgs.DeleteDepotDeGarantie(id);
	}
	
	@GetMapping(value="/dbl")
	@ResponseBody
	public DepotDeGaranties getDepotByLocataire(@RequestParam int id)
	{
		return dpgs.getDepotUser(id);
	}
	
	@GetMapping(value="/last")
	@ResponseBody
	public DepotDeGaranties getLast()
	{
		return dpgs.getLast();
	}
	
	@Scheduled(fixedRate = 60000)
	public void DeleteUnchanged() {
		
	SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DAY_OF_MONTH, -3); 
	
	String date =formater.format(cal.getTime());
	for(DepotDeGaranties ddg : dpgs.getUnchanged(date))
	{	
		for(Location location : ls.getLocations())
		{
			if(location.getGaranties().getId()==ddg.getId())
			{
				SimpleMailMessage message = new SimpleMailMessage();
				String FRIEND_EMAIL="yassine.benamor@esprit.tn";
		        message.setTo(FRIEND_EMAIL);
		        message.setSubject("Votre Depot et location a été annuler");
		        message.setText("Nous avons decider d'annuler votre Depot de garantie :\n montant de "+ddg.getSomme()+"DT pour une delais de"+ ddg.getMoisLoyers() + " mois \nnumero de payment : "+ddg.getNumeroPayment() +
		        		"\n et location de "+location.getTypelocation()+"appartir du " + location.getDateDebut()+" au "+location.getDateFin() +" pour raison de non validité du payment");
		        this.emailSender.send(message);
				ls.DeleteLocation(location.getId());
			}
		}
		
		dpgs.DeleteDepotDeGarantie(ddg.getId());
	}
	
	}
	
	/*
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		DepotDeGaranties doc = dpgs.retrieveDepotDeGaranties(fileId);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getCaution()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
	@PostMapping(value = "/saveDepot" ,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public DepotDeGaranties AddDepot(@RequestBody MultipartFile caution) throws IllegalStateException, IOException
	{	
		
		return dpgs.addDepotDeGarantie(new DepotDeGaranties(),caution);
	}
	*/
	
	
	
}
