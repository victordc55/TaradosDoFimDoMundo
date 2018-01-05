/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 *
 * 
 */

public class CalculoZdDT implements ICalculoZdDT{

    @Override
    public Optional<ZonedDateTime> adicionarZonedDateTime(TemporalAccessor data, ZoneId zone, long tempo, ChronoUnit unit) {
        try {
            if (data != null) {
                LocalDateTime ldt = LocalDateTime.from(data).plus(tempo, unit);
                ZonedDateTime zdt = ZonedDateTime.of(ldt, zone);
                return Optional.of(zdt);
            }
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.empty();   
    }

    @Override
    public Optional<Duration> diferencaZonedDateTime(TemporalAccessor dataInicial, TemporalAccessor dataFinal) {
        ZonedDateTime inicioI = null;
        ZonedDateTime fimI = null;
        try{
            inicioI = ZonedDateTime.from(dataInicial);
            fimI = ZonedDateTime.from(dataFinal);
        }catch(Exception e ){
            return Optional.empty();
        }
        
        if( inicioI != null && fimI != null){
            return Optional.ofNullable(Duration.between( inicioI, fimI ) );
        }    
        else 
            return Optional.empty();
    }

    @Override
    public Optional<ZonedDateTime> conversaoDeFusos(TemporalAccessor data, ZoneId zone) {
        Instant inst = null;
        try {
            if (data != null) {
                inst = Instant.from(data);
            }
        } catch (Exception e) {
            return Optional.empty();
        }   
        if( inst != null ){
            ZonedDateTime zdt = inst.atZone(zone);
            return Optional.of(zdt);
        }    
        else 
            return Optional.empty();
    }
    
}
