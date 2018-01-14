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
    
   private Relogio relogio;
   private IPrinter printer;
// 
//    public static void main(String[] args) {
//        // Let's start the main....
//        init();
//        boolean wantToQuit = false;
//        while(!wantToQuit){
//            currentUI = UIFactory.firstUI();
//            switch(currentUI.printMenu()){
//                case 1:
//                     firstModeInteraction();
//                     break;
//                case 2:
//                     secondModeInteraction();
//                     break;
//                case 3:
//                     cronometro();
//                     break;
//                case 4:
//                     outputFormatingInteraction();
//                     break;
//                case 5:
//                     wantToQuit = true;
//                     relogio.stop();
//                 default:
//                     break;
//            }
//        }
//    }
   
   private UserInterface(){
        relogio = null;
        printer = null;
   }
   
   public static UserInterface getUserInterface(){
       return new UserInterface();
   }
   
   
   public void setPrinter(IPrinter p){
       printer = p;
       if(relogio != null) relogio.setPrinter(p);
       else relogio = new Relogio(p);
   }

    public  void init(){
    	ITextualUI currentUI; 
        boolean wantToQuit = false;
        while(!wantToQuit){
          currentUI = UIFactory.firstUI(printer.clone());
          relogio.showTime();
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
    
    private void firstModeInteraction(){
    	ITextualUI currentUI;
    	ICalculadoraUniversal calculadoraUniversal = CalculadoraUniversalFactory.mode(Mode.ISO_LDATETIME);;
        boolean wantToQuit = false;
            
            while(!wantToQuit){
                
                currentUI = UIFactory.localDataTimeUI(printer.clone());
                relogio.showTime();
                switch(currentUI.printMenu()){
                    case 1:
                        addSubDatas(calculadoraUniversal);
                        break;
                    case 2:
                        addSubHoras(calculadoraUniversal);
                        break;
                    case 3:
                        addSubTempos(calculadoraUniversal);
                        break;
                    case 4:
                        diferençaEntreTempos(calculadoraUniversal);
                        break;
                    case 5:
                        infoDatas(calculadoraUniversal);
                        break;
                    case 6:
                        tempoAteData(calculadoraUniversal);
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
    
    
    
    private void curiosidades() {
    	ITextualUI currentUI;
    	boolean wantToQuit = false;
        ICalculadoraUniversalCuriosidade curiosidades = CalculadoraUniversalFactory.getCuriosidade();
         while(!wantToQuit){
                
        	currentUI = UIFactory.curiosidadesUI(printer.clone());
                relogio.showTime();
        	 switch(currentUI.printMenu()){
	        	 case 1: // Primeiro dia do ano
	        		 printer.print("Insira o ano. \n");
	        		 OptionalInt ano = printer.getInt();
	        		 if( ano.isPresent() ){
	        			 printer.print(curiosidades.primeiroDiaAno(ano.getAsInt()).toString());
	        			 printer.print("\n");
	        		 }else{
	        			 printer.printErro("O valor inserido é incorreto.\n");
	        		 }
	                 break;
	        	 case 2: // Ultimo dia do ano
	        		 printer.print("Insira o ano. \n");
	        		 OptionalInt anoUltimo = printer.getInt();
	        		 if(anoUltimo.isPresent()){
	        			 printer.print(curiosidades.ultimoDiaAno(anoUltimo.getAsInt()).toString());
	        			 printer.print("\n");
	        		 }else{
	        			 printer.printErro("O valor inserido é incorreto.\n");
	        		 }
	                 break;
	        	 case 3: // Diz se o ano é bissexto ou nao
	        		 printer.print("Insira o ano.");
	        		 OptionalInt bissexto = printer.getInt();
	        		 if(bissexto.isPresent()){
	        			 printer.print(curiosidades.isLeap(bissexto.getAsInt()));
	        			 printer.print("\n");
	        		 }else {
	        			 printer.printErro("O valor inserido é incorreto.\n");
					}
	        		 break;
	        	 case 4:
	        		 printer.print("Insira a primeira data: ");
	        		 LocalDate ldt1 = printer.pedirData();
	        		 printer.print("Insira a segunda data: ");
	        		 LocalDate ldt2 = printer.pedirData();
	        		 if(ldt1 != null && ldt2 != null){
	        			 printer.print(curiosidades.diaUteisEntreDatas(ldt1, ldt2).toString());
	        		 }else{
	        			 printer.printErro("Os valores inseridos são incorretos.\n");
	        		 }
	        		 break;
	        	 case 5:
	        		 printer.print("Insera o ano: ");
	        		 OptionalInt anoNatal = printer.getInt();
	        		 if(anoNatal != null){
                                        if( anoNatal.isPresent() && anoNatal.getAsInt() >= 1){
                                                       Optional<DayOfWeek> odow = curiosidades.diaNatal(anoNatal);
                                                       if( odow.isPresent()) printer.print(odow.get().toString());
                                                       else printer.print("Não foi possivel determinar em que dia de semana ira ocorrer natal no ano inserido.\nPedimos desculpa.");
                                        }
	        		 }else {
	        			 printer.printErro("O valor inserido é incorreto.\n");
					}
	        		 break;
	        	 case 6:
	        		 printer.print("Insera o mes: ");
	        		 OptionalInt mes = printer.getInt();
	        		 if(mes != null){
	        			 printer.print(curiosidades.diasDoMes(mes).toString());
	        		 }else {
	        			 printer.printErro("O valor inserido é incorreto.\n");
					}
	        		 break;
	        	 case 7:
	        		 printer.print("Semanas desde o inicio do ano: " + curiosidades.semanasDesdeInicio());
	        		 printer.print("Semanas para o fim do ano: " + curiosidades.semanasFimAno());
	        		 break;
	        	 case 8:
	        		 printer.print("Insira uma data: ");
	        		 LocalDate ldt = printer.pedirData();
	        		 if(ldt != null){
	        			 printer.print("trimestre corresponde é: " + curiosidades.trimestre(ldt));
	        		 }else {
	        			 printer.printErro("Os valores inseridos são incorretos.\n");
					}
	        		 break;
	        	 case 9:
	        		 printer.print("Insira uma data: ");
	        		 LocalDate ldtestacao = printer.pedirData();
	        		 if(ldtestacao != null){
	        			 printer.print("Estação do ano corresponde é: " + curiosidades.estacaoDoAno(ldtestacao));
	        		 }else {
	        			 printer.printErro("Os valores inseridos são incorretos.\n");
					}
	        		 break;
	             case 10:
		             	wantToQuit = true;
		                 break;
        	 }

         }
    }


    private void tempoAteData(ICalculadoraUniversal calculadoraUniversal) {
    	ITextualUI currentUI ;
    	boolean wantToQuit = false;
        LocalDate inicio,fim;
        LocalTime time1,time2;
        LocalDateTime ini,fi=null; // Divisão em metodos...
        while(!wantToQuit){
            currentUI = UIFactory.diferencaEntreTempos(printer.clone());
            relogio.showTime();
            switch(currentUI.printMenu()){
                case 1:
                            inicio = LocalDate.now();
                            printer.print("Insira a Data final");
                            fim = printer.pedirData();
                            if(fim != null){
                                Optional<Period> od = calculadoraUniversal.diferencaEntreDatas(inicio, fim);
                            	if(od.isPresent()) printer.print( od.get());
                                else printer.print("Não foi possivel calcular a diferença entre as datas. Pedimos desculpa.");
                            }else{
                            	printer.printErro("Os valores inseridos são incorretos.\n");
                            }
                            break;
                case 2:
                            time1 = LocalTime.now();
                            printer.print("Insira a hora final");
                            time2 = printer.pedirHoras();
                            if(time2 != null){
                                Optional<Duration> d = calculadoraUniversal.diferencaEntreTempos(time1, time2, true);
                                if(d.isPresent()) printer.print(d.get());
                                else printer.print("Não foi possivel calcular a diferença de horas. Pedimos desculpa.");
                            }else{
                            	printer.printErro("Os valores inseridos são incorretos.\n");
                            }
                            break;
                case 3:
                            ini = LocalDateTime.now();
                            printer.print("Insira a data e hora final");
                            inicio = printer.pedirData();
                            time1 = printer.pedirHoras();
                            if( time1 != null && inicio != null)
                                    fi = LocalDateTime.of(inicio,time1);
                            if(fi != null){
                                Optional<Duration> op = calculadoraUniversal.diferencaEntreTempos(ini, fi, false);
                                if( op.isPresent()) printer.printBigDuration(op.get());
                                else  printer.print("Não foi possivel calcular a diferença de tempos. Pedimos desculpa.");
                            }else {
                            	printer.printErro("Os valores inseridos são incorretos.\n");
							}
                            break;
                case 4: 
                        wantToQuit = true;  
                        break;
                default:
                        printer.printErro("Não existe essa opção.");
                        break;
               }
            
        }
	}

    private void infoDatas(ICalculadoraUniversal calculadoraUniversal) {
            String answer = printer.ask("Quere informações sobre hoje ou outra data? [h/hoje] [qualquer outro input = outro]\n");
            if( answer.contentEquals("hoje") || answer.contentEquals("h")){
                    infoDatas2(LocalDate.now(),calculadoraUniversal);
            }else{
                    printer.print("Insira a data.");
	            LocalDate data = printer.pedirData();
                    infoDatas2(data,calculadoraUniversal);
	        }
	}
        
    private void infoDatas2(LocalDate data,ICalculadoraUniversal calculadoraUniversal){
            if(data != null){
	            Optional<DayOfWeek> dayOfWeek = calculadoraUniversal.diaDaSemana(data);
	            OptionalInt trimestre = calculadoraUniversal.trimestre(data);
                    OptionalInt diaNoAno = calculadoraUniversal.numeroDoDiaNoAno(data);
	            OptionalInt semanaNoAno = calculadoraUniversal.semanaNoAno(data);
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
                    printer.print(sb.toString());
                    }else printer.print("A data introduzida é invalida.");
        }

    private void diferençaEntreTempos(ICalculadoraUniversal calculadoraUniversal) {
		ITextualUI currentUI;
		boolean wantToQuit = false;
                LocalDate inicio=null;LocalDateTime ini= null,fi= null; // Deveriam ser criados metodos para cada funcionalidade em vez de termos tantas variaveis
                LocalDate fim=null;
                LocalTime time1= null,time2=null;
                boolean weGotAProblem;
	        while(!wantToQuit){
	           currentUI = UIFactory.diferencaEntreTempos(printer.clone());
                   weGotAProblem = false;
                   relogio.showTime();
	            switch(currentUI.printMenu()){
                            case 1: 
	                            printer.print("Insira a hora inicial.");
	                            inicio = printer.pedirData();
	                            printer.print("Insira a hora final");
	                            fim = printer.pedirData();
	                            if(inicio != null && fim != null){
	                            	Optional<Period> o = calculadoraUniversal.diferencaEntreDatas(inicio, fim);
                                        if( o.isPresent()) printer.print(o.get());
                                        else weGotAProblem = true;
	                            }else {
	                            	weGotAProblem = true;
                                    }
                                    break;
                            case 2:
	                            printer.print("Insira a hora inicial.");
	                            time1 = printer.pedirHoras();
	                            printer.print("Insira a hora final");
	                            time2 = printer.pedirHoras();
	                            if(time1 != null && time2 != null){
                                        Optional<Duration> p = calculadoraUniversal.diferencaEntreTempos(time1, time2, true);
	                            	if(p.isPresent()) printer.print(p.get());
                                        else weGotAProblem = true;
	                            }else {
	                            	weGotAProblem = true;
                                    }
                                    break;
                            case 3 :
	                            printer.print("Insira a hora inicial.");
                                    inicio = printer.pedirData();
                                    time1 = printer.pedirHoras();
                                    if( inicio != null && time1 != null)
                                        ini = LocalDateTime.of(inicio,time1);
	                            printer.print("Insira a hora final");
                                    inicio = printer.pedirData();
                                    time1 = printer.pedirHoras();
                                    if( inicio != null && time1 != null)
                                        fi = LocalDateTime.of(inicio,time1);
	                            if(ini != null && fi  != null){
                                        Optional<Duration> op = calculadoraUniversal.diferencaEntreTempos(ini, fi, false);
                                        if(op.isPresent()) printer.print(op.get());
                                        else weGotAProblem = true;
	                            }else {
	                            	weGotAProblem = true;
                                    }
                                    break;
                            case 4: 
                                    wantToQuit = true;
                                    break;
                            default:
                                    break;
                    }
                    if(weGotAProblem) printer.printErro("O valore não foram introduzido corretamente.\n");
	        }
	}


    private void addSubTempos(ICalculadoraUniversal calculadoraUniversal) {
    	ITextualUI currentUI;
	boolean wantToQuit = false;
         while(!wantToQuit){
            currentUI = UIFactory.addSubtrair(printer.clone());
            relogio.showTime();
           int  option = currentUI.printMenu();
                try {
                    if (option <3) {
                        printer.print("Insira a hora inicial.");
                        LocalDateTime inicio = LocalDateTime.of(printer.pedirData(), printer.pedirHoras());
                        printer.print("Valor que pretende somar ou subtrair.");
                        LocalDateTime valor = LocalDateTime.of(printer.pedirComSemana(), printer.pedirHoras());
                        if(inicio != null && valor != null){
                        	 if (option == 1) 
                        		 printer.print(calculadoraUniversal.addSubTempos(inicio, valor, true).toString());
                        	 if (option == 2)
                        		 printer.print(calculadoraUniversal.addSubTempos(inicio, valor, false).toString());
                        }else {
                        	printer.printErro("O valore não foram introduzido corretamente.\n");
						}
                       
                    }
                    else if(option > 3)
                        printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }


    private void addSubHoras(ICalculadoraUniversal calculadoraUniversal) {
	boolean wantToQuit = false;
        ITextualUI currentUI ;
        int option;
        while(!wantToQuit){
            currentUI = UIFactory.addSubtrair(printer.clone());
            relogio.showTime();
            option = currentUI.printMenu();
                try {
                    if (option <3) {
                        printer.print("Insira a hora inicial.");
                        LocalTime inicio = printer.pedirHoras();
                        printer.print("Valor que pretende somar ou subtrair.");
                        LocalTime valor = printer.pedirHoras();
                        if(inicio != null && valor != null){
	                        if (option == 1) 
	                            printer.print(calculadoraUniversal.addSubHoras(inicio, valor, true).toString());
	                        
	                        if (option == 2)
	                            printer.print(calculadoraUniversal.addSubHoras(inicio, valor, false).toString());
                        }else {
                        	printer.printErro("O valore não foram introduzido corretamente.\n");
						}
                    }
                    else if(option > 3)
                        printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
	}


    private void addSubDatas(ICalculadoraUniversal calculadoraUniversal) {
	boolean wantToQuit = false;
        int option; ITextualUI currentUI;
        while(!wantToQuit){
             currentUI = UIFactory.addSubtrair(printer.clone());
             relogio.showTime();
            option = currentUI.printMenu();
           
                try {
                    if (option < 3) {
                        printer.print("Insira a data inicial.");
                        LocalDate inicio = printer.pedirData();
                        
                        printer.print("Valor que pretende somar ou subtrair.");
                        LocalDate valor = printer.pedirComSemana();
                        
                        if(inicio != null && valor != null){
	                        if (option == 1) 
	                            printer.print(calculadoraUniversal.addSubDatas(inicio, valor, true).toString());
	                        if (option == 2)
	                            printer.print(calculadoraUniversal.addSubDatas(inicio, valor, false).toString());
                        }else {
                        	printer.printErro("O valore não foram introduzido corretamente.\n");
						}
                    }else if(option > 3){
                    	
                        printer.printErro("Não existe essa opção.");
                    }else {   
                        wantToQuit = true;
                    }
                } catch (Exception e) {
                    printer.printErro("Os valores da Data não foram introduzidos corretamente.\n");
                }
        }
		
	}

    private void secondModeInteraction(){
	   ITextualUI currentUI ;
           boolean quit = false;
           ICalculadoraUniversal calculadoraUniversal = CalculadoraUniversalFactory.mode(Mode.ISO_ZODATETIME);
           while(! quit){
             currentUI = UIFactory.zonedDateTimeUI(printer.clone());
             relogio.showTime();
             switch(currentUI.printMenu()){
	            case 1:
                            addSubTempoZonedDateTime(calculadoraUniversal);
                            break;
                    case 2:
			    diferencaEntreFusos(calculadoraUniversal);        
			    break;
                    case 3:
			    converterZonedDateTime(calculadoraUniversal);         
			    break;
                    case 4:
                            diferencaTempoEntreCidades(calculadoraUniversal);
			    break;
                    case 5:
			    tempoAteOutroFuso(calculadoraUniversal);
		            break;
		    case 6:
			    quit = true;
		            break;	  	               
		    default:
			    printer.print("Valor invalido. Escolhe uma das opções disponiveis.");
             }
           }
        
    }

    private void addSubTempoZonedDateTime(ICalculadoraUniversal calculadoraUniversal) {
    	ITextualUI currentUI;
    	boolean wantToQuit = false;
        ZoneId zone;
    	while(!wantToQuit){
            currentUI = UIFactory.addSubtrair(printer.clone());
            relogio.showTime();
            int  option = currentUI.printMenu();
            try {
                if (option <3) {
                    printer.print("Insira a hora inicial.");
                    LocalDateTime inicio = LocalDateTime.of(printer.pedirData(), printer.pedirHoras());
                    currentUI = UIFactory.listZonedId(printer.clone());
                    int index =currentUI.printMenu();
                    if (index >= 1 && index<= 26) {
                       zone = ZoneId.of(getZoneId(index-1)); 
                    }
                    else{
                        printer.print("Não existe essa opção");
                        break;
                    }
                    printer.print("Valor que pretende somar ou subtrair.");
                    LocalDateTime valor = LocalDateTime.of(printer.pedirComSemana(), printer.pedirHoras());
                    if (option == 1) 
                     //   Printer.print();
                    if (option == 2)
                            printer.print(calculadoraUniversal.addSubTempos(inicio, valor, false));
                    }
                    else if(option > 3)
                        printer.printErro("Não existe essa opção.");
                    else    
                        wantToQuit = true;  
                } catch (Exception e) {
                    printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    private void diferencaEntreFusos(ICalculadoraUniversal calculadoraUniversal){
    	ITextualUI currentUI;
        printer.print("Insira o fuso e data-hora inicial.");
        currentUI = UIFactory.listZonedId(printer.clone());
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index = currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            printer.print("Não existe essa opção");
        }
        ZonedDateTime zonaI = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneI);
        printer.print("Insira o fuso e data-hora final.\n");
        //currentUI = UIFactory.listZonedId(printer.clone());
        index = currentUI.printMenu();
        if (index >= 1 && index<= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            printer.print("Não existe essa opção");
            }
        ZonedDateTime zonaF = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneF);
        Optional<Duration> d = calculadoraUniversal.diferencaEntreFusos(zonaI, zonaF);
        if(d.isPresent()) printer.print(d.get());
        else printer.print("Não foi possivel, usando os dados introduzidos, calcular a diferença entre elas.");
    }
    
    private void converterZonedDateTime(ICalculadoraUniversal calculadoraUniversal){
    	ITextualUI currentUI;
        printer.print("Insira o fuso e data-hora inicial.");
        currentUI = UIFactory.listZonedId(printer.clone());
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index = currentUI.printMenu();
        
        if (index >= 1 && index <= 26) {
            zoneI = ZoneId.of(getZoneId(index-1)); 
        }else{
            printer.print("Não existe essa opção");
        }
        
        ZonedDateTime zdtI = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneI);
        printer.print("Insira o novo fuso.");
        //currentUI = UIFactory.listZonedId(printer.clone());
        index =currentUI.printMenu();
        
        if (index >= 1 && index <= 26) {
            zoneF = ZoneId.of(getZoneId(index-1)); 
        }else{
            printer.print("Não existe essa opção");
         }
        printer.print(calculadoraUniversal.convertZonedDateTime(zdtI, zoneF).toString());
    }
    

    private void diferencaTempoEntreCidades(ICalculadoraUniversal calculadoraUniversal){
    	ITextualUI currentUI = new Utils().getCurrentUI();
        printer.print("Insira o fuso e data-hora da cidade inicial.");
        currentUI = UIFactory.listZonedId(printer.clone());
        ZoneId zoneI,zoneF ;
        zoneI = zoneF = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneI = ZoneId.of(getZoneId(index-1)); 
        else{
            printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtI = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneI);
        printer.print("Insira o fuso e data-hora da cidade final.");
        index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneF = ZoneId.of(getZoneId(index-1)); 
        else{
            printer.print("Não existe essa opção");
            }
        ZonedDateTime zdtF = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneF);
        printer.print(calculadoraUniversal.diferencaEntreFusos(zdtI, zdtF).toString());
    }
    
    private void tempoAteOutroFuso(ICalculadoraUniversal calculadoraUniversal){
    	ITextualUI currentUI = new Utils().getCurrentUI();
        LocalDateTime agora = LocalDateTime.now();
        ZoneOffset zoneOff = OffsetDateTime.now().getOffset();
        ZonedDateTime zdtAtual = ZonedDateTime.of(agora, zoneOff);
        printer.print("Insira o fuso e data-hora da cidade inicial.");
        currentUI = UIFactory.listZonedId(printer.clone());
        ZoneId zoneFinal = null;
        int index =currentUI.printMenu();
        if (index >= 1 && index <= 26) 
            zoneFinal = ZoneId.of(getZoneId(index-1)); 
        else{
            printer.print("Não existe essa opção");
            tempoAteOutroFuso(calculadoraUniversal);
            }
        ZonedDateTime zdtFinal = ZonedDateTime.of(printer.pedirData(), printer.pedirHoras(), zoneFinal);
        
       printer.print(calculadoraUniversal.diferencaEntreFusos(zdtAtual, zdtFinal).toString());
    }
    

    private void cronometro(){
    	    ITextualUI currentUI= UIFactory.cronometroUI(printer.clone());
            ICronometro crono = CalculadoraUniversalFactory.getCrono();
            boolean quit = false;
            while(! quit){
              relogio.showTime();
              switch(currentUI.printMenu()){
                  case 1:
                         if(crono.start()) printer.print("Cronometro lançado.");
                         else printer.print("O cronometro ja esta a correr.");
                         break;
                  case 2:
                         Optional<Duration> duration = crono.stop();
                         if(duration.isPresent()) printer.print(duration.get());
                         else printer.print("O crono ja esta parado.");
                         break;
                  case 3:
                         if(crono.reset()) printer.print("Cronómetro reset.");
                         else printer.print("O cronómetro não pode ser reset enquanto estiver a correr.");
                         break;
                  case 4:
                          quit = true;
                          break;
                  default:
                          printer.print("Valor invalido. Escolhe uma das opções disponiveis.");
              }
                
            }
    }
        
    private String getZoneId(int index){
        
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
    
    private void outputFormatingInteraction(){
            ITextualUI currentUI = new Utils().getCurrentUI();
            currentUI = UIFactory.formatingOutputUI(printer);
            relogio.showTime();
            switch(currentUI.printMenu()){
                case 1:
                      printer.setPrintMode(1);
                      break;
                case 2:
                      printer.setPrintMode(2);
                      break;
                default:
                      break;
            }
        }
         

    

}
