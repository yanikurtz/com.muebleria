package dao;

import model.Item;
import java.util.List;

public interface ItemDao {
    List<Item> getStock();
    Item getStock(Integer itemId);
    boolean addStock(Integer itemId, Integer quantity);
    boolean withdraw(Integer itemId, Integer quantity);
}
