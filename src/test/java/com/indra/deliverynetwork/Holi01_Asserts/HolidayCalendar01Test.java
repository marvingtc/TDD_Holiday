package com.indra.deliverynetwork.Holi01_Asserts;

import org.junit.jupiter.api.*;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/*
Ejercicio:
Modelar un Calendario de días feriados a los que se pueda indicar qué días son feriados de la siguiente manera:
Por medio de un día de la semana.                   (MakeDayOfWeekAsHoliday)
Por medio de un día de un mes ej 25 de diciembre.   (MakeDayOfMonthAsHoliday)
Por medio de un día particular, ej 10/02/2024       (MakeDateAsHoliday)

Cada clase Test cuenta con clase implementada de acuerdo a la etapa en que se encuentre.
Las etapas se definen en pasos para la mejor comprensión.
 */

/*
Las fases de TDD son:
1. Red: Crear un test que falle.( Pasos: set up, excersise, assertions)
2. Green: Implementar el código mínimo para que el test pase. (Package main/Holi01 y Package test/Holi01)
3. Refactor: Mejorar el código sin cambiar su comportamiento. (Package main/Holi02 hasta Holi06 con los respectivos package test/02Test hasta 06Test)
*/

/*
Etapa 01 Asserts - Se implementa la clase HolidayCalendar01 con los métodos MakeDayOfWeekAsHoliday, MakeDayOfMonthAsHoliday y MakeDateAsHoliday.
Se implementa la clase de pruebas HolidayCalendar01Test con los métodos de pruebas testOneOfWeekCanBeHoliday, testDayOfWeekCanNotBeHoliday, test3, testMoreThanDayOfWeekCanBeHoliday, Test1, Test2, Test3, Test4 y Test5.
*/
public class HolidayCalendar01Test {

    private static HolidayCalendar01 holidayCalendar01;
    @BeforeAll
    public static void beforeAllTests(){
        //Paso 1: set up
        holidayCalendar01 = new HolidayCalendar01();
        System.out.println("@BeforeAll -> beforeAllTests()");
    }

    @Test
    public void testOneOfWeekCanBeHoliday(){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        //Paso 2: excersise
        LocalDate aSaturday = LocalDate.of(2024, 8, 10);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aSaturday));
    }

    @Test
    public void testDayOfWeekCanNotBeHoliday(){
        //Paso 2: excersise
        LocalDate aMonday = LocalDate.of(2024, 8, 12);
        //Paso 3: assertions
        assertFalse(holidayCalendar01.isHoliday(aMonday));
    }

    @Test
    public void test3(){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfWeekAsHoliday(DayOfWeek.SUNDAY);
        //Paso 2: excersise
        LocalDate aSunday = LocalDate.of(2024, 8, 11);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aSunday));
    }

    @Test
    public void testMoreThanDayOfWeekCanBeHoliday(){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfWeekAsHoliday(DayOfWeek.SATURDAY);
        holidayCalendar01.MakeDayOfWeekAsHoliday(DayOfWeek.SUNDAY);
        //Paso 2: excersise
        LocalDate aSaturday= LocalDate.of(2024, 8, 10);
        LocalDate aSunday = LocalDate.of(2024, 8, 11);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aSunday));
        assertTrue(holidayCalendar01.isHoliday(aSaturday));
    }

    @Test
    public void Test1 (){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfMonthAsHoliday(1,1);
        //Paso 2: excersise
        LocalDate aJanuaryFirst = LocalDate.of(2024, 1, 1);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aJanuaryFirst));
    }
    @Test
    public void Test2 (){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfMonthAsHoliday(12,25);
        //Paso 2: excersise
        LocalDate aChristmas = LocalDate.of(2024, 12, 25);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aChristmas));
    }
    @Test
    public void Test3 (){
        //Paso 1: set up
        holidayCalendar01.MakeDayOfMonthAsHoliday(1,1);
        holidayCalendar01.MakeDayOfMonthAsHoliday(12,25);
        //Paso 2: excersise
        LocalDate aJanuaryFirst = LocalDate.of(2024, 1, 1);
        LocalDate aChristmas = LocalDate.of(2024, 12, 25);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aJanuaryFirst));
        assertTrue(holidayCalendar01.isHoliday(aChristmas));
    }
    @Test
    public void Test4 (){
        //Paso 1: set up
        holidayCalendar01.MakeDateAsHoliday(LocalDate.of(2024, 1, 1));
        //Paso 2: excersise
        LocalDate aDate = LocalDate.of(2024, 1, 1);
        //Paso 3: assertions
        assertTrue(holidayCalendar01.isHoliday(aDate));
    }

    @Test
    public void Test5 (){
        //Paso 1: set up
        holidayCalendar01.MakeDateAsHoliday(LocalDate.of(2024, 1, 1));
        //Paso 2: excersise
        LocalDate aDate = LocalDate.of(2024, 1, 2);
        //Paso 3: assertions
        assertFalse(holidayCalendar01.isHoliday(aDate));
    }
}
