//CREATE TABLE COMMENTAIRE
//(
//	idComment INTEGER,
//	pseudo VARCHAR(20) REFERENCES MEMBRE NOT NULL,
//	idSort INTEGER REFERENCES SORTIE NOT NULL,
//	text VARCHAR(500) NOT NULL,
//	dte DATE NOT NULL,
//	PRIMARY KEY (idComment)
//);

package tp4.Entity;

import java.io.IOException;

public class Commentaire extends Entity
{
	public int id;

	// Relation avec sortie
	public int idsort;
	private Sortie sortie;

	// Relation avec sortie
	public String pseudo;
	private Membre auteur;

	public String text;
	public String date;

	public Commentaire(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public Membre getAuteur()
	{
		if (auteur == null) {
			tp4.Model.MembreModel membres = (tp4.Model.MembreModel)orm.getModel("Membre");
			auteur = membres.find(pseudo);
		}
	
		return auteur;
	}

	public Sortie getSortie()
	{
		if (sortie == null) {
			tp4.Model.SortieModel sorties = (tp4.Model.SortieModel)orm.getModel("Sortie");
			sortie = sorties.find(Integer.toString(idsort));
		}
	
		return sortie;
	}

	public void setAuteur(Membre m)
	{
		auteur = m;
		pseudo = m.pseudo;
	}

	public void setSortie(Sortie s)
	{
		sortie = s;
		idsort = s.id;
	}
}
