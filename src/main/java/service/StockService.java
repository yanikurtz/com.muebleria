package service;

import model.Item;
import java.util.List;

public interface StockService {

    List<Item> getStock();

    boolean addStock(Integer itemId, Integer quantity);

    boolean withdrawStock(Integer itemId, Integer quantity);
}
