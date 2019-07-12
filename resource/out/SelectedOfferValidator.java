package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SelectedOffer;


import java.util.ArrayList;
import java.util.List;

public class SelectedOfferValidator extends BaseValidator{
    private SelectedOffer protoObj;

    public SelectedOfferValidator(SelectedOffer protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

