package apuntes_videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class EjemploConexionesPosgreSQL {

	public static void main(String[] args) {
/*		
 * 			Esta seria para conectarme a Docker
 * 			try {
			Connection conexion = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1/test","postgres","postgres");
			String sql = "SELECT apellidos from clientes";
			Statement sentencia = conexion.createStatement();
			ResulSet rs = sentencia.executeQuery(sql);
		
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			rs.close();
			sentencia.close();
			conexion.close();
		
		} catch (SQLException e ) {
			e.printStackTrace();
		}

	*/}

}
