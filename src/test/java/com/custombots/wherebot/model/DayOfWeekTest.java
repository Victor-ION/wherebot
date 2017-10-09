package com.custombots.wherebot.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class DayOfWeekTest {
    @Test
    public void castToStandardDayOfWeek() throws Exception {
        DayOfWeek dayOfWeek = new DayOfWeek("Monday", null);

        java.time.DayOfWeek day = dayOfWeek.castToStandardDayOfWeek();
        System.out.println(day.toString());
        assertEquals(day, java.time.DayOfWeek.MONDAY);
    }

}