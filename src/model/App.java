package model;

import java.io.Serializable;

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

}
