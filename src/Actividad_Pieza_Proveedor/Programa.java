package Actividad_Pieza_Proveedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Programa {
ArrayList<Pieza> piezas;
ArrayList<Proveedor>Prov;


	public Programa() {
	this.piezas = new ArrayList<>();
	this.Prov = new ArrayList<>();
}
	
	
	public ArrayList<Pieza> getPiezas() {
	return piezas;
}
public void setPiezas(ArrayList<Pieza> piezas) {
	this.piezas = piezas;
}
public ArrayList<Proveedor> getProv() {
	return Prov;
}
public void setProv(ArrayList<Proveedor> prov) {
	Prov = prov;
}
	public static void main(String[] args) {
		Programa p=new Programa();
		Utilidades u=new Utilidades();
		p.setPiezas(u.leerPiezas("piezas.csv"));
		p.setProv(u.leerProveedores("proveedor.csv"));
		p.generarFichero("Piezas_proveedor.txt");
	}
		private void generarFichero(String filename) {
			double peso=0;
			try {
			PrintWriter salida=new PrintWriter(new File(filename));	
		for(Proveedor prov:this.getProv()) {
			System.out.println("El proveedor "+prov.getNombreProveedor()+"suministra:");
			peso=0;
			for(Pieza pie:this.getPiezas()) {
				if(prov.getCodProveedor()==pie.getProveedor()) {
					salida.println("\t*)"+Character.toUpperCase(pie.getNombrePieza().charAt(0))+pie.getNombrePieza().substring(1));
				}
				salida.println("Peso total: "+peso);
			}
		}
		salida.flush();
		salida.close();
		System.out.println("Fichero creado");

}catch (FileNotFoundException e) {
	
}
			
		
	}

}

