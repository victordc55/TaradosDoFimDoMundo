package TUI;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class TextualUI implements ITextualUI{
    // Representa uma interface textual fixa.
    private final List<String> options;
    private final String header;
    private int lastChosenOption;
    private final IPrinter printer;
    //private final int pageSize;// without head
    //private int thisPage;
    
    private TextualUI(List<String> opt, String head,IPrinter print){
        options = opt;
        header = head;
        lastChosenOption = -1;
        printer = print;
    }
    
    /**
     * Cria um TextualUI usando os parametros passados.
     * @param opt
     * @param head
     * @return 
     */
    public static ITextualUI of(List<String> opt, String head,IPrinter p){
        return new TextualUI(opt,head,p);
    }
    /**
     * Imprima o header do menu.
     * @return 
     */
    public boolean printHeader(){
        printer.print(header);
        return true;
    }
    /**
     * Numera e imprima as opções do menu.
     * @return 
     */
    public boolean printOptions(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for(String s : options){
             sb.append( i + "." + s + "\n");
             i++;
        }
        printer.print(sb.toString());
        return true;
    }
    
    /**
     * Imprima o menu como um todo e parse a opção escolhida pelo utilizador.
     * @return A opção escolhida pelo utilizador ou -1 em caso de erro.
     */
    public int printMenu(){
        lastChosenOption = -1;
        printHeader();
        printOptions();
        String line = printer.ask("");
        try{
            lastChosenOption = Integer.parseInt(line);
        }catch(Exception e){
            
        }
        return lastChosenOption;
        
    }
    /**
     * Devolve a ultima opção escolhida pelo utilizador.
     * @return 
     */
    public int getChosenOption(){
        return lastChosenOption;
    }
    
    
}   
