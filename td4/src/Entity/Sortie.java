package tp4.Entity;

import java.io.IOException;

public class Sortie extends Entity
{
	public int id;
	public String title;
	public String datetime;

	// Relation avec Membre
	private Membre organisateur;
	public String organisateurPseudo;

	// Nouveaux champs
	public String description;
	public String adresse;
	public int nbMax;

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
}
