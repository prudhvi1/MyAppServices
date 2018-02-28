package com.tracfone.generic.myaccountlibrary.restpojos; 

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
* This class defines the POJO for retailer list
* It corresponds to the restful service get Retailers
*
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/


import java.util.ArrayList;
import java.util.List;  
import com.fasterxml.jackson.annotation.*;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)   

public class ResponseRetailersList { 
	
	public static class RetailerList {

		public static class Retailer {   

			public static class LatLng { 

				@JsonProperty("lat")
				private String lat;
				@JsonProperty("lng")
				private String lng; 

				public double getLat() {  
					if (lat != null)  {
						return Double.parseDouble(lat);
					} else {
						return -1;
					}
				}
				public void setLat(String s) { lat = s; }

				public double getLng() {  
					if (lng != null)  {
						return Double.parseDouble(lng);
					} else {
						return -1;
					}
				}
				public void setLng(String s) { lng = s; }  
			}



			@JsonProperty("resultNumber")
			private String resultNumber;
			@JsonProperty("distance")
			private String distance;
			@JsonProperty("storeId")
			private String storeId;
			@JsonProperty("latLng")
			private LatLng latLng;
			@JsonProperty("state")
			private String state; 
			@JsonProperty("zip") 
			private String postalCode;
			@JsonProperty("storeList") 
			private String storeList;
			@JsonProperty("storeName")
			private String name;  
			@JsonProperty("isBrandedRetailStore")
			private String isBrandedRetailStore; 
			@JsonProperty("address")
			private String address;  
			@JsonProperty("storeType")
			private String storeType;  
			@JsonProperty("storeNum")
			private String storeNumber;  
			@JsonProperty("phone")
			private String phone;
			@JsonProperty("city")
			private String city; 

			public int getResultNumber() { 
				if (resultNumber != null)  {
					return Integer.parseInt(resultNumber);
				} else {
					return -1;
				}
			}
			public void setResultNumber(String  n ) { resultNumber = n; } 

			public String getStoreId() { return storeId; }
			public void setStoreId(String s) { storeId = s; } 

			public String getDistance() { return distance; }
			public void setDistance(String s) { distance = s; } 

			public LatLng getLatLng() { return latLng; }
			public void setLatLng(LatLng c) { latLng = c; } 

			public String getState() { return state; }
			public void setState(String s) { state = s; }  

			public String getStoreList() { return storeList; }
			public void setStoreList(String s) { storeList = s; }   

			public String getName() { return name; }
			public void setName(String n) { name = n; }  

			public String getIsBrandedRetailStore() { return isBrandedRetailStore; }
			public void setIsBrandedRetailStore(String i) { isBrandedRetailStore = i; } 

			public String getAddress() { return address; }
			public void setAddress(String a) { address = a; }  

			public String getStoreType() { return storeType; }
			public void setStoreType(String s) { storeType = s; }  

			public String getStoreNumber() { return storeNumber; }
			public void setStoreNumber(String s) { storeNumber = s; }  

			public String getPostalCode() { return postalCode; }
			public void setPostalCode(String z) { postalCode  = z; }   

			public String getPhone() { return phone; }
			public void setPhone(String p) { phone = p; }  

			public String getCity() { return city; }
			public void setCity(String c) { city = c; } 

		}

		@JsonProperty("searchResults")
		private List<Retailer> retailer = new ArrayList<Retailer>();
		@JsonProperty("origin")
		private Origin origin; 
		
		public List<Retailer> getRetailer() { return retailer; } 
		public void setRetailer(List<Retailer> r) { retailer = r;  }  

		public Origin getOrigin() { return origin; }
		public void setOrigin(Origin o) { origin = o; }  
	}


	public static class Origin {
		public static class LatLng {
			private String lat;
			private String lng; 
			
			public double getLat() {  
				if (lat != null)  {
					return Double.parseDouble(lat);
				} else {
					return -1;
				}
			}
			public void setLat(String s) { lat = s; }

			public double getLng() {  
				if (lng != null)  {
					return Double.parseDouble(lng);
				} else {
					return -1;
				}
			}
			public void setLng(String s) { lng = s; } 
		}
		private LatLng latLng; 

		public LatLng getLatLng() { return latLng; }
		public void setLatLng(LatLng l) { latLng = l; }
	}



	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private RetailerList retailerList; 

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  
	
	public RetailerList getResponse() { return retailerList; }
	public void setResponse(RetailerList r) { retailerList = r; }  
	

	/**
	 * This method varifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public void validateRetailerList() throws MyAccountServiceException{
		boolean valid = true; 
		
		if (retailerList.getOrigin().getLatLng().getLat() == -1) valid = false;  
		if (retailerList.getOrigin().getLatLng().getLng() == -1) valid = false;  
		
		for (int i = 0; i < retailerList.getRetailer().size(); i++) { 
			if (retailerList.getRetailer().get(i).getResultNumber() == -1) valid = false;  
			if (retailerList.getRetailer().get(i).getDistance() == null) valid = false;   
//			if (retailerList.getRetailer().get(i).getStoreId() == null) valid = false;   
			if (retailerList.getRetailer().get(i).getLatLng().getLat() == -1) valid = false;  
			if (retailerList.getRetailer().get(i).getLatLng().getLng() == -1) valid = false;  
			if (retailerList.getRetailer().get(i).getState() == null) valid = false;    
			if (retailerList.getRetailer().get(i).getPostalCode() == null) valid = false;   
			if (retailerList.getRetailer().get(i).getStoreList() == null) valid = false;   
			if (retailerList.getRetailer().get(i).getName() == null) valid = false;     
//			if (retailerList.getRetailer().get(i).getIsBrandedRetailStore() == null) valid = false;    
			if (retailerList.getRetailer().get(i).getAddress() == null) valid = false;     
			if (retailerList.getRetailer().get(i).getStoreType() == null) valid = false;     
//			if (retailerList.getRetailer().get(i).getStoreNumber() == null) valid = false;    
			if (retailerList.getRetailer().get(i).getPhone() == null) valid = false;   
			if (retailerList.getRetailer().get(i).getCity() == null) valid = false;    
		}
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}


} 
