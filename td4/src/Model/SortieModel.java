package tp4.Model;
import java.sql.*;
import java.util.*;

import tp4.Entity.Sortie;

public class SortieModel extends Model
{
	public SortieModel(tp4.Lib.Orm orm_)
	{
		super(orm_);
	}

	public tp4.Entity.Sortie find(String id)
	{
		ResultSet rs = orm.select("SELECT * FROM sortie m WHERE m.idsort = '" + id + "'");
		tp4.Entity.Sortie sortie = new tp4.Entity.Sortie(orm);

		try {
			while(rs.next()) {
				sortie = fillEntity(rs);
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}

		return sortie;
	}

	public Map<String,List<Sortie>> list()
	{
		Map<String,List<Sortie>> sorties = new HashMap<String,List<Sortie>>();

		for (String date : getFutureDates()) {

			sorties.put(date, new ArrayList<Sortie>());
			ResultSet rs = orm.select("SELECT IDSORT, NOM, DTE, RESPONSABLE FROM sortie WHERE TO_CHAR(DTE, 'YYYY-MM-DD') = '" + date + "'");

			try {
				while(rs.next()) {
					sorties.get(date).add(fillEntity(rs));
				}
			}
			catch(SQLException se) {
				se.printStackTrace();
			} finally {
				orm.close();
			}
		}

		return sorties;
	}

	protected List<String> getFutureDates()
	{
		ResultSet rs = orm.select("SELECT DISTINCT TO_CHAR(DTE, 'YYYY-MM-DD') m_day FROM sortie WHERE DTE >= SYSDATE ORDER BY m_day");
		List<String> dates = new ArrayList<String>();

		try {
			while(rs.next()) {
				dates.add(rs.getString("M_DAY"));
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		} finally {
			orm.close();
		}


		return dates;
	}

	protected tp4.Entity.Sortie fillEntity(ResultSet rs)
	{
		Sortie entity = new Sortie(orm);

		try {
			entity.id = Integer.parseInt(rs.getString("IDSORT"));
			entity.title = rs.getString("NOM");
			entity.datetime = rs.getString("DTE");
			entity.organisateurPseudo = rs.getString("RESPONSABLE");
			entity.description = rs.getString("DESCRIPTION");
			entity.adresse = rs.getString("ADRESSE");
			entity.nbMax = Integer.parseInt(rs.getString("MAXPERS"));
		}
		catch(SQLException se) {
			 se.printStackTrace();
		}

		return entity;
	}

	public void save(tp4.Entity.Sortie entity)
	{
		System.out.println("SQL");
		Integer id = entity.id;

		if (id == 0)
			orm.execute("INSERT INTO sortie (idsort, nom, dte, responsable, description, adresse, maxpers, genre) VALUES ('"+getNextId()+"', '"+entity.title+"', TO_DATE('"+entity.datetime+"', 'YYYY-MM-DD HH24:MI:SS'), '"+entity.organisateurPseudo+"', '"+entity.description+"', '"+entity.adresse+"', '"+entity.nbMax+"', 'auto')");
		else
			orm.execute("UPDATE sortie SET idsort = "+Integer.toString(entity.id)+", nom = '"+entity.title+"', dte = TO_DATE('"+entity.datetime+"', 'YYYY-MM-DD HH24:MI:SS'), responsable = '"+entity.organisateurPseudo+"', description = '"+entity.description+"', adresse = '"+entity.adresse+"', maxpers = "+entity.nbMax+" WHERE idsort = "+entity.id);
	}

	protected int getNextId()
	{
		int id = 0;
		ResultSet rs = orm.select("SELECT MAX(idsort) as id FROM sortie");
		
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
}