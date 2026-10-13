package FunctionalProgramingJava;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionInterface {

    public static BiFunction<Integer , Integer , Integer> add = (a,b)->(a+b);  // apply method implementation we are providing here;
    public static BiFunction<Integer , Integer , Integer> sub = (a,b)->(a-b);

    public static Function<Integer,Integer> mul = (a)->a*10;

    public static BiFunction<Integer,Integer,Integer> combine = add.andThen(mul);

    public static void main(String[] args) {

        int result1 = add.apply(10,20);
        System.out.println(result1);
        int result2 = add.apply(20,80);
        System.out.println(result2);

        System.out.println(sub.apply(10,20));
        System.out.println(sub.apply(20,80));

        BiFunction<String,Integer,String> concat = (s1,s2)->(s1+s2);
        System.out.println(concat.apply("Hello ", 10));
        System.out.println(concat.apply("Hello ", 20));
        System.out.println(concat.apply("Hello ", 30));

        BiFunction<String,Integer,String> concat2 = new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) {
                return s+integer;
            }
        };

        System.out.println(concat2.apply("Hello ", 10));
        System.out.println(concat2.apply("Hello ", 20));
        System.out.println(concat2.apply("Hello ", 30));


        System.out.println(combine.apply(10,20));

        System.out.println();

        BiFunction<String,Integer,String> formater = (title,price)-> title+ "Costs $"+price;
        System.out.println(formater.apply("Laptop ", 1000));
        System.out.println(formater.apply("Tab ", 2000));
        System.out.println(formater.apply("MackBook ", 3000));


    }

}
