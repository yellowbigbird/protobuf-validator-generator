package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.TravelerInfo;


import java.util.ArrayList;
import java.util.List;

public class TravelerInfoValidator extends BaseValidator{
    private TravelerInfo protoObj;

    public TravelerInfoValidator(TravelerInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

