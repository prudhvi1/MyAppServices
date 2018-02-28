package com.tracfone.generic.myaccountlibrary.restrequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.octo.android.robospice.request.SpiceRequest;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestCommon;
import com.tracfone.generic.myaccountlibrary.restpojos.RequestValidateAddress;
import com.tracfone.generic.myaccountlibrary.restserviceconnection.SetupHttpURLConnection;

/**
 * Created by atatipally on 9/22/2016.
 */
public class ValidateAddressRequest extends SpiceRequest<String> {

    String id,addrLine1, addrLine2, city, country,locality,poBoxNumber,stateOrProvince,streetName, zipCode;

    public ValidateAddressRequest() {
        super(String.class);
    }

    @Override
    public String loadDataFromNetwork() throws Exception {
        String result = null;
        String url =  RestfulURL.getUrl(RestfulURL.VALIDATE_ADDRESS, GlobalLibraryValues.getBrand());
        url = String.format(url);

        //Populate and create Body
        RequestValidateAddress validateAddress = new RequestValidateAddress();
        RequestValidateAddress.ValidateAddress validateAddrRequest = new RequestValidateAddress.ValidateAddress();
        validateAddrRequest.setId(id);
        validateAddrRequest.setAddressLine1(addrLine1);
        validateAddrRequest.setAddressLine2(addrLine2);
        validateAddrRequest.setCity(city);
        validateAddrRequest.setLocality(locality);
        validateAddrRequest.setStateOrProvince(stateOrProvince);
        validateAddrRequest.setStreetName(streetName);
        validateAddrRequest.setPoBoxNumber(poBoxNumber);
        validateAddrRequest.setZipCode(zipCode);
        validateAddrRequest.setCountry(country);

        validateAddress.setRequest(validateAddrRequest);

        RequestCommon requestCommon = new RequestCommon();
        requestCommon.setAll();
        validateAddress.setCommon(requestCommon);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_DEFAULT);
        String jsonString = mapper.writeValueAsString(validateAddress);

        SetupHttpURLConnection execConnection = new SetupHttpURLConnection(SetupHttpURLConnection.OAUTH_TYPE_CCU, url, "POST", jsonString, getClass().toString());
        result = execConnection.executeRequest();

        return result;
    }
    public ValidateAddressRequest setId(String id) {
        this.id = id;
        return this;
    }

    public ValidateAddressRequest setAddrLine2(String addrLine2) {
        this.addrLine2 = addrLine2;
        return this;
    }

    public ValidateAddressRequest setAddrLine1(String addrLine1) {
        this.addrLine1 = addrLine1;
        return this;
    }

    public ValidateAddressRequest setCity(String city) {
        this.city = city;
        return this;
    }

    public ValidateAddressRequest setCountry(String country) {
        this.country = country;
        return this;
    }

    public ValidateAddressRequest setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public ValidateAddressRequest setPoBoxNumber(String poBoxNumber) {
        this.poBoxNumber = poBoxNumber;
        return this;
    }

    public ValidateAddressRequest setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
        return this;
    }

    public ValidateAddressRequest setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getAddrLine1() {
        return addrLine1;
    }

    public String getAddrLine2() {
        return addrLine2;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getLocality() {
        return locality;
    }

    public String getPoBoxNumber() {
        return poBoxNumber;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public ValidateAddressRequest setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }


}
