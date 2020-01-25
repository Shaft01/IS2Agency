package agencija.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agencija.repository.AranzmanRepository;
import agencija.repository.KorisnikRepository;
import model.Aranzman;
import model.Hotel;
import model.Korisnik;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="/Aranzman")
public class AranzmanController {
	@Autowired
	KorisnikRepository kr;
	@Autowired
	AranzmanRepository ar;
	@RequestMapping(value="getAranzmaniKorisnika",method=RequestMethod.GET)
	public String getAranzmani(HttpServletRequest request,Model m) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Korisnik k = kr.findById(userDetails.getUsername()).get();
		List<Aranzman> aranzmani=ar.findByKorisnik(k);
		request.getSession().setAttribute("aranzmani", aranzmani);
		m.addAttribute("korisnik", k);
		return "prikazAranzmanaKorisnika";
	}
	@RequestMapping(value="izvestaj",method=RequestMethod.GET)
	public void generisiIzvestaj(HttpServletRequest request,HttpServletResponse response)throws Exception {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Korisnik k = kr.findById(userDetails.getUsername()).get();
		List<Aranzman> aranzmani = ar.findByKorisnik(k);
	
		response.setContentType("text/html");
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(aranzmani);
		InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/aranzmaniKorisnika.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ime", k.getIme()+" "+k.getPrezime());
		params.put("username",k.getUsername());
		params.put("email",k.getEmail());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		inputStream.close();
		
		
		response.setContentType("application/x-download");
		response.addHeader("Content-disposition", "attachment; filename=aranzmaniKorisnika.pdf");
		OutputStream out = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint,out);
	}
}