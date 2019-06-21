package net.skyscanner.halo.megastorm.api.rest.validate;

import java.util.List;
import java.util.regex.Pattern;

public class BaseValidator {
    protected BaseValidator() {}

    //checknull
    public static void checkNull(Object data, String dataName, List<String> listStr) {
        if( data == null) {
            listStr.add(String.format("%s is null.", dataName));
        }
    }

    //checknull has
    public static void checkHas(boolean data, String dataName, List<String> listStr) {
        if(!data){
            listStr.add(String.format("%s is null.", dataName));
        }
    }

    //checkempty
    public static void checkEmpty(String data, String dataName, List<String> listStr) {
        if( data.isEmpty()) {
            listStr.add(String.format("%s is empty.", dataName));
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

    //regex
    public static void checkRegex(String data, String pattern, String dataName, List<String> listStr) {
        if(!Pattern.matches(pattern, data)) {
            listStr.add(String.format("%s regex(%s)", dataName, pattern));
        }
    }
}
