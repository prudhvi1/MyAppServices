package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.Sim;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class defines the POJO for Device
 * It corresponds to the restful service Get Customer Account Details and Validate Device
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

@JsonIgnoreProperties(ignoreUnknown = true)

public class Device implements Parcelable {

    @JsonProperty("min")
    private String deviceMin;
    @JsonProperty("esn")
    private String deviceEsn;
    @JsonProperty("deviceStatus")
    private String deviceStatus;
    @JsonProperty("servicePlanName")
    private String servicePlanName;
    @JsonProperty("servicePlanDescription")
    private String servicePlanDescription;
    @JsonProperty("servicePlanDescription2")
    private String servicePlanDescription2;
    @JsonProperty("servicePlanDescription3")
    private String servicePlanDescription3;
    @JsonProperty("servicePlanDescription4")
    private String servicePlanDescription4;
    @JsonProperty("servicePlanId")
    private String servicePlanId;
    @JsonProperty("serviceEndDate")
    private String lastDayService;
    @JsonProperty("autoRefillStatus")
    private boolean autoRefill;
    @JsonProperty("reserveCount")
    private String reserveCount;
    @JsonProperty("deviceNickname")
    private String deviceNickName;
    @JsonProperty("defaultDevice")
    private boolean accountDetailsDefaultDevice;
    @JsonProperty("devicePartClass")
    private String devicePartClass;
    @JsonProperty("paymentSourceId")
    private String accountDetailsDevicePaymentSourceId;
    @JsonProperty("accountStatus")
    private String validatedDeviceAccountStatus;
    @JsonProperty("deviceType")
    private String deviceType;
    @JsonProperty("reservedLine")
    private boolean reservedLine;
    @JsonProperty("isHandsetProtectionEligible")
    private boolean isProtectionEligible;
    @JsonProperty("isHandsetProtectionEnrolled")
    private boolean isProtectionEnrolled;
    @JsonProperty("isSecurityPinAvailable")
    private boolean validateDeviceIsSecurityPinAvailable;
    @JsonProperty("technology")
    private String accountDetailsDeviceTechnology;
    @JsonProperty("inquiryType")
    private String inquiryType;
    @JsonProperty("leaseStatus")
    private String leaseStatus;
    @JsonProperty("leaseApplicationNumber")
    private String leaseApplicationNumber;
    @JsonProperty("rewards")
    private DeviceRewards accountDetailsDeviceRewards;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("zipcode")
    private String zipcode;
    @JsonProperty("accountId")
    private String validateDeviceAccountId;
    @JsonProperty("accountDeviceCount")
    private String validateDeviceAccountDeviceCount;
    @JsonProperty("isSimRequired")
    private boolean isSimRequired;
    @JsonProperty("sim")
    private Sim sim;
    @JsonProperty("flashMessage")
    private DeviceFlashMessage deviceFlashMessage;
    @JsonProperty("groupInfo")
    private DeviceGroup group;
    @JsonProperty("securityPin")
    private String securityPin;
    private boolean isGroupNameHeader = false;


    public void setDeviceMin(String deviceMin) {
        this.deviceMin = deviceMin;
    }

    public String getDeviceMin() {
        return deviceMin;
    }

    public void setDeviceEsn(String deviceEsn) {
        this.deviceEsn = deviceEsn;
    }

