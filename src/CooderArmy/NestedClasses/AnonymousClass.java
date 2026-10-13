package CooderArmy.NestedClasses;

class Person{
    void introduce() {
        System.out.println("Hi I am a Person");
    }
}

class Guest extends  Person{
    @Override
    void introduce() {
        System.out.println("Hi I am a Guest");
    }
}

public class AnonymousClass {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.introduce();
        Person p2 = new Guest(); //This is Not suggested for One Use class Costly Process.
        p2.introduce();

        //Anonymous class

        Person p3 = new Person() {//Anonymous class: A class With no name | One time use .
            String name = "Adarsh";
            private int num = 90;

            @Override
            void introduce() {
                System.out.println("Hi I am a Anonymous Guest ");
                display();  //We can only use the methods defined in the anonymous class which are not in the parent class.
            }

            void display() {
                System.out.println("Name: " + name + "\nNumber: " + num);
            }

        };
        p3.introduce();
        //p3.display();  //Error becouse in my Parent class persond ther is no method display().


        Guest g1 = new Guest(){  //Anonymous class: Used for Only one time use. and cant have Constructors and we cant create object of it;//Take it as RUn Time class without Name just like a block.
            void greet(){
                System.out.println("Hi I am a Guest in Anonymous class g1");
            }

            @Override
            void introduce() {
                System.out.println("Hi I am a Guest in Anonymous class g1");
            }

        };

        g1.introduce();

    }
}
