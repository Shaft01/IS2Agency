package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the soba database table.
 * 
 */
@Entity
@NamedQuery(name="Soba.findAll", query="SELECT s FROM Soba s")
public class Soba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSoba;

	private double cena;

	private String tip;

	//bi-directional many-to-one association to Aranzman
	@OneToMany(mappedBy="soba", fetch=FetchType.EAGER)
	private List<Aranzman> aranzmans;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	private Hotel hotel;

	public Soba() {
	}

	public int getIdSoba() {
		return this.idSoba;
	}

	public void setIdSoba(int idSoba) {
		this.idSoba = idSoba;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<Aranzman> getAranzmans() {
		return this.aranzmans;
	}

	public void setAranzmans(List<Aranzman> aranzmans) {
		this.aranzmans = aranzmans;
	}

	public Aranzman addAranzman(Aranzman aranzman) {
		getAranzmans().add(aranzman);
		aranzman.setSoba(this);

		return aranzman;
	}

	public Aranzman removeAranzman(Aranzman aranzman) {
		getAranzmans().remove(aranzman);
		aranzman.setSoba(null);

		return aranzman;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}