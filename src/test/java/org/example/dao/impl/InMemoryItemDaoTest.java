package org.example.dao.impl;

import dao.ItemDao;
import dao.impl.InMemoryItemDao;
import junit.framework.TestCase;
import model.Item;

import java.util.Arrays;

import static org.example.model.TestItem.*;

public class InMemoryItemDaoTest extends TestCase {

    public void testGetItem() {
        Item redPaint = RED_PAINT.build(20);
        Item bluePaint = BLUE_PAINT.build(30);
        Item nails = NAILS.build(5);

        ItemDao dao = buildItemDao(redPaint, bluePaint, nails);

        assertEquals(redPaint, dao.getItem(RED_PAINT.id));
        assertEquals(bluePaint, dao.getItem(BLUE_PAINT.id));
        assertEquals(nails, dao.getItem(NAILS.id));
    }

    public void testGetMissingItem() {
        ItemDao dao = buildItemDao(RED_PAINT.build(20));

        assertNull(dao.getItem(BLUE_PAINT.id));
    }

    public void testGetItems() {
        ItemDao dao = buildItemDao(RED_PAINT.build(20), BLUE_PAINT.build(30), NAILS.build(5));

        assertEquals(3, dao.getItems().size());
    }

    public void testGetEmptyItems() {
        ItemDao dao = buildItemDao();

        assertTrue(dao.getItems().isEmpty());
    }

    public void testAddQuantity() {
        ItemDao dao = buildItemDao(LIGHT_WOOD.build(20), DARK_WOOD.build(30), NAILS.build(5));

        assertEquals(Integer.valueOf(20), dao.getItem(LIGHT_WOOD.id).getQuantity());
        dao.addQuantity(LIGHT_WOOD.id, 5);
        assertEquals(Integer.valueOf(25), dao.getItem(LIGHT_WOOD.id).getQuantity());

        assertEquals(Integer.valueOf(5), dao.getItem(NAILS.id).getQuantity());
        dao.addQuantity(NAILS.id, 40);
        assertEquals(Integer.valueOf(45), dao.getItem(NAILS.id).getQuantity());
    }

    public void testWithdrawQuantity() {
        ItemDao dao = buildItemDao(LIGHT_WOOD.build(20), DARK_WOOD.build(30), NAILS.build(5));

        assertEquals(Integer.valueOf(20), dao.getItem(LIGHT_WOOD.id).getQuantity());
        dao.withdrawQuantity(LIGHT_WOOD.id, 6);
        assertEquals(Integer.valueOf(14), dao.getItem(LIGHT_WOOD.id).getQuantity());

        assertEquals(Integer.valueOf(5), dao.getItem(NAILS.id).getQuantity());
        dao.withdrawQuantity(NAILS.id, 5);
        assertEquals(Integer.valueOf(0), dao.getItem(NAILS.id).getQuantity());
    }




    private InMemoryItemDao buildItemDao(Item... items) {
        return new InMemoryItemDao(Arrays.asList(items));
    }
}
