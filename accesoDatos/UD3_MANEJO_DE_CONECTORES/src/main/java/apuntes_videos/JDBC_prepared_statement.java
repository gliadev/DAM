package apuntes_videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_prepared_statement {

    public static void muestraErrorSQL(SQLException e) {
        System.err.println("SQL ERROR mensaje: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL código específico: " + e.getErrorCode());
    }

    public static void main(String[] args) {
        String basedatos = "test";
        String host = "localhost";
        String port = "3306";
        String parAdic = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String urlConnection = "jdbc:mysql://" + host + ":" + port + "/" + basedatos + parAdic;
        String user = "test";
        String pwd = "test";

        Connection c = null;
        PreparedStatement sInsert = null;

        try {
            c = DriverManager.getConnection(urlConnection, user, pwd);
            sInsert = c.prepareStatement("INSERT INTO CLIENTES(DNI, APELLIDOS, CP) VALUES (?, ?, ?)");

            sInsert.setString(1, "78901231A");
            sInsert.setString(2, "PEREZ");
            sInsert.setInt(3, 44126);

            sInsert.executeUpdate();
            System.out.println("Datos almacenados");
        } catch (SQLException e) {
            muestraErrorSQL(e);
        } finally {
            try {
                if (sInsert != null) sInsert.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                muestraErrorSQL(e);
            }
        }
    }
}

