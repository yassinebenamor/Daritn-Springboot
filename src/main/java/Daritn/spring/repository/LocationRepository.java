package Daritn.spring.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.EnumeratedEtat;
import Daritn.spring.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

	@Query(value="SELECT SUM(typelocation=?1) FROM location ",nativeQuery =true)
	public Integer Stat(String type); 
	
	@Modifying
	@Transactional 
	@Query("update ContratLocation cl set cl.etat = ?1 where cl.id = ?2")
	int updateEtat(EnumeratedEtat Etat,Long idLocation);
	
}
