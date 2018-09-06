package com.capgemini.util;

public class Util {

    /**
     * Function that compare String with integer,
     * using try and catch. Expected integer
     * @param str number as String
     * @return True if is int, False isn`t
     */
    public static boolean numeric(String str) {
        boolean is = Boolean.TRUE;

        try {
            Integer.valueOf(str);
        } catch (Exception e) {
            is = Boolean.FALSE;
        }
        return is;

    }
}
