package com.indra.deliverynetwork.Holi02_Refactor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
Nuevo Requerimiento:
    Los feriados son válidos en un intervalo de tiempo . Ejemplos:
        Del 01/01/1990 al 31/12/1999 fueron feriado los lunes.

    Empezamos escribiendo el test06

* */
public class HolidayCalendar02Test {

    private static HolidayCalendar02 holidayCalendar;
    @BeforeAll
    public static void beforeAllTests(){
        //Paso 1: set up
        holidayCalendar = new HolidayCalendar02();
        System.out.println("@BeforeAll -> beforeAllTests()");
    }

    @Test
    public void testOneOfWeekCanBeHoliday(){
        //Paso 1: set up
        holidayCalendar.MakeDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        //Paso 2: excersise
        LocalDate aSaturday = LocalDate.of(2024, 8, 10);
        //Paso 3: assertions
        assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void testDayOfWeekCanNotBeHoliday(){
        LocalDate aMonday = LocalDate.of(2024, 8, 12);
        assertFalse(holidayCalendar.isHoliday(aMonday));
    }

    @Test
    public void test3(){

        holidayCalendar.MakeDayOfWeekAsHoliday(DayOfWeek.SUNDAY);
        LocalDate aSunday = LocalDate.of(2024, 8, 11);
        assertTrue(holidayCalendar.isHoliday(aSunday));
    }

    @Test
    public void testMoreThanDayOfWeekCanBeHoliday(){
        holidayCalendar.MakeDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        holidayCalendar.MakeDayOfWeekAsHoliday(DayOfWeek.SUNDAY);
        LocalDate aSaturday= LocalDate.of(2024, 8, 10);
        LocalDate aSunday = LocalDate.of(2024, 8, 11);
        assertTrue(holidayCalendar.isHoliday(aSunday));
        assertTrue(holidayCalendar.isHoliday(aSaturday));
    }

    @Test
    public void Test1 (){
        holidayCalendar.MakeDayOfMonthAsHoliday(1,1);
        LocalDate aJanuaryFirst = LocalDate.of(2024, 1, 1);
        assertTrue(holidayCalendar.isHoliday(aJanuaryFirst));
    }
    @Test
    public void Test2 (){
        holidayCalendar.MakeDayOfMonthAsHoliday(12,25);
        LocalDate aChristmas = LocalDate.of(2024, 12, 25);
        assertTrue(holidayCalendar.isHoliday(aChristmas));
    }
    @Test
    public void Test3 (){
        holidayCalendar.MakeDayOfMonthAsHoliday(1,1);
        holidayCalendar.MakeDayOfMonthAsHoliday(12,25);
        LocalDate aJanuaryFirst = LocalDate.of(2024, 1, 1);
        LocalDate aChristmas = LocalDate.of(2024, 12, 25);
        assertTrue(holidayCalendar.isHoliday(aJanuaryFirst));
        assertTrue(holidayCalendar.isHoliday(aChristmas));
    }
    @Test
    public void Test4 (){

        holidayCalendar.MakeDateAsHoliday(LocalDate.of(2024, 1, 1));
        LocalDate aDate = LocalDate.of(2024, 1, 1);
        assertTrue(holidayCalendar.isHoliday(aDate));
    }

    @Test
    public void Test5 (){

        holidayCalendar.MakeDateAsHoliday(LocalDate.of(2024, 1, 1));
        LocalDate aDate = LocalDate.of(2024, 1, 2);
        assertFalse(holidayCalendar.isHoliday(aDate));
    }

    @Test
    public void Test6 (){

        holidayCalendar.MakeDayOfWeekAsHoliday(
                LocalDate.of(1990, 1, 1),
                LocalDate.of(1999, 1, 1),
                DayOfWeek.MONDAY);
        LocalDate aDate = LocalDate.of(1998, 3, 2);
        assertFalse(holidayCalendar.isHoliday(aDate));
    }


}
