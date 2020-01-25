package agencija.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import agencija.repository.KorisnikRepository;
import model.Korisnik;
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	KorisnikRepository kr;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik k= kr.findById(username).get();
		UserDetailsImpl userDetails=new UserDetailsImpl();
		userDetails.setUsername(k.getUsername());
		userDetails.setPassword(k.getPassword());
		userDetails.setUloge(k.getUlogas());
		userDetails.setIme(k.getIme());
		userDetails.setPrezime(k.getPrezime());
		return userDetails;
	}

}
