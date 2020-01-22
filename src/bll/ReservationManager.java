package bll;

import java.util.List;

import bo.Reservation;
import dal.ReservationDAO;

public class ReservationManager {
	private ReservationDAO dao;

	public void setDao(ReservationDAO dao) {
		this.dao = dao;
	}

	public List<Reservation> selectResaByUser(Integer idUser) {
		// TODO Auto-generated method stub
		return dao.selectResaByUser(idUser);
	}

	public void insertResa(Reservation reservation) {
		dao.insertResa(reservation);

	}

}
