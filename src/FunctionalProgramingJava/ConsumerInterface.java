package FunctionalProgramingJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class ConsumerInterface {

    public static Consumer<Integer> consumer1 = (a)->System.out.println(a);
    public static Consumer<Integer> consumer2 = (a)->System.out.println(a*10);

    public static void main(String[] args) {

        Consumer<String> consumer3 = System.out::println;
        consumer3.accept("Hello");

        consumer1.andThen(consumer2).accept(10);

        Consumer<String> consumer4 = a -> System.out.println(a.length());
        consumer4.accept("Hello");

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<Integer> consumer5 = (a)-> System.out.println(a*2);

        System.out.println();
        list.forEach(consumer5);

        list.forEach(System.out::println);
        list.forEach((a)->System.out.println(a*2)); //accept method implementation.


        // BiConsumer<Integer,Integer> consumer6 = (a,b)-> System.out.println(a+b); consumer koi bhi ho it doesn't return anything only consumes;

        BiConsumer<Integer,Integer> addVal = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer integer, Integer integer2) {
                System.out.println(integer+integer2);
            }
        };

        addVal.accept(10, 20);

        System.out.println();

        BiConsumer<Integer,Integer> addVal2 = (a,b)-> System.out.println(a+b);
        addVal2.accept(10, 20);

        System.out.println();

        BiConsumer<String,String> consumer7 = (a,b)-> System.out.println(a.concat(b));
        consumer7.accept("Hello ", "World");

        System.out.println();

    }
}
