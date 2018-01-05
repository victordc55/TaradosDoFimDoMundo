/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

/**
 *
 * 
 */
public class CalculadoraUniversalFactory {
    
    public static ICalculadoraUniversal mode(Mode m){
        switch( m ){
            case ISO_LDATETIME:
                    return new CalculadoraUniversalISOLDT();
            case ISO_ZODATETIME:
                    return new CalculadoraUniversalISOLDT();
            default:
                break;
        } 
        return null;
    }
    
    public static ICronometro getCrono(){
        return new Cronometro();
    }
    
    
}
