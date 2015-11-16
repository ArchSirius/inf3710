package tp4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/account")
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Database database = new Database();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("option");
	}

	public List<String[]> selectPseudo() {
		String sql = "SELECT idPays, nom FROM Pays ORDER BY nom";
		database.connect();
		Statement stmt = database.getStatement();
		ResultSet rs = database.executeSelect(stmt, sql);
		List<String[]> pays = new ArrayList<String[]>();
		try {
			while(rs.next()) {
				String idPays = rs.getString("idPays");
				String nom = rs.getString("nom");
				pays.add(new String[] { idPays, nom });
			}
			database.closeStatement(stmt);
			database.closeConnection();
		}
		catch(SQLException se) {
			   se.printStackTrace();
		}
		return pays;
	}

}
