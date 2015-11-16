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
			orm.close();
		}
		catch(SQLException se) {
			   se.printStackTrace();
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
				orm.close();
			}
			catch(SQLException se) {
				   se.printStackTrace();
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
			orm.close();
		}
		catch(SQLException se) {
			   se.printStackTrace();
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
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}

		return entity;
	}
}