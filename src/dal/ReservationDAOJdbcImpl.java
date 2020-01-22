package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import bo.Reservation;

public class ReservationDAOJdbcImpl implements ReservationDAO {

	private Session session;

	public ReservationDAOJdbcImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	@Override
	public List<Reservation> selectResaByUser(Integer idUser) {

		Query query = session.createQuery("from Reservation where idUtilisateur = : ID");
		query.setParameter("ID", idUser);
		List result = query.list();
		return result;

	}

	@Override
	public void insertResa(Reservation reservation) {

		Transaction t = session.beginTransaction();
		session.save(reservation);
		t.commit();

	}

}
