package com.indra.deliverynetwork.Holi05_RefactorDate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar05 {
    /*
     R9. Cambiamos el nombre de la variable _daysOfWeekHolidays -> _holidayRule, lista que recibirá todas las reglas.
    * */
    private List<HolidayRule> _holidayRule = new ArrayList<>();

    /* R10. Eliminamos la listas _daysOfMonthHolidays y _datesOfHolidays */
    //private List<Tuple<Integer, Integer>> _daysOfMonthHolidays = new ArrayList<>();
    //private List<LocalDate> _datesOfHolidays = new ArrayList<>();

    /*
     Un diseño no está terminado cuando no mas que agregarle, sino cuando no hay mas para sacarle.
    */

    /*

     R12. Renombramos IsDayOfWeekHoliday por refactor Inline Method (elimina el método)
     */

    public boolean isHoliday(LocalDate aDate) {
        return _holidayRule.stream().anyMatch(aHolidayRule -> aHolidayRule.isHoliday(aDate));
    }


    /* R11. Eliminamos isDateHoliday */
//    private boolean IsDateHoliday(LocalDate aDate) {
//        return _datesOfHolidays.contains(aDate);
//    }

    /* R13(F). Eliminamos IsDayOfMonthHoliday */
//    private boolean IsDayOfMonthHoliday(LocalDate aDate) {
//        return _daysOfMonthHolidays.contains(new Tuple<>(aDate.getMonthValue(), aDate.getDayOfMonth()));
//    }

    public void MakeDayOfWeekAsHoliday(DayOfWeekHolidayRule dayOfWeekHolidayRule){
        _holidayRule.add(dayOfWeekHolidayRule); //
    }
    public void MakeDayOfMonthAsHoliday(DayOfMonthHolidayRule dayOfMonthHolidayRule) {
        _holidayRule.add(dayOfMonthHolidayRule);
    }
    /*
    R8(I). Repetimos el paso R2 con MakeDateAsHoliday y además enviaremos el día a una misma lista _dateHolidays anterior
    */
    public void MakeDateAsHoliday(DateHolidayRule dateHolidayRule) {
        _holidayRule.add(dateHolidayRule);
    }
    public void MakeDayOfWeekAsHoliday(LocalDate from, LocalDate to, DayOfWeek dayOfWeek) {
    }
}
