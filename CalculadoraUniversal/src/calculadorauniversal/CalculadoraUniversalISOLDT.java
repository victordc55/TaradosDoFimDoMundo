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
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;

import Datas.CalculoLDT;
import Datas.EstacaoTemperada;

/**
 *
 * 
 */
public class CalculadoraUniversalISOLDT implements ICalculadoraUniversal {
	
	private static CalculoLDT ldt;

    public CalculadoraUniversalISOLDT(){
        ldt = new CalculoLDT();
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
	public void tempoAteData(TemporalAccessor tempo) {
		 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
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
	public boolean isLeap(TemporalAccessor data) {
		 return ldt.isLeap(data);
	}


    
}
