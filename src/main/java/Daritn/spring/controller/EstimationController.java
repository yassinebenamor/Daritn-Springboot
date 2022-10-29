package Daritn.spring.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Daritn.spring.entity.Estimation;
import Daritn.spring.entity.MaisonALouer;
import Daritn.spring.service.EstimationService;

@RequestMapping("Estimation")
@CrossOrigin("*")
@RestController
public class EstimationController {
	@Autowired
	private EstimationService estimationService;
	
	@GetMapping(value="/page")
	@ResponseBody
	public List<MaisonALouer> getPage(@RequestParam String region) throws MalformedURLException, IOException
	{
    	return estimationService.getPage(region);
	}
	
	@PostMapping(value = "/")
	public int GetEstimation(@RequestBody Estimation Est)
	{	
		return estimationService.getEstimationLocation(Est);
	}

    @PostMapping("/Estimate")
	@ResponseBody
	Double retrieveAllContratAchat(@RequestBody Estimation e) {
		return estimationService.estimationAchat(e);
	}
    
}
