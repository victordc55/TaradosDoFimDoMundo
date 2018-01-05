/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import Datas.CalculoZdDT;
import Datas.EstacaoTemperada;
import Datas.ICalculoZdDT;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author VICTOR CUNHA
 */
public class CalculadoraUniversalISOZDT implements ICalculadoraUniversal{
    
     private static ICalculoZdDT czdt;// calculaZonedDateTime;
    
     public CalculadoraUniversalISOZDT(){
         czdt =  new CalculoZdDT();
     }
     
    public Optional<LocalDate> addSubDatas(TemporalAccessor data, TemporalAccessor valor, boolean bool){
        
        
    }
	    
    public Optional<LocalTime> addSubHoras(TemporalAccessor horas,TemporalAccessor valor, boolean bool){
        
    }
	    
    public LocalDateTime addSubTempos(TemporalAccessor tempos, TemporalAccessor valor, boolean bool){
        
    }
	    
    public Optional<Duration> diferencaEntreTempos(TemporalAccessor dataInicial, TemporalAccessor dataFinal, boolean bool){
         return czdt.diferencaZonedDateTime(dataInicial, dataFinal);
    }
	    
    public Optional<Period> diferencaEntreDatas(TemporalAccessor dataInicial, TemporalAccessor dataFinal){
         return Optional.empty();
    }
	    
    public Optional<Duration> tempoAteData(TemporalAccessor tempo){
        if( czdt.diferencaZonedDateTime(ZonedDateTime.now(), tempo).isPresent())
                return czdt.diferencaZonedDateTime(ZonedDateTime.now(), tempo);
        else return czdt.diferencaZonedDateTime(tempo,ZonedDateTime.now());
    }
	    
    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data){
        return Optional.empty();
    }
	    
	    
    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data){
        return OptionalInt.empty();
    }
	    
    public OptionalInt semanaNoAno(TemporalAccessor data){
        return OptionalInt.empty();
    }
	    
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data, boolean isNorth){
        return Optional.empty();
    }
	  

        @Override
    public Optional<Duration> diferencaEntreFusos(TemporalAccessor ldtInicial, TemporalAccessor ldtFinal) {
        
        return czdt.diferencaZonedDateTime(ldtInicial, ldtFinal);
    }


    public Optional<ZonedDateTime> convertZonedDateTime(TemporalAccessor zdtInicial, ZoneId zone) {
        Instant agora = Instant.from(zdtInicial);
        Optional<ZonedDateTime> zddt = czdt.conversaoDeFusos(agora, zone);
        return zddt;
    }
    
}
