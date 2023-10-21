package tarea_Aprendizaje_04;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Realiza un programa java que te permita modificar los datos de un libro. 
 * El programa recibe desde la línea de comandos el ID del libro y la cantidad de libros 
 * vendidos este mes. Si el libro no existe devolverá un mensaje de error, 
 * sino sumara la cantidad de libros vendidos. Visualiza el isbn del libro 
 * y el dato antiguo y nuevo de los libros vendidos.
 * 
 */

public class ModificarLibros {
	public static void main(String[] args) {
		try {
            // Verificar si se proporcionaron ambos argumentos (ID del libro y libros vendidos este mes)
            if (args.length != 2) {
                System.out.println("Uso: java ModificarLibros <ID del libro> <Libros vendidos este mes>");
                return;
            }

            // Convertir los argumentos de la línea de comandos a valores enteros
            int idLibro = Integer.parseInt(args[0]);
            int librosVendidosEsteMes = Integer.parseInt(args[1]);

            // Ruta del archivo donde se almacenan los datos de los libros
            File fichero = new File("." + File.separator + "src" + File.separator + "tarea_Aprendizaje_04" + File.separator + "libros2.dat");

            // Verificar si el archivo existe, si no, mostrar un mensaje de error
            if (!fichero.exists()) {
                System.out.println("El archivo libros2.dat no existe. Por favor, ejecute el programa anterior para crear el archivo.");
                return;
            }

            // Abrir el archivo para lectura y escritura
            RandomAccessFile file = new RandomAccessFile(fichero, "rw");

            // Calcular la posición en el archivo basada en el ID del libro
            final int long_registro = 168;  // Longitud del registro
            int posicion = (idLibro - 1) * long_registro;

            // Verificar si la posición calculada está dentro del tamaño del archivo
            if (posicion >= file.length()) {
                System.out.println("El libro no existe.");
                return;
            }

            // Posicionarse en el lugar correcto en el archivo y leer el ID del libro
            file.seek(posicion);
            int idFichero = file.readInt();

            // Verificar si el ID del libro leído coincide con el ID del libro proporcionado
            if (idFichero != idLibro) {
                System.out.println("El libro no existe.");
                return;
            }

            // Saltar los datos no necesarios y llegar al número de ejemplares vendidos
            file.skipBytes(120);
            int ejemplaresVendidosAnterior = file.readInt();

            // Calcular el nuevo total de ejemplares vendidos
            int ejemplaresVendidosTotal = ejemplaresVendidosAnterior + librosVendidosEsteMes;

            // Posicionarse en el lugar correcto en el archivo y actualizar el número de ejemplares vendidos
            file.seek(posicion + 164);
            file.writeInt(ejemplaresVendidosTotal);

            // Volver al inicio del registro del libro y leer el ISBN
            file.seek(posicion + 4);  // Saltar el ID del libro
            char[] isbnChars = new char[20];
            for (int i = 0; i < 20; i++) {
                isbnChars[i] = file.readChar();
            }
            String isbn = new String(isbnChars).trim();

            // Mostrar la información del libro y los ejemplares vendidos
            System.out.println("ISBN del libro: " + isbn);
            System.out.println("Número de ejemplares anterior: " + ejemplaresVendidosAnterior);
            System.out.println("Nuevo número de ejemplares: " + ejemplaresVendidosTotal);

            // Cerrar el archivo
            file.close();

        } catch (NumberFormatException e) {
            // Manejar la excepción si los argumentos no son números válidos
            System.out.println("Por favor, ingrese valores numéricos válidos para el ID del libro y los libros vendidos este mes.");
        } catch (IOException e) {
            // Manejar cualquier otra excepción de I/O
            e.printStackTrace();
        }
    }
}