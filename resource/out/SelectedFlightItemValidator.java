package net.skyscanner.halo.megastorm.api.rest.validate;

import net.skyscanner.halo.megastorm.api.rest.validate.base.BaseValidator;
import net.skyscanner.halo.megastorm.api.rest.schema.SelectedFlightItem;


import java.util.ArrayList;
import java.util.List;

public class SelectedFlightItemValidator extends BaseValidator{
    private SelectedFlightItem protoObj;

    public SelectedFlightItemValidator(SelectedFlightItem protoObj){
        this.protoObj = protoObj;
    }

    public List<String> validate(){
        List<String> listStr = new ArrayList<>();

        validateOfferItemId(listStr);
        validateLegReferences(listStr);
        validateSegmentReferences(listStr);
        validateTravelerReferences(listStr);

        return listStr;
    }

    public void validateOfferItemId(List<String> listStr){
        var data = protoObj.getOfferItemId();
        String name = "offer_item_id";

        // strEmpty
        checkStringEmpty(data, name, listStr);        
        // strMin(1)
        checkStringMin(data, 1, name, listStr);
    }
    
    public void validateLegReferences(List<String> listStr){
        var data = protoObj.getLegReferencesList();
        String name = "leg_references";
        
        // listMin(1)
        checkListMin(data, 1, name, listStr);
    }
    
    public void validateSegmentReferences(List<String> listStr){
        var data = protoObj.getSegmentReferencesList();
        String name = "segment_references";
        
        // listMin(1)
        checkListMin(data, 1, name, listStr);
    }
    
    public void validateTravelerReferences(List<String> listStr){
        var data = protoObj.getTravelerReferencesList();
        String name = "traveler_references";
        
        // listMin(1)
        checkListMin(data, 1, name, listStr);
    }
    

}

