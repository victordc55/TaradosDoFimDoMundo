/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.SECONDS;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.Year;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;

import Datas.CalculoLDT;
import Datas.CalculoZdDT;
import Datas.EstacaoTemperada;
import TUI.Printer;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.OptionalLong;

/**
 *
 * 
 */
public class CalculadoraUniversalISOLDT implements ICalculadoraUniversal, ICalculadoraUniversalCuriosidade {
	
	private static CalculoLDT ldt;
        private static CalculoZdDT zdt;

    public CalculadoraUniversalISOLDT(){
        ldt = new CalculoLDT();
        zdt = new CalculoZdDT();
    }

	@Override
	public Optional<LocalDate> addSubDatas(TemporalAccessor data, TemporalAccessor valor, boolean bool) {
		LocalDate res = LocalDate.from(data);
        LocalDate val = LocalDate.from(valor);
        LocalDate zero = LocalDate.of(0, 1, 1);
        long nDias = zero.until(val, DAYS)+31;
        if (bool) 
          return ldt.addicionarAData(res, nDias, DAYS);
        
        else
          return ldt.addicionarAData(res, -nDias, DAYS);      
	}

	@Override
	public Optional<LocalTime> addSubHoras(TemporalAccessor horas, TemporalAccessor valor, boolean bool) {
		LocalTime res = LocalTime.from(horas);
        LocalTime val = LocalTime.from(valor);
        LocalTime zero = LocalTime.MIN;
        long nSegundos = zero.until(val, SECONDS);
        if (bool) {
            return ldt.adicionarTempos(res, nSegundos, SECONDS);
        }
        else {   
            return ldt.adicionarTempos(res, -nSegundos, SECONDS);
        }
	}

	@Override
	public LocalDateTime addSubTempos(TemporalAccessor tempos, TemporalAccessor valor, boolean bool) {
            LocalDateTime res = LocalDateTime.from(tempos);
            LocalDateTime val = LocalDateTime.from(valor);
            LocalDateTime zero = LocalDateTime.of(0, 1, 1, 0, 0);
            long nTempo = zero.until(val, SECONDS) + 31*24*3600  ;
            if(bool)
                return ldt.addicionarADateTime(res, nTempo, SECONDS);
            else
                return ldt.addicionarADateTime(res, -nTempo, SECONDS);
	}

	@Override
	public Optional<Duration> diferencaEntreTempos(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal, boolean bool) {
		 if (bool) {
	            return ldt.diferençaTempos(tempoInicial, tempoFinal);
	        }
	        else {
	            return ldt.diferencaDateTime(tempoInicial, tempoFinal);
	        }
	}

	@Override
	public Optional<Period> diferencaEntreDatas(TemporalAccessor tempoInicial, TemporalAccessor tempoFinal) {
		  return ldt.diferencaData(tempoInicial, tempoFinal);
	}

	@Override
	public Optional<Duration> tempoAteData(TemporalAccessor tempo) {
		 return Optional.empty();
		
	}



	@Override
	public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data) {
		 return ldt.diaDaSemana(data);
	}

	@Override
	public OptionalInt trimestre(TemporalAccessor data) {
		return ldt.trimestre(data);
	}

	@Override
	public OptionalInt numeroDoDiaNoAno(TemporalAccessor data) {
		return ldt.numeroDoDiaNoAno(data);
	}

	@Override
	public OptionalInt semanaNoAno(TemporalAccessor data) {
		 return ldt.semanaNoAno(data);
	}

	@Override
	public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data, boolean isNorth) {
		 if(isNorth)
	            return ldt.estaçãoDoAnoNorte(data);
	        else 
	            return ldt.estaçãoDoAnoSul(data);
	}

	@Override
	public boolean isLeap(int a) {
		Year ano = Year.of(a);
		 return ldt.isLeap(ano);
	}

	@Override
	public DayOfWeek ultimoDiaAno(int a) {
		Year ano = Year.of(a);
		return ldt.ultimoDiaDoAno(ano);
	}

	@Override
	public DayOfWeek primeiroDiaAno(int a) {
		Year ano = Year.of(a);	
		return ldt.primeiroDiaDoAno(ano);
	}

	@Override
	public OptionalInt diaUteisEntreDatas(LocalDate data1, LocalDate data2) {
		return ldt.diaEntreDatas(data1, data2);
	}

	@Override
	public Optional<DayOfWeek> diaNatal(OptionalInt ano) {
		return Optional.ofNullable(ldt.diaNatal(ano));
	}

	@Override
	public OptionalInt diasDoMes(OptionalInt mes) {
		return ldt.diasDoMes(mes);
	}

	@Override
	public OptionalLong semanasDesdeInicio() {
		return ldt.semanasDesdeInicio();
	}

	@Override
	public OptionalInt semanasFimAno() {
		return ldt.semanasFimAno();
	}

	@Override
	public String estacaoDoAno(LocalDate ldtestacao) {
		return ldt.estacaoDoAno(ldtestacao);
	}

    @Override
    public Optional<Instant> addSubZonedDateTime(TemporalAccessor ldt, ZoneId zone, TemporalAccessor tempo) {
          return  Optional.empty();
    }

    @Override
    public Optional<Duration> diferencaEntreFusos(TemporalAccessor ldtInicial, TemporalAccessor ldtFinal) {
        
        return zdt.diferencaZonedDateTime(ldtInicial, ldtFinal);
    }

    @Override
    public Optional<ZonedDateTime> convertZonedDateTime(TemporalAccessor zdtInicial, ZoneId zone) {
        Instant agora = Instant.from(zdtInicial);
        Optional<ZonedDateTime> zddt = zdt.conversaoDeFusos(agora, zone);
        return zddt;
    }
    
    


    
}
