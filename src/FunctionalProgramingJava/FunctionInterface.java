package FunctionalProgramingJava;

import java.util.function.Function;

public class FunctionInterface {

    static void calculate(int number, Function<Integer, Integer> operation) {
        System.out.println(operation.apply(number));
    }

    public static Function<Integer,Integer> addFunction  = (a) -> a+10;
    public static Function<Integer,Integer> subFunction = (a) -> a-10;

    // chaining
    public static Function<Integer,Integer> combine = addFunction.andThen(subFunction);

    public static void main(String[] args) {
        System.out.println(addFunction.apply(10));

        Function<Integer,Integer> subFunction = (a) -> a-10; // implementation of apply method

        System.out.println(subFunction.apply(10));

        Function<Integer,Integer> multiplyFunction = (a) -> a*10;
        System.out.println(multiplyFunction.apply(10));

        Function<Integer,Integer> divideFunction = (a) -> a/10;
        System.out.println(divideFunction.apply(10));

        Function<Integer,Integer> modFunction = (a) -> a%10;
        System.out.println(modFunction.apply(10));

        Function<Integer,Integer> powerFunction = (a) -> a*10;
        System.out.println(powerFunction.apply(10));

        Function<Integer,Integer> squareFunction = (a) -> a*a;
        System.out.println(squareFunction.apply(10));

        Function<Integer,Integer> cubeFunction = (a) -> a*a*a;
        System.out.println(cubeFunction.apply(10));

        Function<Integer,Integer> factorialFunction = (a) -> a;
        System.out.println(factorialFunction.apply(10));

        Function<Integer,Integer> absoluteFunction = (a) -> a;
        System.out.println(absoluteFunction.apply(10));

        Function<String,String> convert = name -> name.toUpperCase();
        System.out.println(convert.apply("shivam"));

        // Function ko variable mein store kar sakte hain, doosre methods ko pass kar sakte hain aur apply() se execute kar sakte hain.


        calculate(5,n->n+10);
        calculate(10,n->n*10);
        calculate(12 , n->n/2);
        calculate(16 , n->n%2);

        // chaining
        System.out.println(combine.apply(20));

    }
}
