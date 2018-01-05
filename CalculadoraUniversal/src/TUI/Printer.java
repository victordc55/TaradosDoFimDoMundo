package TUI;


import java.io.PrintStream;
import static java.lang.System.err;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
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
    private static final String completeNumericalPattern = "[d-M-yyyy ][H:mm:ss ][VV ][O ][G]";
    private static final String extendedPattern = "[EEEE d MMMM yyyy ][H:mm:ss ][VV ][OOOO ]['Era' G ]['Trimestre' Q]";
    private static DateTimeFormatter printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
     
    
    
    public static void setPrintMode(int mode){
        if( mode== 2 ){
            printFormat = DateTimeFormatter.ofPattern(extendedPattern);
        }
        else{
            printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
        }
    }
    
    /**
     * Imprima no ecrã um temporalAccessor passado como parametro segundo um padrão
     * Este metodo so imprime o que recebe segundo o padrão logo pode vir a não imprimir nada caso o temporalAccessor passado
     * não possui as informações esperadas pelo padrão.
     * Exemplos de temporal Accessor que não dao nada: Instant, MonthDay, DayOfWeek,Year,Month, YearMonth.
     * @param t 
     */
    public static void print(TemporalAccessor t){
        if( t != null){
              Printer.print( printFormat.format(t) );
        }
    }
    

    public static void print(Duration d){
          if( d != null){
              long min = d.toMinutes();
              if(min > 0){
                  out.print(d.toMinutes() + " min ");
              }
              out.print( ( ( d.get(ChronoUnit.SECONDS) / 60.0) - min) * 60.0  + " segundos e ");
              out.println( d.get(ChronoUnit.NANOS) / Math.pow(10,6) + " millisegundos" );
             // out.println( d.get(ChronoUnit.SECONDS) +" s e "+ d.get(ChronoUnit.NANOS) +" nanosegundos");
          }
    }
    
    public static void print(Period p){
           if( p != null){
               Period period = p.normalized();
               out.println(  "Anos: " +period.get(ChronoUnit.YEARS) + " \tMeses: " + period.get(ChronoUnit.MONTHS) + " \tDias: "+ period.get(ChronoUnit.DAYS) );       
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
    
    public static void print(boolean b){
        out.println(b);
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
    
    
 public static LocalDate pedirData(){
        
        print("Ano: ");
        int ano = Printer.getInt().getAsInt();
        print("Mês: ");
        int mes = Printer.getInt().getAsInt();
        print("Dia: ");
        int dia = Printer.getInt().getAsInt();
  //      OptionalInt a = Printer.getInt();
        
        LocalDate ld = LocalDate.of(ano, mes, dia);
        return ld;
        
    }
    
    public static LocalTime pedirHoras(){
        print("Hora: ");
        int hora = Printer.getInt().getAsInt();
        print("Minutos: ");
        int min = Printer.getInt().getAsInt();
        print("Segundos: ");
        int seg = Printer.getInt().getAsInt();
        LocalTime lt = LocalTime.of(hora, min, seg);
        return lt;
    }
    
    public static LocalDate pedirComSemana(){
        LocalDate local = LocalDate.from(pedirData());
        print("Semanas: ");
        int semanas = Printer.getInt().getAsInt();
        local = local.plusWeeks(semanas);
        return local;
    }
    
    

}
