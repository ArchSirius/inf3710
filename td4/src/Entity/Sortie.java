package tp4.Entity;

import java.io.IOException;
import java.util.*;

public class Sortie extends Entity
{
	public int id;
	public String title;
	public String datetime;

	// Relation avec Membre
	private Membre organisateur;
	private List<Membre> inscrits;
	private List<Commentaire> commentaires;
	public String organisateurPseudo;

	// Nouveaux champs
	public String description; 	// ALTER TABLE SORTIE ADD DESCRIPTION VARCHAR(1000);
	public String adresse; 		// ALTER TABLE SORTIE ADD ADRESSE VARCHAR(255);
	public int nbMax; 			// ALTER TABLE SORTIE ADD MAXPERS NUMBER CHECK (MAXPERS BETWEEN 0 AND 8);

	public Sortie(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public Membre getOrganisateur()
	{
		if (organisateur == null) {
			tp4.Model.MembreModel membres = (tp4.Model.MembreModel)orm.getModel("Membre");
			organisateur = membres.find(organisateurPseudo);
		}
	
		return organisateur;
	}

	public String getTime()
	{
		return datetime.substring(10, 16);
	}

	public List<Membre> getParticipants()
	{
		if (inscrits == null) {
			tp4.Model.MembreModel membresRepo = (tp4.Model.MembreModel)orm.getModel("Membre");
			inscrits = membresRepo.getInscrits(id);
		}

		return inscrits;
	}

	public List<Commentaire> getCommentaires()
	{
		if (commentaires == null) {
			tp4.Model.CommentaireModel commentairesRepo = (tp4.Model.CommentaireModel)orm.getModel("Commentaire");
			commentaires = commentairesRepo.getBySortie(id);
		}

		return commentaires;
	}
}
