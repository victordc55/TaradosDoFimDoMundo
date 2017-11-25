/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalQuery;

/**
 *
 * @author VICTOR CUNHA
 */
public class QueryFactory {
    
    
    public static TemporalQuery<Integer> dayOfWeek(){
        return (d) -> d.get(ChronoField.DAY_OF_WEEK);
    }
    
    public static TemporalQuery<Integer> dayOfYear(){
        return (d) -> d.get(ChronoField.DAY_OF_YEAR);
    }

}
