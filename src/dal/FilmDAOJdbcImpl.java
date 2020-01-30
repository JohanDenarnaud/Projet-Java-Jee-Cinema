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

import bo.Film;

public class FilmDAOJdbcImpl implements FilmDAO {
	private Session session;

	public FilmDAOJdbcImpl() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Film> selectAll() {

		return session.createQuery("from Film").list(); // Film ecrit comme la Classe language HQL (Hibernate Query
														// Language)
	}

	@Override
	public Film selectById(Integer idAsInt) {

		return (Film) session.load(Film.class, idAsInt);
	}

	@Override
	public void insertFilm(Film film) {
		Transaction t = session.beginTransaction();
		session.save(film);
		t.commit();

	}

	@Override
	public void deleteFilm(Integer idAsInt) {

		Transaction t = session.beginTransaction();
		Query query = session.createQuery("delete Film where id = :ID");
		query.setParameter("ID", idAsInt);

		query.executeUpdate();
		t.commit();

	}

}
