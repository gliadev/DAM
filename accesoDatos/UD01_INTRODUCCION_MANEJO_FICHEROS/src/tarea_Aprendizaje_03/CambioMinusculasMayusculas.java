package tarea_Aprendizaje_03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//  Realiza un programa en Java que cambie el texto de un fichero y devuelva el contenido 
// por consola con las mayúsculas y minúsculas cambiadas. Utiliza FileReader y lee caracter a caracter.
public class CambioMinusculasMayusculas {

	public static void main(String[] args) {
		
		// ruta para accerder al archivo
		File archivo = new File("src" + File.separator + "tarea_Aprendizaje_03" + File.separator + "cambioMinusculasMayusculas.txt");

		

		// conecto al archivo para utilizarlo
		try {
			
			// creo un objeto para leer el fichero
			FileReader fileReader = new FileReader(archivo);
			
			// leo el primer caracter 
			int charInt = fileReader.read();
			
			// mientras no llegue al final del archivo -1
			while (charInt != -1) {
				// conbierto el numero a caracter cast
				char charRead = (char) charInt;
				
				// Si es minúscula, la convertimos a mayúscula. Si es mayúscula, a minúscula.
                if (Character.isLowerCase(charRead)) {
                    System.out.print(Character.toUpperCase(charRead));
                } else {
                    System.out.print(Character.toLowerCase(charRead));
                }
                
                // Leemos el siguiente carácter.
                charInt = fileReader.read();
            }
            
            // Cerramos el  fichero.
            fileReader.close();
        } catch (IOException e) {
            // Si algo va mal (por ejemplo, el fichero no existe), mostramos un mensaje de error.
            e.printStackTrace();
        }
    }
}


