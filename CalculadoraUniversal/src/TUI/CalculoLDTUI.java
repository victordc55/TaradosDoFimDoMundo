/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import Datas.CalculoLDT;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class CalculoLDTUI{
 
    private static CalculoLDT ldt;
    private static TextualUI currentUI;
    private static Scanner readValue;
    private static int option;
    private static boolean wantToQuit;


    public CalculoLDTUI() {
        readValue= new Scanner(System.in);
        ldt = new CalculoLDT();
        wantToQuit = false;
    }
    
    public void addSubDatas(){

        while(!wantToQuit){
            currentUI = CalculoUIFactory.addSubDatas();
            option = currentUI.printMenu();    
            if (option < 5) {
                Print.print("Insira a data inicial.\n");
                Print.print("Ano: ");
                int ano = readValue.nextInt();
                Print.print("Mês: ");
                int mes = readValue.nextInt();
                Print.print("Dia: ");
                int dia = readValue.nextInt();
                try {
                    LocalDate inicio = LocalDate.of(ano, mes, dia);
                    Print.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
            
                    switch(option){
                    case 1:
                        Print.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.DAYS).toString()+"\n");
                        break;
                    case 2:
                        Print.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.WEEKS).toString()+"\n");
                        break;
                    case 3:
                        Print.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.MONTHS).toString()+"\n");
                        break;
                    case 4:
                        Print.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.YEARS).toString()+"\n");
                        break;
                    }
                } catch (Exception e) {
                    Print.printErro("Os valores não foram introduzidos corretamente.\n");
                }
            }    
            else if(option > 5)
                Print.printErro("Não existe essa opção.\n");
            
            else
                wantToQuit = true;
        }
    }
    
    public void addSubHoras(){

        while(!wantToQuit){
            currentUI = CalculoUIFactory.addSubHoras();
            option = currentUI.printMenu();
            if (option < 4) {
                Print.print("Insira a hora inicial.\n");
                Print.print("Hora: ");
                int hora = readValue.nextInt();
                Print.print("Minuto: ");
                int min = readValue.nextInt();
                try {
                    LocalTime inicio = LocalTime.of(hora, min);
                    Print.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
             
                    switch(option){
                        case 1:
                            Print.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.SECONDS).toString()+"\n");
                            break;
                        case 2:
                            Print.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.MINUTES).toString()+"\n");
                            break;
                        case 3:
                            Print.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.HOURS).toString()+"\n");
                            break;
                    }
                } catch (Exception e){
                    Print.printErro("Os valores não foram corretamente.\n");
                }
            }
            else if(option > 4)
                Print.printErro("Não existe essa opção.\n");
            
            else
                wantToQuit = true;
        }    
    }
    
    public void addSubTempos(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.addSubTempos();
            option = currentUI.printMenu();
             if (option < 8) {
                Print.print("Insira a data e hora nicial.\n");
                Print.print("Ano: ");
                int ano = readValue.nextInt();
                Print.print("Mês: ");
                int mes = readValue.nextInt();
                Print.print("Dia: ");
                int dia = readValue.nextInt();
                Print.print("Hora: ");
                int hora = readValue.nextInt();
                Print.print("Minuto: ");
                int min = readValue.nextInt();
            
                try {
                    LocalDateTime inicio = LocalDateTime.of(ano, mes, dia, hora, min);
                    Print.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
             
                    switch(option){
                        case 1:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.SECONDS).toString()+"\n");
                            break;
                        case 2:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.MINUTES).toString()+"\n");
                            break;
                        case 3:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.HOURS).toString()+"\n");
                            break;
                        case 4:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.DAYS).toString()+"\n");
                            break;
                        case 5:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.WEEKS).toString()+"\n");
                            break;
                        case 6:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.MONTHS).toString()+"\n");
                            break;                    
                        case 7:
                            Print.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.YEARS).toString()+"\n");
                            break;
                        }
                } catch (Exception e) {
                    Print.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 8){
                Print.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }     
    }
    
    public void diferençaEntreTempos(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.diferencaEntreTempos();
            option = currentUI.printMenu();
            if (option < 4) { 
                switch(option){
                    case 1:
                        Print.print("Insira a data inicial.\n");
                        Print.print("Ano: ");
                        int anoI = readValue.nextInt();
                        Print.print("Mês: ");
                        int mesI = readValue.nextInt();
                        Print.print("Dia: ");
                        int diaI = readValue.nextInt();
                        Print.print("Insira a data final.\n");
                        Print.print("Ano: ");
                        int anoF = readValue.nextInt();
                        Print.print("Mês: ");
                        int mesF = readValue.nextInt();
                        Print.print("Dia: ");
                        int diaF = readValue.nextInt();
                        try {
                            LocalDate inicio = LocalDate.of(anoI, mesI, diaI);
                            LocalDate fim = LocalDate.of(anoF, mesF, diaF);
                            Print.print("Resposta: "+ldt.diferencaData(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Print.printErro("Os valores não introduzidos correctamente.\n");
                            diferençaEntreTempos();
                        }
                        break;
                        
                    case 2:
                        Print.print("Insira a hora inicial.\n");
                        Print.print("Horas: ");
                        int horaI = readValue.nextInt();
                        Print.print("Minutos: ");
                        int minI = readValue.nextInt();
                        Print.print("Insira a hora final.\n");
                        Print.print("Horas: ");
                        int horaF = readValue.nextInt();
                        Print.print("Minutos: ");
                        int minF = readValue.nextInt();
                        try {
                            LocalTime inicio = LocalTime.of(horaI, minI);
                            LocalTime fim = LocalTime.of(horaF, minF);
                            Print.print("Resposta: "+ldt.diferençaTempos(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Print.printErro("Os valores não introduzidos correctamente.\n");
                            diferençaEntreTempos();
                        }
                            break;
                    case 3:
                        Print.print("Insira a data e hora inicial.\n");
                        Print.print("Ano: ");
                        int anoIn = readValue.nextInt();
                        Print.print("Mês: ");
                        int mesIn = readValue.nextInt();
                        Print.print("Dia: ");
                        int diaIn = readValue.nextInt();
                        Print.print("Hora: ");
                        int horaIn = readValue.nextInt();
                        Print.print("Minutos: ");
                        int minIn = readValue.nextInt();
                        
                        Print.print("Ano: ");
                        int anoFm = readValue.nextInt();
                        Print.print("Mês: ");
                        int mesFm = readValue.nextInt();
                        Print.print("Dia: ");
                        int diaFm = readValue.nextInt();
                        Print.print("Hora: ");
                        int horaFm = readValue.nextInt();
                        Print.print("Minutos: ");
                        int minFm = readValue.nextInt();

                        try {
                            LocalDateTime inicio = LocalDateTime.of(anoIn, mesIn, diaIn, horaIn, minIn);
                            LocalDateTime fim = LocalDateTime.of(anoFm, mesFm, diaFm, horaFm, minFm);
                            Print.print("Resposta: "+ldt.diferencaDateTime(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Print.printErro("Os valores não introduzidos correctamente.\n");
                        }
                        break;
                }
            }
            else if(option > 4){
                Print.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }    
    }
    
    public void infoDatas(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.infoDatas();
            option = currentUI.printMenu();
            if (option <5) {
                Print.print("Insira a data\n");       
                Print.print("Ano: ");
                int ano = readValue.nextInt();
                Print.print("Mês: ");
                int mes = readValue.nextInt();
                Print.print("Dia: ");
                int dia = readValue.nextInt();
                try {
                    LocalDate data = LocalDate.of(ano, mes, dia);
                    switch(option){
                        case 1:
                            Print.print("Resposta: "+ldt.diaDaSemana(data).toString()+"\n");
                            break;
                        case 2:
                            Print.print("Resposta: "+ldt.trimestre(data).toString()+"\n");
                            break;
                        case 3:
                            Print.print("Resposta: "+ldt.numeroDoDiaNoAno(data).toString()+"\n");
                            break;
                        case 4:
                            Print.print("Resposta: "+ldt.semanaNoAno(data).toString()+ "\n");
                    }                         
                }catch (Exception e) {
                    Print.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 5){
                Print.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }    
    }
    public void tempoAteData(){
        Print.print("Insira a data e hora nicial.\n");
        Print.print("Ano: ");
        int ano = readValue.nextInt();
        Print.print("Mês: ");
        int mes = readValue.nextInt();
        Print.print("Dia: ");
        int dia = readValue.nextInt();
        Print.print("Hora: ");
        int hora = readValue.nextInt();
        Print.print("Minuto: ");
                
        int min = readValue.nextInt();
        try {
            LocalDateTime inicial = LocalDateTime.now();
            LocalDateTime fim = LocalDateTime.of(ano, mes, dia, hora, min);
            Print.print("Resposta: "+ldt.diferencaDateTime(inicial, fim).toString() +"\n");
        } catch (Exception e) {
            Print.printErro("Os valores não introduzidos correctamente.\n");
        }
    }
    
    public void curiosidades(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.curiosidades();
            option = currentUI.printMenu();
            
            if (option <4) {
                Print.print("Insira a data\n");       
                Print.print("Ano: ");
                int ano = readValue.nextInt();
                int mes = 1;
                int dia = 1;
                if(option != 3){
                
                Print.print("Mês: ");
                mes = readValue.nextInt();
                Print.print("Dia: ");
                dia = readValue.nextInt();
                }
                try{
                    LocalDate data = LocalDate.of(ano, mes, dia);
                    switch(option){
                        case 1:
                            Print.print("Resposta: "+ldt.estaçãoDoAnoNorte(data).toString()+"\n");
                            break;
                        case 2:
                            Print.print("Resposta: "+ldt.estaçãoDoAnoSul(data).toString()+"\n");
                            break;
                        case 3:
                            Print.print("Resposta: "+ldt.isLeap(data)+"\n");
                            break; 
                    }                     
                }catch (Exception e) {
                    Print.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 4){
                Print.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }            
    }
}

