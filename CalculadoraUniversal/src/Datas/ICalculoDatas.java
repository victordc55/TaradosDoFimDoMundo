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
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;


/**
 * Interface que representa os metodos que interagem com localDate's.
 * 
 */
public interface ICalculoDatas {
    
    /**
     * Faz a diferença de tempo entre duas datas
     * @param inicio
     * @param fim
     * @return devolve o periodo entre as duas datas
     */
    public Optional<Period> diferencaData(TemporalAccessor inicio,TemporalAccessor fim);
    
    /**
     *  Adiciona unidades de tempo a uma data.
     * @param inicio : data sobre quem sera efetuado a operação
     * @param param : Inteiro que corresponde as unidades de tempo adicionado a data passada. 
     * @param unidade : Pode ser DAYS,WEEKS,MONTHS,YEARS
     * @return 
     */
    public Optional<LocalDate> addicionarAData(TemporalAccessor inicio, long param, ChronoUnit unidade);
    
    /**
     * Devolve o dia da semana correspondente a esta data
     * @param data
     * @return 
     */
    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data);
    
    /**
     * Devolve o numero do dia neste ano (ex: dia 56 do ano)
     * @param data
     * @return 
     */
    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data);

    
    /**
     * Devolve o numero de dias no ano assinalado
     * @param ano
     * @return 
     */
    public OptionalInt numeroDeDiasNoAno(TemporalAccessor ano);
    public OptionalInt numeroDeDiasNoAno(Year ano);
    /**
     * Devolve o numero de semanas no ano assinalado
     * @param ano
     * @return 
     */
    public OptionalInt numeroDeSemanasNoAno(TemporalAccessor ano);
    public OptionalInt numeroDeSemanasNoAno(Year ano);
    
    /**
     * Devolve a que semana do ano pertence a data passada.
     * @param data
     * @return 
     */
    public OptionalInt semanaNoAno(TemporalAccessor data);
    
    
    
    /** A VER SE FICA **/
    public Optional<Year> ano(TemporalAccessor data);
    
    public Optional<YearMonth> mesDoAno(TemporalAccessor data);
    
    public OptionalInt trimestre(TemporalAccessor data);
    
    public boolean isLeap(Year ano);
    
    /**
     * Dada a data representada pelo TemporalAcessor devolve a estação temperada correspondente no hemisferio norte.
     * @param data
     * @return 
     */
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data);
    
    /**
     * Dada a data representada pelo TemporalAcessor devolve a estação temperada correspondente no hemisferio sul.
     * @param data
     * @return 
     */
    public Optional<EstacaoTemperada> estaçãoDoAnoSul(TemporalAccessor data);
            
    public DayOfWeek primeiroDiaDoAno(Year ano);

	public DayOfWeek ultimoDiaDoAno(Year ano);

	public OptionalInt diaEntreDatas(LocalDate data1, LocalDate data2);

	public DayOfWeek diaNatal(OptionalInt ano);

	public OptionalInt diasDoMes(OptionalInt mes);

	public OptionalLong semanasDesdeInicio();

	public OptionalInt semanasFimAno();

	public String estacaoDoAno(LocalDate ldtestacao);
    
}
