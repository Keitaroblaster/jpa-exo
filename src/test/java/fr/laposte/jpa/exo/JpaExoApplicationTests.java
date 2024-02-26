package fr.laposte.jpa.exo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.jpa.exo.models.Apprenant;
import fr.laposte.jpa.exo.models.Competence;
import fr.laposte.jpa.exo.models.DossierAdministratif;
import fr.laposte.jpa.exo.models.SessionFormation;
import fr.laposte.jpa.exo.repository.ApprenantRepository;
import fr.laposte.jpa.exo.repository.CompetenceRepository;
import fr.laposte.jpa.exo.repository.DossierAdministratifRepository;
import fr.laposte.jpa.exo.repository.SessionFormationRepository;

@SpringBootTest
class JpaExoApplicationTests {
	
	@Autowired
	private ApprenantRepository apprenants;
	
	@Autowired
	private CompetenceRepository competences;
	
	@Autowired
	private DossierAdministratifRepository dossiers;
	
	@Autowired
	private SessionFormationRepository sessions;

	@BeforeEach
	void clean() {
		
		// ATTENTION: l'ordre de delete est important sinon le test peut péter quand on le relance
		dossiers.deleteAll();
		apprenants.deleteAll();
		sessions.deleteAll();		// on peut inverser session et competence le test fonctionnera
		competences.deleteAll();
	}
	
	@Test
	void freeTests() {
		SessionFormation cda = new SessionFormation("cda 2023");
		sessions.save(cda);
		
		Apprenant apprenant1 = new Apprenant("Rob","Gronkowski",cda);
		apprenants.save(apprenant1);
		
		Apprenant apprenant2 = new Apprenant("Patrick","Mahomes",cda);
		apprenants.save(apprenant2);
		
		DossierAdministratif robFolder = new DossierAdministratif("Belichick","belichick@patriots.us",apprenant1);
		dossiers.save(robFolder);
		
		DossierAdministratif patrickFolder = new DossierAdministratif("Reid","reid@kansascity.us",apprenant2);
		dossiers.save(patrickFolder);
		
		Competence te = new Competence("Tight End",9);
		competences.save(te);
		
		Competence qb = new Competence("QuanterBack",10);
		competences.save(qb);
		
		apprenant1.getCompetences().add(te);
		apprenants.save(apprenant1);
		apprenant2.getCompetences().add(qb);
		apprenants.save(apprenant2);
		
		
	}

}
