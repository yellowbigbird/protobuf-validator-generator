package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.schema.City;
import net.skyscanner.halo.megastorm.api.rest.schema.Date;

import java.util.ArrayList;
import java.util.List;

public class CityValidator extends BaseValidator {
    private City protoObj;

    public CityValidator(City protoObj) {
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<String>();

        validateCityName(listStr);
        validateIataLocationCode(listStr);
        validateDate(listStr);
        return listStr;
    }

    public void validateCityName(List<String> listStr){
        String data = protoObj.getCityName();
        String name = "CityName";

        //checknull
        checkNull(data, name, listStr);

        //checkempty
        checkEmpty(data, name, listStr);
    }

    public void validateIataLocationCode(List<String> listStr){
        String data = protoObj.getIataLocationCode();
        String name = "IataLocationCode";

        //checknull
        checkNull(data, name, listStr);

        //checkempty
        checkEmpty(data, name, listStr);

        //regex
        checkRegex(data, "SHA", "IataLocationCode", listStr);
    }

    public void validateDate(List<String> listStr){
        Date data = protoObj.getDate();
        String name = "Date";

        //checkNull
        checkNull(data, name, listStr);

        DateValidator validator = new DateValidator(data);
        listStr.addAll(validator.validate());
    }
}
