package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.ReleaseFlavorConfig;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestServiceQualification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedResources;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceCategory;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Extension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ServiceSpecification;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;

/**
 * Created by skishore on 10/19/2016.
 */

public class CommonRequestServiceQualification extends SpiceRequest<String> {


    private ArrayList<RelatedParties> relatedParties;
    private ArrayList<ServiceCategory> serviceCategory;
    private ServiceSpecification serviceSpecification;
    private ArrayList<RelatedResources> relatedResources;
    private ArrayList<RelatedResources> resources;
    private Location location;
    private String serviceCategoryValue;
    private ArrayList<Extension> extension;



    public CommonRequestServiceQualification(){
        super(String.class);
    }

    @Override
    public String loadDataFromNetwork() throws Exception {

        RequestServiceQualification requestProductOrder =  new RequestServiceQualification();
        RequestServiceQualification.ServiceQualificationRequest serviceQualificationRequest= new RequestServiceQualification.ServiceQualificationRequest();
        if(relatedParties!=null)
            serviceQualificationRequest.setRelatedParties(relatedParties);
        if(serviceCategory!=null)
            serviceQualificationRequest.setServiceCategory(serviceCategory);
        if(serviceSpecification!=null)
            serviceQualificationRequest.setServiceSpecification(serviceSpecification);
        if(relatedResources!=null)
            serviceQualificationRequest.setRelatedResources(relatedResources);
        if(resources!=null)
            serviceQualificationRequest.setResources(resources);
        if(location!=null)
            serviceQualificationRequest.setLocation(location);
        if(extension!=null)
            serviceQualificationRequest.setExtension(extension);

        //set common request header
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestProductOrder.setCommon(requestCommon);
        requestProductOrder.setRequest(serviceQualificationRequest);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT); //remove unwanted elements
        String jsonString = mapper.writeValueAsString(requestProductOrder);

        String url = RestfulURL.getUrl(RestfulURL.SERVICE_QUALIFICATION, GlobalLibraryValues.getBrand());
        if (ReleaseFlavorConfig.TEST_MOCKABLE) { //this code makes unique urls for mockable so we can get multiple responses.
            url = String.format(url, serviceCategoryValue);
            if(serviceQualificationRequest.getServiceCategory().get(0).getValue().equals(ServiceCategory.VALUE_ACTIVATION))
            {
                for (int i = 0; i < serviceQualificationRequest.getRelatedResources().size(); i++) {
                    if (serviceQualificationRequest.getRelatedResources().get(i).getName().equals(RelatedResources.NAME_PRODUCT_SERIAL_NUMBER)) {
                        url = url + serviceQualificationRequest.getRelatedResources().get(i).getSerialNumber();
                        break;
                    }
                }
            }
        }

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString() );
        String result = execConnection.executeRequest();
        return result;
    }

    public CommonRequestServiceQualification setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public CommonRequestServiceQualification setLocation(Location location) {
        this.location = location;
        return this;
    }

    public CommonRequestServiceQualification setExtenstion(ArrayList<Extension> extension) {
        this.extension = extension;
        return this;
    }

    public CommonRequestServiceQualification setResources(ArrayList<RelatedResources> resources) {
        this.resources = resources;
        return this;
    }

    public CommonRequestServiceQualification setRelatedResources(ArrayList<RelatedResources> relatedResources) {
        this.relatedResources = relatedResources;
        return this;
    }

    public CommonRequestServiceQualification setServiceSpecification(ServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    public CommonRequestServiceQualification setServiceCategory(ArrayList<ServiceCategory> serviceCategory) {
        this.serviceCategory = serviceCategory;
        return this;
    }

    //Common Request Builder
    public void requestBuilderforServiceQualification(String zipCode,String serviceCategoryValue) {
        this.serviceCategoryValue = serviceCategoryValue;
        //relatedPartiesArrayList Building
        ArrayList<RelatedParties> relatedPartiesArrayList = new ArrayList<RelatedParties>();
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
        relatedPartiesArrayList.add(relatedPartiesObj);
        setRelatedParties(relatedPartiesArrayList);

        //locationObj Building
        if(zipCode!=null) {
            Location locationObj = new Location();
            PostalAddress postalAddressObj = new PostalAddress();
            postalAddressObj.setZipcode(zipCode);
            locationObj.setPostalAddress(postalAddressObj);
            setLocation(locationObj);
        }
        //serviceCategoryArrayList Building
        ArrayList<ServiceCategory> serviceCategoryArrayList = new ArrayList<>();
        ServiceCategory serviceCategoryObj = new ServiceCategory();
        serviceCategoryObj.setType(ServiceCategory.TYPE_CONTEXT);
        serviceCategoryObj.setValue(serviceCategoryValue);
        serviceCategoryArrayList.add(serviceCategoryObj);
        setServiceCategory(serviceCategoryArrayList);

        //serviceSpecificationObj Building
        ServiceSpecification serviceSpecificationObj = new ServiceSpecification();
        serviceSpecificationObj.setBrand(GlobalLibraryValues.getBrand());
        setServiceSpecification(serviceSpecificationObj);

        //Related resources is built in activity

    }
}
