package validPrueba;

import java.util.Date;

public class Reporte {
	
	Date date;
	String user;
	String actividad;
	String proyecto;
	double horas;
	
	

	public Reporte(Date date, String user, String actividad, String proyecto, double horas) {
		super();
		this.date = date;
		this.user = user;
		this.actividad = actividad;
		this.proyecto = proyecto;
		this.horas = horas;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getProyecto() {
		return proyecto;
	}
	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}
	public double getHoras() {
		return horas;
	}
	public void setHoras(double horas) {
		this.horas = horas;
	}
	
	
	@Override
	public String toString() {
		return "Reporte [date=" + date + ", user=" + user + ", actividad=" + actividad + ", proyecto=" + proyecto
				+ ", horas=" + horas + "]";
	}
	
	
	

}
