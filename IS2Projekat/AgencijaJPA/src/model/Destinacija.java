package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the destinacija database table.
 * 
 */
@Entity
@NamedQuery(name="Destinacija.findAll", query="SELECT d FROM Destinacija d")
public class Destinacija implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDestinacija;

	private String naziv;

	private double ocena;

	//bi-directional many-to-one association to Aranzman
	@OneToMany(mappedBy="destinacija")
	private List<Aranzman> aranzmans;

	//bi-directional many-to-one association to Hotel
	@OneToMany(mappedBy="destinacija")
	private List<Hotel> hotels;

	public Destinacija() {
	}

	public int getIdDestinacija() {
		return this.idDestinacija;
	}

	public void setIdDestinacija(int idDestinacija) {
		this.idDestinacija = idDestinacija;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getOcena() {
		return this.ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public List<Aranzman> getAranzmans() {
		return this.aranzmans;
	}

	public void setAranzmans(List<Aranzman> aranzmans) {
		this.aranzmans = aranzmans;
	}

	public Aranzman addAranzman(Aranzman aranzman) {
		getAranzmans().add(aranzman);
		aranzman.setDestinacija(this);

		return aranzman;
	}

	public Aranzman removeAranzman(Aranzman aranzman) {
		getAranzmans().remove(aranzman);
		aranzman.setDestinacija(null);

		return aranzman;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Hotel addHotel(Hotel hotel) {
		getHotels().add(hotel);
		hotel.setDestinacija(this);

		return hotel;
	}

	public Hotel removeHotel(Hotel hotel) {
		getHotels().remove(hotel);
		hotel.setDestinacija(null);

		return hotel;
	}

}