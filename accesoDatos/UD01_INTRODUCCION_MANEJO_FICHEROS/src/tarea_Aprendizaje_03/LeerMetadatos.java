package tarea_Aprendizaje_03;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

// Realiza un programa en Java que utilizando la clase FileInputStream para leer los metadatos 
// de un fichero PNG obtenga su anchura y su altura. Puedes encontrar información sobre la 
// estructura de los fichero PNG en el siguiente enlace. En primer lugar, 
// leyendo la cabecera del fichero nos aseguraremos de que se trata de un fichero PNG. 
// Si es así leeremos y devolveremos los bytes para obtener la anchura (width) y altura 
// (height).

public class LeerMetadatos {

	public static void main(String[] args) {
		
		// ubicacion del archivo
		File archivoPNG = new File("." + File.separator + "src" + File.separator + "tarea_Aprendizaje_03" + File.separator + "imagen.png" );
		
		// Firma de un archivo PNG en formato decimal
		 int[] firmaPNG = { 137, 80, 78, 71, 13, 10, 26, 10 };
		 
		// Firma de la cabecera IHDR en formato decimal   
		 byte[] cabeceraIHDR = { 73, 72, 68, 82 }; 
		 
		// Abrir un flujo de entrada para leer el archivo PNG, utilizando un bloque try-with-resources
		// para asegurarse de que el flujo se cierre de forma automática cuando termine su uso.
		 
		 try (InputStream entrada = new FileInputStream(archivoPNG);){
			 
			// Crea un array para almacenar los primeros 8 bytes del archivo PNG,
			// que representan su cabecera. Estos bytes se utilizarán para verificar si
			// el archivo es un PNG válido antes de continuar con la extracción de metadatos.
			int[] cabeceraPNG = new int[8];
			
			// Leer los primeros 8 enteros decimales como cabecera del archivo PNG
			for ( int i = 0; i < 8; i++) {
				cabeceraPNG[i] = entrada.read(); 
			}
			
			 // Verificar si la cabecera leída coincide con la firma de un archivo PNG válido
			if (!Arrays.equals(cabeceraPNG, firmaPNG)) {
				System.out.println("El archivo no es un PNG válido");
                System.exit(-1); // metodo exit
			}
			// Saltar los siguientes 4 bytes relativos a la longitud (Length)
			entrada.skip(4);
			
            // Leer los 4 bytes de la cabecera IHDR
			byte[] bytesCabeceraIHDR = new byte[4];
			entrada.read(bytesCabeceraIHDR);
			
			// Verificar si la cabecera IHDR leída coincide con la firma de la cabecera IHDR válida
            if (!Arrays.equals(bytesCabeceraIHDR, cabeceraIHDR)) {
                System.out.println("La cabecera IHDR no es válida");
                System.exit(-1);
            }
            
         // Leer los siguientes 4 bytes para obtener la anchura (width) del archivo PNG
            byte[] bytesAnchura = new byte[4];
            entrada.read(bytesAnchura);
            ByteBuffer bufferAnchura = ByteBuffer.wrap(bytesAnchura);
            int anchura = bufferAnchura.getInt();

            

            // Leer los siguientes 4 bytes para obtener la altura (height) del archivo PNG
            byte[] bytesAltura = new byte[4];
            entrada.read(bytesAltura);
            BigInteger valorAltura = new BigInteger(bytesAltura);
            int altura = valorAltura.intValue();
            
            
            System.out.println("El archivo: " + archivoPNG.getName()+ " tiene estas medidas.");
            System.out.println("Altura = " + altura + " píxeles");
            System.out.println("Anchura = " + anchura + " píxeles");

			 
		 } catch (IOException e ) {
			 e.printStackTrace();
		 }
		 
		 

	}

}
