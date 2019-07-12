package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SubmitBookingRQ;


import java.util.ArrayList;
import java.util.List;

public class SubmitBookingRQValidator extends BaseValidator{
    private SubmitBookingRQ protoObj;

    public SubmitBookingRQValidator(SubmitBookingRQ protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

