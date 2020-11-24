package com.test.testvidio.presenter.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FormatterDate {
    public static String format(String input) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat resultFormat = new SimpleDateFormat("dd/MM/yyyy");
        String result = "-";
        if (input != null && !input.isEmpty())
            try {
                result = resultFormat.format(inputFormat.parse(input));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        return result;
    }
}
