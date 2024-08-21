package com.indra.deliverynetwork.Holi06_Refactor_Nombres;

import java.time.LocalDate;

public class DayOfMonthHolidayRule implements HolidayRule {
    private final int aMonthNumber;
    private final int aDayNumber;

    public DayOfMonthHolidayRule(int aMonthNumber, int aDayNumber) {
        this.aMonthNumber = aMonthNumber;
        this.aDayNumber = aDayNumber;
    }

    public int getaMonthNumber() {
        return aMonthNumber;
    }

    public int getaDayNumber() {
        return aDayNumber;
    }

    @Override
    public boolean isHoliday(LocalDate aDate) {
        return aDate.getMonthValue() == aMonthNumber && aDate.getDayOfMonth() == aDayNumber;
    }
}
