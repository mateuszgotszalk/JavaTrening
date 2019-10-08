package Koszyk;

import java.util.Scanner;

public class Shirt extends Item{
    private final String color;
    private final String size;

    public Shirt(){
        super();
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz kolor");
        color = input.nextLine();
        System.out.println("Wpisz rozmiar");
        size = input.nextLine();
        input.close();
    }
    public Shirt(String name, double price, String color, String size){
        super(name, price);
            this.color = color;
            this.size = size;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return " (name: " + this.name + " price: " + this.price +
                " color: " + this.color + " size: " + this.size+ ")";
    }
}