/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQuery;

/**
 *
 * 
 */
public class QueryFactory {
    
    /**
     * Query that recover the day of week
     * @return 
     */
    public static TemporalQuery<Integer> dayOfWeek(){
        return (d) -> d.get(ChronoField.DAY_OF_WEEK);
    }
    /**
     * Query that recover the day of the Year.
     * @return 
     */
    public static TemporalQuery<Integer> dayOfYear(){
        return (d) -> d.get(ChronoField.DAY_OF_YEAR);
    }
    
    public static TemporalQuery<Long> weeksFromBeginingOfYearTillNow(){
        return (d) -> IsoFields.WEEK_OF_WEEK_BASED_YEAR.getFrom(d);
    }

}
