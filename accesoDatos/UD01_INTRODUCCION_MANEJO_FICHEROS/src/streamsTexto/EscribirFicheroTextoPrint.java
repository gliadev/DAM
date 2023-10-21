package streamsTexto;
import java.io.*;

public class EscribirFicheroTextoPrint {
	  public static void main(String[] args) {
		  try(PrintWriter fichero = new PrintWriter (new FileWriter("."+ File.separator + "src" + File.separator + "streamsTexto" + File.separator + "fichtexto2.txt"))){
			  for (int i=1; i<11; i++)
			    fichero.println("Fila numero: "+i); //escribe una línea
			  System.out.println("Tarea Realiza con exito");
		  }
		  
		  	catch (FileNotFoundException fn ){                      
		               System.out.println("No se encuentra el fichero");}
			catch (IOException io) {
		               System.out.println("Error de E/S ");}
		  }
	  	
		}

