package bo;

import java.io.Serializable;
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
@Table(name = "utilisateurs")

public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "identifiant")
	private String identifiant;

	@Column(name = "motDePasse")
	private String motDePasse;

	@OneToMany
	@JoinColumn(name = "utilisateur_id")
	private List<Reservation> reservations;

	public Utilisateur() {
		reservations = new ArrayList<Reservation>();

	}

	public Utilisateur(String identifiant, String motDePasse, List<Reservation> reservations) {
		super();

		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.reservations = reservations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Reservation reservations2) {
		this.reservations = (List<Reservation>) reservations2;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", identifiant=" + identifiant + ", motDePasse=" + motDePasse + "]";
	}

}
