package tareaEvaluativa01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 	Realiza un programa en Java que lea la cabecera de un fichero ZIP y comprueba si
*	realmente se trata de un fichero ZIP o no. Para que sea un ZIP válido la cabecera debe
*	comenzar con la siguiente secuencia de bytes {80, 75, 3, 4}
 * 
 */

public class Ejercicio03 {
	public static void main(String[] args) {
		
		// Definimos la firma (secuencia de bytes) que identifica a un archivo ZIP.
        byte[] firmaCabeceraZIP = {80, 75, 3, 4};
        
        // Definimos la ruta al archivo que queremos verificar usando String.
        // Utilizamos File.separator para asegurarnos de que el separador de archivo es el correcto para el sistema operativo actual.
        String archivoZIP = "." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "archivoZip.zip";
        
        try {
            // Creamos un FileInputStream que nos permitirá leer el archivo definido por archivoZIP.
            FileInputStream entradaArchivoZIP = new FileInputStream(archivoZIP);
            
            // Creamos un array de bytes para almacenar los primeros 4 bytes del archivo, 
            // que es lo que vamos a leer para verificar la firma.
            byte[] cabeceraZIP = new byte[4];
            
            // Leemos los primeros 4 bytes del archivo y los almacenamos en el array header.
            entradaArchivoZIP.read(cabeceraZIP, 0, 4);
            
            // Comparamos byte a byte si la cabecera leída (header) es igual a la firma de un archivo ZIP (firmaCabeceraZIP).
            // Si todos los bytes coinciden, se considera que el archivo es un ZIP válido.
            if (cabeceraZIP[0] == firmaCabeceraZIP[0] && 
            	cabeceraZIP[1] == firmaCabeceraZIP[1] && 
            	cabeceraZIP[2] == firmaCabeceraZIP[2] && 
            	cabeceraZIP[3] == firmaCabeceraZIP[3]) {
                
                System.out.println("El archivo es un ZIP válido.");
            } else {
                System.out.println("El archivo NO es un ZIP válido.");
            }
            
            //Cerramos la conexion
            entradaArchivoZIP.close();
        } 
        // Capturamos cualquier excepción de entrada/salida
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}
   