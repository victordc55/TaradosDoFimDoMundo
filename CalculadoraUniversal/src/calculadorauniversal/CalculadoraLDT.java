/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import Datas.CalculoLDT;
import Datas.EstacaoTemperada;
import TUI.CalculoUIFactory;
import TUI.PedidoDatasHorasUI;
import TUI.Printer;
import TUI.TextualUI;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import static java.time.Period.ZERO;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Scanner;

/**
 *
 * 
 */
public class CalculadoraLDT implements ICalculadoraLDT{
 
    private static CalculoLDT ldt;

    public CalculadoraLDT(){
        ldt = new CalculoLDT();
    }
 
    public Optional<LocalDate> addSubDatas(TemporalAccessor data, TemporalAccessor valor, boolean bool) {
        LocalDate res = LocalDate.from(data);
        LocalDate val = LocalDate.from(valor);
        LocalDate zero = LocalDate.of(0, 1, 1);
        long nDias = zero.until(val, DAYS)+31;
        if (bool) 
          return ldt.addicionarAData(res, nDias, DAYS);
        
        else
          return ldt.addicionarAData(res, -nDias, DAYS);      
    }

    public Optional<LocalTime> addSubHoras(TemporalAccessor horas, TemporalAccessor valor, boolean bool) {
        LocalTime res = LocalTime.from(horas);
        LocalTime val = LocalTime.from(valor);
        LocalTime zero = LocalTime.MIN;
        long nSegundos = zero.until(val, SECONDS);
        if (bool) {
            return ldt.adicionarTempos(res, nSegundos, SECONDS);
        }
        else {   
            return ldt.adicionarTempos(res, -nSegundos, SECONDS);
        }
       
    }

    @Override
    public LocalDateTime addSubTempos(TemporalAccessor tempos, TemporalAccessor valor, boolean bool) {
        
        LocalDateTime res = LocalDateTime.from(tempos);
        LocalDateTime val = LocalDateTime.from(valor);
        LocalDateTime zero = LocalDateTime.of(0, 1, 1, 0, 0);
        long nTempo = zero.until(val, SECONDS) + 31*24*3600  ;
        if(bool)
            return ldt.addicionarADateTime(res, nTempo, SECONDS);
        else
            return ldt.addicionarADateTime(res, -nTempo, SECONDS);
    }

    public Optional<Duration> diferencaEntreTempos(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal, boolean bool) {
        if (bool) {
            return ldt.diferençaTempos(tempoInicial, tempoFinal);
        }
        else {
            return ldt.diferencaDateTime(tempoInicial, tempoFinal);
        }
    }
    public Optional<Period> diferencaEntreDatas(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal){
        return ldt.diferencaData(tempoInicial, tempoFinal);
    }

    public void tempoAteData(TemporalAccessor tempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void curiosidades(TemporalAccessor tempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data) {
        return ldt.diaDaSemana(data);
    }

    public OptionalInt trimestre(TemporalAccessor data) {
        return ldt.trimestre(data);
    }

    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data) {
        return ldt.numeroDoDiaNoAno(data);
    }

    public OptionalInt semanaNoAno(TemporalAccessor data) {
        return ldt.semanaNoAno(data);
    }

    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data, boolean isNorth) {
        if(isNorth)
            return ldt.estaçãoDoAnoNorte(data);
        else 
            return ldt.estaçãoDoAnoSul(data);
    }

    public boolean isLeap(TemporalAccessor data) {
        return ldt.isLeap(data);
    }
}

