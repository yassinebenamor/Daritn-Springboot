package Daritn.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.RendezVous;

@Repository
public interface RdvRepository extends JpaRepository<RendezVous, Integer>  {
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE demandeur_id_user=?3 AND etat LIKE %?1% AND region LIKE %?2%",nativeQuery =true)
	public List<RendezVous> RechercheMulti(String Etat,String region,int iduser); 
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE  demandeur_id_user = ?1",nativeQuery =true)
	public List<RendezVous> GetRdvByUser(int id); 
	
	@Modifying
	@Transactional 
	@Query("update RendezVous rv set rv.etat = ?1 where rv.id = ?2")
	int updateEtat(EnumeratedEtat Etat,int idrdv); 
	
	@Query(value="SELECT * FROM `rendez_vous` WHERE  demandeur_id_user = ?1 AND date=?2 AND etat='Confirmed'",nativeQuery = true)
	public List<RendezVous> getTodaysRdvByuser(int id , String date);
	
	
	
}
