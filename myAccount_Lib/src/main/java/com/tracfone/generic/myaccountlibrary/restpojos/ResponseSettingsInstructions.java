package com.tracfone.generic.myaccountlibrary.restpojos;

/************************************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class ResponseSettingsInstructions defines the POJO for the response body of the  APN Settings Instructions restful web service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 * ************************************************************************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseSettingsInstructions {

    public static class SettingsInstructions implements Parcelable {

        public static class OperatingSystem implements Parcelable{

            @JsonProperty("operatingSystemId")
            private String operatingSystemId;
            @JsonProperty("operatingSystemDescription")
            private String operatingSystemDesc;

            public String getOperatingSystemId() { return operatingSystemId; }
            public void setOperatingSystemId(String operatingSystemId) { this.operatingSystemId = operatingSystemId; }

            public String getOperatingSystemDesc() {
                return operatingSystemDesc;
            }
            public void setOperatingSystemDesc(String operatingSystemDesc) { this.operatingSystemDesc = operatingSystemDesc;  }

            public OperatingSystem() {  }

            protected OperatingSystem(Parcel in) {
                operatingSystemId = in.readString();
                operatingSystemDesc = in.readString();
            }

            public static final Creator<OperatingSystem> CREATOR = new Creator<OperatingSystem>() {
                @Override
                public OperatingSystem createFromParcel(Parcel in) {
                    return new OperatingSystem(in);
                }

                @Override
                public OperatingSystem[] newArray(int size) {
                    return new OperatingSystem[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }
            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(operatingSystemId);
                parcel.writeString(operatingSystemDesc);
            }
        }

        public static class APNSettings implements Parcelable{

            @JsonProperty("ratePlan")
            private String ratePlan;

            public static class Setting implements Parcelable{

                @JsonProperty("settingName")
                private String settingName;
                @JsonProperty("settingValue")
                private String settingValue;
                @JsonProperty("displayOrder")
                private int displayOrder;

                public String getSettingName() { return settingName; }
                public void setSettingName(String settingName) { this.settingName = settingName; }

                public String getSettingValue() {
                    return settingValue;
                }
                public void setSettingValue(String settingValue) { this.settingValue = settingValue; }

                public int getDisplayOrder() {
                    return displayOrder;
                }
                public void setDisplayOrder(int displayOrder) { this.displayOrder = displayOrder; }

                public Setting() { }

                protected Setting(Parcel in) {
                    settingName = in.readString();
                    settingValue = in.readString();
                    displayOrder = in.readInt();
                }
                public static final Creator<Setting> CREATOR = new Creator<Setting>() {
                    @Override
                    public Setting createFromParcel(Parcel in) {
                        return new Setting(in);
                    }
                    @Override
                    public Setting[] newArray(int size) {
                        return new Setting[size];
                    }
                };
                @Override
                public int describeContents() {
                    return 0;
                }
                @Override
                public void writeToParcel(Parcel parcel, int i) {
                    parcel.writeString(settingName);
                    parcel.writeString(settingValue);
                    parcel.writeInt(displayOrder);
                }
            }

            @JsonProperty("instructions")
            private String instructions;

            public String getRatePlan() { return ratePlan; }
            public void setRatePlan(String ratePlan) { this.ratePlan = ratePlan; }

            public String getInstructions() { return instructions; }
            public void setInstructions(String instructions) { this.instructions = instructions; }

            @JsonProperty("settings")
            private List<Setting> settings = new ArrayList<Setting>();

            public List<Setting> getSettings() {
                return settings;
            }
            public void setSettings(List<Setting> settings) {
                this.settings = settings;
            }

            public APNSettings() {  }

            protected APNSettings(Parcel in) {
                ratePlan = in.readString();
                instructions = in.readString();
                in.readTypedList(settings,APNSettings.Setting.CREATOR);
            }
            public static final Creator<APNSettings> CREATOR = new Creator<APNSettings>() {
                @Override
                public APNSettings createFromParcel(Parcel in) {
                    return new APNSettings(in);
                }
                @Override
                public APNSettings[] newArray(int size) {
                    return new APNSettings[size];
                }
            };
            @Override
            public int describeContents() {
                return 0;
            }
            @Override
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeString(ratePlan);
                parcel.writeString(instructions);
                parcel.writeTypedList(settings);
            }
        }
        @JsonProperty("APNSettings")
        private APNSettings apnSettings = new APNSettings();

        public APNSettings getApnSettings() { return apnSettings; }
        public void setApnSettings(APNSettings apnSettings) { this.apnSettings = apnSettings; }

        @JsonProperty("operatingSystems")
        private List<OperatingSystem> operatingSystem = new ArrayList<OperatingSystem>();

        public List<OperatingSystem> getOperatingSystem() { return operatingSystem; }
        public void setOperatingSystem(List<OperatingSystem> operatingSystem) { this.operatingSystem = operatingSystem;  }

        public SettingsInstructions() { }

        protected SettingsInstructions(Parcel in) {
            in.readTypedList(operatingSystem,OperatingSystem.CREATOR);
            apnSettings= in.readParcelable(SettingsInstructions.class.getClassLoader());
        }

        public static final Creator<SettingsInstructions> CREATOR = new Creator<SettingsInstructions>() {
            @Override
            public SettingsInstructions createFromParcel(Parcel in) {
                return new SettingsInstructions(in);
            }
            @Override
            public SettingsInstructions[] newArray(int size) {
                return new SettingsInstructions[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }
        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeTypedList(operatingSystem);
            parcel.writeParcelable(apnSettings, i);
        }
    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private SettingsInstructions settingsInstructions;

    public ResponseStatus getCommon() {
        return status;
    }
    public void setCommon(ResponseStatus v) {
        status = v;
    }

    public SettingsInstructions getResponse() {
        return settingsInstructions;
    }
    public void setResponse(SettingsInstructions v) {
        settingsInstructions = v;
    }

    /**
     * This method verifies all data returned from service is valid
     * @return true if all request data is valid
     */
    public void validateSettingsInstructions() throws MyAccountServiceException {
        boolean valid = true;
        reOrderSettingsList();
        if((settingsInstructions.getOperatingSystem().size()==0)&& (settingsInstructions.getApnSettings().getSettings().size()==0) && (settingsInstructions.getApnSettings().getInstructions().isEmpty()))
            valid=false;
        if((settingsInstructions.getOperatingSystem().size()!=0))
        {
            for(int i=0;i< settingsInstructions.getOperatingSystem().size();i++)
            {
                if(settingsInstructions.getOperatingSystem().get(i).getOperatingSystemId()==null) valid=false;
                if(settingsInstructions.getOperatingSystem().get(i).getOperatingSystemDesc()==null) valid=false;
            }
        }
        else if((settingsInstructions.getApnSettings().getSettings().size()!=0) && !(settingsInstructions.getApnSettings().getInstructions().isEmpty()))
        {
            if(settingsInstructions.getApnSettings().getInstructions()==null) valid=false;
            for(int i=0;i<settingsInstructions.getApnSettings().getSettings().size();i++)
            {
                if(settingsInstructions.getApnSettings().getSettings().get(i).getSettingName()==null) valid=false;
                if(settingsInstructions.getApnSettings().getSettings().get(i).getSettingValue()==null) valid=false;
                if(settingsInstructions.getApnSettings().getSettings().get(i).getDisplayOrder()==-1) valid=false;
            }
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }
    public void reOrderSettingsList()
    {
        if(settingsInstructions.getApnSettings().getSettings().size()>0) {
            List<Integer> settingsToRemove = new ArrayList<Integer>();
            for (int i = 0; i < settingsInstructions.getApnSettings().getSettings().size(); i++) {
                if (settingsInstructions.getApnSettings().getSettings().get(i).getDisplayOrder() == -1)
                    settingsToRemove.add(i);
            }
            for (int j = (settingsToRemove.size() - 1); j >= 0; j--) {
                int index = settingsToRemove.get(j);
                settingsInstructions.getApnSettings().getSettings().remove(index);
            }
        }
        Collections.sort(settingsInstructions.getApnSettings().getSettings(), new Comparator<SettingsInstructions.APNSettings.Setting>() {
            @Override
            public int compare(SettingsInstructions.APNSettings.Setting setting1, SettingsInstructions.APNSettings.Setting setting2) {
                Integer i1 = new Integer(setting1.displayOrder);
                Integer i2 = new Integer(setting2.displayOrder);
                return i1.compareTo(i2);
            }
        });
    }
}