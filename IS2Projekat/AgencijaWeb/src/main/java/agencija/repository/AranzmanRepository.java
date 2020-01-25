package agencija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Aranzman;
import model.Hotel;
import model.Korisnik;

public interface AranzmanRepository extends JpaRepository<Aranzman, Integer> {
	List<Aranzman> findByHotel(Hotel h);
	List<Aranzman> findByKorisnik(Korisnik k);
}