package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.Carrier;


import java.util.ArrayList;
import java.util.List;

public class CarrierValidator extends BaseValidator{
    private Carrier protoObj;

    public CarrierValidator(Carrier protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateFlightNumberText(listStr);

        return listStr;
    }

    public void validateFlightNumberText(List<String> listStr){
        var data = protoObj.getFlightNumberText();
        String name = "flight_number_text";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    

}

