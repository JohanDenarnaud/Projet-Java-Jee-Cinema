package dal;

import java.util.List;

import bo.Film;

public interface FilmDAO {

	public List<Film> selectAll();

	public Film selectById(Integer idAsInt);

	public void insertFilm(Film film);

	public void deleteFilm(Integer idAsInt);

}
