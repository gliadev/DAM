package tarea_Aprendizaje_04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ud1TareaAprendizaje4Ejercicio1 {
	public static void main(String[] args) throws IOException { 
		final int long_registro = 168; //Longitud del registro 
		File fichero = new File("."+ File.separator + "src" + File.separator + "tarea_Aprendizaje_04" + File.separator + "libros.dat");
		if(fichero.exists()){
			fichero.delete();
		}
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");
		 //Arrays con los datos de los libros
		int [] ids= {1, 2, 3, 4, 5, 6};
		String[] isbns= {"978-6-0654-9819-8", "978-8-9523-1353-9", "978-3-2580-1238-4", "978-2-9722-8669-9", "978-6-4710-4331-9", "978-0-2782-5910-2"};
		String[] titulos= {"Harry Potter", "1984", "Yo, Robot", "Neuromante" , "American Gods", "La camana"};
		String[] autores = {"JK Rowling", "George Orwell", "Isaac Asimov", "William Gibson", "Neil Gaiman", "Annette Heiss"};
		String[] generos = {"Accion", "Ciencia Ficcion", "Ciencia Ficcion", "Ciencia Ficcion", "Accion", "Accion"};
		int[] ejemplaresVendidos = {76664, 44478, 54578, 35467, 65677, 74788};

		StringBuffer bufferIsbn = null;
		StringBuffer bufferTit = null;
		StringBuffer bufferAut = null;
		StringBuffer bufferGen = null;
		int cuantos=isbns.length;
		int posicion = 0;
				
		for (int i=0;i<cuantos; i++){
			posicion=i*long_registro;
			file.seek(posicion);
			
			 //System.out.println("Insertando libro: "+ titulos[i] " );
			file.writeInt(ids[i]);
			
			bufferIsbn = new StringBuffer( isbns[i] );      //ISBN
			bufferIsbn.setLength(20); 
			file.writeChars(bufferIsbn.toString());
			
			bufferTit = new StringBuffer( titulos[i] );      //Titulo
			bufferTit.setLength(20); 
			file.writeChars(bufferTit.toString());
			
			bufferAut = new StringBuffer( autores[i] );      //Autor
			bufferAut.setLength(20); 
			file.writeChars(bufferAut.toString());
			
			bufferGen = new StringBuffer( generos[i] );      //Genero
			bufferGen.setLength(20); 
			file.writeChars(bufferGen.toString());
			
			file.writeInt(ejemplaresVendidos[i]);
		 }     
		file.close();
		System.out.println("La carga de los libros ha terminado correctamente.");			
	 }
}
