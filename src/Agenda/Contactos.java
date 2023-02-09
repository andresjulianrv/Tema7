package Agenda;

import java.io.Serializable;

public class Contactos implements Serializable {
	private String nombre;
	private String telefono;
	private String direccion;
	private String correo;
	
	public Contactos() {
		this.nombre = "";
		this.telefono = "";
		this.direccion = "";
		this.correo = "";
	}
	
	
	public Contactos(String nombre, String telefono, String direccion, String correo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.correo = correo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	@Override
	public String toString() {
		return "Contactos [nombre=" + nombre + ", telefono=" + telefono + ", direccion=" + direccion + ", correo="
				+ correo + "]";
	}
	
	
}
