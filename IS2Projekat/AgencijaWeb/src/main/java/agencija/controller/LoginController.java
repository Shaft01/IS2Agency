package agencija.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agencija.repository.KorisnikRepository;
import agencija.repository.UlogaRepository;
import model.Korisnik;
import model.Uloga;

@Controller
@RequestMapping(value="/auth")
public class LoginController {
	
	@Autowired
	KorisnikRepository kr;
	
	@Autowired
	UlogaRepository ur;

	@RequestMapping(value="loginPage", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	@RequestMapping(value="pocetna",method=RequestMethod.GET)
	public String pocetna() {
		return "index";
	}
	
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String saveKorisnik(String ime,String prezime,String email,String password,String username) {
		BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
		Korisnik k=new Korisnik();
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setUsername(username);
		k.setEmail(email);
		k.setPassword(passwordEncoder.encode(password));
		Uloga u=ur.findById(2).get();
		u.addKorisnik(k);

		k.addUloga(u);
				
		
		kr.save(k);
		return "login";
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			SecurityContextHolder.getContext().setAuthentication(null);
		}
		
		return "redirect:/auth/loginPage";
	}


}