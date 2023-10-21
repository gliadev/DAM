package streamsTexto;
import java.io.*;

public class EscribirFicheroTexto {
	public static void main(String[] args) throws IOException {
		   
			
		   File fichero = new File("G:\\GITHUB\\DAM\\accesoDatos\\UD01_INTRODUCCION_MANEJO_FICHEROS\\src\\streamsTexto\\fichtexto.txt");//declara fichero          
		   FileWriter fic = new FileWriter(fichero); //crea el flujo de salida.     
		   String cadena ="Esto es una prueba con FileWriter";
		   char [] cad = cadena.toCharArray();//convierte un String en array de caracteres
			
		   for(int i=0; i<cad.length; i++)
			   fic.write(cad[i]);  //escribe un carácter
		   fic.append('*'); //añade al final un *   
		   
		   
		   fic.write("\n");
		   fic.write(cad);//escribe un array de caracteres   
		   String c="\n*esto es lo ultimo*";
		   fic.write(c);//escribe un String   
		   
		   
		   String prov[] = {"Albacete","Avila","Badajoz"};//escribe un array de Strings
		   fic.write("\n");
		   for(int i=0; i<prov.length; i++) {
			      fic.write(prov[i]);
			      fic.write("\n");
		   }
		      
		   fic.close();    //cierra fichero
		   System.out.println("Provincias agregadas al fichero de texto");
		   
		  }

}
