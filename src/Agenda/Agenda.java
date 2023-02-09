package Agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Agenda {
	private ArrayList<Contactos>lista;
	
	public Agenda() {
		this.lista=new ArrayList<>();
	}

	public ArrayList<Contactos> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Contactos> lista) {
		this.lista = lista;
	}
public void cargarAgenda(String filename) {
	try {
		FileInputStream fi=new FileInputStream(filename);
		ObjectInputStream is=new ObjectInputStream(fi);
		Contactos c=null;
		while(is!=null) {
			try {
				c=(Contactos)is.readObject();
				this.añadirContacto(c);
			} catch (Exception e ) {
				//si se lanza la excepcion cambiamos la condicion del bucle
				is=null;

			}
		}//while
		
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}	
	public void guardarAgenda(String filename) {
		try {
			FileOutputStream fo=new FileOutputStream(filename);
			ObjectOutputStream os=new ObjectOutputStream(fo);
			for (Contactos c : this.getLista()) {
				//Escribimos cada objeto en el fichero
				os.writeObject(c);
				
			}
			fo.close();
			os.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	public void imprimirAgenda() {
		System.out.println("Los contactos son:");
		for (Contactos c : this.getLista()) {
			System.out.println(c.getNombre()+" "+c.getTelefono());
			
		}
	}
	public void añadirContacto(Contactos c) {
		this.getLista().add(c);
	}
	public void borrarContacto(String nombre) {
		for(int i=0; i<this.getLista().size();i++) {
			if(this.getLista().get(i).getNombre().equalsIgnoreCase(nombre)) {
				this.getLista().remove(i);
			}
		}
	}
	public static void main(String[] args) {
		Agenda agenda=new Agenda();
		Contactos c=new Contactos("Marta", "12323", "dssdf", "marta@ribera");
		Contactos c1=new Contactos("Carlos", "33561", "addfaf", "carlos@ribera");
		Contactos c2=new Contactos("Juan", "232561456", "dsaasda", "juan@ribera");
		agenda.añadirContacto(c);
		agenda.añadirContacto(c1);
		agenda.añadirContacto(c2);
		agenda.guardarAgenda("contactos.bin");
		agenda.getLista().clear();
		
		//Cargar los contactos desde el fichero
		agenda.cargarAgenda("contactos.bin");
		agenda.imprimirAgenda();
	}
}
