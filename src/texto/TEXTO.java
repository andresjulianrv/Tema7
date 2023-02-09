package texto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TEXTO {
	public static void main(String[] args) {
	
		
//		FileWriter f=null;
//		try {
//			f = new FileWriter("numeros.txt",true);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		File f=new File("numero.txt");
		Scanner s=new Scanner(System.in);
		try {
			PrintWriter salida=new PrintWriter(f);
			int numero=0;
			do {
				System.out.println("Dame un numero");
				numero=s.nextInt();
				salida.println(numero);
			}while(numero!=0);
			salida.flush();
			salida.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Leemos de fichero");
		//Leer el fichero
		try {
			Scanner entrada=new Scanner(new File("numero.txt"));
			int num=0;
			while(entrada.hasNext()) {
				num=entrada.nextInt();
				System.out.println(num);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
