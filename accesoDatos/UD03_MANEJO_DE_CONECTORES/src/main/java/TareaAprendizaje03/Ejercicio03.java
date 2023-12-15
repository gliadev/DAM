package TareaAprendizaje03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejercicio03 {
	/*
	 * 3. Actualiza la población de un país. 
	 * Nos pedirá por consola el código del país y la nueva cifra de población. 
	 * Por ejemplo actualiza la población de Austria (code AUT) a  8822000.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/world";
        String user = "adgomez";
        String password = "0742";
        Scanner scanner = new Scanner(System.in);

        try (Connection miConexion = DriverManager.getConnection(url, user, password)) {
            String updateQuery = "UPDATE country SET population = ? WHERE code = ?";
            try (PreparedStatement prStatement = miConexion.prepareStatement(updateQuery)) {

                System.out.println("Introduce el código del país para actualizar sus habitantes:");
                String countryCode = scanner.nextLine();
                System.out.println("Introduce el nuevo número de habitantes:");
                int population = scanner.nextInt(); // Lee el siguiente entero

                prStatement.setInt(1, population);
                prStatement.setString(2, countryCode);

                int result = prStatement.executeUpdate();

                if (result > 0) {
                    String selectQuery = "SELECT name FROM country WHERE code = ?";
                    try (PreparedStatement prStatement2 = miConexion.prepareStatement(selectQuery)) {
                        prStatement2.setString(1, countryCode);
                        try (ResultSet miResultSet = prStatement2.executeQuery()) {
                            if (miResultSet.next()) {
                                String countryName = miResultSet.getString("name");
                                System.out.println("Se ha modificado correctamente la población de " + countryName);
                            }
                        }
                    }
                } else {
                    System.out.println("El código introducido no es correcto o no hay cambios en la población.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close(); // Cierra el scanner al finalizar
        }
    }
}
