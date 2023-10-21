package streamsTexto;
import java.io.*;

public class LeerFicheroTexto {

	public static void main(String[] args) throws IOException {
	
		File fichero = new File("."+ File.separator + "src" + File.separator + "streamsTexto" + File.separator + "fichero1.txt");
	    FileReader fic = new FileReader(fichero); //crear el flujo de entrada  
	        
	    int i;
	    while ((i = fic.read()) != -1) //se va leyendo un carácter hasta que lea -1
	    	System.out.print((char) i); //cast a char
	    	
	    //para leer de 20 en 20 utilizamos el metodo read pasándole el array de caracteres
	    /*	char b[] = new char [20];
	    	while ((i = fic.read(b)) != -1) 
	    		System.out.println(b);*/
	    	
	    	//System.out.println( (char) i + "==>"+ i);
	        
	    fic.close(); //cerrar fichero  

	}

}
