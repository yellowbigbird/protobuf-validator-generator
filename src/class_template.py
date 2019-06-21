

PROTO_IMPORT_NAMESPACE = 'import net.skyscanner.halo.megastorm.api.rest.schema.'

CLASS_VALIDATOR = """package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.schema.~proto_class_name~;
~import_other_proto_class~

import java.util.ArrayList;
import java.util.List;

public class ~validator_class_name~ extends BaseValidator{
    private ~proto_class_name~ protoObj;

    public ~validator_class_name~(~proto_class_name~ protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

~call_validate_function~
        return listStr;
    }

~function_validate~
}

"""


FUNCTION_TEMPLATE = """    public void ~function_name~(List<String> listStr){
        var data = protoObj.~proto_get_function~();
        String name = "~name~";
~check_call~
    }
    
"""

VALIDATION_TEMPLATE_NO_PARAM = """
        // ~FULL_VALIDATION~
        check~CHECK_NAME~(data, name, listStr);"""

VALIDATION_TEMPLATE_WITH_PARAM = """        
        // ~FULL_VALIDATION~
        check~CHECK_NAME~(data, ~PARAM~, name, listStr);"""

VALIDATION_TEMPLATE_CHECK_HAS = """
        // ~FULL_VALIDATION~
        check~CHECK_NAME~(protoObj.has~proto_name~(), name, listStr);"""

VALIDATION_TEMPLATE_OTHER_CLASS = """
        ~OTHER_VALIDATOR_NAME~ validator = new ~OTHER_VALIDATOR_NAME~(data);
        listStr.addAll(validator.validate());
"""
