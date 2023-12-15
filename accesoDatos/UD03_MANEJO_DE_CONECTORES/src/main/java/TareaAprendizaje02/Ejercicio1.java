package TareaAprendizaje02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Ejercicio1 {
	//1. Visualiza el nombre y el número de todos los departamentos.

	public static void main(String[] args) {
		
		 // Propiedades de conexión a la base de datos ya le tengo configurado
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";

        // Inicia el trabajo con la base de datos
        try (
            // Establece la conexión con la base de datos
            Connection conexion = DriverManager.getConnection(url, user, password);
        ){
            // Mensaje  conexión ha sido exitosa
            System.out.println("La conexión con la base de datos ha sido establecida.");

            // Crea un Statement para ejecutar SQL
            Statement stmt = conexion.createStatement();
            // Ejecuta la consulta SQL para obtener datos de departamentos
            ResultSet rs = stmt.executeQuery("select deptno, dname from DEPT");

            // Mientras haya filas en el resultado, obtener y mostrar los datos
            while(rs.next()){
                int numDept = rs.getInt("deptno"); // Obtiene el número de departamento
                String nombre = rs.getString("dname"); // Obtiene el nombre del departamento
                System.out.println("Departamento: " + numDept + ". Nombre: " + nombre);
            }
        } catch(SQLException e) {
            // Maneja cualquier error SQL que pueda ocurrir
            e.printStackTrace();
        }
    }
}
