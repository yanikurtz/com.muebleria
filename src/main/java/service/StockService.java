package service;

import model.Item;
import java.util.List;

public interface StockService {
    List<Item> getStock();
    boolean withdraw(Integer itemId, Integer quantity);
}
