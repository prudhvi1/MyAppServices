package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
* TracFone Wireless, Inc.
* Engineering Department  
*
* CLASS DESCRIPTION:  
*  
*	This class defines the POJO for app supported versions responses
* 
* TracFone Engineering Confidential Proprietary
* Copyright (c) 2014,  All Rights Reserved
*
*  
* ****************************************************************************/

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseAppSupportVersions {
	
	public static class AppSupportVersions {

		public class BrandFeatures{

			@JsonProperty("ildNuleaf")
			private boolean ildNuleaf;

			@JsonProperty("ildAuris")
			private boolean ildAuris;

			@JsonProperty("facebook")
			private boolean facebook;

			@JsonProperty("crowdX")
			private boolean crowdX;

			@JsonProperty("crowdXEnable")
			private boolean crowdXEnable;

			@JsonProperty("bandwidthX")
			private boolean bandwidthX;

			@JsonProperty("bandwidthXEnable")
			private boolean bandwidthXEnable;

			@JsonProperty("promoCodes")
			private boolean promoCodes;

			@JsonProperty("otherProducts")
			private boolean otherProducts;

			@JsonProperty("upgradePointRewards")
			private boolean upgradePointRewards;

			@JsonProperty("loyaltyRewards")
			private boolean loyaltyRewards;


			@JsonProperty("phoneprotection")
			private boolean phoneprotection;

			@JsonProperty("multiLine")
			private boolean multiLine;

			public boolean isIldNuleaf() {
				return ildNuleaf;
			}

			public void setIldNuleaf(boolean ildNuleaf) {
				this.ildNuleaf = ildNuleaf;
			}

			public boolean isIldAuris() {
				return ildAuris;
			}

			public void setIldAuris(boolean ildAuris) {
				this.ildAuris = ildAuris;
			}

			public boolean isFacebook() {
				return facebook;
			}

			public void setFacebook(boolean facebook) {
				this.facebook = facebook;
			}

			public boolean isCrowdX() {
				return crowdX;
			}

			public void setCrowdX(boolean crowdX) {
				this.crowdX = crowdX;
			}

			public boolean isCrowdXEnable() {
				return crowdXEnable;
			}

			public void setCrowdXEnable(boolean crowdXEnable) {
				this.crowdXEnable = crowdXEnable;
			}

			public boolean isBandwidthX() {
				return bandwidthX;
			}

			public void setBandwidthX(boolean bandwidthX) {
				this.bandwidthX = bandwidthX;
			}

			public boolean isBandwidthXEnable() {
				return bandwidthXEnable;
			}

			public void setBandwidthXEnable(boolean bandwidthXEnable) {
				this.bandwidthXEnable = bandwidthXEnable;
			}

			public boolean isPromoCodes() {
				return promoCodes;
			}

			public void setPromoCodes(boolean promoCodes) {
				this.promoCodes = promoCodes;
			}

			public boolean isOtherProducts() {
				return otherProducts;
			}

			public void setOtherProducts(boolean otherProducts) {
				this.otherProducts = otherProducts;
			}

			public boolean isUpgradePointRewards() {
				return upgradePointRewards;
			}

			public void setUpgradePointRewards(boolean upgradePointRewards) {
				this.upgradePointRewards = upgradePointRewards;
			}

			public boolean isLoyaltyRewards() {
				return loyaltyRewards;
			}

			public void setLoyaltyRewards(boolean loyaltyRewards) {
				this.loyaltyRewards = loyaltyRewards;
			}

			public boolean isPhoneprotection() {
				return phoneprotection;
			}

			public void setPhoneprotection(boolean phoneprotection) {
				this.phoneprotection = phoneprotection;
			}

			public boolean isMultiLine() {
				return multiLine;
			}

			public void setMultiLine(boolean multiLine) {
				this.multiLine = multiLine;
			}

		}

		@JsonProperty("versions")
		private List<String> versions = new ArrayList<String>();
		@JsonProperty("brandFeatures")
		private BrandFeatures brandFeatures;

		
		public List<String> getVersions() {
			return versions;
		}

		public void setVersions(List<String> versions) {
			this.versions = versions;
		}

		public BrandFeatures getBrandFeatures() {
			return brandFeatures;
		}

		public void setBrandFeatures(BrandFeatures brandFeatures) {
			this.brandFeatures = brandFeatures;
		}

	} 
	
	@JsonProperty("status")
	private ResponseStatus status;
	
	@JsonProperty("response")
	private AppSupportVersions appSupportVersions;

	
	public ResponseStatus getCommon() {
		return status;
	}

	public void setCommon(ResponseStatus status) {
		this.status = status;
	}

	public AppSupportVersions getResponse() {
		return appSupportVersions;
	}

	public void setResponse(AppSupportVersions appSupportVersions) {
		this.appSupportVersions = appSupportVersions;
	}

	/**
	 * This method verifies all data returned from service is valid
	 * 
	 * @return  true if all request data is valid
	 */
	public boolean validateVersionList() {
		
		boolean valid = true;
		for (int i = 0; i < appSupportVersions.getVersions().size(); i++) { 
			if(appSupportVersions.getVersions().get(i) == null)
				valid = false;
		}
		return valid;
	}

}
