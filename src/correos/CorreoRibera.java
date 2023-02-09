package correos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CorreoRibera {
	private ArrayList<Correo> listaCorreos;
	
	public CorreoRibera() {
		this.listaCorreos=new ArrayList<>();
	}

	public ArrayList<Correo> getListaCorreos() {
		return listaCorreos;
	}

	public void setListaCorreos(ArrayList<Correo> listaCorreos) {
		this.listaCorreos = listaCorreos;
	}
	
	public static void main(String[] args) {
		CorreoRibera c=new CorreoRibera();
		String cursoCompleto="";
		Scanner entrada;
		try {
			entrada = new Scanner(new File("AlumnosDAM.csv"));
			//Salto 5 líneas
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			entrada.nextLine();
			String cadena="";
			String linea[];
			//Para cada línea
			while(entrada.hasNext()) {
				cadena=entrada.nextLine();
				linea=cadena.split(";");
				String nombreApe=linea[0];
				cursoCompleto=linea[2];
				String curso=cursoCompleto.substring(0, cursoCompleto.length()-1).toLowerCase();
				//System.out.println(nombreApe+" "+curso);
				String nombre=c.getNombre(nombreApe);
				String ape1=c.getApellido1(nombreApe);
				//System.out.println(nombre+" "+ape1+" "+curso);
				String correo=curso+"_"+nombre+ape1+"@riberadeltajo.es";
				c.getListaCorreos().add(new Correo(nombre, ape1, curso, correo));
				
				
				
			}//while
			
			c.generarFicheroTexto(cursoCompleto);
			c.generarFicheroCSV(cursoCompleto);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void generarFicheroCSV(String cursoCompleto) {
		try {
			PrintWriter salida=new PrintWriter(new File("Correos"+cursoCompleto+".csv"));
			salida.println(cursoCompleto);
			salida.println("Número;Alumno");
			int numero=1;
			for(Correo c: this.getListaCorreos()) {
				salida.println(numero+";"+c.getCorreo());
				numero++;
			}
			salida.flush();
			salida.close();
			System.out.println("Fichero Correos"+cursoCompleto+".csv creado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void generarFicheroTexto(String cursoCompleto) {

		try {
			PrintWriter salida=new PrintWriter(new File("Correos"+cursoCompleto+".txt"));
			salida.println("Correos de "+cursoCompleto);
			salida.println();
			for(Correo c: this.getListaCorreos())
				salida.println(c.getCorreo());
			
			
			salida.flush();
			salida.close();
			System.out.println("Fichero Correos"+cursoCompleto+".txt creado");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private String getApellido1(String nombreApe) {
		String palabra[]=nombreApe.split(" ");
		String ape1=palabra[0].trim().toLowerCase();		
		return this.quitaTildes(ape1);
	}

	private String getNombre(String nombreApe) {
		String palabra[]=nombreApe.split(",");
		String nombre=palabra[1].trim().toLowerCase();
	
		return 	this.quitaTildes(nombre);
	}
	
	private String quitaTildes(String cadena) {
		
		String palabra[];
		for(int i=0; i<cadena.length(); i++) {
			if(cadena.charAt(i)=='á') {
				cadena=cadena.replace('á','a');
			}
			if(cadena.charAt(i)=='é') {
				cadena=cadena.replace('é','e');
			}
			if(cadena.charAt(i)=='í') {
				cadena=cadena.replace('í','i');
			}
			if(cadena.charAt(i)=='ó') {
				cadena=cadena.replace('ó','o');
			}
			if(cadena.charAt(i)=='ú') {
				cadena=cadena.replace('ú','u');
			}
			if(cadena.charAt(i)=='ñ') {
				cadena=cadena.replace('ñ', 'n');
			}
			if(cadena.charAt(i)==' ') {
				palabra=cadena.split(" ");
				cadena=palabra[0]+palabra[1];
			}
		}
		return cadena;
	}//

}