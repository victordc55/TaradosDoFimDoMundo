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
 * Interface que representa os metodos que fazem operações entre local date times.
 * @author EVERYONE
 */
public interface ICalculoLDT {

    // Metodos para comparar datas com tempo
    /**
     * Calcula a diferença entre duas datas
     * @param inicio
     * @param fim
     * @return 
     */
    public Duration diferencaDateTime(LocalDateTime inicio, LocalDateTime fim);
    /**
     * Adiciona param unidades de tempo a um localDateTime
     * @param data
     * @param param
     * @param unit
     * @return 
     */
    public LocalDateTime addicionarADateTime(LocalDateTime data, int param, ChronoUnit unit);
    
    
    
}
