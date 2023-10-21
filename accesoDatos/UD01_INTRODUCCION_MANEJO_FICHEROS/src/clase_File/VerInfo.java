package clase_File;

import java.io.*;

public class VerInfo {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		System.out.println("Informacion del fichero");
		File fichero = new File("G:\\GITHUB\\DAM\\accesoDatos\\UD01_iNTRODUCCION_MANEJO_FICHEROS\\src\\clase_File\\VerInfo.java");		
		// File fichero = new File("G:/GITHUB\DAM/accesoDatos/UD01_iNTRODUCCION_MANEJO_FICHEROS/src/clase_File/VerInfo.java");
		// File fichero = new File("G:"+ File.separator + "GITHUB" + File.separator + "DAM" + File.separator + "accesoDatos" + File.separator + "UD01_iNTRODUCCION_MANEJO_FICHEROS" + File.separator + "src" + File.separator + "clase_File"+ File.separator + "VerInfo.java");
		// File fichero = new File(args[0]);
		
		
		if (fichero.exists()) {
			System.out.println("Nombre del fichero : " + fichero.getName());
			System.out.println("Ruta del fichero   : " + fichero.getPath());
			System.out.println("Ruta Absoluta      : " + fichero.getAbsolutePath());
			System.out.println("Se puede leer?     : " + fichero.canRead());
			System.out.println("Tamaño del fichero : " + fichero.length());
			System.out.println("Es un directorio?  : " + fichero.isDirectory());
			System.out.println("Es un fichero?     : " + fichero.isFile());
			System.out.println("Nombre del directorio padre : " + fichero.getParent());
		}
		
	}

}
