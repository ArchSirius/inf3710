package tp4.Model;
import java.sql.*;
import java.util.*;

public class MembreModel extends Model
{
	public MembreModel(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public tp4.Entity.Membre find(String pseudo)
	{
		ResultSet rs = orm.select("SELECT * FROM membre m WHERE m.pseudo = '" + pseudo + "'");
		tp4.Entity.Membre membre = new tp4.Entity.Membre(orm);

		try {
			while(rs.next()) {
				membre = fillEntity(rs);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return membre;
	}

	public List<tp4.Entity.Membre> getInscrits(int idsort)
	{
		List<tp4.Entity.Membre> membres = new ArrayList<tp4.Entity.Membre>();
		ResultSet rs = orm.select("SELECT m.PSEUDO, m.PRENOM, m.NOM, m.DTENAISS FROM membre m JOIN inscription s ON s.pseudo = m.pseudo AND s.idsort = " + Integer.toString(idsort));
		
		try {
			while(rs.next()) {
				membres.add(fillEntity(rs));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return membres;
	}

	protected tp4.Entity.Membre fillEntity(ResultSet rs)
	{
		tp4.Entity.Membre entity = new tp4.Entity.Membre(orm);

		try {
			entity.pseudo = rs.getString("PSEUDO");
			entity.nom = rs.getString("NOM");
			entity.prenom = rs.getString("PRENOM");
		}
		catch(SQLException se) {
			se.printStackTrace();
		}

		return entity;
	}
}