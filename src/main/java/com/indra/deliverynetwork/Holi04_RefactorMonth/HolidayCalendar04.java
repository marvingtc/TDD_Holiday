package com.indra.deliverynetwork.Holi04_RefactorMonth;

import com.indra.deliverynetwork.Holi04_RefactorMonth.DayOfWeekHolidayRule;
import com.indra.deliverynetwork.Tuple;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar04 implements HolidayRule {
    /*
    R7(F). Ahora ya no es una lista de DayOfWeekHolidayRule(C) sino de HolidayRule(I)
    * */
    private List<HolidayRule> _daysOfWeekHolidays = new ArrayList<>();
    private List<Tuple<Integer, Integer>> _daysOfMonthHolidays = new ArrayList<>();
    private List<LocalDate> _datesOfHolidays = new ArrayList<>();

    @Override
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
    private boolean IsDayOfWeekHoliday(LocalDate aDate) {
        return _daysOfWeekHolidays.stream().anyMatch(aHolidayRule -> aHolidayRule.isHoliday(aDate));
    }

    public void MakeDayOfWeekAsHoliday(DayOfWeekHolidayRule dayOfWeekHolidayRule){
        _daysOfWeekHolidays.add(dayOfWeekHolidayRule); //
    }
    /* R5(I). Repetimos el paso R2 con MakeDayOfMonthAsHoliday y además enviaremos el día a una misma lista _daysOfWeekHolidays anterior
       es ahora una regla DayOfWeekHolidayRule.
       Refactor -> Introduce Parameter Object.
        MakeDayOfMonthAsHoliday -> DayOfMonthHolidayRule
        */
    public void MakeDayOfMonthAsHoliday(DayOfMonthHolidayRule dayOfMonthHolidayRule) {
        /* R6 Es aquí donde vemos la necesidad de abstraer el comportamiento de las reglas de feriado con un Interface.
        c. Crea la interface a partir de DayOfWeekHolidayRule -> Refactor - Extract Interface - Con el método isHolidayRule.
        d. Implementamos el método isHoliday en DayOfMonthHolidayRule, DayOfWeekHolidayRule y DateHolidayRule según se vayan creando.
        */
        _daysOfWeekHolidays.add(dayOfMonthHolidayRule);
    }
    public void MakeDateAsHoliday(LocalDate aDate) {
        _datesOfHolidays.add(aDate);
    }


    public void MakeDayOfWeekAsHoliday(LocalDate from, LocalDate to, DayOfWeek dayOfWeek) {
    }
}
