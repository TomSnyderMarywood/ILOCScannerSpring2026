package edu.marywood.iloc;
import java.io.IOException;

/**
 * <p><b>ILOC</b> (Intermediate Language for an Optimizing Compiler) compiler.</p>
 * <p>ILOC is like assembly language for a simple RISC (Reduced Instruction Set Computer) machine.</p>
 *
 * Note: This is the starting point for you to add your own code using the Scanner class methods:
 * <ul>
 *  <li>nextChar</li>
 *  <li>pushChar</li>
 *  <li>peekChar</li>
 * </ul>
 */
public class ILOC {
    private static Scanner myScanner;

    /**
     * <p><b>main</b> entry point of ILOC compiler</p>
     * @param args required file name located in input folder
     */
    static void main(String[] args) {
        String inFile = "";
        String outFile = "";

        System.out.println("Calling the program...");
        if (args.length > 0) {
            System.out.println("SUCCESS: Parameter(s) passed");
            inFile = args[0];
            if (args.length > 1) {
                outFile = args[1];
            } else {
                outFile = args[0];
            }
            System.out.printf("Infile: %s, Outfile: %s%n", inFile, outFile);
        } else {
            System.out.println("FAILURE: You must pass a parameter");
            System.exit(1);
        }

        try {
            myScanner = new Scanner(inFile);
            int c = 'a';
            while (c != -1) {
                c = myScanner.nextChar();
                System.out.print((char)c);
            }
            System.out.println("Reached the end of the file.");
        }
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }
        finally {
            myScanner.closeScanner();
        }

        System.out.println("Finishing successfully.");
        System.exit(0);

    }
}

