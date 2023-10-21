package tarea_Aprendizaje_03;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ud1TareaAprendizaje3Ejercicio2 {
		public static void main(String[] args) throws IOException {
			mostrarFicheroMod();
		
	}

		private static void mostrarFicheroMod() throws IOException {
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "cambioMayusMinus");
		FileReader fir = new FileReader (fichero);
		int i;
		char caracter = 0;
		System.out.println("Este es el fichero con las mayusculas y minusculas cambiadas:");
		while ((i=fir.read())!=-1) {
			//Leer el caracter y sobreescribir en mayus o minus
			caracter = (char)i;
	    	if(caracter>=97 && caracter<=122){
	    		caracter-=32;
	    	} else if(caracter>=65 && caracter<=90){
	    		caracter+=32;
	    	}
	    	System.out.print(caracter);
	    }
			fir.close();
	}
	}