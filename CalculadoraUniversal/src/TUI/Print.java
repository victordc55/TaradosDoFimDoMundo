package TUI;


import java.io.Console;
import java.io.PrintStream;
import static java.lang.System.err;
import java.util.OptionalInt;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Print {
    // Every method for printing simple strings
    public static final PrintStream out = System.out;
    public static final Scanner in = new Scanner(System.in);
    /**
     * Imprima no output uma string e lê e devolve uma linha do output.
     * @param s - string a imprimir.
     * @return Linha lida.
     */
    public static String ask(String s){
        out.print(s);
        return in.nextLine();
    }
    /**
     * Imprima no output uma string.
     * @param s - string a imprimir.
     */
    public static void print(String s){
        out.print(s);
    }
    
    public static void printErro(String s){
        err.print(s);
    }
    
   /**
     * Le do input e devolve o inteiro lido
     * @param s
     * @return 
     */
    public static OptionalInt getInt(){
            String input = in.nextLine();
            try{
                return OptionalInt.of( Integer.parseInt(input));
            }catch(Exception e){
                return OptionalInt.empty();
            }
    }
    
}
