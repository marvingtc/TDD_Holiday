package com.indra.deliverynetwork.Holi03_RefactorParameter;

import com.indra.deliverynetwork.Tuple;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar03 {
    // R3. Ahora se acumulan una lista (_daysOfWeekHolidays) de reglas <DayOfWeekHolidayRule> -> <DayOfWeek>
    private List<DayOfWeekHolidayRule> _daysOfWeekHolidays = new ArrayList<>();
    private List<Tuple<Integer, Integer>> _daysOfMonthHolidays = new ArrayList<>();
    private List<LocalDate> _datesOfHolidays = new ArrayList<>();

    public boolean isHoliday(LocalDate aDate) {
        return
                IsDayOfWeekHoliday(aDate) ||
                IsDayOfMonthHoliday(aDate) ||
                IsDateHoliday(aDate);
    }

    private boolean IsDateHoliday(LocalDate aDate) {
        return _datesOfHolidays.contains(aDate);
    }
    private boolean IsDayOfMonthHoliday(LocalDate aDate) {
        return _daysOfMonthHolidays.contains(new Tuple<>(aDate.getMonthValue(), aDate.getDayOfMonth()));
    }
    /* R4(F). Tomamos su respectivo evaluador para hacerlo general.
    Cambiamos contains por stream para determinar si cumple con alguna de las reglas e implementar el método isHoliday
    */
    private boolean IsDayOfWeekHoliday(LocalDate aDate) {
        return _daysOfWeekHolidays.stream().anyMatch(aHolidayRule -> aHolidayRule.isHolidayRule(aDate));
    }


    /* R2(I). Tomamos un método (MakeDayOfWeekAsHoliday) para hacer feriado  donde el parámetro DayOfWeek
           es ahora una regla DayOfWeekHolidayRule.
           Refactor -> Introduce Parameter Object.
            MakeDayOfWeekAsHoliday -> DayOfWeekHolidayRule
            Encapsula los parámetros en un objeto.
            No vamos a enviar el día de semana, sino la regla.
            */
    public void MakeDayOfWeekAsHoliday(DayOfWeekHolidayRule dayOfWeekHolidayRule){
        _daysOfWeekHolidays.add(dayOfWeekHolidayRule);
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
