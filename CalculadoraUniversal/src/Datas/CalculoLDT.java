/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import TUI.Printer;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author Pedro
 */
public class CalculoLDT implements ICalculoLDT, ICalculoTempo {
    
    private ICalculoDatas datas;
    private ICalculoTempo tempos;
    
    // Construtor da Classe
    public CalculoLDT (){
    
    datas = new CalculoDatas();
    tempos = new CalculoTempo();
    }
    
    
    // Calcula os LocalDateTime
    @Override
    public Optional<Duration> diferencaDateTime(TemporalAccessor inicio, TemporalAccessor fim) {
        LocalDateTime inicioI = null;
        LocalDateTime fimI = null;
        try{
            inicioI = LocalDateTime.from(inicio);
            fimI = LocalDateTime.from(fim);
        }catch(Exception e ){
            return Optional.empty();
        }
        
        if( inicioI != null && fimI != null){
            return Optional.ofNullable(Duration.between( inicioI, fimI ) );
        }    
        else 
            return Optional.empty();
    }

    public LocalDateTime addicionarADateTime(TemporalAccessor data, long param, ChronoUnit unit) {
        LocalDateTime novoDateTime = LocalDateTime.from(data).plus(param, unit);
        return novoDateTime;
    }
    
    //------------------------------------------------------------------------------------------------------------
    // Calcula os LocalDate

    public Optional<Period> diferencaData(TemporalAccessor inicio,TemporalAccessor fim){
        return datas.diferencaData(inicio, fim);
    }
    

    public Optional<LocalDate> addicionarAData(TemporalAccessor inicio, long param, ChronoUnit unidade){
        return datas.addicionarAData(inicio, param, unidade);
    }
    
  
    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data){
        return datas.diaDaSemana(data);
    }
    

    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data){
        return datas.numeroDoDiaNoAno(data);    
    }
 
    public OptionalInt numeroDeDiasNoAno(TemporalAccessor ano){
        return datas.numeroDeDiasNoAno(ano);
    }
    
    public OptionalInt numeroDeDiasNoAno(Year ano){
        return datas.numeroDeDiasNoAno(ano);
    }
 
    public OptionalInt numeroDeSemanasNoAno(TemporalAccessor ano){
        return datas.numeroDeSemanasNoAno(ano);
    }
        
    public OptionalInt numeroDeSemanasNoAno(Year ano){
        return datas.numeroDeSemanasNoAno(ano);
    }
    
    public OptionalInt semanaNoAno(TemporalAccessor data){
        return datas.semanaNoAno(data);
    }
        
    /** A VER SE FICA **/
    public Optional<Year> ano(TemporalAccessor data){
        return datas.ano(data);
    }
    
    public Optional<YearMonth> mesDoAno(TemporalAccessor data){
        return datas.mesDoAno(data);
    }
    
    public OptionalInt trimestre(TemporalAccessor data){
        return datas.trimestre(data);
    }
    
    public boolean isLeap(TemporalAccessor data){
         return datas.isLeap(data);
    }
    
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data){
        return datas.estaçãoDoAnoNorte(data);
    }
    

    public Optional<EstacaoTemperada> estaçãoDoAnoSul(TemporalAccessor data){
        return datas.estaçãoDoAnoSul(data);
    }

    public DayOfWeek primeiroDiaDoAno(Year ano) {
        return datas.primeiroDiaDoAno(ano);
    }
    
    //-------------------------------------------------------------------------------------------------------------
    // Calcula o LocalTime
    
    public Optional<Duration> diferençaTempos(TemporalAccessor inicio, TemporalAccessor fim) {
       return tempos.diferençaTempos(inicio, fim);
    }

    public Optional<LocalTime> adicionarTempos(TemporalAccessor tempo, long valor, ChronoUnit unidade) {
       return tempos.adicionarTempos(tempo, valor, unidade);
    }

    public Optional<Duration> temporizador(TemporalAccessor tempo) {
       return tempos.temporizador(tempo); 
    }
    
}
