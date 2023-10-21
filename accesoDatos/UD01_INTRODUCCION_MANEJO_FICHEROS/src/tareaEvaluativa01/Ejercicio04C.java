package tareaEvaluativa01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

/*
 * 	Realiza un programa en Java que te permita visualizar los personajes de un tipo concreto 
 * 	(héroe o villano). El programa recibe desde la línea de comandos el tipo de personaje 
 * 	y visualiza cuantos personajes hay de dicho tipo y todos los datos de dichos personajes. 
 * 	Verifica que exista dicho tipo en el fichero, si no existe saca un mensaje de error 
 * 	por pantalla. (1,5 puntos)
	Nota: Hay que pensar que el fichero puede crecer en un futuro y aparecer nuevos tipos
 */

public class Ejercicio04C {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce un tipo de personaje: ");
        String tipoUsuario = teclado.nextLine();

        File fichero = new File("." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "Marvel.dat");
        
        try (RandomAccessFile file = new RandomAccessFile(fichero, "r")) {
            int maxLenNombre = 0, maxLenIdentidad = 0, maxLenTipo = 0, contadorPersonajes = 0;

            // Primera pasada: obtener las longitudes máximas
            while (file.getFilePointer() < file.length()) {
                file.readInt();
                file.skipBytes(9 * 2); // DNI
                maxLenNombre = Math.max(maxLenNombre, leerString(file, 10).trim().length());
                maxLenIdentidad = Math.max(maxLenIdentidad, leerString(file, 20).trim().length());
                maxLenTipo = Math.max(maxLenTipo, leerString(file, 10).trim().length());
                file.skipBytes(2 * 4); // Peso y Altura
            }

            // Reiniciar el puntero del archivo
            file.seek(0);

            // Segunda pasada: imprimir los datos
            while (file.getFilePointer() < file.length()) {
                file.readInt(); 
                String dni = leerString(file, 9);
                String nombre = leerString(file, 10);
                String identidad = leerString(file, 20);
                String tipo = leerString(file, 10);
                int peso = file.readInt();
                int altura = file.readInt();
                
                if (tipo.trim().equalsIgnoreCase(tipoUsuario.trim())) {
                    contadorPersonajes++;
                    if(contadorPersonajes == 1) {
                        System.out.println("Se han encontrado los siguientes " + tipoUsuario.trim() + "(s):");
                    }
                    String output = String.format("Personaje [dni=%-9s, nombre=%-" + maxLenNombre + "s, identidad=%-" + maxLenIdentidad + "s, tipo=%-" + maxLenTipo + "s, peso=%-3d, altura=%-3d]",
                                      dni.trim(), nombre.trim(), identidad.trim(), tipo.trim(), peso, altura);
                    System.out.println(output);
                }
            }

            if (contadorPersonajes == 0) {
                System.out.println("No existen " + tipoUsuario + "s en el fichero");
            }

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error durante la lectura de datos: " + e.getMessage());
        }
    }

    private static String leerString(RandomAccessFile file, int longitud) throws IOException {
        char[] chars = new char[longitud];
        for (int i = 0; i < longitud; i++) {
            chars[i] = file.readChar();
        }
        return new String(chars);
    }
}		