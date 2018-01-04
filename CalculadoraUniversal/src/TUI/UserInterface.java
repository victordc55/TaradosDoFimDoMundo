package TUI;


import calculadorauniversal.CalculadoraUniversalISOLDT;
import calculadorauniversal.Cronometro;
import calculadorauniversal.ICalculadoraUniversal;
import calculadorauniversal.ICronometro;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;


/**
 *
 * @author 
 */
public class UserInterface{
    
    private static ICalculadoraUniversal calculadoraUniversal;
    private static TextualUI currentUI;
    private static Printer print;
    private static Relogio relogio;
    private static boolean wantToQuit ;
 
    public static void main(String[] args) {
        // Let's start the main....
        init();
        wantToQuit = false;
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
        calculadoraUniversal = new CalculadoraUniversalISOLDT();
    }
    
    private static void firstModeInteraction(){
            currentUI = UIFactory.localDataTimeUI();
            boolean wantToQuit = false;
            while(!wantToQuit){
                switch(currentUI.printMenu()){
                    case 1:
                        addSubDatas();
                        break;
                    case 2:
                        addSubHoras();
                        break;
                    case 3:
                        addSubTempos();
                        break;
                    case 4:
                        diferençaEntreTempos();
                        break;
                    case 5:
                        infoDatas();
                        break;
                    case 6:
                        tempoAteData();
                        break;
                    case 7:
                        curiosidades();
                        break;
                    case 8:
                    	wantToQuit = true;
                        break;
                }
            }  
            
    }
    
    
    
    private static void curiosidades() {
         while(!wantToQuit){
        	 TextualUI currentUI = UIFactory.curiosidades();
            int option = currentUI.printMenu();
                 try {
                     if (option <4) {
                         Printer.print("Insira a data.\n");
                         LocalDate data = Printer.pedirData();
                         if (option == 1){ 
                             Printer.print(calculadoraUniversal.estaçãoDoAnoNorte(data, true).toString());
                         }
                         if (option == 2){
                             Printer.print(calculadoraUniversal.estaçãoDoAnoNorte(data, false).toString());
                         }
                         if (option == 3){
//                             Printer.print(calculadora.isLeap(data));
                         }
                     }
                     else if(option > 4)
                         Printer.printErro("Não existe essa opção.");
                     else    
                    	 wantToQuit = true;  
                 } catch (Exception e) {
                     Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                 }
         }
	}


