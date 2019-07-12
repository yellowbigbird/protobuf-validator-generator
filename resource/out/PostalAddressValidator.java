package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.PostalAddress;


import java.util.ArrayList;
import java.util.List;

public class PostalAddressValidator extends BaseValidator{
    private PostalAddress protoObj;

    public PostalAddressValidator(PostalAddress protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

