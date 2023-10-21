package clase_File;

import java.io.*;

public class VerDirectorio {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		// String dir = "." // Directorio actual
		String dir = "C:\\Windows\\appcompat";
		File f = new File(dir);
		String[] archivos = f.list();
		
		System.out.printf("Fichero en el directorio actual: %d %n", archivos.length);
		for (int i = 0; i < archivos.length; i++) {
			File f2 = new File(f, archivos[i]);
			System.out.printf("Nombre; %s, es un fichero?: %b, es un directorio?: %b %n", archivos[i], f2.isFile(), 
					f2.isDirectory());
		}

	}

}
