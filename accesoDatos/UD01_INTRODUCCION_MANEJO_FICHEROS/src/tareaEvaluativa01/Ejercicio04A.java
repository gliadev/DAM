package tareaEvaluativa01;
/*
* 	Realiza un programa en java para guardar datos de personajes en un fichero aleatorio,
*	dale el nombre Marvel.dat. Introduce la información de los personajes a partir de los arrays
*	que se te proporcionan en la plataforma Moodle. Cuando termine de realizar la carga de
*	datos deberá informar al usuario de que la carga se ha realizado satisfactoriamente o no.
*		Los datos por cada personaje son: (1,5 puntos)
*		Id: Numero Entero.
*		DNI: String [9].
*		Nombre: String[10].
*		Identidad secreta: String[20].
*		Tipo: String[10]
*		Peso: Numero Entero.
*		Altura: Numero Entero
 * 
 */

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio04A {

	public static void main(String[] args) {
		
		// Creo arrays para guardar la información de los personajes.
		int[] identificadores = {1, 2, 3, 4, 5, 6, 7};
		String[] documentosIdentidad = {"01010101A", "03030303C", "05050505E", "07070707G", "02020202B", "04040404D", "06060606F"};
		String[] nombresPersonajes = {"Spiderman", "Green Goblin", "Storm", "Wolverine", "Mystique", "IronMan", "Mandarin"};
		String[] identidadesSecretas = {"Peter Parker", "Norman Osborn", "Ororo Munroe","James Howlett", "Raven Darkholme", "Tony Stark", "Zhang Tong"};
		String[] tiposPersonaje = {"heroe","villano","heroe","heroe","villano","heroe","villano"};
		int[] pesosPersonajes = {76,84,66,136,78,102,70};
		int[] alturasPersonajes = {178,183,156,152,177,182,188};

		// Defino la ruta del archivo donde quiero guardar la información.
		File archivo = new File( "." + File.separator + "src" + File.separator + "tareaEvaluativa01" + File.separator + "Marvel.dat");

		// Intento abrir el archivo y escribir en él.
		try (RandomAccessFile archivoAccesoAleatorio = new RandomAccessFile(archivo, "rw")){

		    // Recorro los arrays y guardo la información de cada personaje en el archivo.
		    for (int i = 0; i < identificadores.length; i++) {
		        archivoAccesoAleatorio.writeInt(identificadores[i]);
		        escribirCadena(archivoAccesoAleatorio, documentosIdentidad[i], 9);
		        escribirCadena(archivoAccesoAleatorio, nombresPersonajes[i], 10);
		        escribirCadena(archivoAccesoAleatorio, identidadesSecretas[i], 20);
		        escribirCadena(archivoAccesoAleatorio, tiposPersonaje[i], 10);
		        archivoAccesoAleatorio.writeInt(pesosPersonajes[i]);
		        archivoAccesoAleatorio.writeInt(alturasPersonajes[i]);
		    }
		    // Si todo sale bien, muestro un mensaje positivo.
		    System.out.println("La carga de los personajes ha terminado correctamente");
		} 
		// Si algo sale mal, muestro un mensaje de error.
		catch (IOException o) {
		    System.out.println("Ha ocurrido un error durante la carga de datos: ");
		}
	}
		// Este método ayuda a escribir cadenas en el archivo de una manera controlada.
		private static void escribirCadena(RandomAccessFile archivoDestino, String cadenaAEscribir, int longitudMaximaPermitida) throws IOException {
		    StringBuffer bufferCadena = null;
		    // Si la cadena a escribir no es null, se inicializa el buffer con ella. Si es null, se inicializa un buffer vacío.
		    if (cadenaAEscribir != null) {
		        bufferCadena = new StringBuffer(cadenaAEscribir);
		    } else {
		        bufferCadena = new StringBuffer();
		    }
		    // Se ajusta la longitud del buffer para que siempre tenga la longitud máxima permitida al escribir en el archivo.
		    bufferCadena.setLength(longitudMaximaPermitida);
		    // Finalmente, se escribe la cadena en el archivo.
		    archivoDestino.writeChars(bufferCadena.toString());
	}
}


	