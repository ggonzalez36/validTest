package validPrueba;


import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ReportController {
	
	@Autowired
	private CsvReader reporteService;

	@GetMapping("/reporte/horas")
	public Map<String, Double> retrivehours(@RequestParam(value="user") String user){

		return reporteService.retrieveAllhours();
	}
	
	@GetMapping("/reporte/horasbygroup")
	public Map<String, Set<Double>> retrivehoursgroup(@RequestParam(value="user") String user){

		return reporteService.retrievehoursGroup();
	}
	
	@GetMapping("/reporte/datesbygroup")
	public Map<String, Set<Date>> retriveDates(@RequestParam(value="user") String user){

		return reporteService.retrieveDatesGroup();
	}
	
	

	
	

}
