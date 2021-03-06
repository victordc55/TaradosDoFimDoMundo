/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import Query.QueryFactory;
import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 *
 * 
 */
public class CalculoDatas implements ICalculoDatas{
    
    public Optional<Period> diferencaData(TemporalAccessor inicio,TemporalAccessor fim){
        LocalDate inicio1 = null;
        LocalDate fim1 = null;
        try{
            inicio1 = LocalDate.from(inicio);
            fim1 = LocalDate.from(fim);
        }catch(Exception e ){
            return Optional.empty();
        }
        
        if( inicio1 != null && fim1 != null){
            return Optional.ofNullable(Period.between( inicio1, fim1 ) );
        }    
        else 
            return Optional.empty();
    }
    
    public long diferencaData(TemporalAccessor inicio,TemporalAccessor fim, ChronoUnit units){
        try{ return Period.between(LocalDate.from(inicio), LocalDate.from(fim)).get(units); }
        catch(Exception e){ return 0;}
        
    }
    
    
     public Optional<LocalDate> addicionarAData(TemporalAccessor inicio, long param, ChronoUnit unidade){
         if( inicio != null && unidade != null ){
           try{  LocalDate dinicio = LocalDate.from(inicio);
                 if(dinicio.isSupported(unidade))
                    return Optional.of(dinicio.plus(param, unidade) );
           }catch(Exception e){};
         }      
         return Optional.empty();
     }
     
     public Optional<DayOfWeek> diaDaSemana(TemporalAccessor data){
         if( data != null)
                 return Optional.ofNullable(DayOfWeek.of( data.get(ChronoField.DAY_OF_WEEK)) );
         else return Optional.empty();
     }
     
     public OptionalInt numeroDoDiaNoAno(TemporalAccessor data){
        // return data.query( d -> d.get(ChronoField.DAY_OF_YEAR));
        if( data == null ) return OptionalInt.empty();
        return OptionalInt.of( data.query(QueryFactory.dayOfYear()) );
     }
     
     public OptionalInt numeroDeDiasNoAno(TemporalAccessor ano){
         if( ano == null ) return OptionalInt.empty();
         LocalDate bano = LocalDate.from(ano);
         return  OptionalInt.of( bano.lengthOfYear() );
     }
     
     public OptionalInt numeroDeDiasNoAno(Year ano){
         if( ano == null) return OptionalInt.empty();
         return OptionalInt.of( ano.atDay(ano.length()).get(ChronoField.DAY_OF_YEAR) ) ;
         
     }
    
    /**
     * 
     * @param ano
     * @return 
     */
    public OptionalInt numeroDeSemanasNoAno(TemporalAccessor ano){
        if( ano == null) return OptionalInt.empty();
        LocalDate fano = LocalDate.from(ano).with(TemporalAdjusters.lastDayOfYear());
        
        //return date.get(IsoFields.WEEK_BASED_YEAR);
        return OptionalInt.of((int) IsoFields.WEEK_OF_WEEK_BASED_YEAR.getFrom(fano));
   }
    
    public OptionalInt numeroDeSemanasNoAno(Year ano){
       
        return OptionalInt.of( (int) IsoFields.WEEK_OF_WEEK_BASED_YEAR.getFrom( ano.atDay( ano.length())));
    }
    
    /**
     * Devolve a que semana do ano pertence a data passada.
     * @param data
     * @return 
     */
    public OptionalInt semanaNoAno(TemporalAccessor data){
        return OptionalInt.of( (int) data.getLong( IsoFields.WEEK_OF_WEEK_BASED_YEAR));
       //return OptionalInt.of( (int) IsoFields.WEEK_OF_WEEK_BASED_YEAR.getFrom());
    }
    
    
    
    /** A VER SE FICA **/
    /** A que ano pertence a data passada. **/
    public Optional<Year> ano(TemporalAccessor data){
        return Optional.ofNullable( Year.from(data));
    }
    
    public Optional<YearMonth> mesDoAno(TemporalAccessor data){
        return Optional.ofNullable( YearMonth.from(data));
    }
    
    public OptionalInt trimestre(TemporalAccessor data){
        return OptionalInt.of( (int) IsoFields.QUARTER_OF_YEAR.getFrom(data) );
    }
    
    public boolean isLeap(Year ano){
        return ano.isLeap();
     }
    
    /**
     * Dada a data representada pelo TemporalAcessor devolve a estação temperada correspondente no hemisferio norte.
     * @param data
     * @return 
     */
   
    public Optional<EstacaoTemperada> estaçãoDoAnoNorte(TemporalAccessor data){
        // Versão mesmo meh
        return Estacoes.estacoesNorte.stream().filter( p -> p.isInSeason(data)).findFirst();

    }
    /**
     * Dada a data representada pelo TemporalAcessor devolve a estação temperada correspondente no hemisferio sul.
     * @param data
     * @return 
     */
    public Optional<EstacaoTemperada> estaçãoDoAnoSul(TemporalAccessor data){
         EstacaoTemperada res = null;
        // Versão mesmo meh
        return Estacoes.estacoesNorte.stream().filter( p -> p.isInSeason(data)).findFirst();
    }
    
    
    public DayOfWeek primeiroDiaDoAno(Year ano){
        return ano.atDay(1).getDayOfWeek();
    }

	@Override
	public DayOfWeek ultimoDiaDoAno(Year ano) {
		return ano.atMonth(12).atDay(31).getDayOfWeek();
	}

	@Override
	public OptionalInt diaEntreDatas(LocalDate data1, LocalDate data2) {
		int diasUteis = 0;
		 

		int dias = (int) ChronoUnit.DAYS.between(data1, data2);
		for (int i = 1; i <= dias; i++) {
			LocalDate data = data1.plus(i, ChronoUnit.DAYS);
			if((!data.getDayOfWeek().equals(DayOfWeek.SATURDAY)) && (!data.getDayOfWeek().equals(DayOfWeek.SUNDAY))){
				diasUteis++;
			}
		}
		
		return OptionalInt.of(diasUteis);
	}

	@Override
	public DayOfWeek diaNatal(OptionalInt ano) {
		if( ano.isPresent()){
                MonthDay natal = MonthDay.of(Month.DECEMBER, 25);
                
		LocalDate natalDesseAno = natal.atYear(ano.getAsInt());
		long diasAteONatal = LocalDate.now().until(natalDesseAno, ChronoUnit.DAYS);
		LocalDate data = LocalDate.now().plus(diasAteONatal, ChronoUnit.DAYS);
		return data.getDayOfWeek();
                }else return null;
	}

	@Override
	public OptionalInt diasDoMes(OptionalInt mes) {
		return OptionalInt.of(Month.of(mes.getAsInt()).maxLength());
	}

	@Override
	public OptionalLong semanasDesdeInicio() {
                return OptionalLong.of(LocalDate.now().query(QueryFactory.weeksFromBeginingOfYearTillNow()));
	}

	@Override
	public OptionalInt semanasFimAno() {
                Year ano = Year.now();
		return OptionalInt.of((int) LocalDate.now().until(ano.atDay(ano.length()), ChronoUnit.WEEKS));
	}

	@Override
	public String estacaoDoAno(LocalDate ldtestacao) {
               return  EstacaoTemperada.fromNorth(ldtestacao).toString();
	}
            
}
