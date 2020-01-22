package bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "films")

public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "titre")
	private String titre;

	@Column(name = "description")
	private String description;

	@Column(name = "dateSortie")
	private LocalDate dateSortie;

	@Column(name = "duree")
	private Integer duree;

	@OneToMany
	@JoinColumn(name = "id_film")
	private List<Seance> seances;

	@Column(name = "affiche")
	private String affiche;

	public String getAffiche() {
		return affiche;
	}

	public void setAffiche(String affiche) {
		this.affiche = affiche;
	}

	public Film() {
		seances = new ArrayList<Seance>();

	}

	public Film(Integer id, String titre, String description, LocalDate dateSortie, Integer duree, List<Seance> seances,
			String affiche) {
		super();
		this.id = id;
		this.titre = titre;
		this.description = description;
		this.dateSortie = dateSortie;
		this.duree = duree;
		this.seances = seances;
		this.affiche = affiche;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", titre=" + titre + ", description=" + description + ", dateSortie=" + dateSortie
				+ ", duree=" + duree + ", seances=" + seances + ", affiche=" + affiche + "]";
	}

}
