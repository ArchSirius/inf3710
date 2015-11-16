package tp4.Lib;

import java.io.IOException;

import java.util.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Orm
{
	private tp4.Database dbh;
	private Map<String,tp4.Model.Model> models;
	private Statement stmt = null;

	public Orm(tp4.Database db)
	{	
		dbh = db;
		models = new HashMap<String,tp4.Model.Model>();
		models.put("Sortie", new tp4.Model.SortieModel(this));
		models.put("Membre", new tp4.Model.MembreModel(this));
	}

	public tp4.Model.Model getModel(String name)
	{
		return models.get(name);
	}

	public ResultSet select(String sql)
	{
		if (stmt != null) {
			close();
		}

		dbh.connect();
		stmt = dbh.getStatement();
		return dbh.executeSelect(stmt, sql);
	}

	public void close()
	{
		dbh.closeStatement(stmt);
		dbh.closeConnection();
	}
}