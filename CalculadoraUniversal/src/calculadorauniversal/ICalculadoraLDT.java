/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import Datas.EstacaoTemperada;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.util.Optional;
import java.util.OptionalInt;

/**
 *
 * @author Pedro
 */
public interface ICalculadoraLDT {
    
    public Optional<LocalDate> addSubDatas(TemporalAccessor data, TemporalAccessor valor, boolean bool);
    public Optional<LocalTime> addSubHoras(TemporalAccessor horas,TemporalAccessor valor, boolean bool);
    public LocalDateTime addSubTempos(TemporalAccessor tempos, TemporalAccessor valor, boolean bool);
    public Optional<Duration> diferencaEntreTempos(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal, boolean bool);
    public Optional<Period> diferencaEntreDatas(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal);
    public void tempoAteData(TemporalAccessor tempo);
    public void curiosidades(TemporalAccessor tempo);
    public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data);
    public OptionalInt trimestre(TemporalAccessor data);
    public OptionalInt numeroDoDiaNoAno(TemporalAccessor data);
    public OptionalInt semanaNoAno(TemporalAccessor data);
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data, boolean isNorth);
    public boolean isLeap(TemporalAccessor data);

}
