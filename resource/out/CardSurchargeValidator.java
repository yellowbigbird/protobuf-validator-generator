package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.CardSurcharge;


import java.util.ArrayList;
import java.util.List;

public class CardSurchargeValidator extends BaseValidator{
    private CardSurcharge protoObj;

    public CardSurchargeValidator(CardSurcharge protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validatePercentage(listStr);
        validateTotal(listStr);

        return listStr;
    }

    public void validatePercentage(List<String> listStr){
        var data = protoObj.getPercentage();
        String name = "percentage";
        
        // max(100.00)
        checkMax(data, 100.00, name, listStr);        
        // min(0)
        checkMin(data, 0, name, listStr);
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

