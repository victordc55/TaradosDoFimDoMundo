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
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author VICTOR CUNHA
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
    
    public boolean isOutSeason(TemporalAccessor data){
        MonthDay date = MonthDay.from(data);
        //LocalDate myDate = LocalDate.now().with( AdjustersFactory.adjustToMonthDay(mes, day));
        return date.isAfter(fEstacao) && date.isBefore(iEstacao);
    }
    
    public boolean isInSeason(TemporalAccessor data){
        MonthDay date = MonthDay.from(data);
        return date.isBefore(fEstacao) && date.isAfter(iEstacao);
    }
    
    
}
