/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datas;

import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.ZoneId;

/**
 * Interface que representa os metodos que interagem com localDate's.
 * @author EVERYONE
 */
public interface ICalculoODT {
    
    public OffsetTime obterOffset (LocalDateTime ldt, ZoneId zona);

}