package model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the korisnik database table.
 * 
 */
@Entity
@NamedQuery(name="Korisnik.findAll", query="SELECT k FROM Korisnik k")
public class Korisnik implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	
	private String username;

	private String email;

	private String ime;

	private String password;

	private String prezime;

	//bi-directional many-to-one association to Aranzman
	@OneToMany(mappedBy="korisnik")
	private List<Aranzman> aranzmans;

	//bi-directional many-to-many association to Uloga
	@ManyToMany(mappedBy="korisniks", fetch=FetchType.EAGER)
	private List<Uloga> ulogas;

	public Korisnik() {
		ulogas=new ArrayList<>();
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public List<Aranzman> getAranzmans() {
		return this.aranzmans;
	}

	public void setAranzmans(List<Aranzman> aranzmans) {
		this.aranzmans = aranzmans;
	}

	public Aranzman addAranzman(Aranzman aranzman) {
		getAranzmans().add(aranzman);
		aranzman.setKorisnik(this);

		return aranzman;
	}

	public Aranzman removeAranzman(Aranzman aranzman) {
		getAranzmans().remove(aranzman);
		aranzman.setKorisnik(null);

		return aranzman;
	}

	public List<Uloga> getUlogas() {
		return this.ulogas;
	}

	public void setUlogas(List<Uloga> ulogas) {
		this.ulogas = ulogas;
	}
	public Uloga addUloga(Uloga u) {
		this.ulogas.add(u);
		return u;
	}
}