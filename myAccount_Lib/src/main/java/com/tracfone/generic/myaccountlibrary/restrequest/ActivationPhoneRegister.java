package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestPhoneRegister;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Association;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Individual;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Location;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Party;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PartyExtension;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PhysicalResource;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PostalAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.RelatedParties;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Resource;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ResourceSpecification;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.SupportingLogicalResources;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.SupportingResources;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

import java.util.ArrayList;

/**
 * Created by skishore on 10/19/2016.
 */

public class ActivationPhoneRegister extends SpiceRequest<String> {

    private ArrayList<RelatedParties> relatedParties;
    Resource resource;
    Association association;
    ResourceSpecification resourceSpecification;
    PhysicalResource physicalResource;
    ArrayList<SupportingLogicalResources> supportingLogicalResources;
    String  esn, simNumber, brand, carrier, zipcode;

    public ActivationPhoneRegister(String esn, String simNumber, String brand,String carrier, String zipcode) {

        super(String.class);
        this.esn = esn;
        this.simNumber = simNumber;
        this.brand = brand;
        this.carrier = carrier;
        this.zipcode = zipcode;
    }


    @Override
    public String loadDataFromNetwork() throws Exception {

        String url = RestfulURL.getUrl(RestfulURL.PHONE_REGISTER, GlobalLibraryValues.getBrand());
        RequestPhoneRegister requestPhoneRegister = new RequestPhoneRegister();
        RequestPhoneRegister.PhoneRegisterRequest phoneRegisterRequest = new RequestPhoneRegister.PhoneRegisterRequest();
        requestBuilderforPhoneRegister();
        phoneRegisterRequest.setRelatedParties(relatedParties);
        resource.getLocation().getPostalAddress().setZipcode(zipcode);
        resource.setAssociation(association);
        resourceSpecification.setBrand(brand);
        resource.setResourceSpecification(resourceSpecification);
        physicalResource.setSerialNumber(esn);
        if (simNumber != null && !simNumber.isEmpty()) {
            SupportingResources supportingResourcesObj1 = new SupportingResources();
            supportingResourcesObj1.setResourceCategory(SupportingResources.RESOURCE_CATEGORY_SIMCARD);
            supportingResourcesObj1.setResourceIdentifier(simNumber);
            physicalResource.getSupportingResources().add(supportingResourcesObj1);
            SupportingResources supportingResourcesObj2 = new SupportingResources();
            supportingResourcesObj2.setResourceCategory(SupportingResources.RESOURCE_CATEGORY_SIMSIZE);
            supportingResourcesObj2.setResourceIdentifier(SupportingResources.RESOURCE_IDENTIFIER_NANO);
            physicalResource.getSupportingResources().add(supportingResourcesObj2);
        }
        resource.setPhysicalResource(physicalResource);
        supportingLogicalResources.get(0).setResourceIdentifier(carrier);
        resource.setSupportingLogicalResources(supportingLogicalResources);
        phoneRegisterRequest.setResource(resource);


        //Populate and create Body
        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        requestPhoneRegister.setCommon(requestCommon);
        requestPhoneRegister.setRequest(phoneRegisterRequest);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        String jsonString = mapper.writeValueAsString(requestPhoneRegister);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        String result = execConnection.executeRequest();

        return result;
    }

    public ActivationPhoneRegister setRelatedParties(ArrayList<RelatedParties> relatedParties) {
        this.relatedParties = relatedParties;
        return this;
    }

    public ActivationPhoneRegister setResource (Resource resource) {
        this.resource = resource;
        return this;
    }

    public ActivationPhoneRegister setAssociation (Association association) {
        this.association = association;
        return this;
    }

    public ActivationPhoneRegister setResourceSpecification (ResourceSpecification resourceSpecification) {
        this.resourceSpecification = resourceSpecification;
        return this;
    }

    public ActivationPhoneRegister setPhysicalResource (PhysicalResource physicalResource) {
        this.physicalResource = physicalResource;
        return this;
    }

    public ActivationPhoneRegister setSupportingLogicalResources ( ArrayList<SupportingLogicalResources> supportingLogicalResources) {
        this.supportingLogicalResources = supportingLogicalResources;
        return this;
    }


    //Common Request Builder
    public void requestBuilderforPhoneRegister() {
        //relatedPartiesArrayList Building
        ArrayList<RelatedParties> relatedPartiesArrayList = new ArrayList<RelatedParties>();
        RelatedParties relatedPartiesObj = new RelatedParties();

        //partyExtensionArrayList Building
        ArrayList<PartyExtension> partyExtensionArrayList = new ArrayList<>();
        PartyExtension partyExtensionObj = new PartyExtension();
        partyExtensionObj.setName("partyTransactionID");
        partyExtensionObj.setValue("1231234234424");
        partyExtensionArrayList.add(partyExtensionObj);
        PartyExtension partyExtensionObj1 = new PartyExtension();
        partyExtensionObj1.setName("sourceSystem");
        partyExtensionObj1.setValue("APP");
        partyExtensionArrayList.add(partyExtensionObj1);

        //partyObj Building
        Party partyObj = new Party();
        partyObj.setPartyID("CUST_HASH");
        Individual individualObj = new Individual();
        individualObj.setId("");//Customer ID
        partyObj.setIndividual(individualObj);
        relatedPartiesObj.setParty(partyObj);
        relatedPartiesObj.setRoleType("customer");
        relatedPartiesArrayList.add(relatedPartiesObj);

        //partyObj Building-2
        RelatedParties relatedPartiesObj1 = new RelatedParties();
        Party partyObj1 = new Party();
        partyObj1.setPartyID("TFAPP-ST");
        partyObj1.setLanguageAbility("ENG");
        partyObj1.setPartyExtension(partyExtensionArrayList);
        relatedPartiesObj1.setParty(partyObj1);
        relatedPartiesObj1.setRoleType("application");
        relatedPartiesArrayList.add(relatedPartiesObj1);

        setRelatedParties(relatedPartiesArrayList);

        Resource resourceObj = new Resource();
        Location locationObj = new Location();
        resourceObj.setLocation(locationObj);
        PostalAddress postalAddressObj = new PostalAddress();
        locationObj.setPostalAddress(postalAddressObj);

        setResource(resourceObj);

        Association associationObj = new Association();
        associationObj.setRole(Association.ROLE_REGISTER);

        setAssociation(associationObj);

        ResourceSpecification resourceSpecificationObj = new ResourceSpecification();

        setResourceSpecification(resourceSpecificationObj);

        PhysicalResource physicalResourceObj = new PhysicalResource();
        physicalResourceObj.setResourceCategory(PhysicalResource.RESOURCE_CATEGORY_HANDSET);
        physicalResourceObj.setResourceSubCategory(PhysicalResource.RESOURCE_SUB_CATEGORY_BYOP);
        ArrayList<SupportingResources> supportingResourcesArrayListObj = new ArrayList<>();
        physicalResourceObj.setSupportingResources(supportingResourcesArrayListObj);

        setPhysicalResource(physicalResourceObj);

        ArrayList<SupportingLogicalResources> supportingLogicalResourcesArrayListObj = new ArrayList<>();
        SupportingLogicalResources supportingLogicalResourcesObj = new SupportingLogicalResources();
        supportingLogicalResourcesObj.setResourceCategory(SupportingResources.RESOURCE_CATEGORY_CARRIER);
        supportingLogicalResourcesArrayListObj.add(supportingLogicalResourcesObj);

        setSupportingLogicalResources(supportingLogicalResourcesArrayListObj);
    }
}

