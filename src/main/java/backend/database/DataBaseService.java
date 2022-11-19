package backend.database;

import model.Item;
import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataBaseService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseService.class);
    private static final String SELECT_ALL_ITEMS_QUERY = "SELECT * FROM ITEMS";
    private final DataBaseClient dataBaseClient;

    public DataBaseService(DataBaseClient dataBaseClient) {
        this.dataBaseClient = dataBaseClient;
    }

    public ItemList getAllItems() {
        ResultSet resultSet = dataBaseClient.executeGet(SELECT_ALL_ITEMS_QUERY);
        List<Item> items = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                items.add(new Item(
                    resultSet.getString("key"),
                        resultSet.getString("category"),
                        resultSet.getString("name"),
                        resultSet.getString("district"),
                        resultSet.getDate("createDate").toLocalDate().atStartOfDay()
                ));
            } catch (SQLException e) {
                LOGGER.warn("Exception encountered while getting data from database", e);
            }
        }
        return new ItemList(items);
    }
}
