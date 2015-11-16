package tp4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import java.util.*;
import tp4.Lib.Orm;

@WebServlet("/account")
public class Account extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Database database = new Database();
	Orm orm = new Orm(database);
	String currentPseudo;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
        currentPseudo = (String)session.getAttribute("currentPseudo");

        if (currentPseudo == null) {
        	currentPseudo = "Elixir";
        	session.setAttribute("currentPseudo", currentPseudo);
        }

		orm.registerModel("Membre", new tp4.Model.MembreModel(orm));
		tp4.Model.MembreModel membresRepo = (tp4.Model.MembreModel)orm.getModel("Membre");

		List<tp4.Entity.Membre> membres = membresRepo.findAll();

		request.setAttribute("membres", membres);
		request.setAttribute("currentPseudo", currentPseudo);

		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
    	session.setAttribute("currentPseudo", (String)request.getParameter("pseudo"));
    	currentPseudo = (String)session.getAttribute("currentPseudo");

    	orm.registerModel("Membre", new tp4.Model.MembreModel(orm));
		tp4.Model.MembreModel membresRepo = (tp4.Model.MembreModel)orm.getModel("Membre");

		List<tp4.Entity.Membre> membres = membresRepo.findAll();
		request.setAttribute("membres", membres);
		request.setAttribute("currentPseudo", currentPseudo);

		request.getRequestDispatcher("/account.jsp").forward(request, response);
	}

}
