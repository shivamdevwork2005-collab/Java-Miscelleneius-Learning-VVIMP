package FunctionalProgramingJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodReffrences {
    public static void main(String[] args) {
        // Method Reference ::
        // :: is a method reference operator

        List<String> names = Arrays.asList("Shivam", "Ojha", "Adarsh", "Raman");
        int[] arr = {1,2,3,4,45,6};

        for(int i=0;i<names.size();i++){
            System.out.println(names.get(i));
        }

        System.out.println();

        for(String name:names){
            System.out.println(name);
        }

        System.out.println();

        // Now Method Reference
       names.forEach(name->System.out.println(name));  //  void accept(T t); is a method of Consumer interface

        System.out.println();

        Consumer c = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

        names.forEach(c);

        System.out.println();

        names.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println();

        names.forEach((name)->{
            System.out.println(name);
        });

        System.out.println();

        names.forEach(name -> System.out.println(name));

        System.out.println();

        names.forEach(System.out::println); // describe this line: System.out::println is a method reference :: is a method reference operator.
        System.out.println();   // Ye lambda expression ka shorter alternative hai.

    }
}
