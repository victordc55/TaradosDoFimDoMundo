/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

/**
 *
 * 
 */
public interface ICalculoZdDT {
    /**
     * Adicionar um dado tempo ao ZonedDateTime
     * @param data
     * @param zone
     * @param tempo
     * @param unit
     * @return 
     */
    
    public Optional<ZonedDateTime> adicionarZonedDateTime(TemporalAccessor data, ZoneId zone, long tempo, ChronoUnit unit);
    
    /**
     * Calcular a diferença entre duas datas
     * @param dataInicial
     * @param dataFinal
     * @return 
     */
    
    public Optional<Duration> diferencaZonedDateTime(TemporalAccessor dataInicial, TemporalAccessor dataFinal);
    /**
     * Fazer a conversao de fuso dando um ZoneId
     * @param data
     * @param zone
     * @return 
     */
    public Optional<ZonedDateTime> conversaoDeFusos(TemporalAccessor data, ZoneId zone);
    
}
