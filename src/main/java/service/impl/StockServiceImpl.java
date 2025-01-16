package service.impl;

import service.StockService;
import model.Item;
import dao.ItemDao;
import java.util.List;

public class StockServiceImpl implements StockService {

    private ItemDao itemDao;

    // Constructor para inyectar el ItemDao
    public StockServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public List<Item> getStock() {
        return itemDao.getItems();  // Llama al DAO para obtener el stock
    }

    @Override
    public boolean addStock(Integer itemId, Integer quantity) {
        Item item = itemDao.getItem(itemId);

        if (item != null) {
            itemDao.addQuantity(itemId, item.getQuantity() + quantity);  // Retira la cantidad del artículo
            return true;
        }

        return false;  // Si no hay suficiente stock, la operación falla
    }

    @Override
    public boolean withdrawStock(Integer itemId, Integer quantity) {
        Item item = itemDao.getItem(itemId);

        if (item != null && item.getQuantity() >= quantity) {
            itemDao.withdrawQuantity(itemId, quantity);  // Retira la cantidad del artículo
            return true;
        }

        return false;  // Si no hay suficiente stock, la operación falla
    }
}
