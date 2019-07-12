package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.ClassOfService;


import java.util.ArrayList;
import java.util.List;

public class ClassOfServiceValidator extends BaseValidator{
    private ClassOfService protoObj;

    public ClassOfServiceValidator(ClassOfService protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

