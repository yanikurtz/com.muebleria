package service.impl;

import dao.ItemDao;
import model.Item;
import java.util.ArrayList;
import java.util.List;

public class InMemoryItemDao implements ItemDao {
    private List<Item> stock = new ArrayList<>();

    @Override
    public List<Item> getStock() {
        return stock;  // Devuelve el stock completo
    }

    @Override
    public Item getStock(Integer itemId) {
        for (Item item : stock) {
            if (item.getId().equals(itemId)) {
                return item;  // Devuelve el artículo con el ID correspondiente
            }
        }
        return null;  // Si no se encuentra el artículo, devuelve null
    }

    @Override
    public boolean addStock(Integer itemId, Integer quantity) {
        Item item = getStock(itemId);

        if (item != null) {
            item.setQuantity(item.getQuantity() + quantity);  // Suma la cantidad al artículo existente
            return true;
        }

        // Si el artículo no existe, lo crea
        stock.add(new Item(itemId, "Nuevo Producto", quantity));
        return true;
    }

    @Override
    public boolean withdraw(Integer itemId, Integer quantity) {
        Item item = getStock(itemId);

        if (item != null && item.getQuantity() >= quantity) {
            item.setQuantity(item.getQuantity() - quantity);  // Resta la cantidad del artículo
            return true;
        }

        return false;  // Si no hay suficiente stock, la operación falla
    }
}

