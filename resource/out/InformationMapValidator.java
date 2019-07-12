package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.InformationMap;


import java.util.ArrayList;
import java.util.List;

public class InformationMapValidator extends BaseValidator{
    private InformationMap protoObj;

    public InformationMapValidator(InformationMap protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

