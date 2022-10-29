package Daritn.spring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.EnumeratedEtat;

public interface ContratAchatRepository extends JpaRepository<ContratAchat, Long>, CrudRepository<ContratAchat, Long> {

	@Query(value="SELECT * FROM `contrat_achat` WHERE etat=?1 AND reglement LIKE %?2%", nativeQuery=true)
	
    public List<ContratAchat> search(String etat, String reglement);
	
	
	@Query(value="SELECT * FROM `contrat_achat` cl JOIN `annonce` an join `user` u on u.id_user=cl.acheteur_id_user where cl.acheteur_id_user=?1",nativeQuery =true)
    public List<ContratAchat> findAllContrat(Long Userid);  
	
	@Query(value="SELECT * FROM `contrat_achat` where acheteur_id_user=?1",nativeQuery = true)
    public List<ContratAchat> findAllContratByUserID(Long Userid);  
	
	
	
	@Modifying
	@Transactional 
	@Query("update ContratAchat cl set cl.etat = ?1 where cl.id = ?2")
	int updateEtat(EnumeratedEtat Etat,Long idContrat); 
	
	
	@Query(value="SELECT (SUM(etat=?1)) FROM `contrat_achat`",nativeQuery =true)
    public Integer statContrat(String etat);  
	
	
	@Query(value="SELECT COUNT(*) FROM contrat_achat",nativeQuery =true)
    public int allstatContrat();  
	
	
}

