package ObjectClass;

import java.util.Objects;

public class Pen {
    String brand;
    int price;

    public Pen(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    public static void main(String[] args) {
        Pen p1 = new Pen("Flair",25);
        Pen p2 = new Pen("Parker",300);
        Pen p3 = new Pen("Flair",25);
        Pen p4 = p2;

        System.out.println(p4 == p2); // compares refrences;  implicit calling of a method to string but that is used to print only not to change the actual reffrence.
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p3));

        System.out.println(p4);

    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == null || this != o) return false;
//        Pen pen = (Pen) o; // downcasting
//        return (this == o); // this means curr Object. -> p1 , p2 ,p3 ......... this means that obj which is calling this method.
//    }


    @Override
    public boolean equals(Object o) {
        if((o instanceof Pen)){  // for cheking the type first   # if(!(o instanceof Pen)) imp
            Pen pen = (Pen) o; // downcasting for cheking the states
            if (pen == null || this.price != pen.price || this.brand != pen.brand) return false;
            else return pen.price == this.price && pen.brand == this.brand;
        }
        return false;
    }


    @Override
    public String toString() {
        return "Pen{\n" +
                "      brand='" + brand + '\'' +
                ",     price=" + price +
                "\n"+
                '}';
    }
}
