package TUI;


import static java.lang.System.err;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.OptionalInt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Printer {
//    // Every method for printing simple strings
//    public static final PrintStream out = System.out;
//    public static final Scanner in = new Scanner(System.in);
//    private static final String completeNumericalPattern = "[d-M-yyyy ][H:mm:ss ][VV ][O ][G]";
//    private static final String extendedPattern = "[EEEE d MMMM yyyy ][H:mm:ss ][VV ][OOOO ]['Era' G ]['Trimestre' Q]";
//    private static DateTimeFormatter printFormat = DateTimeFormatter.ofPattern(completeNumericalPattern);
     
	
    
    
    @SuppressWarnings("unused")
	public static void setPrintMode(int mode){
    	DateTimeFormatter printFormat = new Utils().getPrintFormat();
        if( mode== 2 ){
        	
        	printFormat = DateTimeFormatter.ofPattern(new Utils().getExtendedPattern());
        }
        else{
        	printFormat = DateTimeFormatter.ofPattern(new Utils().getCompleteNumericalPattern());
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
              Printer.print( new Utils().getPrintFormat().format(t) );
        }
    }
    

    public static void print(Duration d){
          if( d != null){
              long horas = d.toHours();
              if(horas > 0){
                  new Utils().getOut().print(horas + " horas ");
              }
              long min = d.toMinutes() - horas *60;
              if(min > 0){
            	  new Utils().getOut().print( horas + " min ");
              }
              new Utils().getOut().print( ( ( d.get(ChronoUnit.SECONDS) / 60.0) - min) * 60  + " segundos e ");
              new Utils().getOut().println( d.get(ChronoUnit.NANOS) / Math.pow(10,6) + " millisegundos" );
             
          }
    }
    /**
    * Variação de print(Duration). Imprima anos,meses, dias, horas,minutos,segundos,millisegundos.Aproximado.
    */
    public static void printBigDuration(Duration d){
        if(d != null){
            long anos =(long)(d.toDays() / 365); // Assume 1 year = 365.25 always. Wich means some days might be losts, maybe.
            if(anos != 0){
                if( anos == 1)
                	new Utils().getOut().print( anos + " ano ");
                else new Utils().getOut().print( anos + " anos ");
            }
            long meses =(long) (d.toDays() / 30.42) - (anos * 12); // Assuma-se 1 mes = 30 dias sempre logo ganha-se/perda-se meses, provavelmente.
            if( meses != 0){
                if( meses == 1)
                	new Utils().getOut().print(meses +" mes ");
                else new Utils().getOut().print(meses +" meses ");
            }
            long dias;
            if(meses > 0) dias = (long)( d.toDays() - anos*365.25 + meses * 30.42 );
            else dias = (long)( d.toDays() - (anos*365.25) - (meses * 30.42) );
            if( dias != 0){
                 if( dias == 1)
                	 new Utils().getOut().print( dias + " dia ");
                 else new Utils().getOut().print(dias + " dias ");
            }
            long horas = (long) d.toHours() - (d.toDays()/24);
            if(horas != 0){
                 if( horas == 1)
                	 new Utils().getOut().print(horas + " hora ");
                 else new Utils().getOut().print(horas + " horas ");
              }
            long min = d.toMinutes() - d.toHours()*60;
            if(min != 0){
            	new Utils().getOut().print( min + " min ");
            }
            long segundos = d.get(ChronoUnit.SECONDS) - d.toMinutes() *60;
            if( segundos != 0)
            	new Utils().getOut().print( segundos  + " segundos ");
            new Utils().getOut().println( d.get(ChronoUnit.NANOS) / Math.pow(10,6) + " millisegundos" );
        }
        
    }
    
    public static void print(Period p){
           if( p != null){
               Period period = p.normalized();
               new Utils().getOut().println(  "Anos: " +period.get(ChronoUnit.YEARS) + " \tMeses: " + period.get(ChronoUnit.MONTHS) + " \tDias: "+ period.get(ChronoUnit.DAYS) );       
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
    	new Utils().getOut().print(s);
        return new Utils().getIn().nextLine();
    }
    /**
     * Imprima no output uma string.
     * @param s - string a imprimir.
     */
    public static void print(String s){
    	new Utils().getOut().println(s);
    }
    
    public static void printErro(String s){
        err.print(s);
    }
    
    public static void print(boolean b){
    	new Utils().getOut().println(b);
    }
    
   /**
     * Le do input e devolve o inteiro lido
     * @param s
     * @return 
     */
    public static OptionalInt getInt(){
            String input = new Utils().getIn().nextLine();
            try{
                return OptionalInt.of( Integer.parseInt(input));
            }catch(Exception e){
                return OptionalInt.empty();
            }
    }
    
    public static OptionalInt getPositiveInt(){
           String input = new Utils().getIn().nextLine();
           try{
               int intInput = Integer.parseInt(input);
               if( intInput >= 0) return OptionalInt.of(intInput);
           }catch(Exception e){
           }
           return OptionalInt.empty();
    }
    
    
 public static LocalDate pedirData(){
        
        print("Ano: ");
        OptionalInt ano = Printer.getPositiveInt();
        print("Mês: ");
        OptionalInt mes = Printer.getPositiveInt();
        print("Dia: ");
        OptionalInt dia = Printer.getPositiveInt();
        if((ano != null) && (mes != null) && (dia != null) && (ano.isPresent()) && (mes.isPresent()) && (dia.isPresent())){
        	LocalDate lt = LocalDate.of(ano.getAsInt(), mes.getAsInt(), dia.getAsInt());
            return lt;
        }else{
        	return null;
        }
        
    }
    
    public static LocalTime pedirHoras(){
        print("Hora: ");
        OptionalInt hora = Printer.getInt();
        print("Minutos: ");
        OptionalInt min = Printer.getInt();
        print("Segundos: ");
        OptionalInt seg = Printer.getInt();
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
    
    public static LocalDate pedirComSemana(){
        LocalDate local = pedirData();
        if( local == null) return null;
        print("Semanas: ");
        OptionalInt semanas =  Printer.getPositiveInt();
        if( semanas.isPresent())
            local = local.plusWeeks(semanas.getAsInt());
        else return null;
        return local;
    }
    
    

}
