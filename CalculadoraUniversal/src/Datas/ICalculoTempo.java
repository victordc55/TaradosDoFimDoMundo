package Datas;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 *
 * 
*/

public interface ICalculoTempo {

    
    /**
     * Devolve a duração entre dois tempos 
     * @param tempo
     * @return 
     */
    public Optional<Duration> diferençaTempos(TemporalAccessor inicio, TemporalAccessor fim); 
    
    
    /**
     * Devolve o tempo entre o tempo atribuido e o valor que é definido 
     * @param tempo
     * @param valor
     * @param unidade
     * @return 
     */
    public Optional<LocalTime> adicionarTempos(TemporalAccessor tempo, long valor, ChronoUnit unidade);
    
    
    /** 
     * Faz a contagem decrescente do tempo.
     * @param tempo
     * @return 
     */
    public Optional<Duration> temporizador(TemporalAccessor tempo);
    
}


