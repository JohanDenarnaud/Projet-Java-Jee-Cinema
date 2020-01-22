package bll;

import java.util.List;

import bo.Reservation;
import bo.Utilisateur;
import dal.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO dao;

	public void setDao(UtilisateurDAO dao) {
		this.dao = dao;
	}

	public void insertUtilisateur(String identifiant, String motDePasse) {

		dao.insertUtilisateur(identifiant, motDePasse);

	}

	public Utilisateur selectUserById(Integer idUser) {
		// TODO Auto-generated method stub
		return dao.selectUserById(idUser);
	}

	public List<Utilisateur> selectAllUser() {
		// TODO Auto-generated method stub
		return dao.selectAllUser();
	}

	public void insertResa(Reservation reservation) {

		dao.insertResa(reservation);

	}

}