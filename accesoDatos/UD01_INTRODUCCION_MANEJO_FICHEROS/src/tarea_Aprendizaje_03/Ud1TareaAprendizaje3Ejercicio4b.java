package tarea_Aprendizaje_03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ud1TareaAprendizaje3Ejercicio4b {
	public static void main(String[] args) {
		
		Alumno alumno = new Alumno();
		File fichero = new File ("./FichAlumno.dat");
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
				while (true) {
				alumno= (Alumno) ois.readObject();
				 System.out.printf("Nombre: %s, Apellido: %s, Fecha de nacimiento: %s, Telefono: %d \n",
				        	alumno.getNombre(), alumno.getApellido(), alumno.getFecha_nac(), alumno.getTelefono());  
					
				 /*Otra opción para mostrar los datos con ventanas
				  * JOptionPane.showMessageDialog(null, "Nombre y apellido: "+alumno.getNombre()+" "+alumno.getApellido()+
				"\nFecha de nacimiento: "+alumno.getFecha_nac()+
				"\nTelefono: "+alumno.getTelefono());*/	 
				}
			}catch (EOFException eo) {
				System.out.println("Fin de lectura del fichero");
			}catch (IOException ex) {
				ex.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	}


}