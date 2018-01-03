package TUI;


import TUI.Parser;
import java.util.OptionalInt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe que possua metodos para a criação de parsers e parsing simples.
 * 
 */
public class Parsers {
    
    /**
     * Dado um formato cria um parser
     * @param format
     * @return 
     */
    public static Parser of(String format){
        return Parser.of(format);
    }
    
    /**
     * Recover an int from the passed string
     * @param s
     * @return 
     */
    public static OptionalInt getInt(String s){
            try{
                return OptionalInt.of( Integer.parseInt(s) );
            }catch(Exception e){
                return OptionalInt.empty();
            }         
    }
}
