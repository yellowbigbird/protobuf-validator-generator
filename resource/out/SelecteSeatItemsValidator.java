package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SelecteSeatItems;


import java.util.ArrayList;
import java.util.List;

public class SelecteSeatItemsValidator extends BaseValidator{
    private SelecteSeatItems protoObj;

    public SelecteSeatItemsValidator(SelecteSeatItems protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

