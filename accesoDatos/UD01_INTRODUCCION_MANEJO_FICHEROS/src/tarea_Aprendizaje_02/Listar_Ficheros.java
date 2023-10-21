package tarea_Aprendizaje_02;

import java.io.File;

		//Realiza un programa Java que muestre por defecto un listado de los ficheros 
		// y directorios que contiene el directorio C:\Windows. 
		// En cambio, si se le pasa la ruta como argumento del main, 
		// mostrará información de ese directorio.
public class Listar_Ficheros {

	public static void main(String[] args) {
		// Verificar si se proporcionó una ruta como argumento
        if (args.length == 0) {
            // Si no se proporciona una ruta, listar el directorio C:\Windows por defecto
            listarDirectorio(new File("C:\\Windows"));
        } else {
            // Si se proporciona una ruta como argumento, listar el directorio especificado
            String ruta = args[0];
            listarDirectorio(new File(ruta));
        }
    }

    public static void listarDirectorio(File directorio) {
        // Verificar si el directorio existe
        if (directorio.exists() && directorio.isDirectory()) {
            System.out.println("Contenido del directorio: " + directorio.getAbsolutePath());

            // Obtener la lista de archivos y directorios en el directorio especificado
            File[] archivos = directorio.listFiles();

            // Mostrar la lista de archivos y directorios
            for (File archivo : archivos) {
                System.out.println(archivo.getName());
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio válido.");
        }
    }
}