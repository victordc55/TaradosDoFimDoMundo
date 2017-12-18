/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import Query.AdjustersFactory;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

/**
 *
 * @author ALL
 */
public enum EstacaoTemperada {
    // Boreal = Hemisferio Norte
    PrimaveraBoreal(20,Month.MARCH,20,Month.JUNE), VeraoBoreal(21,Month.JUNE,22,Month.SEPTEMBER), 
    OutonoBoreal(23,Month.SEPTEMBER,20,Month.DECEMBER), InvernoBoreal(21,Month.DECEMBER,19,Month.MARCH),
    // Austral = Hemisferio Sul
    PrimaveraAustral(23,Month.SEPTEMBER, 20,Month.DECEMBER), VeraoAustral(21,Month.DECEMBER, 19,Month.MARCH), 
    OutonoAustral(20,Month.MARCH, 20,Month.JUNE), InvernoAustral(21,Month.JUNE, 22,Month.SEPTEMBER);
    
    private MonthDay iEstacao;
    private MonthDay fEstacao;
    
    private EstacaoTemperada(int idia,Month imes, int fimdia,Month fimmes){
        iEstacao = MonthDay.of(imes,idia);
        fEstacao = MonthDay.of(fimmes,fimdia);
    }
    
    /**
     * Determine if the temporalAccessor represent a date outside of the season.
     * If ,from the temporalAccessor, we can't recover a global ace
     * @param data
     * @return 
     */
    public boolean isOutSeason(TemporalAccessor data){
        MonthDay date = null;
        try{
            date = MonthDay.from(data);
         }catch(Exception e){}
        if( date != null)
        //LocalDate myDate = LocalDate.now().with( AdjustersFactory.adjustToMonthDay(mes, day));
             return date.isAfter(fEstacao) && date.isBefore(iEstacao);
        else return false;
    }
    
    
    public boolean isInSeason(TemporalAccessor data){
        MonthDay date = null;
        try{
            date = MonthDay.from(data);
         }catch(Exception e){}
        if( date != null)
            return date.isBefore(fEstacao) && date.isAfter(iEstacao);
        else return false;
    }
    
    /**
     * Determine a estação do ano, do hemisferio Norte, especificado pela data contida no TemporalAccessor.
     * @param data
     * @return 
     */
    public static Optional<EstacaoTemperada> fromNorth(TemporalAccessor data){
        ZonedDateTime date = null;
        EstacaoTemperada res = null;
        try{
           date = ZonedDateTime.from(data);
        }catch(Exception e){
            return Optional.empty();
        }
        for(EstacaoTemperada estacao : EstacaoTemperada.values()){
            if(estacao.toString().contains("Boreal")){
                if( estacao.isInSeason(date) ){
                    res = estacao;
                    break;
                }
            }
        }
        /*
       return data.query( (t) -> { if(PrimaveraBoreal.isInSeason(t)) return Optional.of(PrimaveraBoreal);
                            else if(VeraoBoreal.isInSeason(t)) return Optional.of(VeraoBoreal);
                            else if(OutonoBoreal.isInSeason(t)) return Optional.of(OutonoBoreal);
                            else if( InvernoBoreal.isInSeason(t)) return Optional.of(InvernoBoreal);
                            else return Optional.empty();
                           });
        */
        return Optional.ofNullable(res);
    }
    
    /**
     * Determine a estação do ano, do hemisferio Sul, especificado pela data contida no TemporalAccessor.
     * @param data
     * @return 
     */
    public static Optional<EstacaoTemperada> fromSouth(TemporalAccessor data){
       
        return data.query( (t) -> { if(PrimaveraAustral.isInSeason(t)) return Optional.of(PrimaveraAustral);
                            else if(VeraoAustral.isInSeason(t)) return Optional.of(VeraoAustral);
                            else if(OutonoAustral.isInSeason(t)) return Optional.of(OutonoAustral);
                            else if( InvernoAustral.isInSeason(t)) return Optional.of(InvernoAustral);
                            else return Optional.empty();
                           });
    }
}
