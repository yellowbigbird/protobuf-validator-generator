package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.Country;


import java.util.ArrayList;
import java.util.List;

public class CountryValidator extends BaseValidator{
    private Country protoObj;

    public CountryValidator(Country protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateCountryCode(listStr);

        return listStr;
    }

    public void validateCountryCode(List<String> listStr){
        var data = protoObj.getCountryCode();
        String name = "country_code";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // regex("^[A-Z]{2}$")
        checkRegex(data, "^[A-Z]{2}$", name, listStr);
    }
    

}

