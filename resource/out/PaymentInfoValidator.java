package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PaymentInfo;


import java.util.ArrayList;
import java.util.List;

public class PaymentInfoValidator extends BaseValidator{
    private PaymentInfo protoObj;

    public PaymentInfoValidator(PaymentInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

