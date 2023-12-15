package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Aplicaction {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try ( Connection connection = DriverManager.getConnection("jdbc:h2:mem:")){
			System.out.print("connection.isValid(0)= " + connection.isValid(0));
		}

	}

}
