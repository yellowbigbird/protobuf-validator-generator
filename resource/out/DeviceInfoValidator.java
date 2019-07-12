package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.DeviceInfo;


import java.util.ArrayList;
import java.util.List;

public class DeviceInfoValidator extends BaseValidator{
    private DeviceInfo protoObj;

    public DeviceInfoValidator(DeviceInfo protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();


        return listStr;
    }


}

