package tareaEvaluativa01;
/*
 * 	Desde la editorial quieren tener controlado el peso de sus personajes, ya que
*	últimamente han hecho algún exceso que otro. Realiza un programa en java que te permita
*	modificar los datos de un personaje. El programa recibe desde la línea de comandos el dni
*	y el peso del último mes. Si el personaje no existe devolverá un mensaje de error, sino
*	mostrará en la consola el nombre del personaje y cuantos kilos ha engordado, adelgazado
*	o si se mantiene en su peso
 * 
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio04B {

	public static void main(String[] args) {
       
		
		// Creamos la ruta al archivo donde están guardados nuestros personajes.
        File fichero = new File("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "Marvel.dat");
		
		// Utilizamos try-with-resources para gestionar nuestro archivo, 
        // así nos aseguramos de que se cierra correctamente al terminar.
        try (RandomAccessFile file = new RandomAccessFile(fichero, "r")) {
        	
        	 // Con la clase Scanner para leer lo que introduzca el usuario
    		Scanner teclado = new Scanner(System.in);
    		
    		// pido al usuario el DNI
    		System.out.println("Introduzca el DNI (con letra) del personaje para el control de peso");
    		String dniUsuario = teclado.next();
    		
    		// pido al usuario el peso
    		System.out.println("Introduzca su peso actual: ");
    		int pesoActual = teclado.nextInt();
            
            // Vamos a utilizar una variable para guardar si hemos encontrado al personaje
            boolean personajeEncontrado = false;
            
            // Recorremos nuestro archivo de personajes.
            while (file.getFilePointer() < file.length()) {
                
                // Leemos los datos del personaje.
                int id = file.readInt();
                String dni = leerString(file, 9);
                String nombre = leerString(file, 10);
                String identidadSecreta = leerString(file, 20);
                String tipo = leerString(file, 10);
                int peso = file.readInt();
                int altura = file.readInt();

                // Comprobamos si el DNI del personaje coincide con la entrada del usuario.
                if (dni.trim().equals(dniUsuario.trim())) {
                    personajeEncontrado = true;

                    // Comparamos el peso y proporcionamos el feedback correspondiente.
                    if (peso == pesoActual) {
                        System.out.println(nombre.trim() + " se mantiene en su peso");
                    } else if (peso < pesoActual) {
                        System.out.println(nombre.trim() + " ha engordado " + (pesoActual - peso) + " Kilos");
                    } else {
                        System.out.println(nombre.trim() + " ha adelgazado " + (peso - pesoActual) + " Kilos");
                    }

                    // Salimos del bucle, ya que hemos encontrado al personaje
                    break;
                }
            }
           // teclado.close();

            // Si no encontramos al personaje, mostramos un mensaje de error.
            if (!personajeEncontrado) {
                System.out.println("Error: No se ha encontrado a un personaje con el DNI proporcionado.");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error durante la lectura de datos: " + e.getMessage());
        }
    }

    // Este método lee una cadena del archivo y asegura que se retorne en un formato manejable, 
    // incluso si hay algún problema con los datos guardados en el archivo.
    private static String leerString(RandomAccessFile file, int longitud) throws IOException {
        char[] chars = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars);
    }
}
