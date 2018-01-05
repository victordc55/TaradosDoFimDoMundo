/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;


import java.time.ZonedDateTime;

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
            zdtnow = ZonedDateTime.now();
            p.print(zdtnow);
            
            synchronized(this){
                try{
                    Thread.currentThread().sleep(29950);
                }catch(Exception e){
                    
                }
            }
        }
         
    }
    
    public void stop(){
        stop = true;
        t.interrupt();
    }
    
}
