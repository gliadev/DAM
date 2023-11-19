package apuntes_videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_create_table {

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
        Statement s = null;

        try {
            c = DriverManager.getConnection(urlConnection, user, pwd);
            s = c.createStatement();
            s.execute("CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL,"
            		+ " APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5),"
            		+ " PRIMARY KEY(DNI))");
            System.out.println("La tabla CLIENTES se ha creado correctamente");

            
        } catch (SQLException e) {
            muestraErrorSQL(e);
        } finally {
            try {
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                muestraErrorSQL(e);
            }
        }
    }
}