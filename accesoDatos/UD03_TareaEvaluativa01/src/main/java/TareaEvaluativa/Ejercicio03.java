package TareaEvaluativa;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
        // Datos para la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/dbeventos";
        String user = "adgomez";
        String password = "0742";

        try (Connection conexion = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Introduce el DNI del asistente: ");
            String dni = scanner.nextLine();

            // Verificar si el asistente ya existe en la base de datos
            boolean asistenteExiste = verificarAsistente(conexion, dni);

            // Si el asistente no existe, pedir el nombre y registrar
            if (!asistenteExiste) {
                System.out.print("Introduce el nombre del asistente: ");
                String nombre = scanner.nextLine();
                registrarAsistente(conexion, dni, nombre);
            }

            // Mostrar eventos disponibles
            mostrarEventos(conexion);

            // Seleccionar evento y realizar registro
            System.out.print("Elige el número del evento al que quiere asistir: ");
            int idEvento = Integer.parseInt(scanner.nextLine());
            registrarAsistenciaEvento(conexion, dni, idEvento);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean verificarAsistente(Connection conexion, String dni) throws SQLException {
        String consulta = "SELECT * FROM asistentes WHERE dni = ?";
        try (PreparedStatement statement = conexion.prepareStatement(consulta)) {
            statement.setString(1, dni);
            ResultSet resultados = statement.executeQuery();
            if (resultados.next()) {
                System.out.println(resultados.getString("nombre") + " ha sido encontrado.");
                return true;
            } else {
                System.out.println("No se encontró un asistente con el DNI proporcionado.");
                return false;
            }
        }
    }

    private static void registrarAsistente(Connection conexion, String dni, String nombre) throws SQLException {
        String insert = "INSERT INTO asistentes (dni, nombre) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(insert)) {
            statement.setString(1, dni);
            statement.setString(2, nombre);
            statement.executeUpdate();
            System.out.println(nombre + " ha sido registrado en la base de datos.");
        }
    }

    private static void mostrarEventos(Connection conexion) throws SQLException {
        String consulta = "SELECT e.id_evento, e.nombre_evento, (u.capacidad - COUNT(ae.dni)) AS espacios_disponibles " +
                          "FROM eventos e " +
                          "JOIN ubicaciones u ON e.id_ubicacion = u.id_ubicacion " +
                          "LEFT JOIN asistentes_eventos ae ON e.id_evento = ae.id_evento " +
                          "GROUP BY e.id_evento " +
                          "HAVING espacios_disponibles > 0";
        try (Statement statement = conexion.createStatement();
             ResultSet resultados = statement.executeQuery(consulta)) {
            System.out.println("Lista de eventos:");
            while (resultados.next()) {
                int idEvento = resultados.getInt("id_evento");
                String nombreEvento = resultados.getString("nombre_evento");
                int espaciosDisponibles = resultados.getInt("espacios_disponibles");
                System.out.printf("%d. %s - Espacios disponibles: %d%n", idEvento, nombreEvento, espaciosDisponibles);
            }
        }
    }

    private static void registrarAsistenciaEvento(Connection conexion, String dni, int idEvento) throws SQLException {
        String insert = "INSERT INTO asistentes_eventos (id_evento, dni) VALUES (?, ?)";
        try (PreparedStatement statement = conexion.prepareStatement(insert)) {
            statement.setInt(1, idEvento);
            statement.setString(2, dni);
            statement.executeUpdate();
            System.out.println("El asistente ha sido registrado para el evento seleccionado.");
        }
    }
}
