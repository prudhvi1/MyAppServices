package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

import java.text.DecimalFormat;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *  
 * This class defines the POJO for a devices data usage
 * It corresponds to the restful service Get data usage details. 
 * 
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *  
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDataUsage {

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class DataUsage{ 

		@JsonProperty("usage")
		private Double usage;
		@JsonProperty("lastUpdate")
		private String lastUpdate;
		@JsonProperty("totalData")
		private int totalData;
		@JsonProperty("serviceEndDate")
		private String serviceEndDate;
		@JsonProperty("serviceBeginDate")
		private String serviceBeginDate;
		@JsonProperty("balance")
		private Double balance;
		@JsonProperty("servicePlanData")
		private int servicePlanData;
		@JsonProperty("dataAddOn")
		private DataAddOn dataAddOn;
		@JsonProperty("ildAddOn")
		private IldAddOn ildAddOn;

		public static class DataAddOn{
			@JsonProperty("balance")
			private Float balance;
			@JsonProperty("lastUpdate")
			private String lastUpdate;
			@JsonProperty("addOnData")
			private int addOnData;
			@JsonProperty("serviceEndDate")
			private String serviceEndDate;
			@JsonProperty("serviceBeginDate")
			private String serviceBeginDate;
			@JsonProperty("description")
			private String description;

			public Float getBalance() { return balance; }

			public void setBalance(Float balance) {
				this.balance = balance;
			}

			public String getLastUpdate() {
				return lastUpdate;
			}

			public void setLastUpdate(String lastUpdate) {
				this.lastUpdate = lastUpdate;
			}

			public int getAddOnData() {
				return addOnData;
			}

			public void setAddOnData(int addOnData) {
				this.addOnData = addOnData;
			}

			public String getServiceEndDate() {
				return serviceEndDate;
			}

			public void setServiceEndDate(String serviceEndDate) {
				this.serviceEndDate = serviceEndDate;
			}

			public String getServiceBeginDate() {
				return serviceBeginDate;
			}

			public void setServiceBeginDate(String serviceBeginDate) {
				this.serviceBeginDate = serviceBeginDate;
			}

			public String getDescription() {
				return description;
			}

			public void setDescription(String description) {
				this.description = description;
			}
		}

		public static class IldAddOn{
			@JsonProperty("balance")
			private Double balance;
			@JsonProperty("type")
			private String type;

			public String getBalance() {
				if(balance!=null) {
					DecimalFormat df = new DecimalFormat("#.#");
					String d = df.format(balance);
					return d;
				}
				return null;
			}

			public void setBalance(Double balance) {
				this.balance = balance;
			}


			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}
		}

		public void setBalance(Double balance) {
			this.balance = balance;
		} //Data is in MB

		public String getBalance() {
			if(balance!=null) {
				DecimalFormat df = new DecimalFormat("#.#");
				String d = df.format(balance);
				return d;
			}
			return null;
		}

		public void setUsage(Double usage) { this.usage = usage; }  //Data is in MB
		public String getUsage() {
			if(usage!=null) {
				DecimalFormat df = new DecimalFormat("#.#");
				String d = df.format(usage);
				return d;
			}
			return null;
		}

		public void setLastUpdate( String lastUpdate) { this.lastUpdate = lastUpdate; }
		public String getLastUpdate() { 
			String d = lastUpdate.replace("-", "/");
			return d;
		}

		public String getServiceEndDate() {
			String d = serviceEndDate.replace("-", "/");
			return d;
		}

		public void setServiceEndDate( String serviceEndDate) {
			this.serviceEndDate = serviceEndDate;
		}

		public String getServiceBeginDate() {
			String d = serviceBeginDate.replace("-", "/");
			return d;
		}

		public void setServiceBeginDate( String serviceBeginDate) {
			this.serviceBeginDate = serviceBeginDate;
		}

		public int getTotalData() {
			return totalData;
		}

		public void setTotalData(int totalData) {
			this.totalData = totalData;
		}

		public int getServicePlanData() {
			return servicePlanData;
		}

		public void setServicePlanData(int servicePlanData) {
			this.servicePlanData = servicePlanData;
		}

		public DataAddOn getDataAddOn() {
			return dataAddOn;
		}

		public void setDataAddOn(DataAddOn dataAddOn) {
			this.dataAddOn = dataAddOn;
		}

		public IldAddOn getIldAddOn() {
			return ildAddOn;
		}

		public void setIldAddOn(IldAddOn ildAddOn) {
			this.ildAddOn = ildAddOn;
		}

	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private DataUsage dataUsage; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public DataUsage getResponse() { return dataUsage; }
	public void setResponse(DataUsage u) { dataUsage = u; } 
	
	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateDataUsage() throws MyAccountServiceException {
		boolean valid = true; 
		if (dataUsage.getUsage() == null && dataUsage.getBalance() == null) valid = false;
		if (dataUsage.getLastUpdate() == null) valid = false;
		if (dataUsage.getTotalData() == 0) valid = false;
		if (dataUsage.getServiceEndDate() == null) valid = false;
		if (dataUsage.getServiceBeginDate() == null) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}

}
