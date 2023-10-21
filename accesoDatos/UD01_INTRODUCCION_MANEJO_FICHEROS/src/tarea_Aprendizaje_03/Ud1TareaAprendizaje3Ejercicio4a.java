package tarea_Aprendizaje_03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ud1TareaAprendizaje3Ejercicio4a {
	public static void main(String[] args) throws IOException {
		File fichero = new File ("./FichAlumno.dat");
		if (!fichero.exists()  && !fichero.isDirectory()) {
		//if (!fichero.isFile()) {
			fichero.createNewFile();
			System.out.println("El fichero se ha creado correctamente");
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
			List<Alumno> listaAlumnos =  new ArrayList<>();
			listaAlumnos.add(new Alumno("Mikel","Bergara",LocalDate.parse("1997-08-28"), 654789562));
			listaAlumnos.add(new Alumno("Asier","Etxebarria",LocalDate.parse("1996-03-25"), 66489565));
			for (Alumno alumno: listaAlumnos) {
				oos.writeObject(alumno);
			}
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
