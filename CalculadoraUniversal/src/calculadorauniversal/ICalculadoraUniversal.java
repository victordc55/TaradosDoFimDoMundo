/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;

import Datas.EstacaoTemperada;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.OptionalLong;

/**
 *
 * 
 */
public interface ICalculadoraUniversal {
    
	  public Optional<LocalDate> addSubDatas(TemporalAccessor data, TemporalAccessor valor, boolean bool);
	    public Optional<LocalTime> addSubHoras(TemporalAccessor horas,TemporalAccessor valor, boolean bool);
	    public LocalDateTime addSubTempos(TemporalAccessor tempos, TemporalAccessor valor, boolean bool);
	    public Optional<Duration> diferencaEntreTempos(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal, boolean bool);
	    public Optional<Period> diferencaEntreDatas(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal);
	    public void tempoAteData(TemporalAccessor tempo);
	    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data);
	    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data);
	    public OptionalInt semanaNoAno(TemporalAccessor data);
	    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data, boolean isNorth);	
            public OptionalInt trimestre(TemporalAccessor data);
            //ZonedDateTime    
    
        public Optional<Instant> addSubZonedDateTime(TemporalAccessor ldt, ZoneId zone, TemporalAccessor tempo);        
        public Optional<Duration> diferencaEntreFusos(TemporalAccessor ldtInicial, TemporalAccessor ldtFinal);
        public Optional<ZonedDateTime> convertZonedDateTime(TemporalAccessor zdtInicial, ZoneId zone);
}
