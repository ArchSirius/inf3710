package tp4.Model;
import java.sql.*;
import java.util.*;

public class CommentaireModel extends Model
{
	public CommentaireModel(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public List<tp4.Entity.Commentaire> getBySortie(int idsort)
	{
		List<tp4.Entity.Commentaire> commentaires = new ArrayList<tp4.Entity.Commentaire>();
		ResultSet rs = orm.select("SELECT * FROM commentaire c WHERE c.idsort = " + Integer.toString(idsort));
		
		try {
			while(rs.next()) {
				commentaires.add(fillEntity(rs));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return commentaires;
	}

	protected tp4.Entity.Commentaire fillEntity(ResultSet rs)
	{
		tp4.Entity.Commentaire entity = new tp4.Entity.Commentaire(orm);

		try {
			entity.id = Integer.parseInt(rs.getString("IDCOMMENT"));
			entity.pseudo = rs.getString("PSEUDO");
			entity.idsort = Integer.parseInt(rs.getString("IDSORT"));
			entity.text = rs.getString("TEXT");
			entity.date = rs.getString("DTE");
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}

		return entity;
	}

	protected int getNextId()
	{
		int id = 0;
		ResultSet rs = orm.select("SELECT MAX(idcomment) as id FROM commentaire");
		
		try {
			while(rs.next()) {
				id = rs.getInt("id");
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return id + 1;
	}

	public void save(tp4.Entity.Commentaire entity)
	{
		entity.id = getNextId();

		orm.execute("INSERT INTO commentaire (IDCOMMENT, PSEUDO, IDSORT, TEXT, DTE) VALUES ('"+Integer.toString(entity.id)+"', '"+entity.pseudo+"', '"+Integer.toString(entity.idsort)+"', '"+entity.text+"', TO_DATE('"+entity.date+"', 'YYYY-MM-DD HH24:MI:SS'))");
	}
}