package servlets;

import java.io.IOException;

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
 * Servlet implementation class ServletDetailFilm
 */
@WebServlet("/ServletDetailFilm")
public class ServletDetailFilm extends HttpServlet {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		Integer idAsInt = Integer.valueOf(id);

		Film film = fm.selectById(idAsInt);

		request.setAttribute("film", film);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("detailFilm");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
