package agencija.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agencija.repository.DestinacijaRepository;
import agencija.repository.HotelRepository;
import model.Destinacija;
import model.Hotel;

@Controller
@RequestMapping(value="Unos")
public class UnosController {
	@Autowired
	DestinacijaRepository dr;
	
	@Autowired
	HotelRepository hr;
	@RequestMapping(value="unosDestinacije")
	public String dodajDestinaciju(String naziv, String ocena,Model m) {
		Destinacija d=new Destinacija();
		d.setNaziv(naziv);
		Double oc=Double.parseDouble(ocena);
		d.setOcena(oc);
		dr.save(d);
		String poruka="Destinacija je uspesno dodata";
		m.addAttribute("poruka", poruka);
		return "unosDestinacije";
	}
	@RequestMapping(value="getDestinacije",method=RequestMethod.GET)
	public String getDestinacije(HttpServletRequest request) {
		List<Destinacija> destinacije=dr.findAll();
		request.getSession().setAttribute("destinacije", destinacije);
		return "/unosHotela";
	}
	@RequestMapping(value="unosHotela",method=RequestMethod.POST)
	public String dodajHotel(String naziv,int destinacija,int brZvezdica, Model m) {
		Destinacija d=dr.findById(destinacija).get();
		Hotel h=new Hotel();
		h.setBrZvezdica(brZvezdica);
		h.setNaziv(naziv);
		h.setDestinacija(d);
			
		hr.save(h);
		d.addHotel(h);
		String poruka="Hotel je uspesno sacuvan";
		m.addAttribute("poruka",poruka);
		return "/unosHotela";
		
	}
}
