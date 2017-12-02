package Datas;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Pedro
 */
public class CalculoTempo implements ICalculoTempo {

    @Override
    public Duration diferençaTempos(LocalTime inicio, LocalTime fim) {
    
        Duration duracao = Duration.between(inicio, fim);
        return duracao;
    }

    @Override
    public LocalTime adicionarTempos(LocalTime tempo, long valor, ChronoUnit unidade) {
    
        LocalTime novoTempo = tempo.plus(valor, unidade);
        return novoTempo;
        
    }

    @Override
    public Duration temporizador(LocalTime tempo) {
        return diferençaTempos(LocalTime.now(), tempo);     
    }
    
}
