/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.OptionalInt;

/**
 *
 * @author VICTOR CUNHA
 */
public interface IPrinter {
    
    public void setPrintMode(int mode);

    /**
     * Imprima no ecrã um temporalAccessor passado como parametro segundo um padrão
     * Este metodo so imprime o que recebe segundo o padrão logo pode vir a não imprimir nada caso o temporalAccessor passado
     * não possui as informações esperadas pelo padrão.
     * Exemplos de temporal Accessor que não dao nada: Instant, MonthDay, DayOfWeek,Year,Month, YearMonth.
     * @param t 
     */
    public void print(TemporalAccessor t);
    

    public void print(Duration d);
    /**
    * Variação de print(Duration). Imprima anos,meses, dias, horas,minutos,segundos,millisegundos.Aproximado.
    */
    public void printBigDuration(Duration d);
    
    public void print(Period p);
    

    /**
     * Imprima no output uma string e lê e devolve uma linha do output.
     * @param s - string a imprimir.
     * @return Linha lida.
     */
    public String ask(String s);
    /**
     * Imprima no output uma string.
     * @param s - string a imprimir.
     */
    public void print(String s);
    
    public void printErro(String s);
    
    public void print(boolean b);
    /** Recupera, se possivel, um inteiro do input. */
    public OptionalInt getInt();
    
    public OptionalInt getPositiveInt();
    
    public LocalDate pedirData();
    
    public LocalTime pedirHoras();
    
    public LocalDate pedirComSemana();
        
    public IPrinter clone();
}
