package com.openbayes.util;

public class Util {
    public static boolean isEmpty(String value){
        return value==null || value.isEmpty();
    }
    public static boolean isEmpty(Integer value){
        return String.valueOf(value).equals("");
    }
}
