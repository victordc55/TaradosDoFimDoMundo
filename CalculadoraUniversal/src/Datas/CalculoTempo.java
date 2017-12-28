package Datas;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
public class CalculoTempo implements ICalculoTempo {

    
    public Optional<Duration> diferençaTempos(TemporalAccessor inicio, TemporalAccessor fim) {
        
        if (inicio != null && fim != null) {
          return Optional.of(Duration.between(LocalTime.from(inicio), LocalTime.from(fim) ) );
        }
        return Optional.empty();
    }

    public Optional<LocalTime> adicionarTempos(TemporalAccessor tempo, long valor, ChronoUnit unidade) {
    
        LocalTime novoTempo = LocalTime.from(tempo).plus(valor, unidade);
        return Optional.of(novoTempo);
    }

    public Optional<Duration> temporizador(TemporalAccessor tempo) {
        return diferençaTempos(LocalTime.now(), tempo);     
    }
    
}
