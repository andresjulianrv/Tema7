package Agenda;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		//1)Imprimir agenda
		//2)Añadir contacto
		//3)Eliminar contacto
		//4)Salir
		
		Agenda agenda=new Agenda();
		agenda.cargarAgenda("contactos.bin");
		int selecionar=0;
		do {
		menu();
		Scanner s=new Scanner(System.in);
		int selecionar1=s.nextInt();
		
		switch(selecionar1) {
		case 1:
			agenda.imprimirAgenda();
			break;
		case 2:
//			System.out.println("Datos del contacto");
//			System.out.println("Nombre");
//			String nombre=s.next();
//			System.out.println("Telefono");
//			String telefono=s.next();
//			System.out.println("Direccion");
//			String direccion=s.next();
//			System.out.println("Correo");
//			String email=s.next();
//			agenda.añadirContacto(new Contactos(nombre, telefono, direccion, email));
			Contactos c=new Contactos();
			System.out.println("Datos del contacto");
			System.out.println("Nombre");
			String nombre=s.next();
			c.setNombre(nombre);
			System.out.println("Telefono");
			String telefono=s.next();
			c.setTelefono(telefono);
			System.out.println("Direccion");
			String direccion=s.next();
			c.setDireccion(direccion);
			System.out.println("Correo");
			String email=s.next();
			c.setCorreo(email);
			break;
		case 3:
			System.out.println("Dame un nombre");
			String n=s.next();
			agenda.borrarContacto(n);
			break;
		case 4:
			agenda.guardarAgenda("contactos.bin");
			break;
		}
		}while(selecionar!=4);
	}

	private static void menu() {
		System.out.println("1)Imprimir contacto");
		System.out.println("2)Añadir contacto");
		System.out.println("3)Eliminar contacto");
		System.out.println("4)Salir");
		
	}

}
