package com.ptngaye.spocktutorial.dataseries

import com.ptngaye.spocktutorial.HolidaysHelper
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.Month


public class HolidaysHelperSpec extends Specification {
    private HolidaysHelper holidaysHelper = new HolidaysHelper();

    def 'should calculate easter day for a given year classic'() {
        expect:
        holidaysHelper.identifyEasterDay(year) == easterDay

        where:
        year || easterDay
        2008 || LocalDate.of(2008, Month.MARCH, 23)
        2008 || LocalDate.of(2008, Month.MARCH, 23)
        2009 || LocalDate.of(2009, Month.APRIL, 12)
        2010 || LocalDate.of(2010, Month.APRIL, 4)
        2011 || LocalDate.of(2011, Month.APRIL, 24)
        2012 || LocalDate.of(2012, Month.APRIL, 8)
        2013 || LocalDate.of(2013, Month.MARCH, 31)
        2014 || LocalDate.of(2014, Month.APRIL, 20)
        2015 || LocalDate.of(2015, Month.APRIL, 5)
        2016 || LocalDate.of(2016, Month.MARCH, 27)
    }

    def 'should calculate easter day for a given year with one array per var'() {
        expect:
        holidaysHelper.identifyEasterDay(year) == easterDay

        where:
        year << [2008, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016]
        easterDay << [LocalDate.of(2008, Month.MARCH, 23),
                      LocalDate.of(2008, Month.MARCH, 23),
                      LocalDate.of(2009, Month.APRIL, 12),
                      LocalDate.of(2010, Month.APRIL, 4),
                      LocalDate.of(2011, Month.APRIL, 24),
                      LocalDate.of(2012, Month.APRIL, 8),
                      LocalDate.of(2013, Month.MARCH, 31),
                      LocalDate.of(2014, Month.APRIL, 20),
                      LocalDate.of(2015, Month.APRIL, 5),
                      LocalDate.of(2016, Month.MARCH, 27)]
    }

    @Unroll
    def "in #year easter day is #easterDay with Unroll and one array per var"() {
        expect:
        easterDay == holidaysHelper.identifyEasterDay(year)

        where:
        year << [2008, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016]
        easterDay << [LocalDate.of(2008, Month.MARCH, 23),
                      LocalDate.of(2008, Month.MARCH, 23),
                      LocalDate.of(2009, Month.APRIL, 12),
                      LocalDate.of(2010, Month.APRIL, 4),
                      LocalDate.of(2011, Month.APRIL, 24),
                      LocalDate.of(2012, Month.APRIL, 8),
                      LocalDate.of(2013, Month.MARCH, 31),
                      LocalDate.of(2014, Month.APRIL, 20),
                      LocalDate.of(2015, Month.APRIL, 5),
                      LocalDate.of(2016, Month.MARCH, 27)]
    }

    @Unroll
    def "in #year easter day is #easterDay with Unroll and single array"() {
        expect:
        easterDay == holidaysHelper.identifyEasterDay(year)

        where:
        [year,easterDay]  << [[2008,LocalDate.of(2008, Month.MARCH, 23)],
                              [2008,LocalDate.of(2008, Month.MARCH, 23)],
                              [2009,LocalDate.of(2009, Month.APRIL, 12)],
                              [2010,LocalDate.of(2010, Month.APRIL, 4)],
                              [2011,LocalDate.of(2011, Month.APRIL, 24)],
                              [2012,LocalDate.of(2012, Month.APRIL, 8)],
                              [2013,LocalDate.of(2013, Month.MARCH, 31)],
                              [2014,LocalDate.of(2014, Month.APRIL, 20)],
                              [2015,LocalDate.of(2015, Month.APRIL, 5)],
                              [2016,LocalDate.of(2016, Month.MARCH, 27)]]
    }
}


