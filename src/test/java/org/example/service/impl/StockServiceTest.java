package org.example.service.impl;

import dao.ItemDao;
import dao.impl.InMemoryItemDao;
import model.Item;
import service.StockService;
import service.impl.StockServiceImpl;
import junit.framework.TestCase;

import java.util.Arrays;

public class StockServiceTest extends TestCase {

    private InMemoryItemDao itemDao;
    private StockServiceImpl stockService;

    public void testGetItem_Missing(){
        StockService service = buildService();
        service.addStock(1, 10);

        assertEquals(0, service.getStock().size());
    }

    private StockServiceImpl buildService(Item... items) {
        ItemDao itemDao = new InMemoryItemDao(Arrays.asList(items));
        return new StockServiceImpl(itemDao);
    }
}
