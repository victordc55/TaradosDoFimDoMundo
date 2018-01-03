package TUI;


import TUI.TextualUI;
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
    public static TextualUI isoAdSubsDateUI(){
            List<String> options = Arrays.asList( "Substrair duas datas.",
                                                  "Substrair a uma data.",
                                                  "Adicionar a uma data.",
                                                  "Quit.");
           
            /* String head = "As datas e tempos de input deverão seguir um dos seguintes formatos:\n"+
                          "1. DD/MM/YYYY hh:mm:ss \n" + 
                          "2. DD-MM-YYYY hh:mm:ss \n" +
                          "3. YYYY-MM-DD hh:mm:ss \n" +
                          "Caso só quera adicionar certos campos pode fazé-lo deixando os outros com zeros.\nEx: " +
                          " 00/00/0000 01:00:00 irá adicionar/substrair uma hora.";*/
           
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);            
    }
    

    public static TextualUI isoAddSubsTimeUI(){
            
            List<String> options = Arrays.asList( "Substrair duas datas.",
                                                  "Substrair a uma data.",
                                                  "Adicionar a uma data.",
                                                  "Quit.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
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
    
    
    public static TextualUI firstUI(){
            List<String> options = Arrays.asList("Calcular data e tempos locais.",
                                                 "Calcular data e tempos segundo diferentes fusos horarios.",
                                                 "Cronometro.",
                                                 "Alterar formato de apresentação das datas.",
                                                 "Quit.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);      
        
    }
    
    public static TextualUI localDataTimeUI(){
        
           List<String> options = Arrays.asList("Adicionar ou substrair a uma data.",
                                                "Adicionar ou substrair a uma hora.",
                                                 "Adicionar ou substrair a um tempo.",
                                                 "Duração entre duas datas.",
                                                 "Informações sobre uma data.",
                                                 "Tempo até uma data e hora.",
                                                 "Curiosidades.",
                                                 "Voltar atras.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);    
    }
    
    
    
    public static TextualUI zonedDateTimeUI(){
        
           List<String> options = Arrays.asList( "Adicionar ou substrair a um tempo usando diferentes fusos horarios.",
                                                 "Calcular a duração entre duas datas.",
                                                 "Converter uma data e hora para um outro fuso horario.",
                                                 "Calcular duração de um voo de avião entre duas cidades.",
                                                 "Tempo até uma data e hora usando diferentes fusos horarios.",
                                                 "Voltar atras.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);    
    }
    
    
    public static TextualUI formatingOutputUI(){
         
           List<String> options = Arrays.asList( "Numérico (ex:9-10-2017 15:52:18  +00:00GMT L/P 4) .",
                                                 "Expandido (ex: Sabado 9 Outubro 2017 15:55:18 +00:00GMT Lisbon/Portugal Trimestre 4).",
                                                 "Voltar atras.");
           
        
           String head = "Só as informações disponiveis serão apresentadas.Formato padrão : Numérico.\nEscolhe o formato desejado:";
           
           return TextualUI.of(options, head);        
        
    }


    public static TextualUI curiosidadesUI(){
         
           List<String> options = Arrays.asList( "Determinar o primeiro dia do ano.",
                                                 "Determinar o ultimo dia do ano.",
                                                 "Determinar o i-ésimo dia do ano.",
                                                 "Contar o numero de dias uteis entre duas datas.",
                                                 "Determinar o dia de natal.",
                                                 "Determinar o mês e o numero de dia do mês.",
                                                 "Determinar quantas semanas passaram desde o inicio do ano e quantas semanas faltam.",
                                                 "A que trimestre corresponde uma data.",
                                                 "Determinar em que estação do ano corresponde uma certa data.",
                                                 "Voltar atras.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);         
    }
    
    
    
    public static TextualUI hojeOuOutraDataUI(){
          
           List<String> options = Arrays.asList( "Hoje.",
                                                 "Introduzir data.",
                                                 "Voltar atras.");
           
        
           String head = "Escolha uma das opções:";
           
           return TextualUI.of(options, head);        
    }




    public static TextualUI cronometroUI(){
           // Sera que posso fazer start ao chronometro, sair e depois voltar nele e ele ter continuado a correr?       
           List<String> options = Arrays.asList( "Start.",
                                                 "Stop.",
                                                 "Reset.",
                                                 "Quit.");
           
        
           String head = "Escolha uma das opções:";
           
           return TextualUI.of(options, head);       
        
    }




}



