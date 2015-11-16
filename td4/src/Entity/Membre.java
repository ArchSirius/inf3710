package tp4.Entity;

import java.io.IOException;

public class Membre extends Entity
{
	public String pseudo;
	public String nom;
	public String prenom;

	public Membre(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}
}
