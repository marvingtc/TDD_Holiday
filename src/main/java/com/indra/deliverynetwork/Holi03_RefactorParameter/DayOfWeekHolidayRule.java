package com.indra.deliverynetwork.Holi03_RefactorParameter;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DayOfWeekHolidayRule {
    private final DayOfWeek aDayOfWeek;

    public DayOfWeekHolidayRule(DayOfWeek aDayOfWeek) {
        this.aDayOfWeek = aDayOfWeek;
    }

    public DayOfWeek getaDayOfWeek() {
        return aDayOfWeek;
    }

    public boolean isHolidayRule(LocalDate aDate) {
        return aDate.getDayOfWeek().equals(aDayOfWeek);
    }
}
