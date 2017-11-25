/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.OptionalInt;


/**
 * Interface que representa os metodos que interagem com localDate's.
 * @author EVERYONE
 */
public interface ICalculoDatas {
    
    /**
     * Faz a diferença de tempo entre duas datas
     * @param inicio
     * @param fim
     * @return devolve o periodo entre as duas datas
     */
    public Optional<Period> diferencaData(LocalDate inicio,LocalDate fim);
    
    /**
     *  Adiciona unidades de tempo a uma data.
     * @param inicio : data sobre quem sera efetuado a operação
     * @param param : Inteiro que corresponde as unidades de tempo adicionado a data passada. 
     * @param unidade : Pode ser DAYS,WEEKS,MONTHS,YEARS
     * @return 
     */
    public Optional<LocalDate> addicionarAData(LocalDate inicio, long param, ChronoUnit unidade);
    
    /**
     * Devolve o dia da semana correspondente a esta data
     * @param data
     * @return 
     */
    public Optional<DayOfWeek> diaDaSemana(LocalDate data);
    
    /**
     * Devolve o numero do dia neste ano (ex: dia 56 do ano)
     * @param data
     * @return 
     */
    public OptionalInt numeroDoDiaNoAno(LocalDate data);

    
    /**
     * Devolve o numero de dias no ano assinalado
     * @param ano
     * @return 
     */
    public OptionalInt numeroDeDiasNoAno(LocalDate ano);
    public OptionalInt numeroDeDiasNoAno(Year ano);
    /**
     * Devolve o numero de semanas no ano assinalado
     * @param ano
     * @return 
     */
    public OptionalInt numeroDeSemanasNoAno(LocalDate ano);
    public OptionalInt numeroDeSemanasNoAno(Year ano);
    
    /**
     * Devolve a que semana do ano pertence a data passada.
     * @param data
     * @return 
     */
    public OptionalInt semanaNoAno(LocalDate data);
    
    
    
    /** A VER SE FICA **/
    public Optional<Year> ano(LocalDate data);
    
    public Optional<YearMonth> mesDoAno(LocalDate data);
    
    public OptionalInt trimestre(LocalDate data);
    
    public boolean isLeap(LocalDate data);
    
    
    
            
}
