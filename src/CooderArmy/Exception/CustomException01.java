package CooderArmy.Exception;

import java.util.Scanner;

class IncorrectPasswordExc extends Exception{
    int password;
    IncorrectPasswordExc(int password){
        super("IncorrectPasswordExc: "+password);
        this.password=password;
    }

    @Override
    public String toString() {
        return "IncorrectPasswordExc :" +
                "password=" + password +
                '\n';
    }

}

public class CustomException01 {
    public static void main(String[] args) {      //throws  IncorrectPasswordExc
        Scanner sc = new Scanner(System.in);
        int yourPass = 2005;

        System.out.print("Enter the password :");
        int password = sc.nextInt();

        if(yourPass == password){
            System.out.println("Login Successful");
        }else{
            try{
                throw new IncorrectPasswordExc(password);
            }catch (IncorrectPasswordExc ex) {
                ex.printStackTrace();
                System.out.println('\n');
                System.out.println(ex);
            }

            finally {
                System.out.println("Jai Shree Ram ..............");
            }

        }

        System.out.println("Now Welcome Bro !!!!!!!!!!!!!");

    }

}
