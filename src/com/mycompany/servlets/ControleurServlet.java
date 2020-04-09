package com.mycompany.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.metier.CreditMetier;
import com.mycompany.model.CreditModel;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CreditMetier metier;
	
	
	
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		metier = new CreditMetier();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("monModel", new CreditModel());
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueCredit.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// On récupère les données
		double montant=Double.parseDouble(request.getParameter("montant"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int duree = Integer.parseInt(request.getParameter("duree"));
		
		// Sauvegarde dans le modèle
		CreditModel model = new CreditModel();
		model.setMontant(montant);
		model.setTaux(taux);
		model.setDuree(duree);
		
		// Calcul métier
		double res = metier.calculeMensualite(montant, duree, taux);
		model.setMensualite(res);
		
		request.setAttribute("monModel", model);
		this.getServletContext().getRequestDispatcher("/WEB-INF/vueCredit.jsp").forward(request, response);
		
		// TODO Auto-generated method stub
		// doGet(request, response);
	}

}
