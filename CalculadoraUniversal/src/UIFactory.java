
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
    
    /**
     * Cria um TextualUI com diversas opções predefinidas.
     * @return 
     */
    public static TextualUI isoLocalDateTimeMainUI(){
            List<String> options = Arrays.asList( "Adicionar ou substrair datas.",
                                                  "Numero de dias até atingir o prazo.",
                                                  "Determinar um dia do ano",
                                                  "Determinar em que estação está.",
                                                  "Quit.");
            String head = "Bem vindo.Escolha uma das operações disponiveis:";
            
            return TextualUI.of(options, head);       
    }
    
    /**
     * Cria um TextualUI para a adicção ou substração de datas e tempos com um header e opções predefinidas.
     * @return 
     */
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
    
    /**
     * Cria um TextualUI para a adição e substração de datas e tempos com opções predifinidas e usando o header passado.
     * @param head - header usado.
     * @return uma interface com o utilizador no formato textual.
     */
    public static TextualUI isoAdsSubsUI(String head){
        List<String> options = Arrays.asList( "Substrair duas datas ou tempo.",
                                                  "Substrair a uma data.",
                                                  "Adicionar a uma data.",
                                                  "Quit.");
        return TextualUI.of(options, head);      
    }
    
    
    
    
}
