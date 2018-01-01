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
                Printer.print("Insira a data inicial.\n");
                Printer.print("Ano: ");
                int ano = readValue.nextInt();
                Printer.print("Mês: ");
                int mes = readValue.nextInt();
                Printer.print("Dia: ");
                int dia = readValue.nextInt();
                try {
                    LocalDate inicio = LocalDate.of(ano, mes, dia);
                    Printer.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
            
                    switch(option){
                    case 1:
                        Printer.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.DAYS).toString()+"\n");
                        break;
                    case 2:
                        Printer.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.WEEKS).toString()+"\n");
                        break;
                    case 3:
                        Printer.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.MONTHS).toString()+"\n");
                        break;
                    case 4:
                        Printer.print("Resposta: "+ldt.addicionarAData(inicio, value, ChronoUnit.YEARS).toString()+"\n");
                        break;
                    }
                } catch (Exception e) {
                    Printer.printErro("Os valores não foram introduzidos corretamente.\n");
                }
            }    
            else if(option > 5)
                Printer.printErro("Não existe essa opção.\n");
            
            else
                wantToQuit = true;
        }
    }
    
    public void addSubHoras(){

        while(!wantToQuit){
            currentUI = CalculoUIFactory.addSubHoras();
            option = currentUI.printMenu();
            if (option < 4) {
                Printer.print("Insira a hora inicial.\n");
                Printer.print("Hora: ");
                int hora = readValue.nextInt();
                Printer.print("Minuto: ");
                int min = readValue.nextInt();
                try {
                    LocalTime inicio = LocalTime.of(hora, min);
                    Printer.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
             
                    switch(option){
                        case 1:
                            Printer.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.SECONDS).toString()+"\n");
                            break;
                        case 2:
                            Printer.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.MINUTES).toString()+"\n");
                            break;
                        case 3:
                            Printer.print("Resposta: "+ldt.adicionarTempos(inicio, value, ChronoUnit.HOURS).toString()+"\n");
                            break;
                    }
                } catch (Exception e){
                    Printer.printErro("Os valores não foram corretamente.\n");
                }
            }
            else if(option > 4)
                Printer.printErro("Não existe essa opção.\n");
            
            else
                wantToQuit = true;
        }    
    }
    
    public void addSubTempos(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.addSubTempos();
            option = currentUI.printMenu();
             if (option < 8) {
                Printer.print("Insira a data e hora nicial.\n");
                Printer.print("Ano: ");
                int ano = readValue.nextInt();
                Printer.print("Mês: ");
                int mes = readValue.nextInt();
                Printer.print("Dia: ");
                int dia = readValue.nextInt();
                Printer.print("Hora: ");
                int hora = readValue.nextInt();
                Printer.print("Minuto: ");
                int min = readValue.nextInt();
            
                try {
                    LocalDateTime inicio = LocalDateTime.of(ano, mes, dia, hora, min);
                    Printer.print("Insira o valor que pretende adicionar. \n(Caso pretenda subtrair, insira o \"-\" antes do valor)\n");
                    int value = readValue.nextInt();
             
                    switch(option){
                        case 1:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.SECONDS).toString()+"\n");
                            break;
                        case 2:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.MINUTES).toString()+"\n");
                            break;
                        case 3:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.HOURS).toString()+"\n");
                            break;
                        case 4:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.DAYS).toString()+"\n");
                            break;
                        case 5:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.WEEKS).toString()+"\n");
                            break;
                        case 6:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.MONTHS).toString()+"\n");
                            break;                    
                        case 7:
                            Printer.print("Resposta: "+ldt.addicionarADateTime(inicio, value, ChronoUnit.YEARS).toString()+"\n");
                            break;
                        }
                } catch (Exception e) {
                    Printer.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 8){
                Printer.printErro("Não existe essa opção.\n");
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
                        Printer.print("Insira a data inicial.\n");
                        Printer.print("Ano: ");
                        int anoI = readValue.nextInt();
                        Printer.print("Mês: ");
                        int mesI = readValue.nextInt();
                        Printer.print("Dia: ");
                        int diaI = readValue.nextInt();
                        Printer.print("Insira a data final.\n");
                        Printer.print("Ano: ");
                        int anoF = readValue.nextInt();
                        Printer.print("Mês: ");
                        int mesF = readValue.nextInt();
                        Printer.print("Dia: ");
                        int diaF = readValue.nextInt();
                        try {
                            LocalDate inicio = LocalDate.of(anoI, mesI, diaI);
                            LocalDate fim = LocalDate.of(anoF, mesF, diaF);
                            Printer.print("Resposta: "+ldt.diferencaData(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Printer.printErro("Os valores não introduzidos correctamente.\n");
                            diferençaEntreTempos();
                        }
                        break;
                        
                    case 2:
                        Printer.print("Insira a hora inicial.\n");
                        Printer.print("Horas: ");
                        int horaI = readValue.nextInt();
                        Printer.print("Minutos: ");
                        int minI = readValue.nextInt();
                        Printer.print("Insira a hora final.\n");
                        Printer.print("Horas: ");
                        int horaF = readValue.nextInt();
                        Printer.print("Minutos: ");
                        int minF = readValue.nextInt();
                        try {
                            LocalTime inicio = LocalTime.of(horaI, minI);
                            LocalTime fim = LocalTime.of(horaF, minF);
                            Printer.print("Resposta: "+ldt.diferençaTempos(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Printer.printErro("Os valores não introduzidos correctamente.\n");
                            diferençaEntreTempos();
                        }
                            break;
                    case 3:
                        Printer.print("Insira a data e hora inicial.\n");
                        Printer.print("Ano: ");
                        int anoIn = readValue.nextInt();
                        Printer.print("Mês: ");
                        int mesIn = readValue.nextInt();
                        Printer.print("Dia: ");
                        int diaIn = readValue.nextInt();
                        Printer.print("Hora: ");
                        int horaIn = readValue.nextInt();
                        Printer.print("Minutos: ");
                        int minIn = readValue.nextInt();
                        
                        Printer.print("Ano: ");
                        int anoFm = readValue.nextInt();
                        Printer.print("Mês: ");
                        int mesFm = readValue.nextInt();
                        Printer.print("Dia: ");
                        int diaFm = readValue.nextInt();
                        Printer.print("Hora: ");
                        int horaFm = readValue.nextInt();
                        Printer.print("Minutos: ");
                        int minFm = readValue.nextInt();

                        try {
                            LocalDateTime inicio = LocalDateTime.of(anoIn, mesIn, diaIn, horaIn, minIn);
                            LocalDateTime fim = LocalDateTime.of(anoFm, mesFm, diaFm, horaFm, minFm);
                            Printer.print("Resposta: "+ldt.diferencaDateTime(inicio, fim)+"\n");
                        } catch (Exception e) {
                            Printer.printErro("Os valores não introduzidos correctamente.\n");
                        }
                        break;
                }
            }
            else if(option > 4){
                Printer.printErro("Não existe essa opção.\n");
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
                Printer.print("Insira a data\n");       
                Printer.print("Ano: ");
                int ano = readValue.nextInt();
                Printer.print("Mês: ");
                int mes = readValue.nextInt();
                Printer.print("Dia: ");
                int dia = readValue.nextInt();
                try {
                    LocalDate data = LocalDate.of(ano, mes, dia);
                    switch(option){
                        case 1:
                            Printer.print("Resposta: "+ldt.diaDaSemana(data).toString()+"\n");
                            break;
                        case 2:
                            Printer.print("Resposta: "+ldt.trimestre(data).toString()+"\n");
                            break;
                        case 3:
                            Printer.print("Resposta: "+ldt.numeroDoDiaNoAno(data).toString()+"\n");
                            break;
                        case 4:
                            Printer.print("Resposta: "+ldt.semanaNoAno(data).toString()+ "\n");
                    }                         
                }catch (Exception e) {
                    Printer.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 5){
                Printer.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }    
    }
    public void tempoAteData(){
        Printer.print("Insira a data e hora nicial.\n");
        Printer.print("Ano: ");
        int ano = readValue.nextInt();
        Printer.print("Mês: ");
        int mes = readValue.nextInt();
        Printer.print("Dia: ");
        int dia = readValue.nextInt();
        Printer.print("Hora: ");
        int hora = readValue.nextInt();
        Printer.print("Minuto: ");
                
        int min = readValue.nextInt();
        try {
            LocalDateTime inicial = LocalDateTime.now();
            LocalDateTime fim = LocalDateTime.of(ano, mes, dia, hora, min);
            Printer.print("Resposta: "+ldt.diferencaDateTime(inicial, fim).toString() +"\n");
        } catch (Exception e) {
            Printer.printErro("Os valores não introduzidos correctamente.\n");
        }
    }
    
    public void curiosidades(){
        while(!wantToQuit){
            currentUI = CalculoUIFactory.curiosidades();
            option = currentUI.printMenu();
            
            if (option <4) {
                Printer.print("Insira a data\n");       
                Printer.print("Ano: ");
                int ano = readValue.nextInt();
                int mes = 1;
                int dia = 1;
                if(option != 3){
                
                Printer.print("Mês: ");
                mes = readValue.nextInt();
                Printer.print("Dia: ");
                dia = readValue.nextInt();
                }
                try{
                    LocalDate data = LocalDate.of(ano, mes, dia);
                    switch(option){
                        case 1:
                            Printer.print("Resposta: "+ldt.estaçãoDoAnoNorte(data).toString()+"\n");
                            break;
                        case 2:
                            Printer.print("Resposta: "+ldt.estaçãoDoAnoSul(data).toString()+"\n");
                            break;
                        case 3:
                            Printer.print("Resposta: "+ldt.isLeap(data)+"\n");
                            break; 
                    }                     
                }catch (Exception e) {
                    Printer.printErro("Os valores não introduzidos correctamente.\n");
                }
            }
            else if(option > 4){
                Printer.printErro("Não existe essa opção.\n");
            }
            else
                wantToQuit = true;
        }            
    }
}

