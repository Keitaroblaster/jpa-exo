package fr.laposte.jpa.exo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.laposte.jpa.exo.models.DossierAdministratif;

public interface DossierAdministratifRepository extends JpaRepository<DossierAdministratif, Long> {
	

}
