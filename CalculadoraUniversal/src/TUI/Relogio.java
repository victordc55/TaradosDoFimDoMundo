/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;
import java.time.ZonedDateTime;


public class Relogio implements Runnable{
//      private  Thread t;
      private int time;
     private boolean stop;
      private IPrinter printer;
      
    public Relogio(IPrinter p){
        printer = p;
      //  t = new Thread(this);
       stop = false;
       time = 59950;
   //     t.start();
    }
    
    public void run(){/*
        ZonedDateTime zdtnow ;
        while(!stop){
            zdtnow = ZonedDateTime.now();
            printer.print(zdtnow);
            
            synchronized(this){
                try{
                    Thread.currentThread().sleep(time);
                }catch(Exception e){
                    
                }
            }
        }
         */
    }
    
    public ZonedDateTime getTime(){
        return ZonedDateTime.now();
    }
    
    public void showTime(){
        printer.print(ZonedDateTime.now());
    }
    
    public void changeActuTime(int time){
        if( time > 0)
            this.time = time;
    }
    
    public void setPrinter(IPrinter p){
        if( p != null ) printer = p;
    }
    
    public void stop(){
        stop = true;
      //  t.interrupt();
    }
    
}
