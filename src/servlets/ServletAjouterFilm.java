package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bll.FilmManager;
import bo.Film;

/**
 * Servlet implementation class ServletAjouterFilm
 */
@WebServlet("/ServletAjouterFilm")
public class ServletAjouterFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmManager fm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml"); // charge le fichier //
		// springContext.xml
		fm = context.getBean("fm", FilmManager.class);
		super.init();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjouterFilm() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Film> films = fm.selectAll();

		request.setAttribute("films", films);
		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("ajouterFilm");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String dateSortie = request.getParameter("dateSortie");
		LocalDate dateSortieLD = LocalDate.parse(dateSortie);
		String duree = request.getParameter("duree");
		String affiche = request.getParameter("affiche");

		Integer dureeAsInt = Integer.valueOf(duree);

		Film film = new Film();
		film.setTitre(titre);
		film.setDescription(description);
		film.setDateSortie(dateSortieLD);
		film.setDuree(dureeAsInt);
		film.setAffiche(affiche);

		fm.insertFilm(film);

		response.sendRedirect("ServletAccueil");
	}

}
