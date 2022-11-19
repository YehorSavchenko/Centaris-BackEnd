package backend.controllers;

import backend.services.ItemService;
import model.Item;
import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class ItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
    private final ItemService itemService;

    public ItemsController(ItemService itemService) {
        this.itemService = itemService;
        itemService.addItem(new Item(7L, "ddd", "huhadk", "fgsjfsjfh", LocalDateTime.now()));
        LOGGER.info("Initialized item controller");
    }


    @GetMapping("/items/get/all")
    public ItemList getAllItems() {
        LOGGER.info("request received");
        ItemList allItems = new ItemList(itemService.getAllItems());
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/district/{district}")
    public ItemList getAllItemsForDistrict(@PathVariable String district) {
        ItemList allItems = new ItemList(itemService.getAllItems());
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/category/{category}")
    public ItemList getAllItemsForCategory(@PathVariable String category) {
        ItemList allItems = new ItemList(itemService.getAllItems());
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/categoryanddistrict/{category}&{district}")
    public ItemList getAllItemsForDistrictAndCategory(@PathVariable String category,
                                                      @PathVariable String district) {
        ItemList allItems = new ItemList(itemService.getAllItems());
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }
}
