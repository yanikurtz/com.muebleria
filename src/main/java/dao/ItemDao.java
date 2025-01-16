package dao;

import model.Item;
import java.util.List;

public interface ItemDao {

    Item getItem(Integer itemId);

    List<Item> getItems();

    boolean addQuantity(Integer itemId, Integer quantity);

    boolean withdrawQuantity(Integer itemId, Integer quantity);
}
