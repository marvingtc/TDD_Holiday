package com.indra.deliverynetwork.Holi06_Refactor_Nombres;

import com.indra.deliverynetwork.Holi06_Refactor_Nombres.DayOfWeekHolidayRule;
import com.indra.deliverynetwork.Holi06_Refactor_Nombres.HolidayRule;

import java.time.LocalDate;

// R18(I). Renombramos los parámetros
// R19. Crear fielD for parameter
public class CompoundRangeHolidayRule implements HolidayRule {
    private final LocalDate _from;
    private final LocalDate _to;
    private final DayOfWeekHolidayRule _holidayRule;

    public CompoundRangeHolidayRule(LocalDate from, LocalDate to, DayOfWeekHolidayRule holidayRule) {
        _from = from;
        _to = to;
        _holidayRule = holidayRule;
    }
    // R20(F) Implementamos el método isHoliday
    @Override
    public boolean isHoliday(LocalDate aDate) {
        return (aDate.isAfter(_from) || aDate.isEqual(_from)) && (aDate.isBefore(_to) || aDate.isEqual(_to)) && _holidayRule.isHoliday(aDate);
    }
}
