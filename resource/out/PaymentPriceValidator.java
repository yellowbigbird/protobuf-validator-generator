package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PaymentPrice;


import java.util.ArrayList;
import java.util.List;

public class PaymentPriceValidator extends BaseValidator{
    private PaymentPrice protoObj;

    public PaymentPriceValidator(PaymentPrice protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateTotal(listStr);

        return listStr;
    }

    public void validateTotal(List<String> listStr){
        var data = protoObj.getTotal();
        String name = "total";

        // has
        checkHas(protoObj.hasTotal(), name, listStr);

        PriceValidator validator = new PriceValidator(data);
        listStr.addAll(validator.validate());

    }
    

}

