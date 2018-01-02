/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import calculadorauniversal.CalculadoraLDT;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Pedro
 */

public class CalculoLDTUI{
 
    private static CalculadoraLDT calculadora;
    private static TextualUI currentUI;
    private static int option;
    private static PedidoDatasHorasUI pdh; 
    private static boolean quit;


    public CalculoLDTUI() {
        pdh = new PedidoDatasHorasUI();
        quit = false;
        calculadora = new CalculadoraLDT();
    }
    
    public void addSubDatas(){
        quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.addSubtrair();
            option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a data inicial.\n");
                        LocalDate inicio = pdh.pedirData();
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalDate valor = pdh.pedirComSemana();
                        if (option == 1) 
                            Printer.print(calculadora.addSubDatas(inicio, valor, true).toString());
                        if (option == 2)
                            Printer.print(calculadora.addSubDatas(inicio, valor, false).toString());
                    }
                    else if(option > 3)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Data não foram introduzidos corretamente.\n");
                }
        }
    }    
    
    public void addSubHoras(){
        quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.addSubtrair();
            option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.\n");
                        LocalTime inicio = pdh.pedirHoras();
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalTime valor = pdh.pedirHoras();
                        if (option == 1) 
                            Printer.print(calculadora.addSubHoras(inicio, valor, true).toString());
                        
                        if (option == 2)
                            Printer.print(calculadora.addSubHoras(inicio, valor, false).toString());
                    }
                    else if(option > 3)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    public void addSubTempos(){
        quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.addSubtrair();
            option = currentUI.printMenu();
                try {
                    if (option <3) {
                        Printer.print("Insira a hora inicial.\n");
                        LocalDateTime inicio = LocalDateTime.of(pdh.pedirData(), pdh.pedirHoras());
                        Printer.print("Valor que pretende somar ou subtrair.");
                        LocalDateTime valor = LocalDateTime.of(pdh.pedirComSemana(), pdh.pedirHoras());
                        if (option == 1) 
                            Printer.print(calculadora.addSubTempos(inicio, valor, true).toString());
                        if (option == 2)
                            Printer.print(calculadora.addSubTempos(inicio, valor, false).toString());
                    }
                    else if(option > 3)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    public void diferençaEntreTempos(){
        quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.diferencaEntreTempos();
            option = currentUI.printMenu();
                try {
                    if (option <4) {
                        if (option == 1){ 
                            Printer.print("Insira a hora inicial.\n");
                            LocalDate inicio = pdh.pedirData();
                            Printer.print("Insira a hora final");
                            LocalDate fim = pdh.pedirData();
                            Printer.print(calculadora.diferencaEntreDatas(inicio, fim).toString());
                        }
                        if (option == 2){
                            Printer.print("Insira a hora inicial.\n");
                            LocalTime inicio = pdh.pedirHoras();
                            Printer.print("Insira a hora final");
                            LocalTime fim = pdh.pedirHoras();
                            Printer.print(calculadora.diferencaEntreTempos(inicio, fim, true).toString());
                        }
                        if (option ==3){
                            Printer.print("Insira a hora inicial.\n");
                            LocalDateTime inicio = LocalDateTime.of(pdh.pedirData(),pdh.pedirHoras());
                            Printer.print("Insira a hora final");
                            LocalDateTime fim = LocalDateTime.of(pdh.pedirData(),pdh.pedirHoras());
                              Printer.print(calculadora.diferencaEntreTempos(inicio, fim, false).toString());
                        }
                    }
                    else if(option > 4)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    public void infoDatas(){
       quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.infoDatas();
            option = currentUI.printMenu();
                try {
                    if (option <5) {
                        Printer.print("Insira a data.\n");
                        LocalDate data = pdh.pedirData();
                        if (option == 1){ 
                            Printer.print(calculadora.diaDaSemana(data).toString());
                        }
                        if (option == 2){
                            Printer.print(calculadora.trimestre(data).toString());
                        }
                        if (option == 3){
                            Printer.print(calculadora.numeroDoDiaNoAno(data).toString());
                        }
                        if (option == 4){
                            Printer.print(calculadora.semanaNoAno(data).toString());
                        }
                    }
                    else if(option > 5)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    public void tempoAteData(){
     quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.diferencaEntreTempos();
            option = currentUI.printMenu();
                try {
                    if (option <4) {
                        if (option == 1){ 
                            LocalDate inicio = LocalDate.now();
                            Printer.print("Insira a Data final");
                            LocalDate fim = pdh.pedirData();
                            Printer.print(calculadora.diferencaEntreDatas(inicio, fim).toString());
                        }
                        if (option == 2){
                            LocalTime inicio = LocalTime.now();
                            Printer.print("Insira a hora final");
                            LocalTime fim = pdh.pedirHoras();
                            Printer.print(calculadora.diferencaEntreTempos(inicio, fim, true).toString());
                        }
                        if (option ==3){
                            LocalDateTime inicio = LocalDateTime.now();
                            Printer.print("Insira a data e hora final");
                            LocalDateTime fim = LocalDateTime.of(pdh.pedirData(),pdh.pedirHoras());
                              Printer.print(calculadora.diferencaEntreTempos(inicio, fim, false).toString());
                        }
                    }
                    else if(option > 4)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
    
    public void curiosidades(){
        quit = false;
        while(!quit){
            currentUI = CalculoUIFactory.curiosidades();
            option = currentUI.printMenu();
                try {
                    if (option <4) {
                        Printer.print("Insira a data.\n");
                        LocalDate data = pdh.pedirData();
                        if (option == 1){ 
                            Printer.print(calculadora.estaçãoDoAnoNorte(data, true).toString());
                        }
                        if (option == 2){
                            Printer.print(calculadora.estaçãoDoAnoNorte(data, false).toString());
                        }
                        if (option == 3){
                            Printer.print(calculadora.isLeap(data));
                        }
                    }
                    else if(option > 4)
                        Printer.printErro("Não existe essa opção.");
                    else    
                        quit = true;  
                } catch (Exception e) {
                    Printer.printErro("Os valores da Hora não foram introduzidos corretamente.\n");
                }
        }
    }
}

