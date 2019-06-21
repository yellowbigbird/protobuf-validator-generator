package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.schema.Date;

import java.util.ArrayList;
import java.util.List;

public class DateValidator extends BaseValidator{
    private Date protoObj;

    public DateValidator(Date protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<String>();

        validateYear(listStr);
        validateMonth(listStr);
        validateDay(listStr);

        return listStr;
    }

    public void validateYear(List<String> listStr){
        int data = protoObj.getYear();
        String name = "year";

        // min(1990)
        checkMin(data, 1990, name, listStr);
    }

    public void validateMonth(List<String> listStr){
        int data = protoObj.getMonth();
        String name = "month";

        //min(1)
        checkMin(data, 1, name, listStr);

        //max(12)
        checkMax(data, 12, name, listStr);
    }

    public void validateDay(List<String> listStr){
        int data = protoObj.getDay();
        String name = "day";

        // max(32)
        checkMax(data, 32, name, listStr);
        // min(0)
        checkMin(data, 0, name, listStr);

    }
}
