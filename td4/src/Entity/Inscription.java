package tp4.Entity;

import java.io.IOException;

public class Inscription extends Entity
{
	// Relation avec sortie
	public int idsort;
	private Sortie sortie;

	// Relation avec sortie
	public String pseudo;
	private Membre membre;

	public String statut;

	// Champs à ajouter
	public int nbInvite = 0; // ALTER TABLE INSCRIPTION ADD NBINVITE NUMBER CHECK (NBINVITE BETWEEN 0 AND 7); ALTER TABLE INSCRIPTION MODIFY NBINVITE NOT NULL NOVALIDATE;


	public Inscription(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public Membre getMembre()
	{
		if (membre == null) {
			tp4.Model.MembreModel membres = (tp4.Model.MembreModel)orm.getModel("Membre");
			membre = membres.find(pseudo);
		}
	
		return membre;
	}

	public Sortie getSortie()
	{
		if (sortie == null) {
			tp4.Model.SortieModel sorties = (tp4.Model.SortieModel)orm.getModel("Sortie");
			sortie = sorties.find(Integer.toString(idsort));
		}
	
		return sortie;
	}

	public void setMembre(Membre m)
	{
		membre = m;
		pseudo = m.pseudo;
	}

	public void setSortie(Sortie s)
	{
		sortie = s;
		idsort = s.id;
	}
}
