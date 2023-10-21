package tarea_Aprendizaje_04;
/*
 * 1. Realiza un programa Java para guardar datos de libros, dale el nombre libros.dat.
Introduce varios libros. Los datos por cadas libro son:

Id: Numero entero.
ISBN: String.
Titulo: String.
Autor: String.
Genero: String. [Amor, Accion o Ciencia Ficcion].
Ejemplares Vendidos: Numero Entero.

Puedes encontrar los datos de los libros a introducir en el apartado de Recursos necesarios.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class GuardarLibros {

	public static void main(String[] args) {
		
		try {
			
		// array de los tados de los libros
		int [] ids= {1, 2, 3, 4, 5, 6};
        String[] isbns= {"978-6-0654-9819-8", "978-8-9523-1353-9", "978-3-2580-1238-4", "978-2-9722-8669-9", "978-6-4710-4331-9", "978-0-2782-5910-2"};
        String[] titulos= {"Harry Potter", "1984", "Yo, Robot", "Neuromante" , "American Gods", "La casa alemana"};
        String[] autores = {"JK Rowling", "George Orwell", "Isaac Asimov", "William Gibson", "Neil Gaiman", "Annette Heiss"};
        String[] generos = {"Accion", "Ciencia Ficcion", "Ciencia Ficcion", "Ciencia Ficcion", "Accion", "Accion"};
        int[] ejemplaresVendidos = {76664, 44478, 54578, 35467, 65677, 74788};
        
        // archivo .dat
        // necesito que la longitud sea fija para facilitar el acceso
        final int long_registro = 168;
        
        // conecto al fichero
        File fichero = new File("." + File.separator + "src" + File.separator + "tarea_Aprendizaje_04" + File.separator +  " libros2.dat");
        
		// voy a controlar si el fichero exite o no existe y lo borro si existe
        if (fichero.exists()) {
        	fichero.delete();
        }
         // creo un acceso ramdom al fichero para escribir y leer
        RandomAccessFile file = new RandomAccessFile(fichero, "rw");
        
        int cuantos = isbns.length;  // Número de libros
        int posicion = 0;  // Posición inicial en el archivo

        for (int i = 0; i < cuantos; i++) {
            posicion = i * long_registro;  // Calculamos la posición en el archivo
            file.seek(posicion);  // Nos posicionamos en el lugar correcto en el archivo

            // Escribimos los datos del libro en el archivo
            file.writeInt(ids[i]);  // ID del libro

            // ISBN del libro
            StringBuffer bufferIsbn = new StringBuffer(isbns[i]);
            bufferIsbn.setLength(20);  // Aseguramos que la longitud sea 20 caracteres
            file.writeChars(bufferIsbn.toString());

            // Título del libro
            StringBuffer bufferTit = new StringBuffer(titulos[i]);
            bufferTit.setLength(20);  // Aseguramos que la longitud sea 20 caracteres
            file.writeChars(bufferTit.toString());

            // Autor del libro
            StringBuffer bufferAut = new StringBuffer(autores[i]);
            bufferAut.setLength(20);  // Aseguramos que la longitud sea 20 caracteres
            file.writeChars(bufferAut.toString());

            // Género del libro
            StringBuffer bufferGen = new StringBuffer(generos[i]);
            bufferGen.setLength(20);  // Aseguramos que la longitud sea 20 caracteres
            file.writeChars(bufferGen.toString());

            // Número de ejemplares vendidos del libro
            file.writeInt(ejemplaresVendidos[i]);
        }

        // Cerramos el archivo
        file.close();
        System.out.println("Se han cargado los libros");
    
        // Capturamos y mostramos cualquier excepción de I/O que pueda ocurrir
		} catch (IOException e){ 
			e.printStackTrace();
		  }

	}
}	
