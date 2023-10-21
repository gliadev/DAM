package tarea_Aprendizaje_03;
// Crea un programa en Java que lea un fichero de caracteres 
// y pida por teclado qué vocal se quiere contar en el fichero. 
// SEl programa devolverá el número de veces que se repite esa vocal.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Ud1TareaAprendizaje3Ejercicio3 {
	
	public static void main(String[] args) throws IOException {
		String voc = JOptionPane.showInputDialog("Introduce la vocal que quieres contar en el fichero:");
		char vocal = voc.charAt(0);
		File fichero = new File ("."+ File.separator + "src" + File.separator + "ejercicios" + File.separator + "cambioMayusMinus");
		BufferedReader bfr = new BufferedReader(new FileReader (fichero));
		String linea;
		int contador = 0;
		while ((linea = bfr.readLine()) != null) {
			System.out.println(linea);
			contador += counterVowelsPerLine(linea, vocal);
		}
		System.out.println("El fichero tiene "+contador+" vocal/es");
		bfr.close();
	}
	
	public static int counterVowelsPerLine(String line, char vowel){
		  int counter=0;
		  char [] charsLine=line.toCharArray();
		  for(int i=0;i<charsLine.length;i++){
		      if(charsLine[i] == vowel){//comparación
		        counter++;
		      }
		  }            
		 
		  return counter;
		}

}
