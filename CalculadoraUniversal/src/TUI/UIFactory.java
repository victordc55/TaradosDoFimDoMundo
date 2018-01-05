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
    public static ITextualUI isoLocalDateTimeMainUI(){
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
    public static ITextualUI isoAdSubsDateUI(){
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
    

    public static ITextualUI isoAddSubsTimeUI(){
            
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
    public static ITextualUI isoAdsSubsUI(String head){
        List<String> options = Arrays.asList( "Substrair duas datas ou tempo.",
                                              "Substrair a uma data.",
                                              "Adicionar a uma data.",
                                              "Quit.");
        return TextualUI.of(options, head);      
    }
    
    
    public static ITextualUI firstUI(){
            List<String> options = Arrays.asList("Calcular data e tempos locais.",
                                                 "Calcular data e tempos segundo diferentes fusos horarios.",
                                                 "Cronometro.",
                                                 "Alterar formato de apresentação das datas.",
                                                 "Quit.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);      
        
    }
    
    public static ITextualUI localDataTimeUI(){
        
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
    
    
    
    public static ITextualUI zonedDateTimeUI(){
        
           List<String> options = Arrays.asList( "Adicionar ou substrair a um tempo usando diferentes fusos horarios.",
                                                 "Calcular a duração entre duas datas.",
                                                 "Converter uma data e hora para um outro fuso horario.",
                                                 "Calcular duração de um voo de avião entre duas cidades.",
                                                 "Tempo até uma data e hora usando diferentes fusos horarios.",
                                                 "Voltar atras.");
           
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);    
    }
    
    
    public static ITextualUI formatingOutputUI(){
         
           List<String> options = Arrays.asList( "Numérico (ex:9-10-2017 15:52:18  GMT+00:00 L/P 4) .",
                                                 "Expandido (ex: Sabado 9 Outubro 2017 15:55:18 GMT+00:00 Lisbon/Portugal Trimestre 4).",
                                                 "Voltar atras.");
           
        
           String head = "Só as informações disponiveis serão apresentadas.Formato padrão : Numérico.\nEscolhe o formato desejado:";
           
           return TextualUI.of(options, head);        
        
    }


    public static ITextualUI curiosidadesUI(){
         
           List<String> options = Arrays.asList( "Determinar o primeiro dia do ano.",
                                                 "Determinar o ultimo dia do ano.",
                                                 "Determinar o se o ano é bissexto.",
                                                 "Contar o numero de dias uteis entre duas datas.",
                                                 "Determinar o dia de natal.",
                                                 "Determinar o numero de dia do mês.",
                                                 "Determinar quantas semanas passaram desde o inicio do ano e quantas semanas faltam.",
                                                 "A que trimestre corresponde uma data.",
                                                 "Determinar em que estação do ano corresponde uma certa data.",
                                                 "Voltar atras.");
           
        
           String head = "Bem vindo.Escolha uma das operações disponiveis:";
           
           return TextualUI.of(options, head);         
    }
    
    
    
    public static ITextualUI hojeOuOutraDataUI(){
          
           List<String> options = Arrays.asList( "Hoje.",
                                                 "Introduzir data.",
                                                 "Voltar atras.");
           
        
           String head = "Escolha uma das opções:";
           
           return TextualUI.of(options, head);        
    }




    public static ITextualUI cronometroUI(){
           // Sera que posso fazer start ao chronometro, sair e depois voltar nele e ele ter continuado a correr?       
           List<String> options = Arrays.asList( "Start.",
                                                 "Stop.",
                                                 "Reset.",
                                                 "Quit.");
           
        
           String head = "Escolha uma das opções:";
           
           return TextualUI.of(options, head);       
        
    }

	
	
	 public static ITextualUI diferencaEntreTempos(){
	        List<String> options = Arrays.asList( "Difença entre datas.",
	                                                "Diferença entre horas.",
	                                                "Diferença entre Tempos.",
	                                                "Voltar para trás.");
	        String head = "Escolha uma das operações disponiveis:";
	        return TextualUI.of(options, head);    
	    }
	    
	    public static ITextualUI infoDatas(){
	        List<String> options = Arrays.asList( "Dia da Semana.",
	                                                "Trimestre.",
	                                                "Dia do Ano.",
	                                                "Semana do Ano",
	                                                "Voltar para trás");
	        String head = "Escolha uma das operações disponiveis:";
	        return TextualUI.of(options, head);    
	    }
	    
	    
	    public static ITextualUI addSubtrair(){
	        List<String> options = Arrays.asList( "Adicionar.",
	                                                "Subtrair.",
	                                                "Voltar para trás");
	        String head = "Escolha uma das operações disponiveis:";
	        return TextualUI.of(options, head);
	    }
	    
    public static ITextualUI listZonedId(){
        List<String> options = Arrays.asList("Pacific/Apia",
                                             "Pacific/Chatham",
                                             "Pacific/Fiji",
                                             "Asia/Anadyr",
                                             "Asia/Magadan",
                                             "Asia/Vladivostok",
                                             "Asia/Tokyo",
                                             "Asia/Hong_Kong",
                                             "Asia/Vientiane",
                                             "Asia/Dhaka",
                                             "Asia/Ashgabat",
                                             "Europe/Samara",
                                             "Europe/Istanbul",
                                             "Europe/Athens",
                                             "Europe/Paris",
                                             "UTC",
                                             "Atlantic/Azores",
                                             "America/Noronha",
                                             "America/Recife",
                                             "America/Puerto_Rico",
                                             "America/Port-au-Prince",
                                             "America/Chicago",
                                             "America/Chihuahua",
                                             "America/Los_Angeles",
                                             "America/Juneau",
                                             "America/Adak",
                                             "Pacific/Samoa");        
        
        String head = "Bem vindo.Escolha uma das operações disponiveis:";
        return TextualUI.of(options, head);    
    }         




}



