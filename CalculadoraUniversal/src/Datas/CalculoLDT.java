/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Pedro
 */
public class CalculoLDT implements ICalculoLDT {

    @Override
    public Duration diferencaDateTime(LocalDateTime inicio, LocalDateTime fim) {
    
        Duration duracao = Duration.between(inicio, fim);
        return duracao;
    }

    @Override
    public LocalDateTime addicionarADateTime(LocalDateTime data, int param, ChronoUnit unit) {
        
        LocalDateTime novoDateTime = data.plus(param, unit);
        return novoDateTime;
    }
    
}
