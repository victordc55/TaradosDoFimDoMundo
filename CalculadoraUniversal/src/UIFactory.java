
import java.util.Arrays;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class UIFactory {
    
    public static TextualUI isoLocalDateTimeMainUI(){
            List<String> options = Arrays.asList( "Adicionar ou substrair datas.",
                                                  "Numero de dias até atingir o prazo.",
                                                  "Determinar um dia do ano",
                                                  "Determinar em que estação está.",
                                                  "Quit.");
            String head = "Bem vindo.Escolha uma das operações disponiveis:";
            
            return TextualUI.of(options, head);       
    }
    
    
    public static TextualUI isoAdSubsDateTimeUI(){
            List<String> options = Arrays.asList( "Substrair duas datas ou tempo.",
                                                  "Substrair a uma data.",
                                                  "Adicionar a uma data.",
                                                  "Quit.");
            String head = "As datas e tempos de input deverão seguir um dos seguintes formatos:\n"+
                          "1. DD/MM/YYYY hh:mm:ss \n" + 
                          "2. DD-MM-YYYY hh:mm:ss \n" +
                          "3. YYYY-MM-DD hh:mm:ss \n" +
                          "Caso só quera adicionar certos campos pode fazé-lo deixando os outros com zeros.\nEx: " +
                          " 00/00/0000 01:00:00 irá adicionar/substrair uma hora.";
            return TextualUI.of(options, head);            
    }
    
    
    
}
