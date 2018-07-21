package controleur;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.gtm.mondedestenebres.domaine.Vampire;
import fr.gtm.mondedestenebres.service.VampireService;

/**
 * Servlet implementation class MaServlet
 */
@WebServlet("/controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request,response);
	}
	
	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	//Soumettre les parametres de la requete a la couche service et recuperer resultat
	
	VampireService service = new VampireService();
	
	ArrayList<Vampire> vampires = service.recenserPopulation();
	
	HttpSession maSession = request.getSession();
	
	maSession.setAttribute("population", vampires);
	
	//Reponse a l'utilisateur
	RequestDispatcher   dispatcher = request.getRequestDispatcher("resultatLogin.jsp");
	
	dispatcher.forward(request, response);
	
	}

}
