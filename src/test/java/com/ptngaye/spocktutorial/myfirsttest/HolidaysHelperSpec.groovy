package com.ptngaye.spocktutorial.myfirsttest

import com.ptngaye.spocktutorial.HolidaysHelper
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

public class HolidaysHelperSpec extends Specification {
    def 'easter day in 2014 is 20 april '() {
        given:
        int year = 2014
        LocalDate easterDayExpected = LocalDate.of(2014, Month.APRIL, 20)
        HolidaysHelper holidaysHelper = new HolidaysHelper()
        when:
        LocalDate easterDayActual = holidaysHelper.identifyEasterDay(year)
        then:
        easterDayActual == easterDayExpected
    }

    def 'easter day in 2014 is 20 april and not 17 march'() {
        given:
        int year = 2014
        LocalDate easterDayExpected = LocalDate.of(2014, Month.FEBRUARY, 17);
        HolidaysHelper holidaysHelper = new HolidaysHelper()
        when:
        LocalDate easterDayActual = holidaysHelper.identifyEasterDay(year)
        then:
        easterDayActual == easterDayExpected
    }
}
