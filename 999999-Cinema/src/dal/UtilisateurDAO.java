package dal;

import java.util.List;

import bo.Reservation;
import bo.Utilisateur;

public interface UtilisateurDAO {

	public Utilisateur selectUserById(Integer idUser);

	void insertUtilisateur(String identifiant, String motDePasse);

	public List<Utilisateur> selectAllUser();

	public void insertResa(Reservation reservation);

}
