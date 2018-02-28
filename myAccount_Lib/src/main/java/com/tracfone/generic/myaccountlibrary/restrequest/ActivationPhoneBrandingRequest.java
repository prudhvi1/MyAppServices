package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestPhoneBranding;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Resource;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;

/**
 * Created by skishore on 10/19/2016.
 */

public class ActivationPhoneBrandingRequest extends SpiceRequest<String> {
    private RelatedParties relatedParties;
    Resource accResource;
    public ActivationPhoneBrandingRequest(){
        super(String.class);
    }
    @Override
    public String loadDataFromNetwork() throws Exception {
        String url = RestfulURL.getUrl(RestfulURL.PHONE_BRANDING, GlobalLibraryValues.getBrand());
        RequestPhoneBranding requestPhoneBranding = new RequestPhoneBranding();
        RequestPhoneBranding.PhoneBrandingRequest phoneBrandingRequest = new RequestPhoneBranding.PhoneBrandingRequest();
        phoneBrandingRequest.setRelatedParties(relatedParties);
        phoneBrandingRequest.setResource(accResource);
        //Populate and create Body
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestPhoneBranding.setCommon(requestCommon);
        requestPhoneBranding.setRequest(phoneBrandingRequest);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(requestPhoneBranding);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        String result = execConnection.executeRequest();

        return result;
    }

    public ActivationPhoneBrandingRequest setRelatedParties(RelatedParties relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public ActivationPhoneBrandingRequest setResources(Resource resources) {
        this.accResource = resources;
        return this;
    }

    //Common Request Builder
    public void requestBuilderforRelatedParties() {
        //relatedPartiesArrayList Building
        RelatedParties relatedPartiesObj = new RelatedParties();

        //partyExtensionArrayList Building
        ArrayList<PartyExtension> partyExtensionArrayList = new ArrayList<>();
        PartyExtension partyExtensionObj = new PartyExtension();
        partyExtensionObj.setName(PartyExtension.PARTY_TRANSACTIONID);
        Long tsLong = System.currentTimeMillis()/1000;
        partyExtensionObj.setValue(GlobalLibraryValues.getDeviceId() +  tsLong.toString());
        partyExtensionArrayList.add(partyExtensionObj);
        PartyExtension partyExtensionObj1 = new PartyExtension();
        partyExtensionObj1.setName(PartyExtension.PARTY_SOURCE_SYSTEM);
        partyExtensionObj1.setValue(PartyExtension.PARTY_APP);
        partyExtensionArrayList.add(partyExtensionObj1);

        //partyObj Building
        Party partyObj = new Party();
        partyObj.setPartyID(Party.PARTY_ID_TFAPP_BRAND);
        partyObj.setLanguageAbility(Party.PARTY_LANGUAGE_AVAILABILITY_ENG);
        partyObj.setPartyExtension(partyExtensionArrayList);
        relatedPartiesObj.setParty(partyObj);
        relatedPartiesObj.setRoleType(Party.PARTY_ROLE_TYPE_APPLICATION);
        setRelatedParties(relatedPartiesObj);
    }

}
