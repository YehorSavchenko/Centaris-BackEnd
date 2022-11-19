package backend.services;

import backend.repositories.ItemRepository;
import model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemService.class);
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item){
        logger.info("Saving {}", item);
        return itemRepository.save(item);
    }

    public List<Item> addItems(List<Item> items) {
        logger.info("Saving {}", items);
        return itemRepository.saveAll(items);
    }

    public List<Item> getAllItems(){
        return itemRepository.findAll();
    }

    public List<Item> getItemsByDistrict(String district) {
        return itemRepository.getItemsByDistrict(district);
    }

    public List<Item> getItemsByCategory(String category) {
        return itemRepository.getItemsByCategory(category);
    }

    public List<Item> getItemsByCategoryAndDistrict(String category, String district) {
        return itemRepository.getItemsByCategoryAndDistrict(category, district);
    }
}
