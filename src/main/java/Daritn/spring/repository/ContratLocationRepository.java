package Daritn.spring.repository;

import org.springframework.stereotype.Repository;


import Daritn.spring.entity.ContratLocation;
import Daritn.spring.entity.EnumeratedEtat;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


@Repository
public interface ContratLocationRepository extends JpaRepository<ContratLocation, Long> , CrudRepository<ContratLocation, Long> , PagingAndSortingRepository<ContratLocation, Long> {
	
@Query(value="SELECT * FROM `contrat_location` cl",nativeQuery =true)
public List<ContratLocation> findAllContrat();   

@Modifying
@Transactional 
@Query("update ContratLocation cl set cl.etat = ?1 where cl.id = ?2")
int updateEtat(EnumeratedEtat Etat,Long idContrat); 

@Query(value="SELECT * FROM `contrat_location` cl join `user` u on u.id_user=cl.locataire_id_user where cl.locataire_id_user=?1",nativeQuery =true)
public List<ContratLocation> findAllByLocataires(int id);




}
