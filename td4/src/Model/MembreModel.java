package tp4.Model;
import java.sql.*;

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
			orm.close();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}

		return membre;
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