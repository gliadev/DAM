package TareaAprendizaje02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Ejercicio2 {
	// 2. Modifica el nombre de un departamento cuyo número (y nombre) 
	// se pase(n) como argumentos del main. No utilizar sentencias preparadas. 
	// Visualiza el número de filas afectadas.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 0;

        if (args.length < 2) {
            System.out.println("No has introducido la información en los argumentos del main");
            return; // Si no hay argumentos suficientes, salimos del método.
        }

        Integer numDep = Integer.valueOf(args[1]);
        String newName = args[0];

        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";

        // Utilizamos try-with-resources para asegurarnos que los recursos sean cerrados automáticamente
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            String sqlUpdate = "UPDATE DEPT SET DNAME = '" + newName + "' WHERE DEPTNO = " + numDep + ";";
            i = stmt.executeUpdate(sqlUpdate);

            System.out.println("El nuevo nombre del departamento " + numDep + " es: " + newName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Filas afectadas: " + i);
    }
}