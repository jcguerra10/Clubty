package model;

import java.io.Serializable;

public class Usuario implements Serializable {

	private String nombre;
	private String apellido;
	private double altura;
	private double peso;
	private String fechaNacimiento;
	private char sexo;
	private int anios;

	public Usuario(String nombre, String apellido, double altura, double peso, String fechaNacimiento, char sexo,
			int anios) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
		this.peso = peso;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.anios = anios;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public double getAltura() {
		return altura;
	}

	public double getPeso() {
		return peso;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public int getAnios() {
		return anios;
	}

}
