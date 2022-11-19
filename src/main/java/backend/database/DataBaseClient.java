package backend.database;

import model.Item;
import model.ItemList;

import java.time.LocalDateTime;
import java.util.Collections;

public class DataBaseClient {
    public ItemList getAllItems() {
        Item item = new Item();
        item.setKey("AAAAA");
        item.setCreateDate(LocalDateTime.now());
        item.setCategory("Test items");
        item.setName("Test name");
        ItemList itemList = new ItemList();
        itemList.setItems(Collections.singletonList(item));
        return itemList;
    }
}
