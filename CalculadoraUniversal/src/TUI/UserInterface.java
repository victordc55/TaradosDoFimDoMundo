package TUI;


import TUI.Print;
import TUI.UIFactory;
import TUI.TextualUI;
import calculadorauniversal.ICalculadoraUniversal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 
 */
public class UserInterface{
    
    private static ICalculadoraUniversal calculadoraUniversal;
    private static TextualUI currentUI;
    private static int formatingMode;
    
    public static void main(String[] args) {
        // Let's start the main....
        currentUI = UIFactory.firstUI();
        int option = 0;
        formatingMode = 1;
        boolean wantToQuit = false;
        while(!wantToQuit){
            currentUI.printMenu();
            switch(option){
                case 1:
                     firstModeInteraction();
                     
                     break;
                case 2:
                     secondModeInteraction();
                     break;
                case 3:
                     cronometro();
                     break;
                case 4:
                     outputFormatingInteraction();
                     break;
                case 5:
                     Print.print("Caso 5:\n");
                     wantToQuit = true;
                 default:
                     break;
            }
            currentUI = UIFactory.firstUI();
        
        }
    }



    
    private static void firstModeInteraction(){
           Print.print("Caso 1:\n");
           currentUI = UIFactory.localDataTimeUI();
           currentUI.printMenu();
        
        
    }
    
    
    
    private static void secondModeInteraction(){
           Print.print("Caso 2:\n");
           currentUI = UIFactory.zonedDateTimeUI();
           currentUI.printMenu();
        
    }
    
    
    
    private static void cronometro(){
            Print.print("Caso 3:\n");
            currentUI = UIFactory.cronometroUI();
            currentUI.printMenu();       
        
    }

    private static void outputFormatingInteraction(){
            Print.print("Caso 4:\n");
            currentUI = UIFactory.formatingOutputUI();
            currentUI.printMenu();
    }
}