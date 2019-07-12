package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SubmitBookingRS;


import java.util.ArrayList;
import java.util.List;

public class SubmitBookingRSValidator extends BaseValidator{
    private SubmitBookingRS protoObj;

    public SubmitBookingRSValidator(SubmitBookingRS protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

