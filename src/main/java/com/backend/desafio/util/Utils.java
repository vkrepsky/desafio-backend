package com.backend.desafio.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    public static Map<String, Integer> getDias(LocalDateTime primeiroDia, LocalDateTime ultimoDia){

        Map<String, Integer> map = new HashMap<>();

        //objetos são convertidos temporariamente de LocalDateTime para LocalDate para facilitar a contagem de dias
        LocalDate tempStart = LocalDate.from(primeiroDia);
        LocalDate tempStop = LocalDate.from(ultimoDia);


        LocalDate iterator = tempStart;

        int diasDeSemana = 0;
        int fimDesemana = 0;

        while (!iterator.isAfter(tempStop.minusDays(1))){

            if (iterator.getDayOfWeek().equals(DayOfWeek.SATURDAY) || iterator.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                fimDesemana++;
            }else{
                diasDeSemana++;
            }
            iterator = iterator.plusDays(1);

        }

        if (ultimoDia.isAfter(ultimoDia.withHour(16).withMinute(30)))
        {
            if (ultimoDia.getDayOfWeek().equals(DayOfWeek.SATURDAY) || ultimoDia.getDayOfWeek().equals(DayOfWeek.SUNDAY)){
                fimDesemana++;
            }else{
                diasDeSemana++;
            }
        }
        map.put("diasDeSemana", diasDeSemana);
        map.put("fimDeSemana", fimDesemana);

        return map;
    }
}
