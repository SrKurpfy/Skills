package me.palotinhagostosa.skills.utils;

import java.text.DecimalFormat;

public class Formats {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,###");

    public static String apply(double number) {
        return DECIMAL_FORMAT.format(number);
    }
}
