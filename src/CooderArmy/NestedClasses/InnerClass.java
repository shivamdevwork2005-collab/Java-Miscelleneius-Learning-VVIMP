package CooderArmy.NestedClasses;

class Outer2{
    int x1 = 800;
    class Inner2 {  //Now This class Related to the Object of the outer class.
        int x = 90;
        static int y = 900; //staic mem in inner classes are Allowed in Moder java Not in old java.
        void display() {
            System.out.println("x = " + x);
            System.out.println(Outer2.this.x1); //This is the way to access the outer class non-static members.In case of same name variable in both inner and outer class.
            //Or
            System.out.println(x1); //Directly Access the outer class non-static members.
        }
    }

    void fun(){
        System.out.println("Fun Games");
    }

}

public class InnerClass {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        System.out.println(outer2.x1);

        Outer2.Inner2 inner2 = new Outer2().new Inner2(); //This is the way to create the object of the inner non-static class.
        //Or
        Outer2.Inner2 inner3 = outer2.new Inner2(); //You Must have to use ref var or reff Of Outer class. Becouse we can access the inner class only through the outer class Object.
        System.out.println(inner2.x);
        inner2.display();

        outer2.fun();

        //Or
        Outer2.Inner2 inner4 = new Outer2().new Inner2(); //This is used when we do not need outer Reference only Inner class object is required.

        inner4.display();
        System.out.println(Outer2.Inner2.y); //static mem Access.

    }

}

//Properties of Inner class Non-Static
//1. Inner class can access all the members of the outer class including private members.
//2. Inner class can be static only if the outer class is static.
//3. Inner class can be final only if the outer class is final.
//4. Inner class can be abstract only if the outer class is abstract.
//5. Inner class can be public only if the outer class is public.
//6. Inner class can be protected only if the outer class is protected.
//7. Inner class can be private only if the outer class is private.
//8. Every Inner class is implicitly  This reference of Outer class
//9.For every Outer object we have a new inner object present in the memory.

