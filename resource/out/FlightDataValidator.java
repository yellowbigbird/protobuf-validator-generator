package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.FlightData;


import java.util.ArrayList;
import java.util.List;

public class FlightDataValidator extends BaseValidator{
    private FlightData protoObj;

    public FlightDataValidator(FlightData protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

