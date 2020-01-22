package bo;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reservations")

public class Reservation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "utilisateur_id")
	private Integer idUtilisateur;

	@Column(name = "nbPlaces")
	private Integer nbPlaces;

	@Column(name = "titre")
	private String titre;

	@Column(name = "horaire")
	private LocalTime horaire;

	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Integer idUtilisateur, Integer nbPlaces, String titre, LocalTime horaire) {

		this.idUtilisateur = idUtilisateur;
		this.nbPlaces = nbPlaces;
		this.titre = titre;
		this.horaire = horaire;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Integer getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalTime getHoraire() {
		return horaire;
	}

	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
