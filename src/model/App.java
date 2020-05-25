package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import exceptions.EqualsException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author diegoa.torres
 * @author juanc.guerra
 */
public class App implements Serializable {

	private Alimentacion alimentacion;
	private Personal personal;
	private Hidratacion hidratacion;

	private Usuario usu;

	public App() {
		alimentacion = new Alimentacion();
		personal = new Personal();
		hidratacion = new Hidratacion();
//		usu = new Usuario("Juan", "Guerra", 1.72, 70, "10/04/2002", 'M', 18);
	}

	public Alimentacion getAlimentacion() {
		return alimentacion;
	}

	public void setAlimentacion(Alimentacion alimentacion) {
		this.alimentacion = alimentacion;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public Hidratacion getHidratacion() {
		return hidratacion;
	}

	public void setHidratacion(Hidratacion hidratacion) {
		this.hidratacion = hidratacion;
	}

	public Usuario getUsu() {
		return usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}

	public void nuevoUsuario(String nombre, String apellido, double altura, double peso, String fechaNacimiento,
			String sexo, int anios) {
		usu = new Usuario(nombre, apellido, altura, peso, fechaNacimiento, sexo, anios);
	}

	public String[] getAllUsuario() {
		String[] s = null;
		if (usu != null) {
			s = new String[7];
			s[0] = usu.getNombre();
			s[1] = usu.getApellido();
			s[2] = usu.getAltura() + "";
			s[3] = usu.getPeso() + "";
			s[4] = usu.getFechaNacimiento() + "";
			s[5] = usu.getSexo() + "";
			s[6] = usu.getAnios() + "";
		}
		return s;
	}

	public void agregarDesayuno(Desayuno d) {
		alimentacion.anadirDesayuno(d);
	}

	public void agregarAlmuerzo(Almuerzo a) {
		alimentacion.anadirAlmuerzo(a);
	}

	public void agregarComida(Comida c) {
		alimentacion.anadirComida(c);
	}

	public void agregarConcentracion(Concentracion c) throws EqualsException {
		personal.AgregarConcentracion(c);
	}

	public void agregarSuenio(Suenio s) throws EqualsException {
		personal.AgregarSuenio(s);
	}

	public Suenio buscarSuenio(String day) {

		return personal.buscarSuenio(day);
	}

	public Concentracion buscarConcentracion(String day) {

		return personal.buscarConcentracion(day);
	}

	public String reporteAlimentacion(String Bdia, String tipo) {
		String filePath = "";
		try {
			String[] s = Bdia.split("/");
			String dia = s[0] + "." + s[1] + "." + s[2];
			File f = new File("src\\reportes\\reporte_" + dia + "_" + tipo + ".txt");
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			String st = crearReporte(Bdia, tipo);
			filePath = f.getAbsolutePath();
			bw.write(st);
			bw.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
		return filePath;
	}

	private String crearReporte(String bdia, String tipo) {
		String re = "";
		if (tipo.equalsIgnoreCase("Desayuno")) {
			re += alimentacion.buscarDesayuno(bdia);
		} else if (tipo.equalsIgnoreCase("Almuerzo")) {
			re += alimentacion.buscarAlmuerzo(bdia);
		} else if (tipo.equalsIgnoreCase("Comida")) {
			re += alimentacion.buscarComida(bdia);
		} else if (tipo.equalsIgnoreCase("Todo")) {
			re += alimentacion.buscarDesayuno(bdia) + "\n" + alimentacion.buscarAlmuerzo(bdia) + "\n"
					+ alimentacion.buscarComida(bdia);
		}
		return re;
	}

	public void agregarCafe(int noVasos, String fecha, String hora) {
		Cafe newCafe = new Cafe(noVasos, fecha, hora);
		hidratacion.agregarCafe(newCafe);
	}

	public void agregarAgua(int noVasos, String fecha, String hora) {
		Agua newAgua = new Agua(noVasos, fecha, hora);
		hidratacion.agregarAgua(newAgua);
	}
	
	public String reporteAgua(String day) {
		String filePath = "";
		try {
			String[] s = day.split("/");
			String dia = s[0] + "." + s[1] + "." + s[2];
			File f = new File("src\\reportes\\reporte_"+dia+".txt");
			filePath = f.getAbsolutePath();
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(crearReporteAgua(day));
			bw.close();
		} catch (IOException e) {
			
		}
		return filePath;
	}
	public String crearReporteAgua(String day) {
		ArrayList<Agua> todos = hidratacion.todosAguaDia(day);
		String ex = "";
		ex += "REPORTE DIA " + 	day +"\n";
		for (int i = 0; i < todos.size(); i++) {
			ex += "\t"+todos.get(i) +"\n";
		}
		return ex;
	}
	public String reporteCafe(String day) {
		String filePath = "";
		try {
			String[] s = day.split("/");
			String dia = s[0] + "." + s[1] + "." + s[2];
			File f = new File("src\\reportes\\reporte_"+dia+".txt");
			filePath = f.getAbsolutePath();
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));
			bw.write(crearReporteCafe(day));
			bw.close();
		} catch (IOException e) {
			
		}
		return filePath;
	}
	public String crearReporteCafe(String day) {
		ArrayList<Cafe> todos = hidratacion.todosCafeDia(day);
		String ex = "";
		ex += "REPORTE DIA " + 	day +"\n";
		for (int i = 0; i < todos.size(); i++) {
			ex += "\t"+todos.get(i) +"\n";
		}
		return ex;
	}

}
