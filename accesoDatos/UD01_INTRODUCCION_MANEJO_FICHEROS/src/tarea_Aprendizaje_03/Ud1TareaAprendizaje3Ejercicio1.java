package tarea_Aprendizaje_03;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Este programa utiliza la clase FileInputStream para leer los
 * metadatos de un fichero PNG y obtener su anchura y altura.
 * http://www.libpng.org/pub/png/spec/1.2/PNG-Structure.html
 * @author www.birt.eus 
 */
public class Ud1TareaAprendizaje3Ejercicio1 {
 
    public static void main(String[] args) {
    	File inputFile = new File ("."+ File.separator + "src" + File.separator + "tarea_Aprendizaje_03" + File.separator + "imagen.png");
 
        int[] pngSignature = {137, 80, 78, 71, 13, 10, 26, 10}; //cabecera de PNG en decimal
        byte[] ihdrSignature = {73, 72, 68, 82};
 
        try (
            InputStream inputStream = new FileInputStream(inputFile);
        ) {
            int[] pngHeader = new int[8];
 
            // lee los 8 primeros enteros decimales como cabecera de PNG
            for (int i = 0; i < 8; i++) {
                pngHeader[i] = inputStream.read();
            }
 
            if (!Arrays.equals(pngHeader, pngSignature)) {
            	System.out.println("No es un fichero PNG");
                System.exit(-1);
            }
 
            // saltamos los siguientes 4 bytes relativos a la logintud  (Length)
            inputStream.skip(4);
 
            // leemos los 4 bytes de la cabecera IHDR
            byte[] ihdrHeader = new byte[4];
            inputStream.read(ihdrHeader);
 
            if (!Arrays.equals(ihdrHeader, ihdrSignature)) {
                System.out.println("La cabecera IHDR no es v lida");
                System.exit(-1);
            }
 
            // lee los siguientes 4 bytes para obtener anchura (width) 
            byte[] bytes = new byte[4];
            inputStream.read(bytes);
            ByteBuffer wrapped = ByteBuffer.wrap(bytes);
            int width = wrapped.getInt();
 
            System.out.println("Width = " + width);
 
            // lee los siguientes 4 bytes para obtener altura (height) 
            // dos formas diferentes de obtener int desde un array de bytes
            inputStream.read(bytes);
            int height = new BigInteger(bytes).intValue();
 
            System.out.println("Height = " + height);
 
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
