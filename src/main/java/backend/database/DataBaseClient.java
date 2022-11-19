package backend.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class DataBaseClient {
    @Value("${database.timeout}")
    private int timeout;
    private final Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseClient.class);

    public DataBaseClient(Connection connection) {
        this.connection = connection;
    }

    public boolean connectionStatus() {
        try {
            return connection.isValid(timeout);
        } catch (SQLException e) {
            LOGGER.error("Encountered exception while checking for connection: {}", e.getMessage());
            return false;
        }
    }

    public ResultSet executeGet(String query) {
        LOGGER.info("Getting value from the Database with query: {}", query);
        try {
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(timeout);
            return statement.executeQuery(query);
        } catch (SQLException e) {
            LOGGER.warn("Error while getting the Value from the database with query: {}, encountered exception: {}",
                    query, e);
            return null;
        }
    }
}
