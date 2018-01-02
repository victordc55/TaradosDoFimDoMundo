/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 *
 * @author Pedro
 */
public class PedidoDatasHorasUI {
    
    public LocalDate pedirData(){
        
        Printer.print("Ano: ");
        int ano = Printer.getInt().getAsInt();
        Printer.print("Mês: ");
        int mes = Printer.getInt().getAsInt();
        Printer.print("Dia: ");
        int dia = Printer.getInt().getAsInt();
        LocalDate ld = LocalDate.of(ano, mes, dia);
        return ld;
        
    }
    
    public LocalTime pedirHoras(){
        Printer.print("Hora: ");
        int hora = Printer.getInt().getAsInt();
        Printer.print("Minutos: ");
        int min = Printer.getInt().getAsInt();
        Printer.print("Segundos: ");
        int seg = Printer.getInt().getAsInt();
        LocalTime lt = LocalTime.of(hora, min, seg);
        return lt;
    }
    
    public LocalDate pedirComSemana(){
        LocalDate local = LocalDate.from(pedirData());
        Printer.print("Semanas: ");
        int semanas = Printer.getInt().getAsInt();
        local = local.plusWeeks(semanas);
        return local;
    }
    
}
