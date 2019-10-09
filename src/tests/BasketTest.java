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

    @Test(expected = Exception.class)
    public void AmountShouldBeNonZeroTest() throws Exception {
        basket.addItem(new Item("Pocket", 20),0);
    }

    @Test(expected = Exception.class)
    public void AmountShouldBeGreaterThanZeroTest() throws Exception {
        basket.addItem(new Item("Pocket", 20),-3);
    }

    @Test(expected = Exception.class)
    public void AmountShouldBeNonZeroRemoveTest() throws Exception {
        basket.removeItem(it1,0);
    }

    @Test(expected = Exception.class)
    public void AmountShouldBeGreaterThanZeroRemoveTest() throws Exception {
        basket.removeItem(it2,-3);
    }
    @Test(expected = Exception.class)
    public void AmountShouldBeLessThenAmountOfItemRemoveTest() throws Exception {
        basket.removeItem(it2,10);
    }

    @Test
    public void removeItemTest() throws Exception {
        basket.removeItem(it1,1);
        basket.showOrder();
        assertEquals(3,basket.sizeOrder());
    }

    @Test
    public void totalPriceTest() throws Exception {
        assertEquals(410,basket.totalPrice(),0);
    }

    @Test
    public void showOrderTest() {
        basket.showOrder();
    }

    @Test
    public void clearOrderTest() {
        assertEquals(4, basket.sizeOrder());
        basket.clearOrder();
        assertEquals(0,basket.sizeOrder());
    }
}