package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.City;


import java.util.ArrayList;
import java.util.List;

public class CityValidator extends BaseValidator{
    private City protoObj;

    public CityValidator(City protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateCityName(listStr);
        validateIataLocationCode(listStr);

        return listStr;
    }

    public void validateCityName(List<String> listStr){
        var data = protoObj.getCityName();
        String name = "city_name";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    
    public void validateIataLocationCode(List<String> listStr){
        var data = protoObj.getIataLocationCode();
        String name = "iata_location_code";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // regex("^[A-Z]{3}$")
        checkRegex(data, "^[A-Z]{3}$", name, listStr);
    }
    

}

