package Koszyk;

import java.util.Scanner;

public class Shoes extends Item{
    private final String destiny;
    private final double size;

    public Shoes(){
        super();
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz przeznaczenie");
        destiny = input.nextLine();
        System.out.println("Wpisz rozmiar");
        size = input.nextDouble();
        input.close();
    }

    public Shoes(String name, double price, String destiny, double size){
        super(name, price);
            this.destiny = destiny;
            this.size = size;
    }

    public String getDestiny() {
        return destiny;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "(name: " + this.name + " price: " + this.price +
                " destiny: " + this.destiny + " size: " + this.size +")";
    }
}
