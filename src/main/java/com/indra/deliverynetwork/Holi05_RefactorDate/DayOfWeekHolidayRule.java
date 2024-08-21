package com.indra.deliverynetwork.Holi05_RefactorDate;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekHolidayRule implements HolidayRule {
    private final DayOfWeek aDayOfWeek;

    public DayOfWeekHolidayRule(DayOfWeek aDayOfWeek) {
        this.aDayOfWeek = aDayOfWeek;
    }

    public DayOfWeek getaDayOfWeek() {
        return aDayOfWeek;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.getDayOfWeek().equals(aDayOfWeek);
    }
}
