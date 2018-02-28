package com.tracfone.generic.myaccountlibrary.restpojos; 

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 * This class defines the POJO for the response to a restful request to
 * calculate Tax for Auto Refill Enrollment.  
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * ****************************************************************************/

import com.fasterxml.jackson.annotation.*;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)   

public class ResponseAutoRefillEnrollTax { 

	public static class EnrollmentTaxes {

		public static class TodayCharges {
			@JsonProperty("e911Tax")
			private String tcE911Tax; 
			@JsonProperty("rcrfTax")
			private String tcRcrfTax;
			@JsonProperty("usfTax")
			private String tcUsfTax;
			@JsonProperty("amount")
			private String tcAmount;
			@JsonProperty("discountAmount")
			private String tcDiscountAmount; 
			@JsonProperty("salesTax")
			private String tcSalesTax;
			@JsonProperty("totalTaxAmount")
			private String tcTotalTaxAmount;
			@JsonProperty("totalCharges")
			private String tcTotalCharges; 

			public double getTcE911Tax() {	
				if(tcE911Tax!=null) {
					return Double.parseDouble(tcE911Tax); }
				else
					return -1;
			}
			public void setTcE911Tax(String tcE911Tax) { this.tcE911Tax = tcE911Tax; }

			public double getTcRcrfTax() {	
				if(tcRcrfTax!=null) {
					return Double.parseDouble(tcRcrfTax); }
				else
					return -1;
			}
			public void setTcRcrfTax(String tcRcrfTax) { this.tcRcrfTax = tcRcrfTax;}

			public double getTcUsfTax() { 
				if(tcUsfTax!=null) {
					return Double.parseDouble(tcUsfTax); }
				else
					return -1;
			}
			public void setTcUsfTax(String tcUsfTax) {	this.tcUsfTax = tcUsfTax;	}

			public double getTcAmount() { 
				if(tcAmount!=null) {
					return Double.parseDouble(tcAmount); }
				else
					return -1;
			}

			public void setTcAmount(String tcAmount) { this.tcAmount = tcAmount; }

			public double getTcSalesTax() {
				if(tcSalesTax!=null) {
					return Double.parseDouble(tcSalesTax); }
				else
					return -1;
			}
			public void setTcSalesTax(String tcSalesTax) {	this.tcSalesTax = tcSalesTax;	}

			public double getTcTotalTaxAmount() {
				if(tcTotalTaxAmount!=null) {
					return Double.parseDouble(tcTotalTaxAmount); }
				else
					return -1;
			}

			public void setTcTotalTaxAmount(String tcTotalTaxAmount) { this.tcTotalTaxAmount = tcTotalTaxAmount; }

			public double getTcDiscountAmount() { 
				if(tcDiscountAmount!=null) {
					return Double.parseDouble(tcDiscountAmount);}
				else
					return -1;
			}
			public void setTcDiscountAmount(String tcDiscountAmount) {	this.tcDiscountAmount = tcDiscountAmount; }

			public double getTcTotalCharges() {	
				if(tcTotalCharges!=null) {
					return Double.parseDouble(tcTotalCharges);}
				else
					return -1;
			}
			public void setTcTotalCharges(String tcTotalCharges) {	this.tcTotalCharges = tcTotalCharges; }
		}

		public static class PeriodicCharges {
			@JsonProperty("periodicE911Tax")
			private String pcE911Tax; 
			@JsonProperty("periodicRcrfTax")
			private String pcRcrfTax;
			@JsonProperty("periodicUsfTax")
			private String pcUsfTax;
			@JsonProperty("periodicAmount")
			private String pcAmount; 
			@JsonProperty("periodicDiscount")
			private String pcDiscountAmount; 
			@JsonProperty("periodicSalesTax")
			private String pcSalesTax; 
			@JsonProperty("periodicTotalTaxAmount")
			private String pcTotalTaxAmount; 
			@JsonProperty("periodicTotalCharges")
			private String pcTotalCharges; 

			public double getPcE911Tax() {	
				if(pcE911Tax!=null) {
					return Double.parseDouble(pcE911Tax); }
				else
					return -1;
			}
			public void setPcE911Tax(String pcE911Tax) { this.pcE911Tax = pcE911Tax; }

			public double getPcRcrfTax() {	
				if(pcRcrfTax!=null) {
					return Double.parseDouble(pcRcrfTax);}
				else
					return -1;
			}
			public void setPcRcrfTax(String pcRcrfTax) { this.pcRcrfTax = pcRcrfTax;}

			public double getPcUsfTax() { 
				if(pcUsfTax!=null) {
					return Double.parseDouble(pcUsfTax);}
				else
					return -1;
			}
			public void setPcUsfTax(String pcUsfTax) {	this.pcUsfTax = pcUsfTax;	}

			public double getPcDiscountAmount() {
				if(pcDiscountAmount!=null) {
					return Double.parseDouble(pcDiscountAmount);}
				else 
					return -1;
			}
			public void setPcDiscountAmount(String pcDiscountAmount) {	this.pcDiscountAmount = pcDiscountAmount; }

			public double getPcAmount() {				
				if(pcAmount!=null) {
					return Double.parseDouble(pcAmount);}
				else 
					return -1;
			}
			public void setPcAmount(String pcAmount) {	this.pcAmount = pcAmount;	}

			public double getPcSalesTax() {
				if(pcSalesTax!=null) {
					return Double.parseDouble(pcSalesTax);}
				else 
					return -1;
			}
			public void setPcSalesTax(String pcSalesTax) {	this.pcSalesTax = pcSalesTax;	}

			public double getPcTotalTaxAmount() {
				if(pcTotalTaxAmount!=null) {
					return Double.parseDouble(pcTotalTaxAmount);}
				else 
					return -1;
			}
			public void setPcTotalTaxAmount(String pcTotalTaxAmount) {	this.pcTotalTaxAmount = pcTotalTaxAmount;	}

			public double getPcTotalCharges() {
				if(pcTotalCharges!=null) {
					return Double.parseDouble(pcTotalCharges);}
				else 
					return -1;
			}
			public void setPcTotalCharges(String pcTotalCharges) {	this.pcTotalCharges = pcTotalCharges;	}			
		}

		@JsonProperty("todayCharges")
		private TodayCharges todayCharges;
		@JsonProperty("periodicCharges")
		private PeriodicCharges periodicCharges;

		public TodayCharges getTodayCharges() {	return todayCharges; }
		public void setTodayCharges(TodayCharges todayCharges) { this.todayCharges = todayCharges;	}

		public void setPeriodicCharges(PeriodicCharges periodicCharges) { this.periodicCharges = periodicCharges; }
		public PeriodicCharges getPeriodicCharges() {	return periodicCharges;	}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private EnrollmentTaxes enrollmentTaxes;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }  

	public EnrollmentTaxes getResponse() { return enrollmentTaxes; }
	public void setResponse(EnrollmentTaxes pt) { enrollmentTaxes = pt; } 
	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void validateAutoRefillEnrollTax() throws MyAccountServiceException{
		boolean valid = true;
		if (enrollmentTaxes.getTodayCharges().getTcE911Tax() == -1) valid = false; 
		if (enrollmentTaxes.getTodayCharges().getTcUsfTax() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcRcrfTax() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcAmount() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcSalesTax() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcTotalTaxAmount() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcDiscountAmount() == -1) valid = false;
		if (enrollmentTaxes.getTodayCharges().getTcTotalCharges() == -1) valid = false;
		if(!valid)
			throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


	}
} 
