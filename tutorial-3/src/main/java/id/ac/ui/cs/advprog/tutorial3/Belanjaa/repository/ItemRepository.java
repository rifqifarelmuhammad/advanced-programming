package id.ac.ui.cs.advprog.tutorial3.Belanjaa.repository;
import id.ac.ui.cs.advprog.tutorial3.Belanjaa.core.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, Item> itemMap;

    public ItemRepository() {
        this.itemMap = new HashMap<>();
    }

    public void addItem(Item item) {
        itemMap.put(item.getName(), item);
    }

    public Item getItem(String itemName) {
        return itemMap.get(itemName);
    }

    public List<Item> getAllItem() {
        return itemMap.values().stream().toList();
    }

}
