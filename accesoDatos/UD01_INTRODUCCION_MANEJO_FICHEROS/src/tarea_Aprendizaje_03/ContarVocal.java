package tarea_Aprendizaje_03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// Crea un programa en Java que lea un fichero de caracteres y 
// pida por teclado qué vocal se quiere contar en el fichero. 
// El programa devolverá el número de veces que se repite esa vocal.

import javax.swing.JOptionPane;


public class ContarVocal {
	public static void main(String[] args) {
	      // Solicitar al usuario que introduzca una vocal a buscar.
        String vocalUsuario = JOptionPane.showInputDialog("¿Qué vocal quieres buscar?");
        
        // Validar que la entrada del usuario sea una única vocal.
        if (vocalUsuario == null || vocalUsuario.length() != 1 || "aeiouAEIOU".indexOf(vocalUsuario.charAt(0)) == -1) {
            JOptionPane.showConfirmDialog(null, "No has introducido una única vocal.");
            return; // Terminar programa si la entrada no es válida.
        }
        
        // Convertir la entrada del usuario (String) a un carácter (char) para la comparación.
        char vocalElegida = vocalUsuario.charAt(0);
        
        // Definir la ruta del archivo y crear un objeto File.
        File ficheroLeer = new File("src" + File.separator + "tarea_Aprendizaje_03" + File.separator + "caracteres.txt");
        
        try (BufferedReader buffer = new BufferedReader(new FileReader(ficheroLeer))) {
            // Inicializar el contador de vocales y una variable para almacenar cada línea del archivo.
            int contador = 0;
            String linea;
            
            // Leer el archivo línea por línea.
            while((linea = buffer.readLine()) != null ) {
                // Aumentar el contador por la cantidad de vocales encontradas en la línea actual.
                contador += contarVocales(linea, vocalElegida);
            }
            
            // Mostrar el resultado al usuario.
            JOptionPane.showMessageDialog(null, "La vocal " + vocalElegida + " aparece " + contador + " veces en el fichero.");
            
        } catch (IOException e) {
            // Manejar posibles excepciones al leer el archivo y mostrar un mensaje de error al usuario.
            JOptionPane.showConfirmDialog(null,"Error: " + e.getMessage());
        }
    }
    
    // Método para contar la cantidad de veces que aparece una vocal específica en una línea de texto.
    public static int contarVocales(String linea, char vocal) {
        int contador = 0;
        
        // Convertir la línea a un array de caracteres y recorrer cada carácter.
        for (char caracter : linea.toCharArray()) {
            // Si el carácter actual es la vocal que estamos buscando, aumentar el contador.
            if (caracter == vocal) {
                contador++;
            }
        }
        // Devolver el total de vocales encontradas en la línea.
        return contador;
    }
}
	
		
		


