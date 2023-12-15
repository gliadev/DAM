package TareaAprendizaje03;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejercicio5 {
	/*
	 * 5. Crea un procedimiento almacenado en MySQL llamado actu_pobla al que se le pasarán 
	 * como parámetros: el código de páis, un porcentaje (entero) y un parámetro de salida 
	 * llamado filas (entero). El procedimiento deberá actualizar la población de todas 
	 * las ciudades de ese determinado país en el porcentaje indicado.
	 *	Por ejemplo, si a la función le pasamos ALB,2 actulizará todas las ciudades de 
	 *	Albania (Tirana en este caso) sumándole un 2% a su población). 
	 *	El programa utilizará la variable filas de salida para recibir y mostrar 
	 *	en pantalla cuantas filas han sido modificadas con el update.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		   	String url = "jdbc:mysql://localhost:3306/world";
	        String user = "adgomez";
	        String password = "0742";
	        String procedureCall = "{call actu_pobla(?,?,?)}";

	        try (Connection connection = DriverManager.getConnection(url, user, password);
	             CallableStatement callableStatement = connection.prepareCall(procedureCall)) {
	            
	            callableStatement.setString(1, "ALB");
	            callableStatement.setInt(2, 2);
	            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

	            callableStatement.execute();

	            int rowsUpdated = callableStatement.getInt(3);
	            System.out.println("Se han actualizado " + rowsUpdated + " filas");

	        } catch (SQLException e) {
	            System.err.println("Error en la operación de base de datos: " + e.getMessage());
	        } catch (Exception e) {
	            System.err.println("Error general: " + e.getMessage());
	        }
	    }
	}