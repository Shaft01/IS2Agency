package agencija.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import agencija.repository.AranzmanRepository;
import agencija.repository.DestinacijaRepository;
import agencija.repository.HotelRepository;
import model.Aranzman;
import model.Destinacija;
import model.Hotel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value="Hotel")
public class HotelController {
	
	@Autowired
	DestinacijaRepository dr;
	
	@Autowired
	HotelRepository hr;
	
	@Autowired 
	AranzmanRepository ar;
	
	@RequestMapping(value="getDestinacije",method=RequestMethod.GET)
	public String getDestinacije(String naziv,HttpServletRequest request) {
		Destinacija d=dr.findByNaziv(naziv);
		List<Hotel> hoteli=hr.findByDestinacija(d);
		request.getSession().setAttribute("hoteli", hoteli);
		return "/prikazHotela";
	}
	@RequestMapping(value="aranzmanIzvestaj",method=RequestMethod.GET)
		public void aranzmanIzvestaj(int idHotel,HttpServletResponse response)throws Exception {
			Hotel h = hr.findById(idHotel).get();
			List<Aranzman> aranzmani = ar.findByHotel(h);
		
			response.setContentType("text/html");
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(aranzmani);
			InputStream inputStream = this.getClass().getResourceAsStream("/jasperreports/aranzmaniZaHotel.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("naziv", h.getNaziv());
			params.put("brZvezdica",h.getBrZvezdica());
			params.put("nazivDestinacije", h.getDestinacija().getNaziv());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
			inputStream.close();
			
			
			response.setContentType("application/x-download");
			response.addHeader("Content-disposition", "attachment; filename=aranzmaniZaHotel.pdf");
			OutputStream out = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint,out);
		}

	

}
