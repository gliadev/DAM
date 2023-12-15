package apuntes_videos;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class JDBC_callable_statement {

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
        CallableStatement s = null;
        ResultSet rs = null;

        try {
            c = DriverManager.getConnection(urlConnection, user, pwd);
            s = c.prepareCall("{ call longitud_apellido(?, ?) }");

            s.setString(1, "24862486S");
            s.registerOutParameter(2,java.sql.Types.INTEGER);

            s.execute();

            int longitud = s.getInt(2);
            System.out.println("=> Longitud del apellido: " + longitud);

            // Si tu procedimiento almacenado también devuelve un ResultSet, puedes procesarlo así:
            // rs = (ResultSet) s.getObject(1); // Asumiendo que el ResultSet es el primer parámetro
            // while (rs.next()) {
            //     // Procesar los resultados
            // }

        } catch (SQLException e) {
            muestraErrorSQL(e);
        } catch (Exception e) {
            System.err.println("ERROR de conexión");
            e.printStackTrace(System.err);
        } finally {
            try {
                if (rs != null) rs.close();
                if (s != null) s.close();
                if (c != null) c.close();
            } catch (SQLException e) {
                muestraErrorSQL(e);
            }
        }
    }
}
