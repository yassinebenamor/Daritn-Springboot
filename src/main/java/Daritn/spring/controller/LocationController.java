package Daritn.spring.controller;

import java.util.ArrayList;
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

import Daritn.spring.entity.DepotDeGaranties;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.Location;
import Daritn.spring.service.LocationService;


@RestController
@RequestMapping("location")
@CrossOrigin("*")
public class LocationController {
	
	@Autowired
	private LocationService LocationService;
	
	@GetMapping("/")
	@ResponseBody
	public List<Location> getLocation()
	{	
		return LocationService.getLocations();
	}
	
	@GetMapping(value="/retrievelocation")
	@ResponseBody
	public Location RetrieveLocation(@RequestParam Long id)
	{
		return LocationService.retrieveLocation(id);
	}
	
	@PostMapping(value = "/saveLocation")
	public Location AddLocation(@RequestBody Location Location)
	{
		Location.setEtat(EnumeratedEtat.Waiting);
		return LocationService.addLocation(Location);
	}
	@PutMapping(value = "/updateLocation")
	public Location EditLocation(@RequestBody Location Location)
	{	
		return LocationService.EditLocation(Location);
	}
	
	@DeleteMapping(value = "/deleteLocation")
	public void DeleteLocation(@RequestParam Long id)
	{	
		LocationService.DeleteLocation(id);
	}
	
	@PutMapping(value="/validate")
	public int Validate(@RequestParam Long id)
	{
		return LocationService.Validate(EnumeratedEtat.Confirmed, id);	
	}
	@PutMapping(value="/refuse")
	public int Refuse(@RequestParam Long id)
	{
		return LocationService.Validate(EnumeratedEtat.Refused, id);	
	}
	
	@GetMapping("/stat")
	@ResponseBody
	public List<Integer> getStat()
	{	
		List<Integer> list=new ArrayList<Integer>(); 
		list.add(LocationService.Stat("Vacances"));
		list.add(LocationService.Stat("Temporraire"));
		list.add(LocationService.Stat("Year"));
		list.add(LocationService.Stat("Long_Period"));
		return list;	
	}
	
}
