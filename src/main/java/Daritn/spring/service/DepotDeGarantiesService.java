package Daritn.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.File;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Daritn.spring.entity.DepotDeGaranties;
import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.repository.DepotDeGarantiesRepository;


@Service
public class DepotDeGarantiesService {
	@Autowired
	private DepotDeGarantiesRepository ddgr;
	private final static String filepath=System.getProperty("user.dir").concat("\\uploads\\");
	
	public List<DepotDeGaranties> getDepot(int id){
		return ddgr.findAllDepot(id);
	}
	public List<DepotDeGaranties> getAllDepot(){
		List<DepotDeGaranties> DepotDeGaranties=ddgr.findAll();
		for (DepotDeGaranties Depot: DepotDeGaranties) {
			System.out.println("Depot :" + Depot);
		}
		return DepotDeGaranties;
	}
	/*
	public DepotDeGaranties addDepotDeGarantie(DepotDeGaranties dg,MultipartFile caution) throws IllegalStateException, IOException {
		String docname = caution.getOriginalFilename();
		  try {
			  dg.setCaution(docname);
			  dg.setDocType(caution.getContentType());
			  dg.setData(caution.getBytes());
			  dg.setCaution(caution.getOriginalFilename());
			  dg.setEtat(EnumeratedEtat.Waiting);
			  dg.setEditedAt(new Date());
			  return ddgr.save(dg);
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		  return null;
	}*/
	public DepotDeGaranties addDepot(DepotDeGaranties dg)
	{
		dg.setEtat(EnumeratedEtat.Waiting);
		dg.setEditedAt(new Date());
		return ddgr.save(dg);
	}
	public DepotDeGaranties EditDepotDeGarantie(DepotDeGaranties ddg){
		
		ddg.setEtat(EnumeratedEtat.Waiting);
		ddg.setEditedAt(new Date());
		return ddgr.save(ddg);
	}
	public void DeleteDepotDeGarantie(int id) {
		ddgr.deleteById(id);
	}
	public int Validate(EnumeratedEtat etat,int id)
	{
		return ddgr.updateEtat(etat,new Date(), id);
	}
	public DepotDeGaranties getDepotUser(int iduser)
	{
		 return ddgr.findAllByLocataires(iduser);
	}
	
	public DepotDeGaranties retrieveDepotDeGaranties(int id) {
		DepotDeGaranties DepotDeGaranties = ddgr.findById(id).orElse(null);
		System.out.println("Contrat de Location :" + DepotDeGaranties);
		return DepotDeGaranties; 
	}
	public void deleteDepot(int id) {
		ddgr.deleteById(id);
	}
	public List<DepotDeGaranties> getUnchanged(String date)
	{
		return ddgr.getUnchanged(date);
	}
	public DepotDeGaranties getLast() {
		return ddgr.getLast();
	}
}
