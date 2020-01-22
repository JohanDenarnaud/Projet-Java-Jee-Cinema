package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bll.UtilisateurManager;
import bo.Utilisateur;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager um;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml"); // charge le fichier //
		// springContext.xml
		um = context.getBean("um", UtilisateurManager.class);
		super.init();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("connection");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String identifiant = request.getParameter("identifiant");
		String motDePasse = request.getParameter("motDePasse");
		String message = null;
		List<Utilisateur> utilisateurs = um.selectAllUser();

		for (Utilisateur current : utilisateurs) {
			if (current.getIdentifiant().equals(identifiant) && current.getMotDePasse().equals(motDePasse)) {
				Integer idUser = current.getId();
				session.setAttribute("sessionConnectee", "connectee");
				session.setAttribute("idUser", idUser);
				session.setAttribute("nomUtilisateur", current.getIdentifiant());

			}
		}

		request.setAttribute("message", message);
		response.sendRedirect("ServletAccueil");
	}

}
