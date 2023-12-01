package TareaEvaluativa;
import java.sql.*;

public class Ejercicio01 {

    public static void main(String[] args) {
        // Datos para la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbeventos";
        String user = "adgomez";
        String password = "0742";

        // Intentar establecer la conexión con la base de datos
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {
            
            // Crear un objeto Statement para poder realizar consultas
            Statement statement = conexion.createStatement();
            
            // Consulta SQL para obtener la información de los eventos
            String consulta = "SELECT e.nombre_evento, COUNT(ae.dni) AS num_asistentes, " +
                              "u.nombre AS ubicacion, u.direccion " +
                              "FROM eventos e " +
                              "JOIN ubicaciones u ON e.id_ubicacion = u.id_ubicacion " +
                              "LEFT JOIN asistentes_eventos ae ON e.id_evento = ae.id_evento " +
                              "GROUP BY e.id_evento, u.id_ubicacion";

            // Ejecutar la consulta y obtener el resultado en un objeto ResultSet
            ResultSet resultados = statement.executeQuery(consulta);

            // Imprimir cabecera de la tabla
            System.out.printf("%-30s | %-10s | %-20s | %-30s%n", "Evento", "Asistentes", "Ubicación", "Dirección");
            
            System.out.println("----------------------------------------------------------------------------------------------------------------");

            // Procesar el ResultSet y mostrar los datos con formato de tabla
            while (resultados.next()) {
                String nombreEvento = resultados.getString("nombre_evento");
                int numAsistentes = resultados.getInt("num_asistentes");
                String ubicacion = resultados.getString("ubicacion");
                String direccion = resultados.getString("direccion");
                
                // Formatear y mostrar los datos de cada evento
                System.out.printf("%-30s | %-10d | %-20s | %-30s%n", nombreEvento, numAsistentes, ubicacion, direccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}