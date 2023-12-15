package apuntes_videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_transacciones {


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
            c.setAutoCommit(false); // Deshabilitar auto-commit para controlar las transacciones manualmente

            sInsert = c.prepareStatement("INSERT INTO CLIENTES(DNI, APELLIDOS, CP) VALUES (?, ?, ?)");

            // Primer insert
            sInsert.setString(1, "54320198V");
            sInsert.setString(2, "CARVAJAL");
            sInsert.setString(3, "10109");
            sInsert.executeUpdate();
            System.out.println("primer insert OK");

            // Segundo insert
            sInsert.setString(1, "76543210S");
            sInsert.setString(2, "MARQUEZ");
            sInsert.setString(3, "46987");
            sInsert.executeUpdate();
            System.out.println("segundo insert OK");

            // Tercer insert
            sInsert.setString(1, "90123456A");
            sInsert.setString(2, "MOLINA");
            sInsert.setString(3, "35153");
            sInsert.executeUpdate();
            System.out.println("tercer insert OK");

            c.commit(); // Confirmar la transacción si todos los inserts son exitosos

            System.out.println("Los datos se han insertado correctamente.");

        } catch (SQLException e) {
            muestraErrorSQL(e);
            try {
                if (c != null) {
                    c.rollback(); // Revertir la transacción en caso de error
                }
            } catch (Exception er) {
                System.err.println("ERROR haciendo ROLLBACK");
                er.printStackTrace(System.err);
            }
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