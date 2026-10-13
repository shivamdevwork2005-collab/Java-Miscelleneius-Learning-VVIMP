package FunctionalProgramingJava.Optional;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Supplier;

public class Demo1 {
    public static void main(String[] args) {
        //Optional : It is used to handle null values and empty values why : null pointer exception and empty pointer exception.
        //Optional : EK Box/Container/Wrapper hai jo null values ko handle karta hai .

        //public final class Optional<T> {} It is a class in java.

        String name = null;
        //Earlier how we are Handling null values (Archive)
        if(name != null) {
            System.out.println(name.length());
        }else{
            System.out.println("No Name Present");
        }

        // System.out.println(name.length()); //null pointer exception

        //Now how we are Handling null values using Optional(Modern Way in Java-8)

        //Optional : Box /Container Object hai  Jisme Value Ho sakti hai Ya Nahi bhi ho sakti.
        //Wrap Yor Object into The Optional and then send or Use it.
        //Aur ye Object jahan ya jiske Pass ja rhi hai us User ko es box Ko dhyan se Kholna Hoga.
        //Aur Ye Box/Container/Wrapper Object ko Use krna hai.

        System.out.println("\nUsing Optional..............\n");

        Optional<String> optionalName = Optional.of("Java"); // Uses: it is used for non_null values like "Java" and "Shiva" etc.
        System.out.println(optionalName);

        Optional<String> emptyName = Optional.empty(); //Uses: it is used for empty values Like null and empty and empty string and empty array and empty collection and empty map eg: Optional.empty()
        System.out.println(emptyName);

        Optional<String> mayBe = Optional.ofNullable(name); //There Can be null values as well Here  Like "null" and "" ;
        System.out.println(mayBe);

        //Checking Or Opening The Optional Box

        System.out.println(optionalName.isPresent()); // true / false
        System.out.println(mayBe.isPresent()); // false

        System.out.println(optionalName.isEmpty()); //false
        System.out.println(mayBe.isEmpty());

        //Retriving The Value From The Optional Box/Container Object

        System.out.println(optionalName.get()); //Java Uses: it is used for Only non_null values like "Java" and "Shiva" etc. If Null comes it throws the exception.
        //System.out.println(mayBe.get()); //Exception in thread "main" java.util.NoSuchElementException: No value present

        //Safe Retrival From Optional Box/Container Object

        System.out.println(optionalName.orElse("No Name")); //Java,  Used: it is used for null values like "null" and "" and Non null values like "Java" and "Shiva" etc. if present then return the value else return the default value which is "No Name".

        System.out.println(mayBe.orElse("Default")); //Default , Because there is null value "null" .

        String temp = optionalName.orElse("No Name");
        System.out.println(temp);

        String temp2 = mayBe.orElse("Default");
        System.out.println(temp2);

        //Suplier: () -> "No Name" //It is a functional interface.
        //Supplier doesn't Take Any Argument but Returns a Value. of Its Type.

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello";
            }
        };

        System.out.println(supplier.get());

        Supplier<String> supplier2 = () -> "Hello";
        System.out.println(supplier2.get());

        Supplier<Integer> supplier3 = () -> 100;
        System.out.println(supplier3.get());


        //OrElseGet() //It Takes an Supplier Function. it executes a func and returns the value.
        String temp3 = optionalName.orElseGet(()->"No Name");
        String temp4 = mayBe.orElseGet(()->"Default"); //Takes Supplier into its Constructor and Provide the Implementation of Test().
        System.out.println(temp3);
        System.out.println(temp4);

        System.out.println(mayBe.orElseGet(()->"Default"));
        System.out.println(optionalName.orElseGet(()->"No Name"));

        //If you want to throw an exception if the value is not present
        //orElseThrow() : It throws an exception if the value is not present.

        try {
            System.out.println(mayBe.orElseThrow()); //Exception in thread "main" java.util.NoSuchElementException: No value present
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        System.out.println(optionalName.orElseThrow()); //What If Value is Present then it will return the value.

        // ifPresent() : It takes a Consumer Function. it executes a func and returns the value.
        //It will execute the func only if the value is present.
        //It is used for only non_null values.

        optionalName.ifPresent(name1 -> System.out.println(name1.length()));
        mayBe.ifPresent(name1 -> System.out.println(name1.length()));

        //ifPresentOrElse() : It takes a Consumer Function. it executes a func and returns the value.it takes 2 Consumer functions.
        //It will execute the func  both if the value is present and not present.
        //It is used for both the null and not null for null default val is printed and for not null val is printed.

        optionalName.ifPresentOrElse(name1 -> System.out.println(name1.length()),()->System.out.println("No Name"));
        mayBe.ifPresentOrElse(name1 -> System.out.println(name1.length()),()->System.out.println("Default"));

        Optional<String> upperCase = Optional.ofNullable(name).map(s -> s.toUpperCase());

        //Map returns an Optional

        Optional<String> upperCase2 = Optional.ofNullable(name).map(s -> s.toUpperCase());
        System.out.println(upperCase2.get());

        //Filter returns an Optional

        Optional<String> filtered = Optional.ofNullable(name).filter(s -> s.startsWith("J"));

        System.out.println(upperCase.get());
        System.out.println(filtered.get());


       //Best Practices: Do Not Use Optional in the Constructor and Entity Class and not in Collections and Return Type  and not as Parameter in Method.

    }
}
