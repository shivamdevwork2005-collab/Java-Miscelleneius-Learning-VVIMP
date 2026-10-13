package Example1;

public class Apple extends Fruit{
    String name;
    Apple(String name){
        super("All Type Fruit"); // explicit super calling
        System.out.println("Apple Const Is created");
        this.name = name;
    }
}
