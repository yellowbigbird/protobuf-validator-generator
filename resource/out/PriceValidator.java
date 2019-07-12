package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.Price;


import java.util.ArrayList;
import java.util.List;

public class PriceValidator extends BaseValidator{
    private Price protoObj;

    public PriceValidator(Price protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateCurrencyCode(listStr);
        validateUnits(listStr);
        validateNanos(listStr);

        return listStr;
    }

    public void validateCurrencyCode(List<String> listStr){
        var data = protoObj.getCurrencyCode();
        String name = "currency_code";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // strMin(3)
        checkStringMin(data, 3, name, listStr);        
        // strMax(3)
        checkStringMax(data, 3, name, listStr);        
        // regex("^[A-Z]{3}$")
        checkRegex(data, "^[A-Z]{3}$", name, listStr);
    }
    
    public void validateUnits(List<String> listStr){
        var data = protoObj.getUnits();
        String name = "units";
        
        // min(0)
        checkMin(data, 0, name, listStr);        
        // max(999999
        checkMax(data, 999999, name, listStr);
    }
    
    public void validateNanos(List<String> listStr){
        var data = protoObj.getNanos();
        String name = "nanos";
        
        // max(999999999)
        checkMax(data, 999999999, name, listStr);        
        // min(0)
        checkMin(data, 0, name, listStr);
    }
    

}

