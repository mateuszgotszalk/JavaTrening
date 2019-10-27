package Koszyk;

import java.util.*;

import java.util.Map.Entry;


class Basket {

   private Map <Item, Integer> order = new TreeMap<>();

   public void addItem(Item item){
       order.put(item, 1);
   }

    public void addItem(Item item, int amount) throws Exception {
       if(amount <=0){
           throw new Exception("Podana ilosc musi byc wieksza od 0");
       }
        order.put(item, amount);
    }

    public void removeItem(Item item, int amount) throws Exception{

       int am1;

       if(item == null) throw new Exception("Pusty obiekt");

       if(amount <=0 ){
           throw new Exception("Podana ilosc musi byc wieksza od 0");
       }

       am1 = order.get(item) - amount;

       if(am1 == 0)
           order.remove(item);

       else if (am1 < 0)
           throw new Exception("Nie ma tyle przedmiotow");

       else
           order.put(item, am1);
    }

    public double totalPrice(){

       double price = 0;

       for(Entry<Item, Integer> it : order.entrySet()){
           price += (it.getKey().price * it.getValue());
       }
       return price;
    }

    public void showOrder(){
        System.out.println("Liczba elementow: " + order.size());

        for(Entry<Item, Integer> it : order.entrySet()){
            System.out.println(it);
        }

    }
    public void clearOrder(){
       order.clear();
        System.out.println("all clear!");
   }

   public int sizeOrder(){
       return order.size();
   }

    /*@Override
    public String toString() {
        String s="";
        for(Entry<Item, Integer> e: order.entrySet()){
            s = "{ (name: " + e.getKey().name + "  price: " +  e.getKey().price + ")=" + e.getValue() + "}";
        }
        return s;
    }

    @Override
    public int hashCode() {
        int sum=0;
        for(Entry<Item, Integer> amount : order.entrySet()){
            sum+= (amount.getKey().price*amount.getValue())+(amount.getKey().name.hashCode());
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || (this.getClass() != obj.getClass())) return false;

        return this.hashCode() == obj.hashCode();
    }*/
}