package tarea_Aprendizaje_02;
import java.io.*;

public class Ud1TareaAprendizaje2Ejercicio1 {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente

		String ruta=("C:" + File.separator + "Windows");
		if(args.length>=1) ruta=args[0]; //Si se le pasa la ruta como argumento del main
			File fich=new File(ruta);
		if(!fich.exists()) {
			System.out.println("No existe el fichero o directorio ("+ruta+").");
		}
		else {
			if(fich.isFile()) {
				System.out.println(ruta+" es un fichero.");
			}
			else {
				System.out.println(ruta+" es un directorio. Contenidos: ");
				File[] ficheros=fich.listFiles(); // Ojo, ficheros o directorios
				for(File f : ficheros) {
					String textoDescr=f.isDirectory() ? "/" : f.isFile() ? "_" : "?";
					System.out.println("("+textoDescr+") "+f.getName());
		 }
		 }
	 }
	}
}