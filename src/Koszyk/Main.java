package Koszyk;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String []args){

        Basket basket = new Basket();
        Item item1 = new Item("Adidasy", 100);


        try{
            basket.addItem(item1);
            basket.addItem(new Item("NewBalance", 80));
            basket.addItem(new Shirt("HM", 5, "White", "L"),4);

            System.out.println("**********");
            basket.showOrder();
            System.out.println("Price = " + basket.totalPrice());

            basket.removeItem(item1,1);
            basket.showOrder();
            System.out.println("Price = " + basket.totalPrice());

            System.out.println("````````````````````");
            basket.clearOrder();
        }catch (Exception e){
            System.out.println("Wiadomosc: " + e.getMessage());
        }

    }
}