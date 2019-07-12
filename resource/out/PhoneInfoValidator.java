package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PhoneInfo;


import java.util.ArrayList;
import java.util.List;

public class PhoneInfoValidator extends BaseValidator{
    private PhoneInfo protoObj;

    public PhoneInfoValidator(PhoneInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validatePhoneNumber(listStr);

        return listStr;
    }

    public void validatePhoneNumber(List<String> listStr){
        var data = protoObj.getPhoneNumber();
        String name = "phone_number";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    

}

