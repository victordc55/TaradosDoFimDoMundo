/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;


/**
 * Interface que representa os metodos que fazem operações entre local date times.
 * 
 */
public interface ICalculoLDT extends ICalculoDatas, ICalculoTempo {

    // Metodos para comparar datas com tempo
    /**
     * Calcula a diferença entre duas datas 
     * @param inicio
     * @param fim
     * @return 
     */
    public Optional<Duration> diferencaDateTime(TemporalAccessor inicio, TemporalAccessor fim);
    
    /**
     * Adiciona param unidades de tempo a um localDateTime
     * @param data
     * @param param
     * @param unit
     * @return 
     */
    
    public LocalDateTime addicionarADateTime(TemporalAccessor data, long param, ChronoUnit unit);
   
}
