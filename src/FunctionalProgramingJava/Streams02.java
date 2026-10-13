package FunctionalProgramingJava;

public class Streams02 {
    public static void main(String[] args) {
        //Stream Pipeline:-
        //1. Source
        //2. Intermediate operation
        //3. Terminal operation

        //1. Source:-
        //List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        //Stream<String> stream = names.stream();

        //2. Intermediate:-
        //stream.filter(s -> s.startsWith("A"));

        //3. Terminal:-
        //stream.forEach(System.out::println);

        //Intermediate operations are lazy and return a stream.
        //Terminal operations are eager and return a result or void.

        //Intermediate operations: filter, map, flatMap, sorted, distinct, limit, skip, peek
        //Terminal operations: forEach, collect, reduce, count, findAny, findFirst, anyMatch, allMatch, noneMatch

        //Example:-
        //List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        //Stream<String> stream = names.stream();
        //stream.filter(s -> s.startsWith("A")).forEach(System.out::println);

        //To Perform some series of operations on a stream we need to chain them together.


        /*
            A. ArrayList
            List<Integer> list = List.of(10, 20, 30);
            list.stream()
            .filter(n -> n > 15)
            .forEach(System.out::println);

           //B. LinkedList
           LinkedList<Integer> linkedList = new LinkedList<>(list);
           linkedList.stream()
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //C. HashSet
            HashSet<Integer> hashSet = new HashSet<>(list);
            hashSet.stream()
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //D. TreeSet
            TreeSet<Integer> treeSet = new TreeSet<>(list);
            treeSet.stream()
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //E. Stream
            Stream<Integer> stream = list.stream();
            stream
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //F. Stream.of()
            Stream.of(10, 20, 30)
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //G. Stream.iterate()
            Stream.iterate(10, n -> n + 10)
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //H. Stream.generate()
            Stream.generate(() -> 10)
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //I. Stream.iterate()
            Stream.iterate(10, n -> n + 10)
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //J. Stream.generate()
            Stream.generate(() -> 10)
            .filter(n -> n > 15)
            .forEach(System.out::println);

            //k.HashMap
            Map<Integer, String> map = new HashMap<>();

            map.put(1, "Shivam");
            map.put(2, "Rahul");

            map.entrySet().stream().filter(e -> e.getValue().equals("Shivam"))
            .forEach(System.out::println);


            Collection: stores elements.
            Stream: processes elements from a source.
            stream(): creates a sequential Stream from a collection.
            parallelStream(): creates a Stream intended for parallel processing.

            Not quite. HashMap itself doesn't provide stream(). becouse it itself doesnt stores data internaly LinkedList or ArrayList of Array is used.


         */


        //Working With Examples.





























    }

}
