package net.skyscanner.halo.megastorm.api.rest.validate.base;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class BaseValidator {
    protected BaseValidator() {}

    //checknull , regular var don't need checkNull
    public static void checkNull(Object data, String dataName, List<String> listStr) {
//        if( data == null) {
//            listStr.add(String.format("%s is null.", dataName));
//        }
    }

    //checknull has
    public static void checkHas(boolean data, String dataName, List<String> listStr) {
        if(!data){
            listStr.add(String.format("%s is null.", dataName));
        }
    }

    //min
    public static <T extends Number> void checkMin(T data, T range, String dataName, List<String> listStr){
        if(data.doubleValue() < range.doubleValue()) {
            listStr.add(String.format("%s min(%d).", dataName, range));
        }
    }

    //max
    public static <T extends Number> void checkMax(T data, T range, String dataName, List<String> listStr){
        if(data.doubleValue() > range.doubleValue()) {
            listStr.add(String.format("%s max(%d).", dataName, range));
        }
    }

    //string checkempty
    public static void checkStringEmpty(String data, String dataName, List<String> listStr) {
        if( data.isEmpty()) {
            listStr.add(String.format("%s is empty.", dataName));
        }
    }

    //string regex
    public static void checkRegex(String data, String pattern, String dataName, List<String> listStr) {
        if(!Pattern.matches(pattern, data)) {
            listStr.add(String.format("%s regex(%s)", dataName, pattern));
        }
    }

    //string len min
    public static void checkStringMin(String data, int range, String dataName, List<String> listStr) {
        if(data.length() < range) {
            listStr.add(String.format("%s strMin(%d)", dataName, range));
        }
    }

    //string len max
    public static void checkStringMax(String data, int range, String dataName, List<String> listStr) {
        if(data.length()>range){
            listStr.add(String.format("%s strMax(%d)", dataName, range));
        }
    }

    //string prefix
    public static void checkStringPrefix(String data, String target, String dataName, List<String> listStr) {
        if (!data.startsWith(target)) {
            listStr.add(String.format("%s strPrefix(%s)", dataName, target));
        }
    }

    //string suffix
    public static void checkStringSuffix(String data, String target, String dataName, List<String> listStr) {
        if (!data.endsWith(target)) {
            listStr.add(String.format("%s strPrefix(%s)", dataName, target));
        }
    }

    //string contains
    public static void checkStringContains(String data, String target, String dataName, List<String> listStr) {
        if (!data.contains(target)) {
            listStr.add(String.format("%s strContain(%s)", dataName, target));
        }
    }

    //repeated min
    public static <T> void checkListMin(List<T> data, int range, String dataName, List<String> listStr) {
        if(data.size() < range) {
            listStr.add(String.format("%s listMin(%d)", dataName, range));
        }
    }

    //repeated max
    public static <T> void checkListMax(List<T> data, int range, String dataName, List<String> listStr) {
        if(data.size() > range) {
            listStr.add(String.format("%s listMax(%d)", dataName, range));
        }
    }

    //map min
    public static <T1, T2> void checkMapMin(Map<T1, T2> data, int range, String dataName, List<String> listStr) {
        if(data.size() < range) {
            listStr.add(String.format("%s mapMin(%d)", dataName, range));
        }
    }

    //map max
    public static <T1, T2> void checkMapMax(Map<T1, T2> data, int range, String dataName, List<String> listStr) {
        if(data.size() > range) {
            listStr.add(String.format("%s mapMax(%d)", dataName, range));
        }
    }
}
