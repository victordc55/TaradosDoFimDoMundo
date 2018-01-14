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

public class Printer implements IPrinter {
//    // Every method for printing simple strings
    private PrintStream out;
    private Scanner in;
    private String completeNumericalPattern ;
    private String extendedPattern ;
    private DateTimeFormatter printFormat ;
    private int mode;
     
    private Printer(){
        out = System.out;
        in = new Scanner(System.in);
        completeNumericalPattern = "[d-M-yyyy ][H:mm:ss ][VV ][O ][G]";
        extendedPattern = "[EEEE d MMMM yyyy ][H:mm:ss ][VV ][OOOO ]['Era' G ]['Trimestre' Q]";
        printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
        mode = 1;
    }
    
    public static IPrinter getPrinter(){
        return new Printer();
    }
    
    
    public void setPrintMode(int mode){
        if( mode== 2 ){
            printFormat = DateTimeFormatter.ofPattern(extendedPattern);
            this.mode = mode;
        }
        else{
            printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
            this.mode = 1;
        }
    }
    
    
    /**
     * Imprima no ecrã um temporalAccessor passado como parametro segundo um padrão
     * Este metodo so imprime o que recebe segundo o padrão logo pode vir a não imprimir nada caso o temporalAccessor passado
     * não possui as informações esperadas pelo padrão.
     * Exemplos de temporal Accessor que não dao nada: Instant, MonthDay, DayOfWeek,Year,Month, YearMonth.
     * @param t 
     */
    public void print(TemporalAccessor t){
        if( t != null){
              print( printFormat.format(t) );
        }
    }
    

    public void print(Duration d){
          if( d != null){
              long horas = d.toHours();
              if(horas > 0){
                  out.print(horas + " horas ");
              }
              long min = d.toMinutes() - horas *60;
              if(min > 0){
                  out.print( horas + " min ");
              }
              out.print( ( ( d.get(ChronoUnit.SECONDS) / 60.0) - min) * 60  + " segundos e ");
              out.println( d.get(ChronoUnit.NANOS) / Math.pow(10,6) + " millisegundos" );
             
          }
    }
    /**
    * Variação de print(Duration). Imprima anos,meses, dias, horas,minutos,segundos,millisegundos.Aproximado.
    */
    public void printBigDuration(Duration d){
        if(d != null){
            long anos =(long)(d.toDays() / 365); // Assume 1 year = 365.25 always. Wich means some days might be losts, maybe.
            if(anos != 0){
                if( anos == 1)
                    out.print( anos + " ano ");
                else out.print( anos + " anos ");
            }
            long meses =(long) (d.toDays() / 30.42) - (anos * 12); // Assuma-se 1 mes = 30 dias sempre logo ganha-se/perda-se meses, provavelmente.
            if( meses != 0){
                if( meses == 1)
                    out.print(meses +" mes ");
                else out.print(meses +" meses ");
            }
            long dias;
            if(meses > 0) dias = (long)( d.toDays() - anos*365.25 + meses * 30.42 );
            else dias = (long)( d.toDays() - (anos*365.25) - (meses * 30.42) );
            if( dias != 0){
                 if( dias == 1)
                     out.print( dias + " dia ");
                 else out.print(dias + " dias ");
            }
            long horas = (long) d.toHours() - (d.toDays()/24);
            if(horas != 0){
                 if( horas == 1)
                  out.print(horas + " hora ");
                 else out.print(horas + " horas ");
              }
            long min = d.toMinutes() - d.toHours()*60;
            if(min != 0){
                  out.print( min + " min ");
            }
            long segundos = d.get(ChronoUnit.SECONDS) - d.toMinutes() *60;
            if( segundos != 0)
                out.print( segundos  + " segundos ");
              out.println( d.get(ChronoUnit.NANOS) / Math.pow(10,6) + " millisegundos" );
        }
        
    }
    
    public void print(Period p){
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
    public String ask(String s){
        out.print(s);
        return in.nextLine();
    }
    /**
     * Imprima no output uma string.
     * @param s - string a imprimir.
     */
    public void print(String s){
        out.println(s);
    }
    
    public void printErro(String s){
        err.print(s);
    }
    
    public void print(boolean b){
    	out.println(b);
    }
    
   /**
     * Le do input e devolve o inteiro lido
     * @param s
     * @return 
     */
    public OptionalInt getInt(){
            String input = in.nextLine();
            try{
                return OptionalInt.of( Integer.parseInt(input));
            }catch(Exception e){
                return OptionalInt.empty();
            }
    }
    
    public OptionalInt getPositiveInt(){
           String input = in.nextLine();
           try{
               int intInput = Integer.parseInt(input);
               if( intInput >= 0) return OptionalInt.of(intInput);
           }catch(Exception e){
           }
           return OptionalInt.empty();
    }
    
    public LocalDate pedirData(){
        
        print("Ano: ");
        OptionalInt ano = getPositiveInt();
        print("Mês: ");
        OptionalInt mes = getPositiveInt();
        print("Dia: ");
        OptionalInt dia = getPositiveInt();
        if((ano != null) && (mes != null) && (dia != null) && (ano.isPresent()) && (mes.isPresent()) && (dia.isPresent())){
        	LocalDate lt = LocalDate.of(ano.getAsInt(), mes.getAsInt(), dia.getAsInt());
            return lt;
        }else{
        	return null;
        }
        
    }
    
    public LocalTime pedirHoras(){
        print("Hora: ");
        OptionalInt hora = getInt();
        print("Minutos: ");
        OptionalInt min = getInt();
        print("Segundos: ");
        OptionalInt seg = getInt();
        if((hora != null) && (min != null) && (seg != null)){
            LocalTime lt  = null;
            try{
                 lt = LocalTime.of(hora.getAsInt(), min.getAsInt(), seg.getAsInt());
            }catch(Exception e){};
            return lt;
        }else{
        	return null;
        }
        
    }
    
    public LocalDate pedirComSemana(){
        LocalDate local = pedirData();
        if( local == null) return null;
        print("Semanas: ");
        OptionalInt semanas =  getPositiveInt();
        if( semanas.isPresent())
            local = local.plusWeeks(semanas.getAsInt());
        else return null;
        return local;
    }   
    
    public IPrinter clone(){
        IPrinter r = new Printer();
        r.setPrintMode(mode);
        return r;
    }
}

