package Koszyk;

import java.util.Scanner;

class Item implements Comparable{
    protected final String name;
    protected final double price;

    Item(){
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz nazwe");
        name = input.nextLine();
        System.out.println("Wpisz cene");
        price = input.nextDouble();
        input.close();
    }

    Item(String name, double price){
            this.name = name;
            this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || (this.getClass() != obj.getClass())) return false;

        return (this.price == ((Item)obj).price) && (this.name.equals(((Item) obj).name));
    }

    @Override
    public int hashCode() {
        return (int) (15* this.price + this.name.hashCode());
    }

    public String toString(){
        return " (name: " + name + "  price: " + price + ")";
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Item)o).name);
    }
}