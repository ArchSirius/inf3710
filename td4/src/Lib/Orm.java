package tp4.Lib;

import java.io.IOException;

import java.util.*;
import java.util.function.*;
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
	}

	public void registerModel(String e, tp4.Model.Model m)
	{
		models.put(e, m);
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

	public void execute(String sql)
	{
		if (stmt != null) {
			close();
		}

		dbh.connect();
		stmt = dbh.getStatement();
		int resp = dbh.executeSql(stmt, sql);
		close();
	}

	public void close()
	{
		dbh.closeStatement(stmt);
		dbh.closeConnection();
	}
}