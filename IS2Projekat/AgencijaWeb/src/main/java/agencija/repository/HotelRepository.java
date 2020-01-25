package agencija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Destinacija;
import model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	List<Hotel> findByDestinacija(Destinacija d);
}
