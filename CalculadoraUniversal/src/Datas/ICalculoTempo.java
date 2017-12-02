package trabalho_psdj;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Pedro
*/

public interface ICalculoTempo {

    
    /**
     * Devolve a duração entre dois tempos 
     * @param tempo
     * @return 
     */
    public Duration diferençaTempos(LocalTime inicio, LocalTime fim); 
    
    
    /**
     * Devolve o tempo entre o tempo atribuido e o valor que é definido 
     * @param tempo
     * @param valor
     * @param unidade
     * @return 
     */
    public LocalTime adicionarTempos(LocalTime tempo, long valor, ChronoUnit unidade);
    
    
    /** 
     * 
     * @param tempo
     * @return 
     */
    public Duration temporizador(LocalTime tempo);
    
}


