package com.indra.deliverynetwork.Holi06_Refactor_Nombres;

import java.time.LocalDate;

public class DateHolidayRule implements HolidayRule {
    private final LocalDate aDate;

    public DateHolidayRule(LocalDate aDate) {
        this.aDate = aDate;
    }

    public LocalDate getaDate() {
        return aDate;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.equals(this.aDate);
    }
}
