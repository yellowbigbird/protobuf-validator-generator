

CLASS_VALIDATOR = """package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.schema.Date;

import java.util.ArrayList;
import java.util.List;

public class ~validator_class_name~ extends BaseValidator{
    private Date protoObj;

    public ~validator_class_name~(~proto_class_name~ protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<String>();

~call_validate_function~
        return listStr;
    }

~function_validate~
}

"""

FUNCTION_TEMPLATE = """    public void ~function_name~(List<String> listStr){
        int data = protoObj.~proto_get_function~();
        String name = "~name~";

~check_call~        
    }
    
"""

VALIDATION_TEMPLATE = """        // ~check_param~
        check~check_name~(data, 1990, name, listStr);
"""
