package Daritn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Daritn.spring.entity.MesCriteres;
import Daritn.spring.entity.Annonce;

public interface MesCriteresRepository extends JpaRepository<MesCriteres, Long>, CrudRepository<MesCriteres, Long>{
	
	


@Query(value="SELECT * FROM mes_criteres",nativeQuery =true)
public MesCriteres allmescriteres();


@Modifying
@Query(value="delete FROM mes_criteres",nativeQuery =true)
public int deletemescritetres();

}
