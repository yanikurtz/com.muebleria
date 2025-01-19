package tests;

import dao.impl.InMemoryItemDao;
import model.Item;
import service.impl.StockServiceImpl;
import junit.framework.TestCase;

import java.util.List;

public class StockServiceTest extends TestCase{

    private InMemoryItemDao itemDao;
    private StockServiceImpl stockService;

    @Override
    protected void setUp(){
        itemDao = new InMemoryItemDao();
        stockService = new StockServiceImpl(itemDao);
    }

    public void testGetItem_Success(){
        itemDao.addQuantity(1, 10);
        Item item = itemDao.getItem(1);

        assertNotNull("El item existe", item);
        assertEquals(1, item.getId().intValue());
        assertEquals(10, item.getQuantity().intValue());
    }

    public void testGetItem_NotFound(){
        Item item = itemDao.getItem(99);
        assertNotNull("El item no existe", item);

    }

}
