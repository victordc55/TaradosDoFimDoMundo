/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VICTOR CUNHA
 */
public class Parser {
    
    
    private final String format;
    
    private Parser(String format){
          this.format = format;
    }
    
    public static Parser of(String format){
        return new Parser(format);
    }
    /**
     * Split a string following the specified format
     * @param in
     * @return 
     */
    public String[] split(String in){
        List<String> res;
        
        
        
    }
}
