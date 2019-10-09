package tests;

import Koszyk.Item;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    Item item;

    @Before
    public void setUp() throws Exception {
        item = new Item("Adidas",80);
    }

    @Test
    public void equalsTest() {
        Item it = new Item("Adidas", 80);
        assertTrue(item.equals(it));
    }

    @Test
    public void equalsTest2() {
        Item it = new Item("Adidas", 80);
        assertEquals(item, it);
    }

    @Test
    public void equalsHashCodeTest() {
        Item it = new Item("Adidas", 80);
        assertEquals(item.hashCode(), it.hashCode());
    }

}