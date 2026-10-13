package CooderArmy.StdInpOp;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws  IOException {

        // ==================== OUTPUT ====================

        // System.out is a static final field of type PrintStream in the System class.
        // PrintStream extends FilterOutputStream and provides methods like println().
        System.out.println("Hello World");
        System.out.flush(); // Force immediate output to prevent out-of-sequence display with System.err

        // System.err is a static final field of type PrintStream used for error messages.
        // Output appears in red color in most IDEs/terminals.
        System.err.println("Hello World");

        // write(int b) writes the specified byte to the output stream.
        // Unicode value 800 corresponds to a character in some encodings.
        System.out.write(800);
        System.out.flush(); // Flushes the stream by writing buffered output bytes to the underlying output stream.

        // ==================== INPUT ====================

        // System.in is a static final field of type InputStream in the System class.
        // Used to read input from the user via the standard input stream.

//        try {
//            System.out.println("Enter a character: ");
//            char ch = (char) System.in.read(); // Reads a single byte and returns it as an int (0-255) // read() ki concrete class kon hai BufferedInputStream.
//            System.out.println("You entered: " + ch);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


//        System.out.println("Enter a number : ");
//        int x = System.in.read();  //It reads data in Binary number formate and returns int only .
//
//        System.out.println("You entered: " + x);

        //Taking Sequence of characters by read() method becouse it reads 1 byte only

        String s = "";
        int ch = 0;
        while(ch != '\n') {
            ch = System.in.read();
            s += (char) ch;
        }
        System.out.write(s.length());
        System.out.flush();
    }
}
