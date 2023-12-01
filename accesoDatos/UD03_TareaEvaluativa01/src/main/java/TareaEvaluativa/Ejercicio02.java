package TareaEvaluativa;
import java.sql.*;
import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306/dbeventos";
	        String user = "adgomez";
	        String password = "0742";
	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Ingrese el DNI del asistente a modificar:");
	        String dni = scanner.nextLine();

	        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
	            // Verificar si existe el asistente
	            String consulta = "SELECT nombre FROM asistentes WHERE dni = ?";
	            try (PreparedStatement pstmt = conexion.prepareStatement(consulta)) {
	                pstmt.setString(1, dni);
	                ResultSet resultados = pstmt.executeQuery();
	                if (resultados.next()) {
	                    // Mostrar nombre actual
	                    String nombreActual = resultados.getString("nombre");
	                    System.out.println("Nombre actual: " + nombreActual);
	                    
	                    // Pedir nuevo nombre
	                    System.out.println("Ingrese el nuevo nombre (dejar en blanco para no cambiar):");
	                    String nuevoNombre = scanner.nextLine();
	                    if (!nuevoNombre.isEmpty()) {
	                        // Actualizar nombre
	                        String update = "UPDATE asistentes SET nombre = ? WHERE dni = ?";
	                        try (PreparedStatement updateStmt = conexion.prepareStatement(update)) {
	                            updateStmt.setString(1, nuevoNombre);
	                            updateStmt.setString(2, dni);
	                            updateStmt.executeUpdate();
	                            System.out.println("Nombre actualizado con éxito.");
	                        }
	                    }
	                } else {
	                    System.out.println("Asistente no encontrado.");
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	}

}
