package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.IdentityDoc;


import java.util.ArrayList;
import java.util.List;

public class IdentityDocValidator extends BaseValidator{
    private IdentityDoc protoObj;

    public IdentityDocValidator(IdentityDoc protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateDocNumber(listStr);
        validateExpiryDate(listStr);

        return listStr;
    }

    public void validateDocNumber(List<String> listStr){
        var data = protoObj.getDocNumber();
        String name = "doc_number";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    
    public void validateExpiryDate(List<String> listStr){
        var data = protoObj.getExpiryDate();
        String name = "expiry_date";

        // has
        checkHas(protoObj.hasExpiryDate(), name, listStr);

        common.DateValidator validator = new common.DateValidator(data);
        listStr.addAll(validator.validate());

    }
    

}

