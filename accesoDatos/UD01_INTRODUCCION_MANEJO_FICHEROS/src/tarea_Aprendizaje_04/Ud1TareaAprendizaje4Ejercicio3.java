package tarea_Aprendizaje_04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ud1TareaAprendizaje4Ejercicio3 {
	public static void main(String[] args) throws IOException {
		final int long_registro = 168; //Longitud del registro 
		try	{
			File fichero = new File("."+ File.separator + "src" + File.separator + "tarea_Aprendizaje_04" + File.separator + "libros.dat");
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");

			String isbnFichero, tituloFichero, autorFichero, generoConsola, generoFichero;
			Boolean existeGenero = false;
			int ejemplaresFichero;
			
			System.out.println("Introduce el g�nero:");
			generoConsola = Consola.readString();
			for(int p=0;p<file.length();p+=long_registro){
				file.seek(p);
				file.skipBytes(124);
				char[] auxGenero =new char[20];
				for(int i=0;i<20;i++)
				{
					auxGenero[i]=file.readChar();
				}
				generoFichero = new String(auxGenero);
				if(generoFichero.trim().equalsIgnoreCase(generoConsola)){
					existeGenero = true;
					file.seek(p);
					file.skipBytes(4);//Salto el c�digo
					//Recojo el ISBN
					char[] auxIsbn =new char[20];
					for(int i=0;i<20;i++)
					{
						auxIsbn[i]=file.readChar();
					}
					isbnFichero = new String(auxIsbn).trim();
					
					//Recojo el titulo
					char[] auxTitulo =new char[20];
					for(int i=0;i<20;i++)
					{
						auxTitulo[i]=file.readChar();
					}
					tituloFichero = new String(auxTitulo).trim();
					//Recojo el autor
					char[] auxAutor =new char[20];
					for(int i=0;i<20;i++)
					{
						auxAutor[i]=file.readChar();
					}
					autorFichero = new String(auxAutor).trim();
					
					file.skipBytes(40);//Salto el g�nero porque ya lo tengo
					ejemplaresFichero= file.readInt();
										
					System.out.println("\tT�tulo: "+isbnFichero);
					System.out.println("\tT�tulo: "+tituloFichero);
					System.out.println("\tAutor: "+autorFichero);
					System.out.println("\tG�nero: "+generoFichero);
					System.out.println("\tEjemplares vendidos: "+ejemplaresFichero);
					System.out.println();
				}
			}
			if(!existeGenero)
				System.out.println("El g�nero introducido no existe.");
			file.close();
		}
		catch (FileNotFoundException e){}
	}
}
