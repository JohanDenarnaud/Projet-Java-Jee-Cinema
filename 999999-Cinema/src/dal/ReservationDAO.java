package dal;

import java.util.List;

import bo.Reservation;

public interface ReservationDAO {

	List<Reservation> selectResaByUser(Integer idUser);

	void insertResa(Reservation reservation);

}
