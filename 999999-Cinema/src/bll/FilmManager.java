package bll;

import java.util.List;

import bo.Film;
import dal.FilmDAO;

public class FilmManager {
	private FilmDAO dao;

	public void setDao(FilmDAO dao) {
		this.dao = dao;
	}

	public List<Film> selectAll() {

		return dao.selectAll();
	}

	public Film selectById(Integer idAsInt) {

		return dao.selectById(idAsInt);
	}

	public void insertFilm(Film film) {
		dao.insertFilm(film);

	}

	public void deleteFilm(Integer idAsInt) {
		dao.deleteFilm(idAsInt);

	}

}
