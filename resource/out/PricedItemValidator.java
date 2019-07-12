package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PricedItem;


import java.util.ArrayList;
import java.util.List;

public class PricedItemValidator extends BaseValidator{
    private PricedItem protoObj;

    public PricedItemValidator(PricedItem protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateOfferItemRef(listStr);
        validateTotal(listStr);

        return listStr;
    }

    public void validateOfferItemRef(List<String> listStr){
        var data = protoObj.getOfferItemRef();
        String name = "offer_item_ref";

        // strEmpty
        checkStringEmpty(data, name, listStr);
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

