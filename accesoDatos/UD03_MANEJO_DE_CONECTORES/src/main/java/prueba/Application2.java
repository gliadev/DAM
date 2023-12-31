package prueba;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

public class Application2 {

    public static void main(String[] args) throws SQLException {
        DataSource ds = createDataSource();

        try (Connection connection = ds.getConnection()) {
            System.out.println("connection.isValid(0) = " + connection.isValid(0));
        }
    }

    private static DataSource createDataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:~/mydatabase");
        ds.setUsername("sa");
        ds.setPassword("s3cr3tPassword");
        return ds;
    }
}