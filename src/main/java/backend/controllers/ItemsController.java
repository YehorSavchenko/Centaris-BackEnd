package backend.controllers;

import backend.services.ImageService;
import backend.services.ItemService;
import model.Image;
import model.Item;
import model.ItemList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class ItemsController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemsController.class);
    private final ItemService itemService;
    private final ImageService imageService;

    public ItemsController(ItemService itemService, ImageService imageService) {
        this.itemService = itemService;
        this.imageService = imageService;
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
        ItemList allItems = new ItemList(itemService.getItemsByDistrict(district));
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/category/{category}")
    public ItemList getAllItemsForCategory(@PathVariable String category) {
        ItemList allItems = new ItemList(itemService.getItemsByCategory(category));
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/categoryanddistrict/{category}&{district}")
    public ItemList getAllItemsForDistrictAndCategory(@PathVariable String category,
                                                      @PathVariable String district) {
        ItemList allItems = new ItemList(itemService.getItemsByCategoryAndDistrict(category, district));
        LOGGER.info("Found following items: {}", allItems);
        return allItems;
    }

    @GetMapping("/items/get/images/for/{itemId}")
    public List<Image> getImagesForItem(@PathVariable Long itemId) {
        return imageService.getImagesForItem(itemId);
    }
}
