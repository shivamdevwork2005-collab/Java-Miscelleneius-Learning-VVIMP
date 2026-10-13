package FunctionalProgramingJava;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateInterface {

    //It is a boolean valued functional interface hai //    boolean test(T t);

    public static Predicate<Integer> p = (a)-> a > 10;   // providing impl for test() method.

    public static void main(String[] args) {
        System.out.println(p.test(90));

        Predicate<String> p2 = (str) -> str.length() > 5;
        System.out.println(p2.test("Hello"));

        Predicate<String> p3 = (str)->{
            System.out.println(str);
            System.out.println("String length is greater than 5 or less than 5");
            return str.length() >= 5;
        };

        System.out.println();
        System.out.println(p3.test("Hello"));

        System.out.println();

        Predicate<Integer> isEven = (a) -> a % 2 == 0;
        System.out.println(isEven.test(10));

        System.out.println(isEven.test(13));

        //Bi predicate

        BiPredicate<Integer,Integer> sumGreaterThan100 = (a,b)->(a+b) > 100;
        System.out.println(sumGreaterThan100.test(50,60));

    }
}
