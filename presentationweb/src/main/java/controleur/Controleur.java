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
	
	//Soumettre les paramètres de la requête à la couche service et récupérer résultat
	
	System.out.println("0");
	
	VampireService service = new VampireService();
	
	System.out.println("1");
	
	/*ArrayList<Vampire> vampires = service.recenserPopulation();
	
	System.out.println("2");
	
	HttpSession maSession = request.getSession();
	
	System.out.println("3");
	
	maSession.setAttribute("population", vampires);
	
	System.out.println("4");
	
	//Réponse à l'utilisateur
	RequestDispatcher   dispatcher = request.getRequestDispatcher("resultatLogin.jsp");
	
	System.out.println("5");
	
	dispatcher.forward(request, response);
	
	System.out.println("6");*/
	
	}

}
