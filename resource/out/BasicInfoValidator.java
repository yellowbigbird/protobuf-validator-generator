package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.BasicInfo;


import java.util.ArrayList;
import java.util.List;

public class BasicInfoValidator extends BaseValidator{
    private BasicInfo protoObj;

    public BasicInfoValidator(BasicInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateCurrencyCode(listStr);
        validateLocale(listStr);

        return listStr;
    }

    public void validateCurrencyCode(List<String> listStr){
        var data = protoObj.getCurrencyCode();
        String name = "currency_code";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // regex("^[A-Z]{3}$")
        checkRegex(data, "^[A-Z]{3}$", name, listStr);
    }
    
    public void validateLocale(List<String> listStr){
        var data = protoObj.getLocale();
        String name = "locale";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // regex("^[a-z]{2}-[a-zA-Z]{2}$")
        checkRegex(data, "^[a-z]{2}-[a-zA-Z]{2}$", name, listStr);
    }
    

}

