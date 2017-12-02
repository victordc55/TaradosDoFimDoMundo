
import calculadorauniversal.ICalculadoraUniversal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VICTOR CUNHA
 */
public class Main{
    private static ICalculadoraUniversal calculadoraUniversal;
    
    public static void main(String[] args) {
        // Let's start the main....
        TextualUI t = UIFactory.isoAdSubsDateTimeUI();
        t.printHeader();
        int option = t.printMenu();
        Print.print(Integer.toString(option));
    }
}
