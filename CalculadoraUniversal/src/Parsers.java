/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe que possua metodos para a criação de parsers e parsing simples.
 * @author VICTOR CUNHA
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
}
