package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.TransportInfo;


import java.util.ArrayList;
import java.util.List;

public class TransportInfoValidator extends BaseValidator{
    private TransportInfo protoObj;

    public TransportInfoValidator(TransportInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