	private static void tempoAteData() {
        while(!wantToQuit){
        	TextualUI currentUI = UIFactory.diferencaEntreTempos();
            int option = currentUI.printMenu();
                try {
                    if (option <4) {
                        if (option == 1){ 
                            LocalDate inicio = LocalDate.now();
                            Printer.print("Insira a Data final");
                            LocalDate fim = Printer.pedirData();
                            Printer.print(calculadoraUniversal.diferencaEntreDatas(inicio, fim).toString());
                        }
                        if (option == 2){
                            LocalTime inicio = LocalTime.now();
                            Printer.print("Insira a hora final");
                            LocalTime fim = Printer.pedirHoras();
                            Printer.print(calculadoraUniversal.diferencaEntreTempos(inicio, fim, true).toString());
                        }
                        if (option ==3){
                            LocalDateTime inicio = LocalDateTime.now();
                            Printer.print("Insira a data e hora final");
                            LocalDateTime fim = LocalDateTime.of(Printer.pedirData(),Printer.pedirHoras());
                              Printer.print(calculadoraUniversal.diferencaEntreTempos(inicio, fim, false).toString());
                        }
                    }
                    else if(option > 4)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
	}


	private static void infoDatas() {
	        while(!wantToQuit){
	        	TextualUI currentUI = UIFactory.infoDatas();
	           int option = currentUI.printMenu();
	                try {
	                    if (option <5) {
	                        Printer.print("Insira a data.\n");
	                        LocalDate data = Printer.pedirData();
	                        if (option == 1){ 
	                            Printer.print(calculadoraUniversal.diaDaSemana(data).toString());
	                        }
	                        if (option == 2){
	                            Printer.print(calculadoraUniversal.trimestre(data).toString());
	                        }
	                        if (option == 3){
	                            Printer.print(calculadoraUniversal.numeroDoDiaNoAno(data).toString());
	                        }
	                        if (option == 4){
	                            Printer.print(calculadoraUniversal.semanaNoAno(data).toString());
	                        }
	                    }
	                    else if(option > 5)
	                        Printer.printErro("Não existe essa opção.");
	                    else    
	                        wantToQuit = true;  
	                } catch (Exception e) {
	                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
	                }
	        }
	}


	private static void diferençaEntreTempos() {
	        while(!wantToQuit){
	        	TextualUI currentUI = UIFactory.diferencaEntreTempos();
	            int option = currentUI.printMenu();
	                try {
	                    if (option <4) {
	                        if (option == 1){ 
	                            Printer.print("Insira a hora inicial.\n");
	                            LocalDate inicio = Printer.pedirData();
	                            Printer.print("Insira a hora final");
	                            LocalDate fim = Printer.pedirData();
	                            Printer.print(calculadoraUniversal.diferencaEntreDatas(inicio, fim).toString());
	                        }
	                        if (option == 2){
	                            Printer.print("Insira a hora inicial.\n");
	                            LocalTime inicio = Printer.pedirHoras();
	                            Printer.print("Insira a hora final");
	                            LocalTime fim = Printer.pedirHoras();
	                            Printer.print(calculadoraUniversal.diferencaEntreTempos(inicio, fim, true).toString());
	                        }
	                        if (option ==3){
	                            Printer.print("Insira a hora inicial.\n");
	                            LocalDateTime inicio = LocalDateTime.of(Printer.pedirData(),Printer.pedirHoras());
	                            Printer.print("Insira a hora final");
	                            LocalDateTime fim = LocalDateTime.of(Printer.pedirData(),Printer.pedirHoras());
	                              Printer.print(calculadoraUniversal.diferencaEntreTempos(inicio, fim, false).toString());
	                        }
	                    }
	                    else if(option > 4)
	                        Printer.printErro("Não existe essa opção.");
	                    else    
	                        wantToQuit = true;  
	                } catch (Exception e) {
	                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
	                }
	        }
	}


	private static void addSubTempos() {
        while(!wantToQuit){
        	TextualUI currentUI = UIFactory.addSubtrair();
           int  option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.\n");
                        LocalDateTime inicio = LocalDateTime.of(Printer.pedirData(), Printer.pedirHoras());
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalDateTime valor = LocalDateTime.of(Printer.pedirComSemana(), Printer.pedirHoras());
                        if (option == 1) 
                            Printer.print(calculadoraUniversal.addSubTempos(inicio, valor, true).toString());
                        if (option == 2)
                            Printer.print(calculadoraUniversal.addSubTempos(inicio, valor, false).toString());
                    }
                    else if(option > 3)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
	}


	private static void addSubHoras() {
        while(!wantToQuit){
        	TextualUI currentUI = UIFactory.addSubtrair();
            int option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.\n");
                        LocalTime inicio = Printer.pedirHoras();
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalTime valor = Printer.pedirHoras();
                        if (option == 1) 
                            Printer.print(calculadoraUniversal.addSubHoras(inicio, valor, true).toString());
                        
                        if (option == 2)
                            Printer.print(calculadoraUniversal.addSubHoras(inicio, valor, false).toString());
                    }
                    else if(option > 3)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
	}


	private static void addSubDatas() {
		 boolean wantToQuit = false;
        while(!wantToQuit){
        	TextualUI currentUI = UIFactory.addSubtrair();
            int option = currentUI.printMenu();
           
                try {
                    if (option < 3) {
                        Printer.print("Insira a data inicial.\n");
                        LocalDate inicio = Printer.pedirData();
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalDate valor = Printer.pedirComSemana();
                        if (option == 1) 
                            Printer.print(calculadoraUniversal.addSubDatas(inicio, valor, true).toString());
                        if (option == 2)
                            Printer.print(calculadoraUniversal.addSubDatas(inicio, valor, false).toString());
                    }else if(option > 3){
                    	
                        Printer.printErro("Não existe essa opção.");
                    }else {   
                        wantToQuit = true;
                    }
                } catch (Exception e) {
                    Printer.printErro("Os valores da Data não foram introduzidos corretamente.\n");
                }
        }
		
	}

	private static void secondModeInteraction(){
    	   
           Printer.print("Caso 2:");
           currentUI = UIFactory.zonedDateTimeUI();
           boolean quit = false;
           while(! quit){
             switch(currentUI.printMenu()){
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
	                  quit = true;
	                  break;
		          default:
		                  Printer.print("Valor invalido. Escolhe uma das opções disponiveis.");
             }
           }
        
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