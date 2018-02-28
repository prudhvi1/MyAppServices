package com.tracfone.generic.myaccountlibrary.restpojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.GlobalLibraryValues;
import com.tracfone.generic.myaccountlibrary.restcommon.RestConstants;

public class RequestCommon {
	
	@JsonProperty("brandName")
	private String brandName;
	@JsonProperty("clientAppName")
	private String clientAppName;
	@JsonProperty("clientAppVersion")
	private String clientAppVersion;
	@JsonProperty("clientAppType")
	private String clientAppType;
	@JsonProperty("deviceModel")
	private String deviceModel;
	@JsonProperty("OSVersion")
	private String osVersion;
	@JsonProperty("language")
	private String language;
	@JsonProperty("sourceSystem")
	private String sourceSystem;
	@JsonProperty("channelId")
	private String channelId;
	@JsonProperty("deviceId")
	private String deviceId;
	@JsonProperty("subBrandName")
	private String subBrandName;
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName() {
		this.brandName = GlobalLibraryValues.getBrand();
	}

	public String getClientAppName() {
		return clientAppName;
	}
	public void setClientAppName() {
		this.clientAppName = GlobalLibraryValues.getClientAppName();
	}

	public String getClientAppVersion() {
		return clientAppVersion;
	}
	public void setClientAppVersion() { this.clientAppVersion = GlobalLibraryValues.getClientAppVersion(); }

	public String getClientAppType() {
		return clientAppType;
	}
	public void setClientAppType() { this.clientAppType = GlobalLibraryValues.getClientAppType(); }

	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel() {
		this.deviceModel =  GlobalLibraryValues.getDeviceModel();
	}

	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion() {
		this.osVersion = GlobalLibraryValues.getOSVersion();
	}

	public String getLanguage() {
		return language;
	}
	public void setLanguage() {
		this.language = GlobalLibraryValues.getLanguage();
	}

	public String getSourceSystem() {
		return sourceSystem;
	}
	public void setSourceSystem() { this.sourceSystem = RestConstants.SERVICE_SOURCESYSTEM; }

	public String getChannelId() {
		return channelId;
	}
	public void setChannelId() {
		this.channelId = GlobalLibraryValues.getChannelId();
	}

	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId() {
		this.deviceId = GlobalLibraryValues.getDeviceId();
	}


	public String getSubBrandName() {
		return subBrandName;
	}

	public void setSubBrandName() {
		this.subBrandName = GlobalLibraryValues.getLibSubBrand();
	}
	public void setAll() {
		setBrandName();
		setClientAppName();
		setClientAppVersion();
		setClientAppType();
		setDeviceModel();
		setOsVersion();
		setLanguage();
		setSourceSystem();
		setChannelId();
		setDeviceId();
		setSubBrandName();
	}

}
