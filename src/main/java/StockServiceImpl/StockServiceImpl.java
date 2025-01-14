package StockServiceImpl;

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
        return itemDao.getStock();  // Llama al DAO para obtener el stock
    }

    @Override
    public boolean withdraw(Integer itemId, Integer quantity) {
        Item item = itemDao.getStock(itemId);

        if (item != null && item.getQuantity() >= quantity) {
            itemDao.withdraw(itemId, quantity);  // Retira la cantidad del artículo
            return true;
        }

        return false;  // Si no hay suficiente stock, la operación falla
    }
}
