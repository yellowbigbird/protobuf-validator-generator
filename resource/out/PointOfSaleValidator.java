package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PointOfSale;


import java.util.ArrayList;
import java.util.List;

public class PointOfSaleValidator extends BaseValidator{
    private PointOfSale protoObj;

    public PointOfSaleValidator(PointOfSale protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateMarket(listStr);

        return listStr;
    }

    public void validateMarket(List<String> listStr){
        var data = protoObj.getMarket();
        String name = "market";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // regex("^[A-Z]{2}$")
        checkRegex(data, "^[A-Z]{2}$", name, listStr);
    }
    

}

