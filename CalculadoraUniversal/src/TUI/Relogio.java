/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import java.time.ZonedDateTime;


public class Relogio implements Runnable{
      private  Thread t;
      private int time;
      private boolean stop;
      
    public Relogio(){
        t = new Thread(this);
        stop = false;
        time = 59950;
        t.start();
    }
    
    public void run(){
        ZonedDateTime zdtnow ;
        while(!stop){
            zdtnow = ZonedDateTime.now();
            Printer.print(zdtnow);
            
            synchronized(this){
                try{
                    Thread.currentThread().sleep(time);
                }catch(Exception e){
                    
                }
            }
        }
         
    }
    
    public void changeActuTime(int time){
        if( time > 0)
            this.time = time;
    }
    public void stop(){
        stop = true;
        t.interrupt();
    }
    
}
