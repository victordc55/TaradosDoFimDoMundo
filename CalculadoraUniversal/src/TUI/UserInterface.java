package TUI;


import calculadorauniversal.CalculadoraUniversalISOLDT;
import calculadorauniversal.Cronometro;
import calculadorauniversal.ICalculadoraUniversal;
import calculadorauniversal.ICronometro;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.OptionalInt;


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
            TextualUI currentUI = UIFactory.firstUI();
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
    	TextualUI currentUI = UIFactory.localDataTimeUI();
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
    	boolean wantToQuit = false;
         while(!wantToQuit){
        	 TextualUI currentUI = UIFactory.curiosidadesUI();
        	 
        	 switch(currentUI.printMenu()){
	        	 case 1:
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt ano = Printer.getInt();
	        		 if(ano != null){
	        			 Printer.print(calculadoraUniversal.primeiroDiaAno(ano.getAsInt()).toString());
	        			 Printer.print("\n");
	        		 }else{
	        			 Printer.printErro("O valore não foram introduzido corretamente.\n");
	        		 }
	                 break;
	        	 case 2:
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt anoUltimo = Printer.getInt();
	        		 if(anoUltimo != null){
	        			 Printer.print(calculadoraUniversal.ultimoDiaAno(anoUltimo.getAsInt()).toString());
	        			 Printer.print("\n");
	        		 }else{
	        			 Printer.printErro("O valore não foram introduzido corretamente.\n");
	        		 }
	                 break;
	        	 case 3:
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt bissexto = Printer.getInt();
	        		 if(bissexto != null){
	        			 Printer.print(calculadoraUniversal.isLeap(bissexto.getAsInt()));
	        			 Printer.print("\n");
	        		 }
	        		 
	        		 break;
	        	 case 4:
	        		 Printer.print("Insira a primeira data: ");
	        		 LocalDate ldt1 = Printer.pedirData();
	        		 Printer.print("Insira a segunda data: ");
	        		 LocalDate ldt2 = Printer.pedirData();
	        		 if(ldt1 != null && ldt2 != null){
	        			 Printer.print(calculadoraUniversal.diaEntreDatas(ldt1, ldt2).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 5:
	        		 Printer.print("Insera o ano: ");
	        		 OptionalInt anoNatal = Printer.getInt();
	        		 if(anoNatal != null){
	        			 Printer.print(calculadoraUniversal.diaNatal(anoNatal).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 6:
	        		 Printer.print("Insera o mes: ");
	        		 OptionalInt mes = Printer.getInt();
	        		 if(mes != null){
	        			 Printer.print(calculadoraUniversal.diasDoMes(mes).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 7:
	        		 Printer.print("Semanas desde o inicio do ano: " + calculadoraUniversal.semanasDesdeInicio().toString());
	        		 Printer.print("Semanas para o fim do ano: " + calculadoraUniversal.semanasFimAno().toString());
	        		 Printer.print("\n");
	        		 break;
	        	 case 8:
	        		 Printer.print("Insira uma data: ");
	        		 LocalDate ldt = Printer.pedirData();
	        		 if(ldt != null){
	        			 Printer.print("trimestre corresponde é: " + calculadoraUniversal.trimestre(ldt).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 9:
	        		 Printer.print("Insira uma data: ");
	        		 LocalDate ldtestacao = Printer.pedirData();
	        		 if(ldtestacao != null){
	        			 Printer.print("Estação do ano corresponde é: " + calculadoraUniversal.estacaoDoAno(ldtestacao).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	             case 10:
		             	wantToQuit = true;
		                 break;
        	 }

         }
    }


    private static void tempoAteData() {
	boolean wantToQuit = false;
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
		boolean wantToQuit = false;
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
		boolean wantToQuit = false;
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
		boolean wantToQuit = false;
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
		boolean wantToQuit = false;
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
           TextualUI currentUI = UIFactory.zonedDateTimeUI();
           boolean quit = false;
           while(! quit){
             switch(currentUI.printMenu()){
	            case 1:
                        addSubTempoZonedDateTime();
	                break;
		    case 2:
		        diferencaEntreFusos();        
		        break;
		    case 3:
		        converterZonedDateTime();         
		        break;
		    case 4:
                        diferencaTempoEntreCidades();
		        break;
		    case 5:
		        tempoAteOutroFuso();
	                break;
		    case 6:
		         quit = true;
	                break;	  	               
		    default:
		        Printer.print("Valor invalido. Escolhe uma das opções disponiveis.");
             }
           }
        
    }

    private static void addSubTempoZonedDateTime() {
    	boolean wantToQuit = false;
        ZoneId zone = null;
    	while(!wantToQuit){
            TextualUI currentUI = UIFactory.addSubtrair();
            int  option = currentUI.printMenu();
            try {
                if (option <3) {
                    Printer.print("Insira a hora inicial.\n");
                    LocalDateTime inicio = LocalDateTime.of(Printer.pedirData(), Printer.pedirHoras());
                    currentUI = UIFactory.listZonedId();
                    int index =currentUI.printMenu();
                    if (index >= 1 && index<= 26) {
                       zone = ZoneId.of(getZoneId(index-1)); 
                    }
                    else{
                        Printer.print("Não existe essa opção");
                        break;
                    }
                    Printer.print("Valor que pretende somar ou subtrair.");
                    LocalDateTime valor = LocalDateTime.of(Printer.pedirComSemana(), Printer.pedirHoras());
                    if (option == 1) 
                     //   Printer.print();
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
    
    private static void diferencaEntreFusos(){
        Printer.print("Insira a fuso e data-hora inicial.\n");
        TextualUI currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zonaI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira a fuso e data-hora final.\n");
        currentUI = UIFactory.listZonedId();
        index =currentUI.printMenu();
        if (index >= 1 && index<= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zonaF = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneF);
        Printer.print(calculadoraUniversal.diferencaEntreFusos(zonaI, zonaF).toString());
    }
    
    private static void converterZonedDateTime(){
        Printer.print("Insira a fuso e data-hora inicial.\n");
        TextualUI currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira o novo fuso.\n");
        currentUI = UIFactory.listZonedId();
        index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        Printer.print(calculadoraUniversal.convertZonedDateTime(zdtI, zoneF).toString());
    }
    
    private static void diferencaTempoEntreCidades(){
        Printer.print("Insira a fuso e data-hora da cidade inicial.\n");
        TextualUI currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira o fuso e data-hora da cidade final.\n");
        currentUI = UIFactory.listZonedId();
        index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtF = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneF);
        Printer.print(calculadoraUniversal.diferencaEntreFusos(zdtI, zdtF).toString());
    }
    
    private static void tempoAteOutroFuso(){
        LocalDateTime agora = LocalDateTime.now();
        ZoneOffset zoneOff = OffsetDateTime.now().getOffset();
        ZonedDateTime zdtAtual = ZonedDateTime.of(agora, zoneOff);
        Printer.print("Insira a fuso e data-hora da cidade inicial.\n");
        TextualUI currentUI = UIFactory.listZonedId();
        ZoneId zoneFinal = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneFinal = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            tempoAteOutroFuso();
            }
        ZonedDateTime zdtFinal = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneFinal);
        
       Printer.print(calculadoraUniversal.diferencaEntreFusos(zdtAtual, zdtFinal).toString());
    }
    

	private static void cronometro(){
            ICronometro crono = new Cronometro();
            TextualUI currentUI = UIFactory.cronometroUI();
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
        
    private static String getZoneId(int index){
        
        String[] zoneId = {"Pacific/Apia",
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
                        "Pacific/Samoa"};
        return zoneId[index];
        }  
    
    private static void outputFormatingInteraction(){
            TextualUI currentUI = UIFactory.formatingOutputUI();
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