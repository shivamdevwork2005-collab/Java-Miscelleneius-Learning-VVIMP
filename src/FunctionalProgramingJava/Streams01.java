package FunctionalProgramingJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Streams01 {
    public static void main(String[] args) {
        //Streams:-Creates a stream from the collection
        //Stream is a sequence of elements supporting sequential and parallel aggregate operations.

        //A Stream is not a data structure; it doesn't store the elements itself.
        //It processes data from a source such as an ArrayList, Set, or array.
        //It does not modify the original collection just by filtering or mapping it.

        //Creating a stream from a collection
        //List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        //Stream<String> stream = names.stream();

        // Intermediate operations return another Stream and are generally lazy.
        //Example: filter(), map(), sorted() , flatMap() , peek() , limit() , skip() , distinct() .

        //Terminal operations return a result or a void.
        //Example: count(), forEach(), collect() , reduce() , match() , anyMatch() , allMatch() , noneMatch()
        //Example: findFirst() , findAny() , min() , max() .


        /*

          1. Why do we need Streams?
            Imagine you have 1,000 employees and want to:
            1. Select employees whose salary is greater than ₹50,000.
            2. Extract their names.
            3. Sort those names.
            4. Print them.
            With traditional Java, you might write multiple loops and temporary collections. Streams let you describe the processing steps as a pipeline:


           Source	How to create a Stream:-
            ArrayList	            list.stream()
            LinkedList	            list.stream()
            HashSet	                set.stream()
            HashMap	                map.entrySet().stream()
            Array	                Arrays.stream(arr)
            Direct values	        Stream.of(10, 20, 30)
            File lines	            Files.lines(path)
            Numeric ranges	        IntStream.range(1, 6)
            Empty Stream	        Stream.empty()
            From a file	        Files.lines(Paths.get("file.txt"))
            From Functions      Stream.iterate(0, n->n+1);
            From Collection	    collection.stream()
        */

        System.out.println("=============================== Begin ===================================");

        // Streams: Assembly Line or Pipeline hai ;

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry","Appleton");

        fruits.forEach(System.out::println);

        Stream<String> stream = fruits.stream();
        //stream.forEach(item -> System.out.println(item)); //One Stream can be used only once.

        Stream<String> newStream = stream.filter(s -> s.startsWith("App"));
        newStream.forEach(item -> System.out.println(item));
        System.out.println();

        fruits.stream().filter(s -> s.startsWith("App")).forEach(System.out::println);

        /*
            Use Case:
            1. Filter
            2. Extract their names
            3. Sort names
            4. Print them
            5. Mapping
            6. Aggregation
            7. Collecting.
            8. Terminating
            9. Searching
            10. Parallelism
            11. Iteration
            12. Creation
         */


    }
}
