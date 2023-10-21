package tarea_Aprendizaje_02;
// Realiza un programa Java que muestre los contenidos de un fichero de texto línea a línea, 
// numerando las líneas. Para leer las líneas de texto se usará el método readLine() 
// de la clase BufferedReader y la ruta se le pasará como argumento del main

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ud1TareaAprendizaje2Ejercicio2 {

	public static void main(String[] args) {
		String nomFich = args[0]; // Obtiene la ruta del archivo de texto del argumento pasado en línea de comandos.

        try (BufferedReader fbr = new BufferedReader(new FileReader(nomFich))) {
            int i = 1; // Inicializa un contador de líneas.
            String linea = fbr.readLine(); // Lee la primera línea del archivo.

            while (linea != null) { // Itera mientras haya líneas que leer en el archivo.
                // Muestra el número de línea (formateado con un ancho de 5 dígitos) y la línea actual.
                System.out.format("[%5d] %s", i++, linea);
                System.out.println(); // Salta una línea para la próxima línea.
                linea = fbr.readLine(); // Lee la siguiente línea.
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existe fichero " + nomFich); // Maneja la excepción si el archivo no se encuentra.
        } catch (IOException e) {
            System.out.println("Error de E/S: " + e.getMessage()); // Maneja errores de entrada/salida.
        } catch (Exception e) {
            e.printStackTrace(); // Maneja cualquier otra excepción no esperada mostrando su traza.
        }
    }
}	

	