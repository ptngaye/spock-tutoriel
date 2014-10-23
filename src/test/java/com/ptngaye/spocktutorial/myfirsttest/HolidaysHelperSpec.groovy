package com.ptngaye.spocktutorial.myfirsttest

import com.ptngaye.spocktutorial.HolidaysHelper
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

public class HolidaysHelperSpec extends Specification {
    private HolidaysHelper holidaysHelper = new HolidaysHelper();

    def 'assert something'() {
        given:
        String valueExpected = 'some value'

        when:
        String valueActual = 'some value'

        then:
        valueActual == valueExpected
    }

    def 'assert something else'() {
        expect:
        LocalDate.of(2014, Month.APRIL, 20)==holidaysHelper.identifyEasterDay(2014)
    }

    def 'easter day in 2014 is 20 april'() {
        given:
        int year = 2014
        LocalDate easterDayExpected = LocalDate.of(2014, Month.APRIL, 20);

        when:
        LocalDate easterDayActual = holidaysHelper.identifyEasterDay(year)

        then:
        easterDayActual == easterDayExpected
    }

    def 'easter day in 2014 is 20 april and not 17 march'() {
        given:
        int year = 2014
        LocalDate easterDayExpected = LocalDate.of(2014, Month.MARCH, 20);

        when:
        LocalDate easterDayActual = holidaysHelper.identifyEasterDay(year)

        then:
        easterDayActual == easterDayExpected
    }
}
