package com.indra.deliverynetwork.Holi01_Asserts;

import com.indra.deliverynetwork.Tuple;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Etapa 01.1 - Crear la clase HolidayCalendar01

Etapa 01.2 - Crear el método MakeDayOfWeekAsHoliday
Etapa 01.3 - Crear el método MakeDayOfMonthAsHoliday
Etapa 01.4 - Crear el método MakeDateAsHoliday
             Estos métodos permiten agregar días de la semana (LUNES A DOMINGO), días del mes (1 AL 12 CON 1 AL 31) y fechas (2024-01-01) como festivos.

Etapa 01.5 - Crear el método isHoliday
             Este método contiene la lógica de evaluación de si una fecha es festiva o no.

Etapa 01.6 - Crear el atributo _daysOfWeekHolidays y lista
Etapa 01.7 - Crear el atributo _daysOfMonthHolidays y lista
Etapa 01.7.1 - Crear la clase Tuple para almacenar el mes y el día
Etapa 01.8 - Crear el atributo _datesOfHolidays y lista
 * */
public class HolidayCalendar01 {

    private List<DayOfWeek> _daysOfWeekHolidays = new ArrayList<>();
    private List<Tuple<Integer, Integer>> _daysOfMonthHolidays = new ArrayList<>();
    private List<LocalDate> _datesOfHolidays = new ArrayList<>();


    /* A. Métodos para agregar feriados a días de semana, días de mes, fecha, dia en rango de fechas */
    public void MakeDayOfWeekAsHoliday(DayOfWeek aDayOfWeek){
        _daysOfWeekHolidays.add(aDayOfWeek);
    }
    public void MakeDayOfMonthAsHoliday(int aMonthNumber, int aDayNumber) {
        _daysOfMonthHolidays.add(new Tuple<>(aMonthNumber, aDayNumber));
    }
    public void MakeDateAsHoliday(LocalDate aDate) {
        _datesOfHolidays.add(aDate);
    }

    /* B. Métodos para evaluar feriado */
    public boolean isHoliday(LocalDate aDate) {
        return
                _daysOfWeekHolidays.contains(aDate.getDayOfWeek()) ||
                _daysOfMonthHolidays.contains(new Tuple<>(aDate.getMonthValue(), aDate.getDayOfMonth())) ||
                _datesOfHolidays.contains(aDate);
    }
}
