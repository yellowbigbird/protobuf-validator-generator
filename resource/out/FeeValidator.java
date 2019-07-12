package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.Fee;


import java.util.ArrayList;
import java.util.List;

public class FeeValidator extends BaseValidator{
    private Fee protoObj;

    public FeeValidator(Fee protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateAmount(listStr);

        return listStr;
    }

    public void validateAmount(List<String> listStr){
        var data = protoObj.getAmount();
        String name = "amount";

        // has
        checkHas(protoObj.hasAmount(), name, listStr);

        PriceValidator validator = new PriceValidator(data);
        listStr.addAll(validator.validate());

    }
    

}

