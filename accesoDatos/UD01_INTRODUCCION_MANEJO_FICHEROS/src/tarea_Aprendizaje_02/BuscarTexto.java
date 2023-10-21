package tarea_Aprendizaje_02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// Crea un programa Java que busque un texto dado en un fichero de texto, 
// y que muestre para cada aparición la línea y la columna. 
// Se recomienda leer el fichero línea por línea con el método readline() y, 
// dentro de cada línea, buscar las apariciones del texto utilizando un método 
// apropiado de la clase String, por ejemplo indexOf(). Se puede consultar la documentación 
// de dicha clase en la API de Java. Para leer del teclado nos vendrá bien realizar 
// una clase Consola donde leeremos distintos tipos de datos. 

public class BuscarTexto {

	public static void main(String[] args) {
		

        try {
            // abro el archivo para la lectura
            BufferedReader reader = new BufferedReader(
                    new FileReader("G:\\GITHUB\\DAM\\accesoDatos\\UD01_INTRODUCCION_MANEJO_FICHEROS\\src\\tarea_Aprendizaje_02\\texto.txt"));

            // activo Scanner para la entrada por consola del texto a buscar
            Scanner busqueda = new Scanner(System.in);
            System.out.println("¿Qué texto quieres buscar?");

            // le pido al usuario por consola el texto a buscar
            String textoBuscar = busqueda.nextLine();

            // Guardo la línea leída
            String linea;

            // número de posición de la línea
            int posicionLinea = 1;

            // si no encuentra el texto
            boolean seEncontro = false;

            // voy leyendo las líneas y las guardo en linea
            while ((linea = reader.readLine()) != null) {
                int columna = linea.indexOf(textoBuscar);

                if (columna != -1) {
                    // imprimo donde está la cadena
                	System.out.printf("Coincidencia encontrada en la línea %d, posición %d:%n", posicionLinea, columna);
                	System.out.println(linea);
                	System.out.println(); // Línea en blanco para separar las coincidencias

                    // Marcamos que se encontró al menos una coincidencia
                    seEncontro = true;
                }
                // si no lo encuentra suma una línea
                posicionLinea++;
            }

            // Cerrar todas las conexiones después de terminar de leer y buscar
            reader.close();
            busqueda.close();

            // Comprobar si no se encontró ninguna coincidencia
            if (!seEncontro) {
                System.out.println("Texto no encontrado");
            }
            System.out.println("Fin del programa");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
