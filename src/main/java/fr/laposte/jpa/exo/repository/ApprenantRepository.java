package fr.laposte.jpa.exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.laposte.jpa.exo.models.Apprenant;

public interface ApprenantRepository extends JpaRepository<Apprenant,Long> {
	

}
