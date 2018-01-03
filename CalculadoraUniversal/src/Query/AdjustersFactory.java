/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * 
 */
public class AdjustersFactory {
 
    
    public static TemporalAdjuster adjustToMonthDay(Month mes, int day){
        return TemporalAdjusters.ofDateAdjuster(d -> d.with( ChronoField.MONTH_OF_YEAR,mes.getValue()).with(ChronoField.DAY_OF_MONTH, day) );
    }
}
