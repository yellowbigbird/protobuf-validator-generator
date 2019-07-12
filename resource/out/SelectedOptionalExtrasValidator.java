package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SelectedOptionalExtras;


import java.util.ArrayList;
import java.util.List;

public class SelectedOptionalExtrasValidator extends BaseValidator{
    private SelectedOptionalExtras protoObj;

    public SelectedOptionalExtrasValidator(SelectedOptionalExtras protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

