package TUI;


import Datas.EstacaoTemperada;
import calculadorauniversal.CalculadoraUniversalISOLDT;
import calculadorauniversal.CalculadoraUniversalFactory;
import calculadorauniversal.Cronometro;
import calculadorauniversal.ICalculadoraUniversal;
import calculadorauniversal.ICalculadoraUniversalCuriosidade;
import calculadorauniversal.ICronometro;
import calculadorauniversal.Mode;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.OptionalInt;


/**
 *
 * @author 
 */
public class UserInterface{
    
    private static ICalculadoraUniversal calculadoraUniversal;
    private static ITextualUI currentUI;
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
        relogio = new Relogio();
    }
    
    private static void firstModeInteraction(){
            boolean wantToQuit = false;
            calculadoraUniversal = CalculadoraUniversalFactory.mode(Mode.ISO_LDATETIME);
            while(!wantToQuit){
                currentUI = UIFactory.localDataTimeUI();
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
        ICalculadoraUniversalCuriosidade curiosidades = CalculadoraUniversalFactory.getCuriosidade();
         while(!wantToQuit){
        	currentUI = UIFactory.curiosidadesUI();
        	 switch(currentUI.printMenu()){
	        	 case 1: // Primeiro dia do ano
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt ano = Printer.getInt();
	        		 if( ano.isPresent() ){
	        			 Printer.print(curiosidades.primeiroDiaAno(ano.getAsInt()).toString());
	        			 Printer.print("\n");
	        		 }else{
	        			 Printer.printErro("O valor inserido é incorreto.\n");
	        		 }
	                 break;
	        	 case 2: // Ultimo dia do ano
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt anoUltimo = Printer.getInt();
	        		 if(anoUltimo.isPresent()){
	        			 Printer.print(curiosidades.ultimoDiaAno(anoUltimo.getAsInt()).toString());
	        			 Printer.print("\n");
	        		 }else{
	        			 Printer.printErro("O valor inserido é incorreto.\n");
	        		 }
	                 break;
	        	 case 3: // Diz se o ano é bissexto ou nao
	        		 Printer.print("Insira o ano. \n");
	        		 OptionalInt bissexto = Printer.getInt();
	        		 if(bissexto.isPresent()){
	        			 Printer.print(curiosidades.isLeap(bissexto.getAsInt()));
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 4:
	        		 Printer.print("Insira a primeira data: ");
	        		 LocalDate ldt1 = Printer.pedirData();
	        		 Printer.print("Insira a segunda data: ");
	        		 LocalDate ldt2 = Printer.pedirData();
	        		 if(ldt1 != null && ldt2 != null){
	        			 Printer.print(curiosidades.diaEntreDatas(ldt1, ldt2).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 5:
	        		 Printer.print("Insera o ano: ");
	        		 OptionalInt anoNatal = Printer.getInt();
	        		 if(anoNatal != null){
	        			 Printer.print(curiosidades.diaNatal(anoNatal).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 6:
	        		 Printer.print("Insera o mes: ");
	        		 OptionalInt mes = Printer.getInt();
	        		 if(mes != null){
	        			 Printer.print(curiosidades.diasDoMes(mes).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 7:
	        		 Printer.print("Semanas desde o inicio do ano: " + curiosidades.semanasDesdeInicio().toString());
	        		 Printer.print("Semanas para o fim do ano: " + curiosidades.semanasFimAno().toString());
	        		 Printer.print("\n");
	        		 break;
	        	 case 8:
	        		 Printer.print("Insira uma data: ");
	        		 LocalDate ldt = Printer.pedirData();
	        		 if(ldt != null){
	        			 Printer.print("trimestre corresponde é: " + curiosidades.trimestre(ldt).toString());
	        			 Printer.print("\n");
	        		 }
	        		 break;
	        	 case 9:
	        		 Printer.print("Insira uma data: ");
	        		 LocalDate ldtestacao = Printer.pedirData();
	        		 if(ldtestacao != null){
	        			 Printer.print("Estação do ano corresponde é: " + curiosidades.estacaoDoAno(ldtestacao).toString());
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
            currentUI = UIFactory.diferencaEntreTempos();
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
            String answer = Printer.ask("Quere informações sobre hoje ou outra data? [h/hoje] [qualquer outro input = outro]\n");
            if( answer.contentEquals("hoje") || answer.contentEquals("h")){
                    infoDatas2(LocalDate.now());
            }else{
                    Printer.print("Insira a data.");
	            LocalDate data = Printer.pedirData();
                    infoDatas2(data);
	        }
	}
        
        private static void infoDatas2(LocalDate data){
            if(data != null){
	            Optional<DayOfWeek> dayOfWeek = calculadoraUniversal.diaDaSemana(data);
	            OptionalInt trimestre = calculadoraUniversal.trimestre(data);
                    OptionalInt diaNoAno = calculadoraUniversal.numeroDoDiaNoAno(data);
	            OptionalInt semanaNoAno =calculadoraUniversal.semanaNoAno(data);
                    Optional<EstacaoTemperada> estacao = calculadoraUniversal.estaçãoDoAnoNorte(data, true);
                    StringBuilder sb = new StringBuilder();
                    if( dayOfWeek.isPresent()) sb.append( dayOfWeek.get().name() +" ");
                    if( trimestre.isPresent()) sb.append( "Trimestre: " +trimestre.getAsInt()  + " ");
                    if( diaNoAno.isPresent()) sb.append( "Dia nº"+ diaNoAno.getAsInt() +" ");
                    if( semanaNoAno.isPresent()) sb.append("Semana nº"+ semanaNoAno.getAsInt() + " ");
                    if(estacao.isPresent()){
                        if( data.equals(LocalDate.now()) ) sb.append("A estação é " + estacao.get().name());
                        else if(data.isBefore(LocalDate.now())) sb.append("A estação era "+ estacao.get().toString());
                        else sb.append("A estação será "+ estacao.get().toString());
                        }
                    Printer.print(sb.toString());
                    }else Printer.print("A data introduzida é invalida.");
        }

	private static void diferençaEntreTempos() {
		boolean wantToQuit = false;
	        while(!wantToQuit){
	           currentUI = UIFactory.diferencaEntreTempos();
	            int option = currentUI.printMenu();
	                try {
	                    if (option <4) {
	                        if (option == 1){ 
	                            Printer.print("Insira a hora inicial.");
	                            LocalDate inicio = Printer.pedirData();
	                            Printer.print("Insira a hora final");
	                            LocalDate fim = Printer.pedirData();  
                                    Optional<Period> o = calculadoraUniversal.diferencaEntreDatas(inicio, fim);
                                    if( o.isPresent()) Printer.print(o.get());
                                    else Printer.printErro("Informações invalidas.");
	                            Printer.print(calculadoraUniversal.diferencaEntreDatas(inicio, fim).toString());
	                        }
	                        if (option == 2){
	                            Printer.print("Insira a hora inicial.");
	                            LocalTime inicio = Printer.pedirHoras();
	                            Printer.print("Insira a hora final");
	                            LocalTime fim = Printer.pedirHoras();
	                            Printer.print(calculadoraUniversal.diferencaEntreTempos(inicio, fim, true).toString());
	                        }
	                        if (option ==3){
	                            Printer.print("Insira a hora inicial.");
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
            currentUI = UIFactory.addSubtrair();
           int  option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.");
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
        	ITextualUI currentUI = UIFactory.addSubtrair();
            int option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.");
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
        	ITextualUI currentUI = UIFactory.addSubtrair();
            int option = currentUI.printMenu();
           
                try {
                    if (option < 3) {
                        Printer.print("Insira a data inicial.");
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
           boolean quit = false;
           while(! quit){
             currentUI = UIFactory.zonedDateTimeUI();
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
            currentUI = UIFactory.addSubtrair();
            int  option = currentUI.printMenu();
            try {
                if (option <3) {
                    Printer.print("Insira a hora inicial.");
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
                            Printer.print(calculadoraUniversal.addSubTempos(inicio, valor, false));
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
        Printer.print("Insira o fuso e data-hora inicial.");
        currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index = currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
        }
        ZonedDateTime zonaI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira o fuso e data-hora final.\n");
        currentUI = UIFactory.listZonedId();
        index =currentUI.printMenu();
        if (index >= 1 && index<= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zonaF = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneF);
        Optional<Duration> d = calculadoraUniversal.diferencaEntreFusos(zonaI, zonaF);
        if(d.isPresent()) Printer.print(d.get());
        else Printer.print("Não foi possivel, usando os dados introduzidos, calcular a diferença entre elas.");
    }
    
    private static void converterZonedDateTime(){
        Printer.print("Insira o fuso e data-hora inicial.");
        currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira o novo fuso.");
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
        Printer.print("Insira o fuso e data-hora da cidade inicial.");
        currentUI = UIFactory.listZonedId();
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            Printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtI = ZonedDateTime.of(Printer.pedirData(), Printer.pedirHoras(), zoneI);
        Printer.print("Insira o fuso e data-hora da cidade final.");
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
        Printer.print("Insira o fuso e data-hora da cidade inicial.");
        currentUI = UIFactory.listZonedId();
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
            ICronometro crono = CalculadoraUniversalFactory.getCrono();
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
                         if(duration.isPresent()) Printer.print(duration.get());
                         else Printer.print("O crono ja esta parado.");
                         break;
                  case 3:
                         if(crono.reset()) Printer.print("Cronómetro reset.");
                         else Printer.print("O cronómetro não pode ser reset enquanto estiver a correr.");
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
            currentUI = UIFactory.formatingOutputUI();
            switch(currentUI.printMenu()){
                case 1:
                      Printer.setPrintMode(1);
                      break;
                case 2:
                      Printer.setPrintMode(2);
                      break;
                default:
                      break;
            }
    }
    

}
