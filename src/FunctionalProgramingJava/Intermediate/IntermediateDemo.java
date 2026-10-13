package FunctionalProgramingJava.Intermediate;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateDemo {

    public static Predicate<Book> p = new Predicate<Book>() {
        @Override
        public boolean test(Book book) {
            return book.price < 500;
        }
    };

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book("Effective Java", 2018, "Joshua Bloch", 650.0, "Programming"));
        books.add(new Book("Clean Code", 2008, "Robert C. Martin", 550.0, "Programming"));
        books.add(new Book("The Pragmatic Programmer", 2019, "David Thomas", 700.0, "Programming"));
        books.add(new Book("Atomic Habits", 2018, "James Clear", 400.0, "Self-Help"));
        books.add(new Book("Rich Dad Poor Dad", 1997, "Robert Kiyosaki", 350.0, "Finance"));
        books.add(new Book("Rich Dad Poor Dad", 1997, "Robert Kiyosaki", 350.0, "Finance"));
        books.add(new Book("Think and Grow Rich", 1937, "Napoleon Hill", 300.0, "Finance"));
        books.add(new Book("Head First Java", 2005, "Kathy Sierra", 600.0, "Programming"));
        books.add(new Book("The Alchemist", 1988, "Paulo Coelho", 250.0, "Fiction"));
        books.add(new Book("Deep Work", 2016, "Cal Newport", 450.0, "Productivity"));
        books.add(new Book("Introduction to Algorithms", 2009, "Thomas H. Cormen", 900.0, "Computer Science"));

        //Custom classes ke sath Stream API use karna

        //1. Books cheaper than 500 Filter
        Stream<Book> stream1 = books.stream();
        Stream stream2 = stream1.filter(p);   //stream1.filter(b -> b.price < 500);
        List<Book> bookList = stream2.toList();

        bookList.forEach(b -> System.out.println(b.toString()));

        System.out.println("\n");

        //Map : takes Function as Functional Interface Use: it is used to map/convert one type to another
        Stream<String> upperCaseTitle = books.stream()
                .map(book -> book.title.toUpperCase());

        upperCaseTitle.forEach(System.out::println);

        System.out.println("\n");

        //Sorting
        Stream<Book> sortedBooks = books.stream()
                .sorted(Comparator.comparingInt(book -> book.publicationYear)); //sorting based on publication year

        sortedBooks.forEach(b -> System.out.println(b.toString()));

        System.out.println("\n");

        //Distinct: Or Removing Duplicates

        Stream<Book> uniqueBooks = books.stream()
                .distinct();

        uniqueBooks.forEach(System.out::println);

        System.out.println("\n");

        //Limit : Used to limit the number of elements
        Stream<Book> limitedBooks = books.stream()
                .limit(3); //Display first 3 elements/books

        limitedBooks.forEach(System.out::println);

        System.out.println("\n");

        //Skip : Used to skip the number of elements
        Stream<Book> skippedBooks = books.stream()
                .skip(3); //skipping first 3 elements

        skippedBooks.forEach(System.out::println);

        System.out.println("\n");

        //Count : Used to count the number of elements
        long count = books.stream()
                .count();

        System.out.println("Count: " + count);

        System.out.println("\n");

        //Display first 3 books sorted by Publication year.
        Stream<Book> sortedBooks2 = books.stream()
                .sorted(Comparator.comparingInt(book -> book.publicationYear))
                .limit(3);

        sortedBooks2.forEach(System.out::println);

        System.out.println("\n");

        // We can perform n no of intermediate operations in between

        //Terminal operations
        //forEach, collect, count, reduce, min, max, anyMatch, allMatch, noneMatch, findFirst, findAny

        //forEach : Used to print the elements
        books.stream()
                .forEach(System.out::println);

        System.out.println("\n");

        //reduce : Used to perform a reduction operation on the stream to a single final value
        List<Integer> ls = Arrays.asList(1,2,3,4,5,6);

        Integer sum = ls.stream()
                .reduce(0, (a, b) -> a + b); //Explain: 0 is initial value, (a, b) -> a + b is binary operator a : previous value initially = 0(Accumulator),  b : current value

        System.out.println("Sum: " + sum);


        Integer max = ls.stream()
                .reduce(Integer.MIN_VALUE , (a,b) -> Math.max(a,b));

        System.out.println("Max: " + max);

        Integer min = ls.stream()
                .reduce(Integer.MAX_VALUE , (a,b) -> Math.min(a,b));

        System.out.println("Min: " + min);

        long count1 = ls.stream().count();
        System.out.println("Count: " + count1);

        //min : Used to find the minimum value
        Optional<Integer> min1 = ls.stream().min(Comparator.comparingInt(a -> a));
        System.out.println("Min: " + min1);

        System.out.println("\n");

        //Collect : Used to collect the elements of the stream into a collection
        List<Integer> ls1 = ls.stream().collect(Collectors.toList());
        System.out.println("List: " + ls1);

        List<Integer> ls2 = ls.stream().toList();
        System.out.println("List: " + ls2);

        System.out.println("\n");

        //Sum of all Even Numbers

        long sumOfEven = ls.stream()
                .filter(a -> a % 2 == 0)
                .reduce(0, (a, b) -> a + b); // a: Accumulator | b: Current Value

        System.out.println("Sum of Even Numbers: " + sumOfEven);

        System.out.println("\n");

        //Sum of all Odd Numbers
        long sumOfOdd = ls.stream()
                .filter((a)->a%2!=0)
                .reduce(0, (a,b) -> a+b);

        System.out.println("Sum of Odd Numbers: " + sumOfOdd);

        System.out.println("\n");

        //Average of all numbers
        OptionalDouble average = ls.stream()
                .mapToDouble(a -> a)
                .average();

        System.out.println("Average: " + average);

        //FindFirst
        ls.stream().findFirst().ifPresent(a -> System.out.println(a)); //Consumer
        System.out.println(ls.stream().findFirst().get());

        System.out.println("\n");

        //FindAny
        ls.stream().findAny().ifPresent(System.out::println);
        System.out.println(ls.stream().findAny().get());

        System.out.println("\n");

        //Match : Used to check if any element matches the given condition

        boolean mathced = ls.stream().anyMatch(n -> n==4); //Used : it is used for checking if any element matches the given condition
        System.out.println("Matched: " + mathced); //True

        boolean mathced1 = ls.stream().allMatch(n -> n==6); //Used : it is used for checking if all elements matches the given condition
        System.out.println("Matched: " + mathced1); //False

        //Iteration
        ls.stream().forEach(System.out::println);
        ls.stream().forEach(a -> System.out.println(a));

        System.out.println("\n");

    }
}
