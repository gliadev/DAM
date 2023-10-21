package tareaEvaluativa01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 1. Flujos de caracteres: (FileReader, FileWriter) (1,5 puntos)
 * Realiza un programa en Java que lea un fichero y lo invierta. Es decir, si el fichero de
 * entrada contiene “Hola mundo”, el fichero de salida contendrá “odnum aloH”.
 * 
 */

public class Ejercicio01 {
	public static void main(String[] args) {
		
		// voy a usar un try catch como en los ejercicios
		try {
			// Crear BufferedReader para leer el archivo de entrada en una sola línea
			 BufferedReader archivoEntrada = new BufferedReader(new FileReader("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator +"archivoEntrada"));
			
            // leo lo que contiene el archivo y lo meto en string
            String contenido = archivoEntrada.readLine();
            
            // invierto el contenido
            String contenidoInvertido = new StringBuilder(contenido).reverse().toString();
            
            // Creo el FileWriter para el archivo de salida
            FileWriter archivoSalida = new FileWriter("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "archivoSalida.txt");
            archivoSalida.write(contenidoInvertido);
            
            // pongo mensaje de ok invertido
            System.out.println("El contenido invertido " );
            
            // cierro las conexiones
            archivoEntrada.close();
            archivoSalida.close();
            
		} catch (IOException e ) {
			e.printStackTrace();
		}

	}

}
