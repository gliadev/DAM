package TareaAprendizaje03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ejercicio01 {
	/*
	 * 1. Visualiza todos los nombres de los paises de la tabla country. 
	 * Utiliza un Statement y visualiza los resultados recorriendo un ResultSet
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 	String url = "jdbc:mysql://localhost:3306/world";
	        String user = "adgomez";
	        String password = "0742";

	        // Utilizando try-with-resources para asegurar el cierre de recursos
	        try (Connection miConexion = DriverManager.getConnection(url, user, password);
	             Statement miStatement = miConexion.createStatement();
	             ResultSet miResultSet = miStatement.executeQuery("Select * from country")) {

	            while (miResultSet.next()) {
	                System.out.println(miResultSet.getString(2));
	            }
	        } catch (Exception e) {
	            System.err.println("Error de conexion: " + e.getMessage());
	        }
	    }
	}