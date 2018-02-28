package com.tracfone.generic.myaccountlibrary.restpojos; 


/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for the response to a restful request to 
* validated a device.  
* 
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/
   

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseValidatedDevice {

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private Device device;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public Device getResponse() { return device; }
	public void setResponse(Device v) { device = v; }
	
	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void  validateValidatedDevice() throws MyAccountServiceException {
		boolean valid = true;   
		if (device.getDeviceEsn() == null) valid = false;
		if (device.getDeviceMin() == null) valid = false;
		if (device.getDeviceStatus() == null) valid = false;
//		if (device.getServicePlanId() == -1) valid = false;
		if (device.getServicePlanName() == null) valid = false;
		if (device.getServicePlanDescription() == null) valid = false;
		if (device.getServicePlanDescription2() == null) valid = false;
		if (device.getServicePlanDescription3() == null) valid = false;
		if (device.getServicePlanDescription4() == null) valid = false;
		if (device.getLastDayService() == null) valid = false;
//		if (device.getReserveCount() == -1) valid = false;
		if (device.getValidatedDeviceAccountStatus() == null) valid = false;
		if (device.getDeviceNickName() == null) valid = false;
		if (device.getDevicePartClass() == null) valid = false;
		if (device.getDeviceType() == null) valid = false;
//		if (device.getInquiryType() == null) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);

	}
} 