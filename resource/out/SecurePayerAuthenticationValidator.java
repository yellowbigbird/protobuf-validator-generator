package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SecurePayerAuthentication;


import java.util.ArrayList;
import java.util.List;

public class SecurePayerAuthenticationValidator extends BaseValidator{
    private SecurePayerAuthentication protoObj;

    public SecurePayerAuthenticationValidator(SecurePayerAuthentication protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

