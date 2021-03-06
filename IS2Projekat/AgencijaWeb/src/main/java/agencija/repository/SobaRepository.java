package agencija.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Hotel;
import model.Soba;

public interface SobaRepository extends JpaRepository<Soba, Integer> {
	List<Soba> findByHotel(Hotel h);
	
	//@Query("select s from Soba s inner join s.hotel h where h.idHotel =:id and not exists(select a.soba from Aranzman a where a.soba=s and a.hotel=h")
	//List<Soba> findByHotelS(@Param("id") Integer id);
}
