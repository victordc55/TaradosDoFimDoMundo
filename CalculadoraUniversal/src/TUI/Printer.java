package TUI;


import java.io.Console;
import java.io.PrintStream;
import static java.lang.System.err;
import java.time.Duration;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.OptionalInt;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Printer {
    // Every method for printing simple strings
    public static final PrintStream out = System.out;
    public static final Scanner in = new Scanner(System.in);
    private DateTimeFormatter printFormat;
    private static final String numericalPattern = "d-M-yyyy H:mm:ss VV O G ";
    private static final String extendedPattern = "EEEE d MMM yyyy H:mm:ss VV OOOO 'Era' G 'Trimestre' Q";
    
    public Printer(){
        printFormat = DateTimeFormatter.ofPattern(numericalPattern);
    }
    
    public Printer(int printModeWanted){
        if( printModeWanted == 2 )
            printFormat = DateTimeFormatter.ofPattern(extendedPattern);
        else printFormat = DateTimeFormatter.ofPattern(numericalPattern);
    }
    
    public void setPrintMode(int mode){
        if( mode == 2 )
            printFormat = DateTimeFormatter.ofPattern(extendedPattern);
        else printFormat = DateTimeFormatter.ofPattern(numericalPattern);
    }
    
    public void print(TemporalAccessor t){
        if( t != null){
              Printer.print( printFormat.format(t) );
        }
    }

    public void print(Duration d){
          if( d != null){
              out.println( d.get(ChronoUnit.SECONDS) + ":" + d.get(ChronoUnit.NANOS));
          }
    }
    
    public void print(Period p){
           if( p != null){
               Period period = p.normalized();
               out.println(  "Anos: " +p.get(ChronoUnit.YEARS) + " \tMeses: " + p.get(ChronoUnit.MONTHS) + " \tDias: "+ p.get(ChronoUnit.DAYS) );       
           }
    }
    
    /*Numérico (ex:9-10-2017 15:52:18  +00:00GMT L/P 4) .",*/                                  
    /*"Expandido (ex: Sabado 9 Outubro 2017 15:55:18 +00:00GMT Lisbon/Portugal Trimestre 4).",*/

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
        out.println(s);
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
    
    public static OptionalInt getPostiveInt(){
           String input = in.nextLine();
           try{
               int intInput = Integer.parseInt(input);
               if( intInput >= 0) return OptionalInt.of(intInput);
           }catch(Exception e){
           }
           return OptionalInt.empty();
    }
    
}
