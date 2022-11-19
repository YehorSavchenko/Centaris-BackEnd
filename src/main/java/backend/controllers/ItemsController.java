package backend.controllers;

import backend.database.DataBaseClient;
import backend.database.DataBaseService;
import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
    private final DataBaseService dataBaseService;

    public ItemsController(DataBaseService dataBaseService) {
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/items/get/all")
    public ItemList getAllItems() {
        ItemList allItems = dataBaseService.getAllItems();
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/district/{district}")
    public ItemList getAllItemsForDistrict(@PathVariable String district) {
        ItemList allItems = dataBaseService.getAllItems();
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/category/{category}")
    public ItemList getAllItemsForCategory(@PathVariable String category) {
        ItemList allItems = dataBaseService.getAllItems();
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/categoryanddistrict/{category}&{district}")
    public ItemList getAllItemsForDistrictAndCategory(@PathVariable String category,
                                                      @PathVariable String district) {
        ItemList allItems = dataBaseService.getAllItems();
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }
}
