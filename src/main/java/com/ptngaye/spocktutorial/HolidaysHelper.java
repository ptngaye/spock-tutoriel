package com.ptngaye.spocktutorial;

import java.time.LocalDate;

public class HolidaysHelper {
    //Source : http://www.aveol.fr/?p=608
    public LocalDate identifyEasterDay(int year) {
        int a = year / 100;
        int b = year % 100;
        int c = (3 * (a + 25)) / 4;
        int d = (3 * (a + 25)) % 4;
        int e = (8 * (a + 11)) / 25;
        int f = (5 * a + b) % 19;
        int g = (19 * f + c - e) % 30;
        int h = (f + 11 * g) / 319;
        int j = (60 * (5 - d) + b) / 4;
        int k = (60 * (5 - d) + b) % 4;
        int m = (2 * j - k - g + h) % 7;
        int n = (g - h + m + 114) / 31;
        int p = (g - h + m + 114) % 31;
        int day = p + 1;
        int month = n;

        return LocalDate.of(year, month, day);
    }
}