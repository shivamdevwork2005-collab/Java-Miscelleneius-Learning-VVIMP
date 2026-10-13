package CooderArmy.StdInpOp;

import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        //Scanner class introduced in java 1.5 ;
        //It is a part of java.util package
        //It is a final class
        //It is a subclass of java.io.

        Scanner sc = new Scanner(System.in); //This obj expect an obj reff of InputStream System.in in itd Constructor.
        //Kuch bhi ker lo kam to InputStream System.in Ke sath hi kerna padega it is Base/Universal class for taking i/p from keyboard.
        int n = sc.nextInt();
        String str = sc.nextLine();
        System.out.println(n);
        System.out.println(str);

    }
}
