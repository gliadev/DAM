package clase_File;

import java.io.*;

public class CrearDirectorio {
	public static void main(String[] args) {
		File d = new File("NuevoDir"); // directorio que creo a partir del actual
		File f1 = new File(d, "Fichero1.txt");
		File f2 = new File(d, "Fichero2.txt");
		
		d.mkdir(); // CREAR DIRECTORIO
		
		try {
			if (f1.createNewFile())
				System.out.println("Fichero1 creado Correctamente");
			else
				System.out.println("No se a creado el FICHERO1...");
			
			if (f2.createNewFile())
				System.out.println("Fichero2 creado Correctamente");
			else
				System.out.println("No se a creado el FICHERO2..");
			
			} catch (IOException ioe ) {ioe.printStackTrace(); }
		
		f1.renameTo(new File(d, "FicheroNuevo")); // renombro Fichero1
		
		try {
			File f3 = new File("NuevoDir/FICHERO3.txt");
			f3.createNewFile(); // crea FICHERO3 en NUEVODIR
		} catch (IOException ioe) { ioe.printStackTrace(); }
	}

}
