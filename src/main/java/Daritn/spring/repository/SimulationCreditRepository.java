package Daritn.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Daritn.spring.entity.ContratAchat;
import Daritn.spring.entity.SimulationCredit;


public interface SimulationCreditRepository  extends JpaRepository<SimulationCredit, Long> {

	
	@Query("SELECT s FROM SimulationCredit s WHERE CONCAT(s.annee, '') LIKE %?1%"
            + " OR CONCAT(s.autofinancement, '') LIKE %?1%"
            + " OR CONCAT(s.plafond, '') LIKE %?1%"
            + " OR CONCAT(s.salaire, '') LIKE %?1%")
    public List<SimulationCredit> search(int keyword);

    public List<SimulationCredit> findByOrderBySalaireAsc();

}