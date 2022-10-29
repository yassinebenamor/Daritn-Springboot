package Daritn.spring.repository;

import java.util.Date;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.DepotDeGaranties;
import Daritn.spring.entity.EnumeratedEtat;
@Repository
public interface DepotDeGarantiesRepository extends JpaRepository<DepotDeGaranties, Integer> , CrudRepository<DepotDeGaranties, Integer> {
	@Query(value="SELECT * FROM `depot_de_garanties` ddg join `user` u on u.id_user=ddg.user_id_user  where ddg.user_id_user =?1",nativeQuery =true)
	public List<DepotDeGaranties> findAllDepot(int id);   

	@Modifying
	@Transactional 
	@Query("update DepotDeGaranties ddg set ddg.etat = ?1 , ddg.editedAt=?2 where ddg.id = ?3")
	int updateEtat(EnumeratedEtat Etat,Date today,int iddepot); 
	
	@Query(value="SELECT * FROM `depot_de_garanties` ddg join `user` u on u.id_user=ddg.user_id_user  where ddg.user_id_user =?1 order by id desc limit 1",nativeQuery =true)
	public DepotDeGaranties findAllByLocataires(int id);
	
	@Query(value="SELECT * FROM `depot_de_garanties` ddg where etat='Refused' && edited_at< ?1",nativeQuery =true)
	public List<DepotDeGaranties> getUnchanged(String date);
	

	@Query(value="SELECT * FROM `depot_de_garanties` ORDER BY ID DESC LIMIT 1",nativeQuery =true)
	public DepotDeGaranties getLast();

}
