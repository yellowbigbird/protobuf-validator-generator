package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PriceBreakdown;


import java.util.ArrayList;
import java.util.List;

public class PriceBreakdownValidator extends BaseValidator{
    private PriceBreakdown protoObj;

    public PriceBreakdownValidator(PriceBreakdown protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

