package backend.configuration;

import backend.database.DataBaseClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Configuration
public class Config {

    @Bean
    public Connection connection() throws SQLException {
        Connection connection = mock(Connection.class);
        Statement statement = mock(Statement.class);
        when(connection.createStatement()).thenReturn(statement);
        ResultSet resultSet = mock(ResultSet.class);
        when(statement.executeQuery("SELECT * FROM ITEMS")).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("key")).thenReturn("MockKey");
        when(resultSet.getString("category")).thenReturn("MockCategory");
        when(resultSet.getString("name")).thenReturn("MockName");
        when(resultSet.getString("district")).thenReturn("MockDistrict");
        when(resultSet.getDate("createDate")).thenReturn(new Date(2022,10,10));
        return connection;
    }


}
