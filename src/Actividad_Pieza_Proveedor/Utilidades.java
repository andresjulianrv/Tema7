package Actividad_Pieza_Proveedor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import correos.Correo;

public class Utilidades {

	public ArrayList<Pieza> leerPiezas(String filename) {
	ArrayList<Pieza> piezas=new ArrayList<>();
		Scanner entrada;
		try {
			entrada = new Scanner(new File(filename));
			String cadena;
			String linea[];
			//Salto la linea de cabecera
			cadena=entrada.nextLine();
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(",");
			piezas.add(new Pieza(Integer.parseInt(linea[0]),linea[1],Integer.parseInt(linea[2]),Double.parseDouble(linea[3])));
			}
			for (Pieza p : piezas) {
			System.out.println(p);
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		return piezas;
	}
	
	public ArrayList<Proveedor> leerProveedores(String filename) {
		ArrayList<Proveedor> proveedor=new ArrayList<>();
			Scanner entrada;
			try {
				entrada = new Scanner(new File(filename));
				String cadena;
				String linea[];
				//Salto la linea de cabecera
				cadena=entrada.nextLine();
				while(entrada.hasNext()) {
					cadena=entrada.nextLine();
					linea=cadena.split(",");
					proveedor.add(new Proveedor(Integer.parseInt(linea[0]), linea[1], linea[2]));
				}
				 for (Proveedor p : proveedor) {
					System.out.println(p);
				}
				
				
				
			} catch (FileNotFoundException e1) {
			
				e1.printStackTrace();
			}
			
			return proveedor;
		}
	
	public static void main(String[] args) {
		Utilidades u=new Utilidades();
		u.leerPiezas("piezas.csv");
		u.leerProveedores("proveedor.csv");
	}
	
	
	
}
