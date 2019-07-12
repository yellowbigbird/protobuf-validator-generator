package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.Name;


import java.util.ArrayList;
import java.util.List;

public class NameValidator extends BaseValidator{
    private Name protoObj;

    public NameValidator(Name protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateFirstName(listStr);
        validateLastName(listStr);

        return listStr;
    }

    public void validateFirstName(List<String> listStr){
        var data = protoObj.getFirstName();
        String name = "first_name";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    
    public void validateLastName(List<String> listStr){
        var data = protoObj.getLastName();
        String name = "last_name";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    

}

