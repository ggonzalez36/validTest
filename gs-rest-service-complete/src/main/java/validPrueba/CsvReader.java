package validPrueba;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CsvReader {
	
	
	
     
	
    	 
    	
         
     private static List<Reporte> reportelist = new ArrayList<Reporte>();
     
     
     
     static {
    	 
    	 String csvFile = "D:\\Entrevistas\\datos_prueba.csv";
         String line = "";
         String cvsSplitBy = ",";
     try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
    	 
    	 
    	 //ArrayList<Reporte> reportelist = new ArrayList<Reporte>();
    	 line = br.readLine();
    	 int i=2;
         while ((line = br.readLine()) != null) {
        	 i++;
        

             // use comma as separator
             String[] reporte = line.split(cvsSplitBy);
             
             System.out.println(i+":"+reporte[4]+reporte[5]);
             
          
             Date date=new SimpleDateFormat("dd/MM/yyyy").parse(reporte[0]);  
             String user=reporte[1];
             String actividad=reporte[2];
             String proyecto=reporte[3];
             double horas= Double.parseDouble(reporte[4]+reporte[5]); 
             
             // public Reporte(Date date, String user, String actividad, String proyecto, double horas)
             
             
             reportelist.add(new Reporte (date,user,actividad,proyecto,horas));

    

         }

     } catch (IOException e) {
         e.printStackTrace();
     } catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
     }   
     
     
     public Map<String, Double> retrieveAllhours() {
    	 
    	 Map<String, Long> counting = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.counting()));

         System.out.println(counting);

         Map<String, Double> sum = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.summingDouble(Reporte::getHoras)));
         
         Map<String, Set<Double>> hoursgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getHoras, Collectors.toSet())));
         
         Map<String, Set<Date>> datesgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getDate, Collectors.toSet())));
    	 
         System.out.println(sum);
         System.out.println(hoursgroup);
         
         System.out.println(datesgroup);
         
         
 
    	 
 		return sum;
 	}
     
     
     public  Map<String, Set<Double>> retrievehoursGroup() {
    	 
    	 Map<String, Long> counting = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.counting()));

         System.out.println(counting);

         Map<String, Double> sum = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.summingDouble(Reporte::getHoras)));
         
         Map<String, Set<Double>> hoursgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getHoras, Collectors.toSet())));
         
         Map<String, Set<Date>> datesgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getDate, Collectors.toSet())));
    	 
         System.out.println(sum);
         System.out.println(hoursgroup);
         
         System.out.println(datesgroup);
         
         
 
    	 
 		return hoursgroup;
     
 		
     }
     
     public  Map<String, Set<Date>> retrieveDatesGroup() {
    	 
    	 Map<String, Long> counting = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.counting()));

         System.out.println(counting);

         Map<String, Double> sum = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser, Collectors.summingDouble(Reporte::getHoras)));
         
         Map<String, Set<Double>> hoursgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getHoras, Collectors.toSet())));
         
         Map<String, Set<Date>> datesgroup = reportelist.stream().collect(
                 Collectors.groupingBy(Reporte::getUser,Collectors.mapping(Reporte::getDate, Collectors.toSet())));
    	 
         System.out.println(sum);
         System.out.println(hoursgroup);
         
         System.out.println(datesgroup);
         
         
 
    	 
 		return datesgroup;
     
 		
     }
     
}
