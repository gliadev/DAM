package TareaAprendizaje03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio02 {
	/*
	 * 2. Visualiza el nombre de los países del continente que introduzcamos por consola 
	 * de la tabla country. Utiliza un PreparedStatement.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String databaseUrl = "jdbc:mysql://localhost:3306/world";
        String databaseUser = "adgomez";
        String databasePassword = "0742";
        String query = "SELECT Name FROM country WHERE Continent = ?";

        // Usando try-with-resources para el manejo automático de recursos
        try (Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Creando un objeto Scanner para leer desde la consola
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el nombre del continente EN INGLÉS:");
            String continentName = scanner.nextLine();

            // Estableciendo el parámetro de la consulta
            preparedStatement.setString(1, continentName);

            // Ejecutando la consulta y procesando los resultados
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String countryName = resultSet.getString("Name");
                    System.out.println(countryName);
                }
            }
            scanner.close();

        } catch (SQLException e) {
            // Imprimiendo el rastreo de la pila de excepciones para un diagnóstico detallado
            e.printStackTrace();
        }
    }
}

