package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import bo.Reservation;
import bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private Session session;

	public UtilisateurDAOJdbcImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	@Override
	public void insertUtilisateur(String identifiant, String motDePasse) {
		Utilisateur newUtilisateur = new Utilisateur();
		newUtilisateur.setIdentifiant(identifiant);
		newUtilisateur.setMotDePasse(motDePasse);
		Transaction t = session.beginTransaction();
		session.save(newUtilisateur);
		t.commit();

	}

	@Override
	public Utilisateur selectUserById(Integer idUser) {
		return (Utilisateur) session.load(Utilisateur.class, idUser);

	}

	@Override
	public List<Utilisateur> selectAllUser() {
		// TODO Auto-generated method stub
		return session.createQuery("from Utilisateur").list();
	}

	@Override
	public void insertResa(Reservation reservation) {

		Transaction t = session.beginTransaction();
		session.save(reservation);
		t.commit();
	}

}
