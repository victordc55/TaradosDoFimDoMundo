
import java.io.Console;
import java.io.PrintStream;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VICTOR CUNHA
 */
public class Print {
    // Every method for printing simple strings
    public static final PrintStream out = System.out;
    public static final Scanner in = new Scanner(System.in);
    public static String ask(String s){
        out.print(s);
        return in.nextLine();
    }
    
    public static void print(String s){
        out.print(s);
    }
    
}
