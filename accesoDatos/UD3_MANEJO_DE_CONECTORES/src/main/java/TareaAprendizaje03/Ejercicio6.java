package TareaAprendizaje03;

import java.sql.*;

public class Ejercicio6 {
	/*
	 * 6. Crea un programa que ejecute una consulta y la guarde en un ResultSet actualizable.
	 *  La consulta puede ser por ejemplo: 
	 *  Selecciona todos los campos de la tabla city donde el país sea 'ESP' 
	 *  ordenados por población. 
	 *  Modifica la población de la última y penúltima ciudad y saca 
	 *  un mensaje con la ciudad que se ha actulizad 
	 */

    private static final String DB_URL = "jdbc:mysql://localhost:3306/world";
    private static final String DB_USER = "adgomez";
    private static final String DB_PASS = "0742";
    private static final String QUERY = "select * from world.city where CountryCode ='ESP' order by population;";

    public static void main(String[] args) {
    	
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = statement.executeQuery(QUERY)) {

            // Actualiza la población de la última ciudad
            rs.last();
            rs.updateInt("Population", 3223335);
            rs.updateRow();
            System.out.println("Se ha actualizado correctamente la población de " + rs.getString("Name"));

            // Actualiza la población de la penúltima ciudad
            rs.previous();
            rs.updateInt("Population", 1620344);
            rs.updateRow();
            System.out.println("Se ha actualizado correctamente la población de " + rs.getString("Name"));

        } catch (SQLException e) {
            System.err.println("Error en la operación de base de datos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}