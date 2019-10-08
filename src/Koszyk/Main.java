package Koszyk;

public class Main {

    public static void main(String []args){


        Basket basket = new Basket();
        Item item1 = new Item("Adidasy", 100);

        try{
            basket.addItem(item1);
            basket.addItem(new Item("NewBalance", 80.33));
            basket.addItem(new Item("CalvinKlein", 120),4);
            basket.addItem(new Shoes("Nike", 90, "AiRforce", "Street", 34));
            basket.addItem(new Shirt("HM", 5, "White", "L"),5);
            basket.showOrder();
            System.out.println("Price = " + basket.totalPrice());

            basket.removeItem(item1,1);
            basket.showOrder();
        }catch (Exception e){
            System.out.println("Wiadomosc: " + e.getMessage());
        }

    }
}