/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import Query.QueryFactory;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalQuery;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author VICTOR CUNHA
 */
public class NewClass implements ICalculoDatas{
    
    public Optional<Period> diferencaData(LocalDate inicio,LocalDate fim){
        if( inicio != null && fim != null)
            return Optional.of(Period.between(inicio, fim));
        else 
            return Optional.empty();
    }
    
    public long diferencaData(LocalDate inicio,LocalDate fim, ChronoUnit units){
        return Period.between(inicio, fim).get(units);
    }
    
    
     public Optional<LocalDate> addicionarAData(LocalDate inicio, long param, ChronoUnit unidade){
         if( inicio != null && unidade != null && inicio.isSupported(unidade))
                     return Optional.of(inicio.plus(param, unidade) );
         else return Optional.empty();
     }
     
     public Optional<DayOfWeek> diaDaSemana(LocalDate data){
         if( data != null)
                 return Optional.of(DayOfWeek.of( data.get(ChronoField.DAY_OF_WEEK)) );
         else return Optional.empty();
     }
     
     public OptionalInt numeroDoDiaNoAno(LocalDate data){
        // return data.query( d -> d.get(ChronoField.DAY_OF_YEAR));
        if( data == null ) return OptionalInt.empty();
        return OptionalInt.of( data.query(QueryFactory.dayOfYear()) );
     }
     
     public OptionalInt numeroDeDiasNoAno(LocalDate ano){
         if( ano == null ) return OptionalInt.empty();
         return  OptionalInt.of( ano.lengthOfYear() );
     }
     
     public OptionalInt numeroDeDiasNoAno(Year ano){
         if( ano == null) return OptionalInt.empty();
         return OptionalInt.of( ano.atDay(ano.length()).get(ChronoField.DAY_OF_YEAR) ) ;
         
     }
    
}
