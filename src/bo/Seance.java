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
@Table(name = "seances")
public class Seance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", insertable = false, updatable = false)
	private Integer id;

	@Column(name = "horaire")
	private LocalTime horaire;

	@Column(name = "salle")
	private Integer salle;

	public Seance() {
		// TODO Auto-generated constructor stub
	}

	public Seance(Integer id, LocalTime horaire, Integer salle) {
		super();
		this.id = id;
		this.horaire = horaire;
		this.salle = salle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHoraire() {
		return horaire;
	}

	public void setHoraire(LocalTime horaire) {
		this.horaire = horaire;
	}

	public Integer getSalle() {
		return salle;
	}

	public void setSalle(Integer salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Seance [id=" + id + ", horaire=" + horaire + ", salle=" + salle + "]";
	}

}
