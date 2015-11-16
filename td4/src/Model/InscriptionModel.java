package tp4.Model;
import java.sql.*;
import java.util.*;

public class InscriptionModel extends Model
{
	public InscriptionModel(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public List<tp4.Entity.Inscription> getBySortie(int idsort)
	{
		List<tp4.Entity.Inscription> inscriptions = new ArrayList<tp4.Entity.Inscription>();
		ResultSet rs = orm.select("SELECT PSEUDO, IDSORT, STATUT, NBINVITE FROM inscription i WHERE i.idsort = " + Integer.toString(idsort));
		
		try {
			while(rs.next()) {
				inscriptions.add(fillEntity(rs));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return inscriptions;
	}

	protected tp4.Entity.Inscription fillEntity(ResultSet rs)
	{
		tp4.Entity.Inscription entity = new tp4.Entity.Inscription(orm);

		try {
			entity.pseudo = rs.getString("PSEUDO");
			entity.idsort = Integer.parseInt(rs.getString("IDSORT"));
			entity.statut = rs.getString("STATUT");
			entity.nbInvite = Integer.parseInt(rs.getString("NBINVITE"));
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}

		return entity;
	}

	public void save(tp4.Entity.Inscription entity)
	{
		orm.execute("INSERT INTO inscription (PSEUDO, IDSORT, STATUT, NBINVITE) VALUES ('"+entity.pseudo+"', "+Integer.toString(entity.idsort)+", "+entity.statut+", "+Integer.toString(entity.nbInvite)+")");
	}
}