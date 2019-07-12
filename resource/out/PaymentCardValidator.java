package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PaymentCard;


import java.util.ArrayList;
import java.util.List;

public class PaymentCardValidator extends BaseValidator{
    private PaymentCard protoObj;

    public PaymentCardValidator(PaymentCard protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

