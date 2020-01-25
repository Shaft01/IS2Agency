package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the aranzman database table.
 * 
 */
@Entity
@NamedQuery(name="Aranzman.findAll", query="SELECT a FROM Aranzman a")
public class Aranzman implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAranzman;

	private int brojDana;

	private double cena;

	@Temporal(TemporalType.DATE)
	private Date datumPlacanja;

	@Temporal(TemporalType.DATE)
	private Date datumRezervacije;

	//bi-directional many-to-one association to Destinacija
	@ManyToOne
	private Destinacija destinacija;

	//bi-directional many-to-one association to Hotel
	@ManyToOne
	private Hotel hotel;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-one association to Soba
	@ManyToOne
	private Soba soba;

	public Aranzman() {
	}

	public int getIdAranzman() {
		return this.idAranzman;
	}

	public void setIdAranzman(int idAranzman) {
		this.idAranzman = idAranzman;
	}

	public int getBrojDana() {
		return this.brojDana;
	}

	public void setBrojDana(int brojDana) {
		this.brojDana = brojDana;
	}

	public double getCena() {
		return this.cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Date getDatumPlacanja() {
		return this.datumPlacanja;
	}

	public void setDatumPlacanja(Date datumPlacanja) {
		this.datumPlacanja = datumPlacanja;
	}

	public Date getDatumRezervacije() {
		return this.datumRezervacije;
	}

	public void setDatumRezervacije(Date datumRezervacije) {
		this.datumRezervacije = datumRezervacije;
	}

	public Destinacija getDestinacija() {
		return this.destinacija;
	}

	public void setDestinacija(Destinacija destinacija) {
		this.destinacija = destinacija;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Soba getSoba() {
		return this.soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

}