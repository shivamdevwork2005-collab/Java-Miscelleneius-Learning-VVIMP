package FunctionalProgramingJava;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams03 {
    public static void main(String[] args) {
        //Stream API

        List<Integer> numbers = List.of(10, 20, 31, 40, 50, 61, 70, 83, 90, 105);

        //I want a new List having Only even numbers from above list

        Predicate<Integer> p1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer%2==0;
            }
        };

        System.out.println(p1.test(10));

        Predicate<Integer> p = (n)->n%2==0; //Lambda Expression

        Stream<Integer> stream = numbers.stream();
        Stream<Integer> filteredStream = stream.filter(p);  //Returns a stream consisting of the elements of this stream that match the given predicate.
        List<Integer> evenNumberList = filteredStream.collect(Collectors.toList());

        System.out.println(evenNumberList);

        System.out.println("-----------------------------------------------------------");

        // Chaining of Operations
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(evenNumbers);

        System.out.println("-----------------------------------------------------------");

        String name = "Adarsh";
        name.chars().forEach(Ascii -> System.out.println((char)(Ascii)));  // chars() => Returns a stream of int zero-extending the char values from this sequence. Any char which maps to a surrogate code point is passed through uninterpreted.

        System.out.println("-----------------------------------------------------------");

        name.chars().forEach(item -> System.out.println(item));  // chars() => Returns a stream of int zero-extending the char values from this sequence. Any char which maps to a surrogate code point is passed through uninterpreted.


        System.out.println("-----------------------------------------------------------");

        name.codePoints().forEach(System.out::println);  // codePoints() => Returns a stream of code point values from this sequence of characters .

        System.out.println("-----------------------------------------------------------");

        // Direct values
        Stream<String> stream3 = Stream.of("Java", "Python", "SQL");

        // Array
        int[] arr = {10, 15, 20, 25};

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("-----------------------------------------------------------");

        // New Example
        List<Integer> list  = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream4 = list.stream();
        //System.out.println(stream4); //java.util.stream.ReferencePipeline$Head@5b480cf9
        //System.out.println(stream4.collect(Collectors.toList()));

        //********************************Note********************************
        // Streams Can be traversed only once Or say Used only once // comes from java.util.stream.Stream
        stream4.forEach(System.out::println);

        //********************************Note********************************
        // Streams Can be traversed only once Or say Used only once // comes from java.util.stream.Stream

        Stream<String> fileStream;
        try {
            fileStream = Files.lines(Path.of("C:\\Users\\shiva\\Downloads\\images.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
