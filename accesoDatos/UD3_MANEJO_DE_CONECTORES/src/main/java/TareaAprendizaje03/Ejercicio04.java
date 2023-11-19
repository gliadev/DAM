package TareaAprendizaje03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio04 {
	/*
	 * 4. Introduce una nueva ciudad italiana. Crea un preparedStatement y 
	 * pásale por ejemplo los siguientes valores. ("Lucca","ITA","Toscana",88397). 
	 * Si la inserción es correcta muestra por pantalla el ID de la misma.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        String url = "jdbc:mysql://localhost:3306/world";
        String user = "adgomez";
        String password = "0742";

        String consulta = "insert into city (name, countrycode, district, population) values (?,?,?,?)";
        
        try (Connection miConexion = DriverManager.getConnection(url, user, password);
             PreparedStatement prStatement = miConexion.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS)) {
            
            prStatement.setString(1, "Lucca");
            prStatement.setString(2, "ITA");
            prStatement.setString(3, "Toscana");
            prStatement.setInt(4, 88397);
            
            prStatement.executeUpdate();

            try (ResultSet rs = prStatement.getGeneratedKeys()) {
                if (rs != null && rs.next()) {
                	System.out.println("Inserccion correcta: ");
                    System.out.println("La nueva ciudad introducida tiene el id: " + rs.getInt(1));
                } else {
                    System.out.println("No se pudo obtener el ID de la nueva ciudad.");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error en la operación de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}