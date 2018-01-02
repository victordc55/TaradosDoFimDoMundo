package TUI;


import calculadorauniversal.Cronometro;
import calculadorauniversal.ICalculadoraUniversal;
import calculadorauniversal.ICronometro;
import java.time.Duration;
import java.util.Optional;


/**
 *
 * @author 
 */
public class UserInterface{
    
    private static ICalculadoraUniversal calculadoraUniversal;
    private static TextualUI currentUI;
    private static Printer print;
    private static CalculoLDTUI ldt;
    private static Relogio relogio;
 
    public static void main(String[] args) {
        // Let's start the main....
        init();
        boolean wantToQuit = false;
        while(!wantToQuit){
            currentUI = UIFactory.firstUI();
            switch(currentUI.printMenu()){
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
                     wantToQuit = true;
                     relogio.stop();
                 default:
                     break;
            }
        }
    }


    private static void init(){
        currentUI = UIFactory.firstUI();
        print = new Printer();
        relogio = new Relogio(print);
        ldt = new CalculoLDTUI();
    }
    
    private static void firstModeInteraction(){
            currentUI = UIFactory.localDataTimeUI();
            boolean quit = false;
            while(!quit){
                switch(currentUI.printMenu()){
                    case 1:
                        ldt.addSubDatas();
                        break;
                    case 2:
                        ldt.addSubHoras();
                        break;
                    case 3:
                        ldt.addSubTempos();
                        break;
                    case 4:
                        ldt.diferençaEntreTempos();
                        break;
                    case 5:
                        ldt.infoDatas();
                        break;
                    case 6:
                        ldt.tempoAteData();
                        break;
                    case 7:
                        ldt.curiosidades();
                        break;
                    case 8:
                        quit = true;
                        break;
                }
            }  
            
    }
    
    
    
    private static void secondModeInteraction(){
           Printer.print("Caso 2:");
           currentUI = UIFactory.zonedDateTimeUI();
           currentUI.printMenu();
        
    }
    
    
    
    private static void cronometro(){
            ICronometro crono = new Cronometro();
            currentUI = UIFactory.cronometroUI();
            boolean quit = false;
            while(! quit){
              switch(currentUI.printMenu()){
                  
                  case 1:
                         if(crono.start()) Printer.print("Cronometro lançado.");
                         else Printer.print("O cronometro ja esta a correr.");
                         break;
                  case 2:
                         Optional<Duration> duration = crono.stop();
                         if(duration.isPresent()) print.print(duration.get());
                         else Printer.print("O crono ja esta parado.");
                         break;
                  case 3:
                         crono.reset();
                         break;
                  case 4:
                          quit = true;
                          break;
                  default:
                          Printer.print("Valor invalido. Escolhe uma das opções disponiveis.");
              }
                
            }
            
 
    }

    
    
    private static void outputFormatingInteraction(){
            currentUI = UIFactory.formatingOutputUI();
            switch(currentUI.printMenu()){
                case 1:
                      print.setPrintMode(1);
                      break;
                case 2:
                      print.setPrintMode(2);
                      break;
                default:
                      break;
            }
    }

}