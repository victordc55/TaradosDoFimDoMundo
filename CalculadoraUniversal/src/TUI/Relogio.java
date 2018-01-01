/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author VICTOR CUNHA
 */
public class Relogio implements Runnable{
      private  Thread t;
      private  Printer p;
      private boolean stop;
      
    public Relogio(Printer printer){
        t = new Thread(this);
        stop = false;
        p = printer;
        t.start();
    }
    
    public void run(){
        ZonedDateTime zdtnow ;
        while(!stop){
            //System.out.println(used.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            zdtnow = ZonedDateTime.now();
            p.print(zdtnow);
            synchronized(this){
                try{
                    Thread.currentThread().sleep(29950);
                }catch(Exception e){
                    
                }
            }
           // zdtnow = zdtnow.plus(1, ChronoUnit.SECONDS);
        }
         
    }
    
    public void stop(){
        stop = true;
        t.interrupt();
    }
    
}
