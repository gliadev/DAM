package apuntes_videos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_ResultSet_actualizable {
    public static void main(String[] args) {
        String urlConnection = "jdbc:mysql://localhost:3306/test"; // Reemplaza con tus datos
        String user = "test"; 
        String pwd = "test"; 
        
        Connection c = null;
        Statement sConsulta = null;
        ResultSet rs = null;

        try {
            System.out.println("Conectando a la base de datos...");
            c = DriverManager.getConnection(urlConnection, user, pwd);
            sConsulta = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = sConsulta.executeQuery("SELECT * FROM CLIENTES WHERE CP IS NOT NULL");

            System.out.println("Desactivando auto-commit...");
            c.setAutoCommit(false);

            System.out.println("Modificando el último cliente...");
            rs.last();
            rs.updateString("CP", "02568");
            rs.updateRow();

            System.out.println("Borrando penúltimo cliente...");
            rs.previous();
            rs.deleteRow();

            System.out.println("Insertando nueva fila...");
            rs.moveToInsertRow();
            rs.updateString("DNI", "24862486S");
            rs.updateString("APELLIDOS", "ZURITA");
            rs.updateString("CP", "33983");
            rs.insertRow();

            System.out.println("Realizando commit de los cambios...");
            c.commit();
            System.out.println("Cambios guardados exitosamente.");

        } catch (SQLException e) {
            if (e.getErrorCode() == 1062) {
                System.err.println("El DNI proporcionado ya existe en la base de datos. Por favor, utilice un DNI único.");
            } else {
                muestraErrorSQL(e);
            }
            try {
                if (c != null) {
                    System.out.println("Realizando rollback de los cambios...");
                    c.rollback();
                    System.out.println("Rollback realizado correctamente.");
                }
            } catch (SQLException ex) {
                System.err.println("Error al intentar hacer rollback:");
                ex.printStackTrace();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (sConsulta != null) sConsulta.close();
                if (c != null) c.close();
                System.out.println("Conexión con la base de datos cerrada.");
            } catch (SQLException e) {
                muestraErrorSQL(e);
            }
        }
    }

    private static void muestraErrorSQL(SQLException e) {
        System.err.println("SQL ERROR mensaje: " + e.getMessage());
        System.err.println("SQL Estado: " + e.getSQLState());
        System.err.println("SQL código específico: " + e.getErrorCode());
    }
}