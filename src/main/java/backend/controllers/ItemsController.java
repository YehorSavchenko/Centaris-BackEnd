package backend.controllers;

import backend.database.DataBaseClient;
import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
    private final DataBaseClient dataBaseClient;

    public ItemsController(DataBaseClient dataBaseClient) {
        this.dataBaseClient = dataBaseClient;
    }

    @GetMapping("/items/get/all")
    public ItemList getAllItems() {
        ItemList allItems = dataBaseClient.getAllItems();
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }
}
