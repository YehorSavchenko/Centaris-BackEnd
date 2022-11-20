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

import java.io.File;
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
        itemService.addItem(new Item("toys", "dinosaur", "Cracow, Wawel Castle",
                LocalDateTime.now(), "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSvPY9kkWxePK9SD7mjhz8_KUsBlKwxCMhe_jp0w0iGiA&s",
                "yee"));
        itemService.addItem(new Item("book", "Alice in Wonderland", "Cracow, Nowa Huta",
                LocalDateTime.now(), "https://a.allegroimg.com/s1024/0c4a9f/d14ac7bb4f8aabce0751df838d3b",
                "A book. You can read it. Or not. Might be decent"));
        itemService.addItem(new Item("clothes", "dress", "Cracow, Kazimierz",
                LocalDateTime.now(), "https://i.ebayimg.com/00/s/ODAwWDYwMA==/z/v6sAAOSw3ldjOpsX/$_86.PNG",
                "yep, the picture is stolen from some random site. So what?"));
        LOGGER.info("Initialized item controller");
    }


    @GetMapping("/items/get/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
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
