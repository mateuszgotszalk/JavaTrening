package tests;

import Koszyk.Basket;
import Koszyk.Item;
import Koszyk.Shirt;
import Koszyk.Shoes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasketTest {
    Basket basket;
    Item it1;
    Item it2;
    Item it3;
    Item it4;


    @Before
    public void setUp() throws Exception {
        basket = new Basket();
        it1 = new Item("NewBalance", 80);
        it2 = new Item("CalvinKlein", 120);
        it3 = new Shirt("HM", 10, "White", "L");
        it4 = new Shoes("Adidasy",200,"Street",33);
        basket.addItem(it1);
        basket.addItem(it2);
        basket.addItem(it3);
        basket.addItem(it4);
    }

    @After
    public void tearDown() throws Exception {
        basket.clearOrder();
    }

    @Test
    public void addItemTest() {
        Item item = new Item("Puma", 70);
        basket.addItem(item);
        assertEquals(5,basket.sizeOrder());
        assertEquals(480,basket.totalPrice(),0);
        basket.showOrder();
    }

    @Test
    public void addItem1Test() {

    }

    @Test
    public void removeItemTest() {
    }

    @Test
    public void totalPriceTest() throws Exception {
        assertEquals(410,basket.totalPrice(),0);
    }

    @Test
    public void showOrderTest() {
        basket.showOrder();
    }
}