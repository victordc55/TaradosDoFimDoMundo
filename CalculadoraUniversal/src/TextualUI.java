
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VICTOR CUNHA
 */
public class TextualUI {
    // Representa uma interface textual fixa.
    private final List<String> options;
    private final String header;
    private int lastChosenOption;
    //private final int pageSize;// without head
    //private int thisPage;
    
    private TextualUI(List<String> opt, String head/*,int pageSize*/){
        options = opt;
        header = head;
        lastChosenOption = -1;
        /*this.pageSize = pageSize;
        thisPage = 0;*/
    }
    
    public static TextualUI of(List<String> opt, String head){
        return new TextualUI(opt,head);
    }
    
    public boolean printHeader(){
        Print.print(header+"\n");
        return true;
    }

    public int printMenu(){
        lastChosenOption = -1;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(String s : options){
             sb.append( i + "." + s + "\n");
             i++;
        }
        String line = Print.ask(sb.toString());
        try{
            lastChosenOption = Integer.parseInt(line);
        }catch(Exception e){
            
        }
        return lastChosenOption;
        
    }
    
    public int getChosenOption(){
        return lastChosenOption;
    }
    
    
}   
