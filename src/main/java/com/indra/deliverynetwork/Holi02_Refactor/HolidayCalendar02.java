package com.indra.deliverynetwork.Holi02_Refactor;

import com.indra.deliverynetwork.Tuple;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar02 {
    private List<DayOfWeek> _daysOfWeekHolidays = new ArrayList<>();
    private List<Tuple<Integer, Integer>> _daysOfMonthHolidays = new ArrayList<>();
    private List<LocalDate> _datesOfHolidays = new ArrayList<>();

    /*
    Nuevo Requerimiento:
    Los feriados son válidos en un intervalo de tiempo . Ejemplos:
        Del 01/01/1990 al 31/12/1999 fueron feriado los lunes.

    Problematica
    a.  Grado de claritividad tiene una implementación
        Muy poco. Debemos tener nombres que indiquen el qué hace mas que el cómo. (REM)
    b.  Tenemos acá conjunto de colaboraciones repetididas.
        Código repetido, no implica texto repetido, implica patrones de colaboraciones repetidas.
        Tenemos acá un método que hace 3 cosas.
        3 listas, 3 preguntas
        Solución: Generalizamos con un concepto (método) que pregunta si un día es feriado, llamado REGLAS DE FERIADO.
     c. Nunca hacer un refacting al diseño sobre pruebas que están fallando.
     d. Hacer refactoring lo más posible.
    */

    /* B. Métodos para evaluar feriado */

    /* R1 en isHoliday cada evaluacion es extraída en un método tenemos: IsDayOfWeekHoliday ... */
    public boolean isHoliday(LocalDate aDate) {
        return
                IsDayOfWeekHoliday(aDate) ||
                IsDayOfMonthHoliday(aDate) ||
                IsDateHoliday(aDate);
    }

    /* C. (new) Se crean nuevos métodos a partir de evaluaciones en isHoliday */
    private boolean IsDateHoliday(LocalDate aDate) {
        return _datesOfHolidays.contains(aDate);
    }
    private boolean IsDayOfMonthHoliday(LocalDate aDate) {
        return _daysOfMonthHolidays.contains(new Tuple<>(aDate.getMonthValue(), aDate.getDayOfMonth()));
    }
    private boolean IsDayOfWeekHoliday(LocalDate aDate) {
        return _daysOfWeekHolidays.contains(aDate.getDayOfWeek());
    }

    /* A Métodos para agregar feriados a días de semana, días de mes, fecha, dia en rango de fechas */
    public void MakeDayOfWeekAsHoliday(DayOfWeek aDayOfWeek){
        _daysOfWeekHolidays.add(aDayOfWeek);
    }
    public void MakeDayOfMonthAsHoliday(int aMonthNumber, int aDayNumber) {
        _daysOfMonthHolidays.add(new Tuple<>(aMonthNumber, aDayNumber));
    }
    public void MakeDateAsHoliday(LocalDate aDate) {
        _datesOfHolidays.add(aDate);
    }
    public void MakeDayOfWeekAsHoliday(LocalDate from, LocalDate to, DayOfWeek dayOfWeek) {
        /* * La implementación requiere cambios en el diseño por lo tanto un refactoring * */
    }
}
