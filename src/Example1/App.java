package Example1;

public class App {
    public static void main(String[] args) {
        Mango m1 = new Mango();
        System.out.println(m1.name);

        System.out.println('\n');

        Apple a1 = new Apple("Apple");
        System.out.println(a1.name);

        System.out.println('\n');

        Fruit f1 = new Apple("Fruit");
        System.out.println(f1.name);

        System.out.println('\n');

        Fruit f2 = new Mango();
        System.out.println(f2.name);

    }
}
