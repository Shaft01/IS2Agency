package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHotel;

	private int brZvezdica;

	private String naziv;

	//bi-directional many-to-one association to Aranzman
	@OneToMany(mappedBy="hotel")
	private List<Aranzman> aranzmans;

	//bi-directional many-to-one association to Destinacija
	@ManyToOne
	private Destinacija destinacija;

	//bi-directional many-to-one association to Soba
	@OneToMany(mappedBy="hotel")
	private List<Soba> sobas;

	public Hotel() {
	}

	public int getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public int getBrZvezdica() {
		return this.brZvezdica;
	}

	public void setBrZvezdica(int brZvezdica) {
		this.brZvezdica = brZvezdica;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Aranzman> getAranzmans() {
		return this.aranzmans;
	}

	public void setAranzmans(List<Aranzman> aranzmans) {
		this.aranzmans = aranzmans;
	}

	public Aranzman addAranzman(Aranzman aranzman) {
		getAranzmans().add(aranzman);
		aranzman.setHotel(this);

		return aranzman;
	}

	public Aranzman removeAranzman(Aranzman aranzman) {
		getAranzmans().remove(aranzman);
		aranzman.setHotel(null);

		return aranzman;
	}

	public Destinacija getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	public List<Soba> getSobas() {
		return this.sobas;
	}

	public void setSobas(List<Soba> sobas) {
		this.sobas = sobas;
	}

	public Soba addSoba(Soba soba) {
		getSobas().add(soba);
		soba.setHotel(this);

		return soba;
	}

	public Soba removeSoba(Soba soba) {
		getSobas().remove(soba);
		soba.setHotel(null);

		return soba;
	}

}