    public String getDeviceEsn() {
        return deviceEsn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getZipcode() {
        String z = zipcode;
        if (z == null) z = "";
        return z;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getValidateDeviceAccountId() {
        String accountId = validateDeviceAccountId;
        if (validateDeviceAccountId == null) accountId = "";
        return accountId;
    }

    public void setValidateDeviceAccountId(String validateDeviceAccountId) {
        this.validateDeviceAccountId = validateDeviceAccountId;
    }

    public int getValidateDeviceAccountDeviceCount() {
        int count = 1;
        try {
            count = Integer.parseInt(validateDeviceAccountDeviceCount);
        } catch (Exception e)  {
            // return a 0
        }
        return count;
    }

    public void setValidateDeviceAccountDeviceCount(String validateDeviceAccountDeviceCount) {
        this.validateDeviceAccountDeviceCount = validateDeviceAccountDeviceCount;
    }

    public boolean isSimRequired() {
        return isSimRequired;
    }

    public void setIsSimRequired(boolean isSimRequired) {
        this.isSimRequired = isSimRequired;
    }

    public Sim getSim() {
        return sim;
    }

    public void setSim(Sim sim) {
        this.sim = sim;
    }

    //Device Statuses
    public static final String DEVICE_INACTIVE = "DEVICE_INACTIVE";
    public static final String DEVICE_ACTIVE = "DEVICE_ACTIVE";
    public static final String DEVICE_NO_ACCOUNT = "DEVICE_NO_ACCOUNT";
    public static final String DEVICE_NEW = "DEVICE_NEW";
    public static final String DEVICE_USED = "DEVICE_USED";
    public static final String DEVICE_PASTDUE = "DEVICE_PASTDUE";
    public static final String DEVICE_STOLEN = "DEVICE_STOLEN";
    public static final String DEVICE_REFURBISH = "DEVICE_REFURBISH";
    public static final String DEVICE_ACTIVATION_PROGRESS = "DEVICE_ACTIVATION_PROGRESS";
    public static final String DEVICE_OTA_PENDING = "DEVICE_OTA_PENDING";
    public static final String DEVICE_PORT_IN_PROGRESS = "DEVICE_PORT IN PROGRESS";
    public static final String DEVICE_RISK_ASSESSMENT = "DEVICE_RISK ASSESMENT";
    public void setDeviceStatus(String deviceStatus) {
        this.deviceStatus = deviceStatus;
    }
    public String getDeviceStatus() {
        if (deviceStatus != null) {
            return "DEVICE_" + deviceStatus;
        } else {
            return "";
        }
    }

    public void setServicePlanName(String servicePlanName) {
        this.servicePlanName = servicePlanName;
    }

    public String getServicePlanName() {
        return servicePlanName;
    }

    public void setServicePlanDescription(String servicePlanDescription) {
        this.servicePlanDescription = servicePlanDescription;
    }

    public String getServicePlanDescription() {
        return servicePlanDescription;
    }

    public void setServicePlanDescription2(String servicePlanDescription2) {
        this.servicePlanDescription2 = servicePlanDescription2;
    }

    public String getServicePlanDescription2() {
        return servicePlanDescription2;
    }

    public void setServicePlanDescription3(String servicePlanDescription3) {
        this.servicePlanDescription3 = servicePlanDescription3;
    }

    public String getServicePlanDescription3() {
        return servicePlanDescription3;
    }

    public void setServicePlanDescription4(String servicePlanDescription4) {
        this.servicePlanDescription4 = servicePlanDescription4;
    }

    public String getServicePlanDescription4() {
        return servicePlanDescription4;
    }

    public void setServicePlanId(String servicePlanId) {
        this.servicePlanId = servicePlanId;
    }

    public int getServicePlanId() {
        if (servicePlanId != null) {
            return Integer.parseInt(servicePlanId);
        } else {
            return -1;
        }
    }

    public void setLastDayService(String lastDayService) {
        this.lastDayService = lastDayService;
    }

    public String getLastDayService() {
        return lastDayService;
    }

    public void setAutoRefill(boolean autoRefill) {
        this.autoRefill = autoRefill;
    }

    public boolean getAutoRefill() {
        return autoRefill;
    }

    public void setReserveCount(String reserveCount) {
        this.reserveCount = reserveCount;
    }

    public int getReserveCount() {
        if (reserveCount != null) {
            return Integer.parseInt(reserveCount);
        } else {
            return -1;
        }
    }

    public void setDeviceNickName(String deviceNickName) {
        this.deviceNickName = deviceNickName;
    }

    public String getDeviceNickName() {
        return deviceNickName;
    }

    public void setAccountDetailsDefaultDevice(boolean accountDetailsDefaultDevice) {
        this.accountDetailsDefaultDevice = accountDetailsDefaultDevice;
    }

    public boolean getAccountDetailsDefaultDevice() {
        return accountDetailsDefaultDevice;
    }

    public String getDevicePartClass() {
        return devicePartClass;
    }

    public void setDevicePartClass(String devicePartClass) {
        this.devicePartClass = devicePartClass;
    }

    public String getAccountDetailsDevicePaymentSourceId() {
        return accountDetailsDevicePaymentSourceId;
    }

    public int setSimMdnPaymentSourceId() {
        if (accountDetailsDevicePaymentSourceId != null) {
            return Integer.parseInt(accountDetailsDevicePaymentSourceId);
        } else {
            return -1;
        }
    }

    //Account Statuses
    public static final String VALID_ACCOUNT = "VALID_ACCOUNT";
    public static final String DUMMY_ACCOUNT = "DUMMY_ACCOUNT";
    public static final String NO_ACCOUNT = "NO_ACCOUNT";
    public void setValidatedDeviceAccountStatus(String validatedDeviceAccountStatus) {
        this.validatedDeviceAccountStatus = validatedDeviceAccountStatus;
    }
    public String getValidatedDeviceAccountStatus() {
        return validatedDeviceAccountStatus;
    }

    public static final String DEVICETYPE_SMARTPHONE = "SMARTPHONE";
    public static final String DEVICETYPE_FEATUREPHONE = "FEATURE_PHONE";
    public static final String DEVICETYPE_HOMEPHONE = "HOMEPHONE";
    public static final String DEVICETYPE_HOME_ALERT = "HOME_ALERT";
    public static final String DEVICETYPE_HOTSPOT = "HOTSPOT";
    public static final String DEVICETYPE_CAR_CONNECT = "CAR_CONNECT";
    public static final String DEVICETYPE_BYOP = "BYOP";
    public static final String DEVICETYPE_BYOT = "BYOT";
    public static final String DEVICETYPE_HOME_CENTER = "HOME_CENTER";
    public String getDeviceType() {
        return deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public void setReservedLine(boolean reservedLine) {
        this.reservedLine = reservedLine;
    }

    public boolean isReservedLine() {
        return reservedLine;
    }

    public void setProtectionEligible(boolean protectionEligible) {
        this.isProtectionEligible = protectionEligible;
    }

    public boolean getProtectionEligible() {
        return isProtectionEligible;
    }

    public void setProtectionEnrolled(boolean protectionEnrolled) {
        this.isProtectionEnrolled = protectionEnrolled;
    }

    public boolean getIsSecurityPintAvailable() {
        return validateDeviceIsSecurityPinAvailable;
    }

    public void setIsSecurityPintAvailable(boolean validateDeviceIsSecurityPintAvailable) {
        this.validateDeviceIsSecurityPinAvailable = validateDeviceIsSecurityPintAvailable;
    }

    public boolean getProtectionEnrolled() {
        return isProtectionEnrolled;
    }

    public static final String DEVICE_TECHNOLOGY_GSM = "GSM";
    public static final String DEVICE_TECHNOLOGY_CDMA = "CDMA";

    public String getAccountDetailsDeviceTechnology() {
        return accountDetailsDeviceTechnology;
    }

    public void setAccountDetailsDeviceTechnology(String accountDetailsDeviceTechnology) {
        this.accountDetailsDeviceTechnology = accountDetailsDeviceTechnology;
    }

    public static final String INQUIRY_TYPE_USAGE = "USAGE";
    public static final String INQUIRY_TYPE_BALANCE = "BALANCE";
    public String getInquiryType() {
        return inquiryType;
    }
    public void setInquiryType(String inquiryType) {
        this.inquiryType = inquiryType;
    }

    public static final String LEASE_STATUS_PREPAID = "1000";
    public static final String LEASE_STATUS_CURRENT = "1001";
    public static final String LEASE_STATUS_CURRENT_R = "1002";
    public static final String LEASE_STATUS_COMPLETE = "1003";
    public static final String LEASE_STATUS_COMPLETE_T = "1004";
    public static final String LEASE_STATUS_REVIEW = "1005";
    public static final String LEASE_STATUS_RETURN = "1006";
    public String getLeaseStatus() {
        return leaseStatus;
    }
    public void setLeaseStatus(String leaseStatus) {
        this.leaseStatus = leaseStatus;
    }

    public String getLeaseApplicationNumber() {
        return leaseApplicationNumber;
    }

    public void setLeaseApplicationNumber(String leaseApplicationNumber) { this.leaseApplicationNumber = leaseApplicationNumber; }

    public DeviceRewards getAccountDetailsDeviceRewards() {
        return accountDetailsDeviceRewards;
    }

    public void setAccountDetailsDeviceRewards(DeviceRewards r) {
        accountDetailsDeviceRewards = r;
    }

    public DeviceFlashMessage getDeviceFlashMessage() {
        return deviceFlashMessage;
    }

    public void setDeviceFlashMessage(DeviceFlashMessage m) {
        deviceFlashMessage = m;
    }

    public DeviceGroup getGroup() {
        return group;
    }

    public void setGroup(DeviceGroup g) {
        group = g;
    }

    public boolean isInGroup() {
        boolean isInGroup = false;
        if (group != null && group.getNumberOfLines() > 1) {
            if (group.getGroupId() !=null && !group.getGroupId().isEmpty()){
                isInGroup = true;
            }

        }
        return isInGroup;
    }

    public void setSecurityPin(String securityPin) {
        this.securityPin = securityPin;
    }

    public String getSecurityPin() {
        return securityPin;
    }

    public boolean isGroupNameHeader() {
        return isGroupNameHeader;
    }

    public void setGroupNameHeader(boolean groupNameHeader) {
        isGroupNameHeader = groupNameHeader;
    }

    public void setDeviceDefaults() {
        this.deviceMin = "----------";
        this.deviceEsn = "0";
        this.deviceStatus = "ACTIVE";
        this.servicePlanName = "";
        this.servicePlanDescription = "";
        this.servicePlanDescription2 = "";
        this.servicePlanDescription3 = "";
        this.servicePlanDescription4 = "";
        this.servicePlanId = "0";
        this.lastDayService = "XX-XX-XXXX";
        this.autoRefill = false;
        this.reserveCount = "0";
        this.deviceNickName = "--------";
        this.accountDetailsDefaultDevice = false;
        this.devicePartClass = "--------";
        this.accountDetailsDevicePaymentSourceId = "0";
        this.deviceType = DEVICETYPE_SMARTPHONE;
        this.reservedLine = false;
        this.isProtectionEligible = false;
        this.isSimRequired = false;
        this.zipcode = "";
        this.validateDeviceAccountId = "";
        this.validateDeviceAccountDeviceCount = "";
        this.brand = "";
    }

    public Device() {
    }

    protected Device(Parcel in) {
        deviceMin = in.readString();
        deviceEsn = in.readString();
        deviceStatus = in.readString();
        servicePlanName = in.readString();
        servicePlanDescription = in.readString();
        servicePlanDescription2 = in.readString();
        servicePlanDescription3 = in.readString();
        servicePlanDescription4 = in.readString();
        servicePlanId = in.readString();
        lastDayService = in.readString();
        autoRefill = in.readByte() != 0;
        reserveCount = in.readString();
        deviceNickName = in.readString();
        accountDetailsDefaultDevice = in.readByte() != 0;
        devicePartClass = in.readString();
        accountDetailsDevicePaymentSourceId = in.readString();
        validatedDeviceAccountStatus = in.readString();
        deviceType = in.readString();
        reservedLine = in.readByte() != 0;
        isProtectionEligible = in.readByte() != 0;
        isProtectionEnrolled = in.readByte() != 0;
        validateDeviceIsSecurityPinAvailable = in.readByte() != 0;
        accountDetailsDeviceTechnology = in.readString();
        inquiryType = in.readString();
        accountDetailsDeviceRewards = in.readParcelable(DeviceRewards.class.getClassLoader());
        deviceFlashMessage = in.readParcelable(DeviceFlashMessage.class.getClassLoader());
        group = in.readParcelable(DeviceGroup.class.getClassLoader());
        isSimRequired = in.readByte() != 0;
        zipcode = in.readString();
        validateDeviceAccountId = in.readString();
        validateDeviceAccountDeviceCount =  in.readString();
        brand = in.readString();
        sim =  in.readParcelable(Sim.class.getClassLoader());
        securityPin = in.readString();
    }

    public static final Creator<com.tracfone.generic.myaccountlibrary.restpojos.Device> CREATOR = new Creator<com.tracfone.generic.myaccountlibrary.restpojos.Device>() {
        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.Device createFromParcel(Parcel in) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.Device(in);
        }

        @Override
        public com.tracfone.generic.myaccountlibrary.restpojos.Device[] newArray(int size) {
            return new com.tracfone.generic.myaccountlibrary.restpojos.Device[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(deviceMin);
        parcel.writeString(deviceEsn);
        parcel.writeString(deviceStatus);
        parcel.writeString(servicePlanName);
        parcel.writeString(servicePlanDescription);
        parcel.writeString(servicePlanDescription2);
        parcel.writeString(servicePlanDescription3);
        parcel.writeString(servicePlanDescription4);
        parcel.writeString(servicePlanId);
        parcel.writeString(lastDayService);
        parcel.writeByte((byte) (autoRefill ? 1 : 0));
        parcel.writeString(reserveCount);
        parcel.writeString(deviceNickName);
        parcel.writeByte((byte) (accountDetailsDefaultDevice ? 1 : 0));
        parcel.writeString(devicePartClass);
        parcel.writeString(accountDetailsDevicePaymentSourceId);
        parcel.writeString(validatedDeviceAccountStatus);
        parcel.writeString(deviceType);
        parcel.writeByte((byte) (reservedLine ? 1 : 0));
        parcel.writeByte((byte) (isProtectionEligible ? 1 : 0));
        parcel.writeByte((byte) (isProtectionEnrolled ? 1 : 0));
        parcel.writeByte((byte) (validateDeviceIsSecurityPinAvailable ? 1 : 0));
        parcel.writeString(accountDetailsDeviceTechnology);
        parcel.writeString(inquiryType);
        parcel.writeParcelable(accountDetailsDeviceRewards, i);
        parcel.writeParcelable(deviceFlashMessage, i);
        parcel.writeParcelable(group, i);
        parcel.writeByte((byte) (isSimRequired ? 1 : 0));
        parcel.writeString(zipcode);
        parcel.writeString(validateDeviceAccountId);
        parcel.writeString(validateDeviceAccountDeviceCount);
        parcel.writeString(brand);
        parcel.writeParcelable(sim, i);
        parcel.writeString(securityPin);
    }
}
