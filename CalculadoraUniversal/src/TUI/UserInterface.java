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
    private static int formatingMode = 1; // mode = 1 represent numerical formating, 2 represents expanded formating.
    
    public static void main(String[] args) {
        // Let's start the main....
        currentUI = UIFactory.firstUI();
        int option = 0;
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
           switch( currentUI.printMenu() ){
               case 1:
                   break;
               case 2:
                   break;
               case 3:
                   break;
               case 4:
                   break;
               case 5:
                   break;
               case 6:
                   break;
               case 7:
                   break;
               case 8:
                   //quit
                   break;
               default:
                   break;
           }
        
        
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