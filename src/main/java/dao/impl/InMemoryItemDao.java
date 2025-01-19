package dao.impl;

import dao.ItemDao;
import model.Item;
import java.util.List;

public class InMemoryItemDao implements ItemDao {
    private final List<Item> stock;

    public InMemoryItemDao(List<Item> stock) {
        this.stock = stock;
    }

    @Override
    public Item getItem(Integer itemId) {
        for (Item item : stock) {
            if (item.getId().equals(itemId)) {
                return item;  // Devuelve el artículo con el ID correspondiente
            }
        }
        return null;  // Si no se encuentra el artículo, devuelve null
    }

    @Override
    public List<Item> getItems() {
        return stock;  // Devuelve el stock completo
    }

    @Override
    public boolean addQuantity(Integer itemId, Integer quantity) {
        Item item = getItem(itemId);

        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);  // Suma la cantidad al artículo existente
            return true;
        }
        return false;
    }

    @Override
    public boolean withdrawQuantity(Integer itemId, Integer quantity) {
        Item item = getItem(itemId);

        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);  // Resta la cantidad del artículo
            return true;
        }

        return false;  // Si no hay suficiente stock, la operación falla
    }
}
