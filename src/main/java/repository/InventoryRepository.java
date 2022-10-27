package repository;

import model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryRepository extends MongoRepository<Item, String> {
    Item findItemByID(String id);
}
