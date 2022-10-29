package Daritn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import Daritn.spring.entity.MesCriteres;
import Daritn.spring.entity.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long>, CrudRepository<Annonce, Long>{
	
	
@Query(value="SELECT * FROM `annonce` WHERE `prix` BETWEEN '1' AND '3' AND `prixm2` BETWEEN '1' AND '3' AND `surface` BETWEEN '1' AND '3' AND `region` ='tunis'",nativeQuery =true)
public List<Annonce> selectedAd(int prixmin, int prixmax, int prixm2min, int prixm2max, int surfacemin, int surfacemax, String region);  

}