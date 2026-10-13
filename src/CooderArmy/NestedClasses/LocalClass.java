package CooderArmy.NestedClasses;

class Outer3{

    private static int x = 90;
   // x = x+101; //Not Allowed because x must be final or effectively final.

    void greet(){

        int y =30; //Local Variable // Effectively Final variable
        //y+=20; //Effectively Final variable rule :-The variable y must be effectively final

        System.out.println("Hello Greet Outer Method");

        class Local2{
            void sayHello() {
                System.out.println("Hello Local2 Inner class");
                System.out.println(x);
                System.out.println(y); // Why Error : Effectively Final variable rule :-The variable y must be effectively final
                //Effectively Final variable :- The var should either final or effectively final mean sif not declared final but behaves like final.
            }
        }

        Local2 local2 = new Local2();  //This will Execute when greet() is called from Outer Class;
        local2.sayHello();

    }

}

public class LocalClass {

    public static void main(String[] args) {
        final int x = 10;
        if(x >= 10){
            class Local{
                void display() {
                    System.out.println("x = " + x);
                }
            }

            Local local = new Local();
            local.display();
        }

        // -----------------------------------------------------------------
        Outer3 outer3 = new Outer3();
        outer3.greet();


    }
}
