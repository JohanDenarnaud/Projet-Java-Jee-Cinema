package servlets;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
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

import bll.ReservationManager;
import bo.Reservation;

/**
 * Servlet implementation class ServletReservation
 */
@WebServlet("/ServletReservation")
public class ServletReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationManager rm;

	@Override
	public void init() throws ServletException {
		ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml"); // charge le fichier //
		// springContext.xml
		rm = context.getBean("rm", ReservationManager.class);

		super.init();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");

		List<Reservation> reservations = new ArrayList();

		reservations = rm.selectResaByUser(idUser);

		request.setAttribute("reservations", reservations);

		RequestDispatcher rd = this.getServletContext().getNamedDispatcher("reservations");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		Integer idUser = (Integer) session.getAttribute("idUser");

		String titreFilm = request.getParameter("titreFilm");
		LocalTime horaireFilm = LocalTime.parse(request.getParameter("horaireFilm"));
		Integer nbPlaces = Integer.valueOf(request.getParameter("nbPlaces"));

		Reservation reservation = new Reservation(idUser, nbPlaces, titreFilm, horaireFilm);

		rm.insertResa(reservation);

		doGet(request, response);
	}

}
