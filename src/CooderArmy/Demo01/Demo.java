package CooderArmy.Demo01;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Args Length is "+args.length);

        for(int i=0;i<args.length;i++){
            System.out.println("Args "+i+" is "+args[i]);
        }

        int x =10;
        Integer y = x;  //AutoBoxing
        Integer z = Integer.valueOf(x); //Static Method  // behind the scene

        int k = y; //UnBoxing
        int k1 = y.intValue(); // Behind the scene //Non_static Method


    }
}


/*
    PS C:\Users\shiva\OneDrive\Desktop\Abstraction\src> java CooderArmy.Demo01.Demo Adarsh Ojha Shivam Rohit Negi
    Args Length is 5
    Args 0 is Adarsh
    Args 1 is Ojha
    Args 2 is Shivam
    Args 3 is Rohit
    Args 4 is Negi
 */