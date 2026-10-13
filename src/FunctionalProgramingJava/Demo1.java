package FunctionalProgramingJava;
// function Interface : interface with only one abstract method
// Lambda Expression : implementation of function interface
// method reference : reference to existing method
// Stream : collection of data
// Optional : container object may or may not contain a non-null value
// Annotation : metadata
// Why we need functional interface ?
// 1. Lambda Expression : implementation of function interface
// 2. method reference : reference to existing method

// eg: Runnable , Callable , Comparator .

@FunctionalInterface
interface BookAction{
    void perform(); // exactly one abstract method
}

@FunctionalInterface
interface Operation{
    int add(int a , int b);
}


// ()->{} // lambda expression

public class Demo1 {
    public static void main(String[] args) {

        // step 01

        BookAction bookAction = new BookAction() {
            @Override
            public void perform() {
                System.out.println("Reading a book");
            }
        };

        bookAction.perform();

        System.out.println("--------------------------------");

        // step 02 Lambda Expression

        BookAction bookAction1 = () -> {
            System.out.println("Reading a book");
        };

        bookAction1.perform();

        System.out.println("--------------------------------");

        // step 03 Lambda Expression

        BookAction bookAction2 = () -> System.out.println("Reading book");

        bookAction2.perform();

        System.out.println("--------------------------------");


        // Operation Interface

        Operation op0 = new Operation() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };

        System.out.println(op0.add(10,20));

        System.out.println();

        Operation op = (int a , int b)->{
            return a+b;
        };

        System.out.println(op.add(10,20));

        System.out.println();

        Operation op2 = (int a ,int b) -> a+b; // implicit return if 1 line is present

        System.out.println(op2.add(10,20));

        System.out.println();

        // thread creation

        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread Started");
            }
        });

        th.start();

        // Runnable interface

        Runnable r = () -> System.out.println("Thread Started");
        Thread th2 = new Thread(r);
        th2.start();

        Thread th1 = new Thread(()-> System.out.println("Thread Started"));
        th1.start();

        System.out.println();



    }
}
