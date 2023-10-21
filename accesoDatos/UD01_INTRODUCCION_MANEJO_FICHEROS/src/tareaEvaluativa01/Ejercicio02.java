package tareaEvaluativa01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * 2. Flujos de caracteres: (BufferedReader, BufferedWriter) (1,5 puntos)
	  Realiza un programa en Java que lea un fichero de texto y cree un nuevo fichero con las
	  palabras palíndromas que encuentre. Es decir, si el fichero original contiene la frase 
	  “ana y lola son amigas”, el fichero resultante contendrá las palabras “ana” e “y”. 
	  Una palabra palíndroma es aquella que se lee igual de izquierda a derecha que de derecha 
	  a izquierda
 * 
 */

public class Ejercicio02 {
public static void main(String[] args) {
        
        try {
            // Crear un objeto File para el fichero de entrada y establecer un flujo de entrada (BufferedReader)
            File ficheroEntrada = new File("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "palabras.txt");
            BufferedReader lector = new BufferedReader(new FileReader(ficheroEntrada));
            
            // Crear un objeto File para el fichero de salida y establecer un flujo de salida
            // Asegurándonos de que el fichero de salida tiene la extensión .txt
            File ficheroSalida = new File("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "palabrasPalindromas.txt");
            BufferedWriter escritor = new BufferedWriter(new FileWriter(ficheroSalida));
            
            String linea;
            
            // Leer cada línea del fichero de entrada hasta que no haya más (null)
            while ((linea = lector.readLine()) != null) {
                // Dividir la línea en palabras usando espacio como delimitador
                String[] palabras = linea.split(" ");
                // Iterar sobre cada palabra
                for (String palabra : palabras) {
                    // Si la palabra es palíndroma, escribirla en el fichero de salida
                    if (esPalindroma(palabra)) {
                        escritor.write(palabra);
                        escritor.newLine();  // Añadir un salto de línea después de cada palabra
                    }
                }
            }
            
            // Cerrar los flujos para liberar recursos
            lector.close();
            escritor.close();
            
        } catch (FileNotFoundException fn) {
            System.out.println("Archivo no encontrado");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
        }
    }
    
    // Método para verificar si una palabra es palíndroma
    public static boolean esPalindroma(String palabra) {
        int i = 0;  // Índice que comienza desde el inicio de la palabra
        int j = palabra.length() - 1;  // Índice que comienza desde el final de la palabra
        
        // Mientras i sea menor que j, comparar los caracteres en los índices i y j
        while (i < j) {
            // Si los caracteres son diferentes, la palabra no es palíndroma
            if (palabra.charAt(i) != palabra.charAt(j)) {
                return false;
            }
            i++;  // Mover i hacia la derecha
            j--;  // Mover j hacia la izquierda
        }
        // Si el bucle termina sin retornar false, la palabra es palíndroma
        return true;
    }
}