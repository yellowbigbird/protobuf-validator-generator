package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.ErrorResult;


import java.util.ArrayList;
import java.util.List;

public class ErrorResultValidator extends BaseValidator{
    private ErrorResult protoObj;

    public ErrorResultValidator(ErrorResult protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateSkyCode(listStr);

        return listStr;
    }

    public void validateSkyCode(List<String> listStr){
        var data = protoObj.getSkyCode();
        String name = "sky_code";

        // strEmpty
        checkStringEmpty(data, name, listStr);
    }
    

}

