package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PaymentMethod;


import java.util.ArrayList;
import java.util.List;

public class PaymentMethodValidator extends BaseValidator{
    private PaymentMethod protoObj;

    public PaymentMethodValidator(PaymentMethod protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

