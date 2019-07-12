package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.FrequentFlyerInfo;


import java.util.ArrayList;
import java.util.List;

public class FrequentFlyerInfoValidator extends BaseValidator{
    private FrequentFlyerInfo protoObj;

    public FrequentFlyerInfoValidator(FrequentFlyerInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

