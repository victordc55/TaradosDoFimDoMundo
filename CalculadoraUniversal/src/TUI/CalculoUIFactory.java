/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TUI;

import java.util.Arrays;
import java.util.List;

/**
 *
 * 
 */
public class CalculoUIFactory {
      
    public static TextualUI diferencaEntreTempos(){
        List<String> options = Arrays.asList( "Difença entre datas.",
                                                "Diferença entre horas.",
                                                "Diferença entre Tempos.",
                                                "Voltar para trás.");
        String head = "Escolha uma das operações disponiveis:";
        return TextualUI.of(options, head);    
    }
    
    public static TextualUI infoDatas(){
        List<String> options = Arrays.asList( "Dia da Semana.",
                                                "Trimestre.",
                                                "Dia do Ano.",
                                                "Semana do Ano",
                                                "Voltar para trás");
        String head = "Escolha uma das operações disponiveis:";
        return TextualUI.of(options, head);    
    }
    
    public static TextualUI curiosidades(){
        List<String> options = Arrays.asList( "Qual a estação boreal.",
                                                "Qual é a estação austral.",
                                                "Verifica se é ano bissexto.",
                                                "Voltar para trás");
        String head = "Escolha uma das operações disponiveis:";
        return TextualUI.of(options, head);    
    }
    
    public static TextualUI addSubtrair(){
        List<String> options = Arrays.asList( "Adicionar.",
                                                "Subtrair.",
                                                "Voltar para trás");
        String head = "Escolha uma das operações disponiveis:";
        return TextualUI.of(options, head);
    }
    
    
}
