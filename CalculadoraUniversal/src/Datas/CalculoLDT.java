/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    // Construtor 
    public CalculoLDT (){
    
    datas = new CalculoDatas();
    tempos = new CalculoTempo();
    }
    
    
    // Calcula os LocalDateTime
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
    
    
    //------------------------------------------------------------------------------------------------------------
    // Calcula os LocalDate

    public Optional<Period> diferencaData(TemporalAccessor inicio,TemporalAccessor fim);
    

    public Optional<LocalDate> addicionarAData(TemporalAccessor inicio, long param, ChronoUnit unidade);
    
  
    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data);
    

    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data);

    
 
    public OptionalInt numeroDeDiasNoAno(TemporalAccessor ano);
    public OptionalInt numeroDeDiasNoAno(Year ano);
 
    public OptionalInt numeroDeSemanasNoAno(TemporalAccessor ano);
    public OptionalInt numeroDeSemanasNoAno(Year ano);
    
    public OptionalInt semanaNoAno(TemporalAccessor data);
    
    
    
    /** A VER SE FICA **/
    public Optional<Year> ano(TemporalAccessor data);
    
    public Optional<YearMonth> mesDoAno(TemporalAccessor data);
    
    public OptionalInt trimestre(TemporalAccessor data);
    
    public boolean isLeap(TemporalAccessor data){
         return this.datas.isLeap(data);
    }
    
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data);
    

    public Optional<EstacaoTemperada> estaçãoDoAnoSul(TemporalAccessor data);

    
    //-------------------------------------------------------------------------------------------------------------
    // Calcula o LocalTime
    
    @Override
    public Duration diferençaTempos(LocalTime inicio, LocalTime fim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LocalTime adicionarTempos(LocalTime tempo, long valor, ChronoUnit unidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Duration temporizador(LocalTime tempo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
