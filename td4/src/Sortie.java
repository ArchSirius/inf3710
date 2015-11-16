package tp4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.*;
import tp4.Lib.Orm;

@WebServlet("/sortie")
public class Sortie extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Database database = new Database();
	Orm orm = new Orm(database);

	public Sortie()
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String option = request.getParameter("option");

		if(option.equals("list")) {

			tp4.Model.SortieModel sortiesRepo = (tp4.Model.SortieModel)orm.getModel("Sortie");
			Map<String,List<tp4.Entity.Sortie>> sorties = sortiesRepo.list();

			request.setAttribute("dates", sorties.keySet());
			request.setAttribute("sorties", sorties);
			request.getRequestDispatcher("/list.jsp").forward(request, response);

		} else if(option.equals("new")) {

			request.getRequestDispatcher("/new.jsp").forward(request, response);

		} else if(option.equals("details")) {

			String id = request.getParameter("id");

			tp4.Model.SortieModel sortiesRepo = (tp4.Model.SortieModel)orm.getModel("Sortie");
			tp4.Entity.Sortie sortie = sortiesRepo.find(id);

			request.setAttribute("sortie", sortie);
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String option = request.getParameter("option");
		//if(option.equals("Insert")){
		//	String message = insert(request);
		//	request.setAttribute("message", message);
		//	List<String[]> pays = selectPays();
		//	request.setAttribute("pays", pays);
		//	request.getRequestDispatcher("/new.jsp").forward(request, response);
		//}
	}

	//protected String insert(HttpServletRequest request) {
	//	String id = request.getParameter("id");
	//	String nom = request.getParameter("nom");
	//	String pays = request.getParameter("pays");
	//	String sql = "INSERT INTO Equipe VALUES ('"+id+"', '"+nom+"', '"+pays+"')";
	//	database.connect();
	//	Statement stmt = database.getStatement();
	//	int resp = database.executeSql(stmt, sql);
	//	database.closeStatement(stmt);
	//	database.closeConnection();
	//	String message = "Modifiées: "+resp;
	//	return message;
	//}

	//protected List<String[]> selectPays() {
	//	String sql = "SELECT idPays, nom FROM Pays ORDER BY nom";
	//	database.connect();
	//	Statement stmt = database.getStatement();
	//	ResultSet rs = database.executeSelect(stmt, sql);
	//	List<String[]> pays = new ArrayList<String[]>();
	//	try {
	//		while(rs.next()) {
	//			String idPays = rs.getString("idPays");
	//			String nom = rs.getString("nom");
	//			pays.add(new String[] { idPays, nom });
	//		}
	//		database.closeStatement(stmt);
	//		database.closeConnection();
	//	}
	//	catch(SQLException se) {
	//		   se.printStackTrace();
	//	}
	//	return pays;
	//}


}
