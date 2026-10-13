package CooderArmy.StdInpOp;

import java.io.*;

public class Demo02 {
    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in); // InputStreamReader is a bridge from byte streams to character streams
        BufferedReader br = new BufferedReader(isr); // BufferedReader is storing the character streams from os buffer to java buffer.
        try {
            String str = br.readLine();
            System.out.println(str);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in)); //Directly creating BufferedReader object


    }
}
