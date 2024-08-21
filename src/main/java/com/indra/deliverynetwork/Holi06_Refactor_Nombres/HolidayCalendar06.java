package com.indra.deliverynetwork.Holi06_Refactor_Nombres;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HolidayCalendar06 {
    private List<HolidayRule> _holidayRule = new ArrayList<>();

    public boolean isHoliday(LocalDate aDate) {
        return _holidayRule.stream().anyMatch(aHolidayRule -> aHolidayRule.isHoliday(aDate));
    }
    // R14(I). RENAME MakeDayOfWeekAsHoliday por AddHolidayRule
    // R15. Generalizar el tipo: DayOfWeekHolidayRule -> HolidayRule (Refactor -> Change Signature -> Parameter(type))
    public void AddHolidayRule(HolidayRule dayOfWeekHolidayRule){
        _holidayRule.add(dayOfWeekHolidayRule); //
    }
    /* R16. RENAME MakeDayOfMonthAsHoliday y MakeDateAsHoliday por AddHolidayRule y luego eliminamos el método.
            Desencadena refactorings para lograr el cometido de mejorar el diseño.
    */
//    public void AddHolidayRule(DayOfMonthHolidayRule dayOfMonthHolidayRule) {
//
//        _holidayRule.add(dayOfMonthHolidayRule);
//    }

//    public void AddHolidayRule(DateHolidayRule dateHolidayRule) {
//        _holidayRule.add(dateHolidayRule);
//    }
     /* Final: Ahora implementaremos la nueva regla motivo de este refactoring ya sin modificar esta clase sino las clases Rule nuevas.
     *         Vamos a la clase TEST para continuar con el ciclo */
}
