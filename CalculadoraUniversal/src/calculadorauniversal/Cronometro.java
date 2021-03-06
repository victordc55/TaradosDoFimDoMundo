/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.util.Optional;

/**
 *
 * 
 */
public class Cronometro implements ICronometro {
    
    private ZonedDateTime startOfCrono;
    private ZonedDateTime endOfCrono;
    private boolean started;
    private boolean ended;
    
    
    public Cronometro(){
        startOfCrono = null;
        endOfCrono = null;
        started = false;
        ended = false;
    }
    
    public boolean start(){
        if(ended && !started){
            ended = false;
            started = true;
            startOfCrono = ZonedDateTime.now().minus( Duration.between(startOfCrono, endOfCrono));
            return true;
        }if( !started){
            startOfCrono = ZonedDateTime.now();
            ended = false;
            started = true;
            return true;
        }else return false;
    }
    
    public Optional<Duration> stop(){
        if(!ended && started){
            endOfCrono = ZonedDateTime.now();
            ended = true;
            started = false;
            endOfCrono = endOfCrono.withZoneSameInstant(startOfCrono.getZone());
            return Optional.ofNullable(Duration.between(startOfCrono, endOfCrono));
        }
        else return Optional.empty();
    }
    
    public boolean reset(){
        if( ended && !started){
                startOfCrono = null;
                endOfCrono = null;
                started = false;
                ended = false;
                return true;
        }else return false;
    }
            
}
