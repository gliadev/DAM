package Videos;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "demodb";
        String password = "demodb";
		
		try {
			System.out.println("Conectado a la base de datos: " + url);
			
			@SuppressWarnings("unused")
			Connection myConn = DriverManager.getConnection(url, user, password);
			
			System.out.println("Conexion OK");
		} catch (Exception exc){
			exc.printStackTrace();
		}
		
				

	}

}
