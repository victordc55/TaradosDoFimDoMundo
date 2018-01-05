/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorauniversal;

import Datas.EstacaoTemperada;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.OptionalLong;

/**
 *
 * @author VICTOR CUNHA
 */
public interface ICalculadoraUniversalCuriosidade {

	    public DayOfWeek ultimoDiaAno (int ano);
            public DayOfWeek primeiroDiaAno(int ano);
            public boolean isLeap(int ano);
            public OptionalInt diaUteisEntreDatas(LocalDate data1, LocalDate data2);
            public Optional<DayOfWeek> diaNatal(OptionalInt ano);
            public OptionalInt diasDoMes(OptionalInt mes);
            public OptionalLong semanasDesdeInicio();
            public OptionalInt semanasFimAno();
            public OptionalInt trimestre(TemporalAccessor data);
            public String estacaoDoAno(LocalDate ldtestacao);
}
