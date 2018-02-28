package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.ParsedAddress;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PortAccountDetails;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;

/**
 * Created by atatipally on 11/18/2016.
 */

//Data Holder class which holds the data to build the request across multiple activities for activation flow
public class ActivationRequestDataHolder implements Parcelable {

    private int groupNumberOfAddsRequested = 0;
    private int groupNumberOfAdds = 0;
    private int groupNumberOfAvailableLines = 0;
    private int groupNumberOfLines = 0;
    private boolean isAddToCurrentGroup = false;
    private String groupAccountId = "";
    private String groupGroupId = "";
    private String purchaseType = "";
    private String purchaseTypeOriginal ="";
    private String airTimePin = "";
    private String promoCode = "";
    private ResponsePlanList.PlanList.Plan selectedPlan;
    private PaymentMean guestCreditCard;
    private ResponseCreditCardList.CreditCardList.CreditCard storedCreditCard;
    private String storedCreditCardCVV = "";

    //Values below this point are device specific
    private String flowActionType;
    private String flowScenarioPinRequired = ResponseServiceQualification.ServiceQualificationResponse.FLOW_SCENARIO_PIN_REQUIRED;
    private boolean flowScenarioAddToNewGroup = false;

    // Sim number to be activated
    private String activationSimCardSerialNumber;
    //Device serial number (ESN/IMEI) to be activated
    private String activationElectronicSerialNumber;
    private Device validatedESN;
    private Device validatedFromMin;
    //Carrier to be activated
    private String activationCarrier = "";
    //Phone number to be activated
    private String activationZipCode = "";
    //Phone number to be activated
    private String activationCurrentMinNumber = "";

    private String portCarrierType = "";
    private String portType = "";
    private String portServiceProvider = "";
    private PortAccountDetails portPortAccountDetails;
    private ParsedAddress portValidatedAddress;
    private MoreAddress portValidateMoreAddress;
    // Sim number to be ported from
    private String portCurrentSimCardSerialNumber;
    //Device serial number (ESN/IMEI) to be ported from
    private String portFromElectronicSerialNumber;
    //Brand to be ported from
    private String portCurrentBrand;
    //device status selected by user for the device we intend to create account(ACRE 126.1)
    private String deviceStatusForAccountCreation ="";
    //Temporary copy of data used for LAST add esn to group
    private ActivationRequestDataHolder lastEsnAddDataholder;

    //GETTERS and SETTERS

    public String getDeviceStatusForAccountCreation() {
        return deviceStatusForAccountCreation;
    }

    public void setDeviceStatusForAccountCreation(String deviceStatusForAccountCreation) {
        this.deviceStatusForAccountCreation = deviceStatusForAccountCreation;
    }

    public int getGroupNumberOfAddsRequested() {
        return groupNumberOfAddsRequested;
    }

    public void setGroupNumberOfAddsRequested(int groupNumberOfAddsRequested) {
        this.groupNumberOfAddsRequested = groupNumberOfAddsRequested;
    }

    public int getGroupNumberOfAdds() {
        return groupNumberOfAdds;
    }

    public void setGroupNumberOfAdds(int groupNumberOfAdds) {
        this.groupNumberOfAdds = groupNumberOfAdds;
    }

    public int getGroupNumberOfAvailableLines() {
        return groupNumberOfAvailableLines;
    }

    public void setGroupNumberOfAvailableLines(int groupNumberOfAvailableLines) {
        this.groupNumberOfAvailableLines = groupNumberOfAvailableLines;
    }

    public int getGroupNumberOfLines() {
        return groupNumberOfLines;
    }

    public void setGroupNumberOfLines(int numberOfLines) {
        this.groupNumberOfLines = numberOfLines;
    }

    public boolean isAddToCurrentGroup() {
        return isAddToCurrentGroup;
    }

    public void setIsAddToCurrentGroup(boolean isAddToCurrentGroup) {
        this.isAddToCurrentGroup = isAddToCurrentGroup;
    }


    public String getGroupGroupId() {
        return groupGroupId;
    }

    public void setGroupGroupId(String groupGroupId) {
        this.groupGroupId = groupGroupId;
    }

    public String getGroupAccountId() {
        return groupAccountId;
    }

    public void setGroupAccountId(String groupAccountId) {
        this.groupAccountId = groupAccountId;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType =purchaseType;
    }

    public String getPurchaseTypeOriginal() {
        return purchaseTypeOriginal;
    }

    public void setPurchaseTypeOriginal(String purchaseTypeOriginal) {
        this.purchaseTypeOriginal =purchaseTypeOriginal;
    }

    public String getAirTimePin() {
        return airTimePin;
    }

    public void setAirTimePin(String airTimePin) {
        this.airTimePin = airTimePin;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public ResponsePlanList.PlanList.Plan getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(ResponsePlanList.PlanList.Plan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }

    public PaymentMean getGuestCreditCard() {
        return guestCreditCard;
    }

    public void setGuestCreditCard(PaymentMean guestCreditCard) {
        this.guestCreditCard = guestCreditCard;
    }

    public ResponseCreditCardList.CreditCardList.CreditCard getStoredCreditCard() {
        return storedCreditCard;
    }

    public void setStoredCreditCard(ResponseCreditCardList.CreditCardList.CreditCard storedCreditCard) {
        this.storedCreditCard = storedCreditCard;
    }

    public String getStoredCreditCardCVV() {
        return storedCreditCardCVV;
    }

    public void setStoredCreditCardCVV(String storedCreditCardCVV) {
        this.storedCreditCardCVV = storedCreditCardCVV;
    }


    public String getFlowActionType() {
        return flowActionType;
    }

    public void setFlowActionType(String flowActionType) {
        this.flowActionType = flowActionType;
    }

    public String getFlowScenarioPinRequired() {
        return flowScenarioPinRequired;
    }
    public void setFlowScenarioPinRequired(String flowScenarioPinRequired) {
        this.flowScenarioPinRequired = flowScenarioPinRequired;
    }

    public boolean getFlowScenarioAddToNewGroup() {
        return flowScenarioAddToNewGroup;
    }

    public void setFlowScenarioAddToNewGroup(boolean flowScenarioAddToNewGroup) {
        this.flowScenarioAddToNewGroup = flowScenarioAddToNewGroup;
    }


    public String getActivationSimCardSerialNumber() {
        return activationSimCardSerialNumber;
    }

    public void setActivationSimCardSerialNumber(String activationSimCardSerialNumber) {
        this.activationSimCardSerialNumber = activationSimCardSerialNumber;
    }

    public String getActivationElectronicSerialNumber() {
        return activationElectronicSerialNumber;
    }

    public void setActivationElectronicSerialNumber(String activationElectronicSerialNumber) {
        this.activationElectronicSerialNumber = activationElectronicSerialNumber;
    }


    public Device getValidatedESN() {
        return validatedESN;
    }

    public void setValidatedESN(Device validatedESN) {
        this.validatedESN = validatedESN;
    }

    public Device getValidatedFromMin() {
        return validatedFromMin;
    }

    public void setValidatedFromMin(Device validatedFromMin) {  this.validatedFromMin = validatedFromMin; }

    public String getActivationCarrier() {
        return activationCarrier;
    }

    public void setActivationCarrier(String activationCarrier) {
        this.activationCarrier = activationCarrier;
    }

    public String getActivationZipCode() {
        return activationZipCode;
    }

    public void setActivationZipCode(String activationZipCode) {
        this.activationZipCode = activationZipCode;
    }

    public String getActivationCurrentMinNumber() {
        return activationCurrentMinNumber;
    }

    public void setActivationCurrentMinNumber(String activationCurrentMinNumber) {
        this.activationCurrentMinNumber = activationCurrentMinNumber;
    }


    public static final String CURRENT_CARRIER_ATT = "AT&T";
    public static final String CURRENT_CARRIER_SPRINT = "SPRINT";

    public String getPortServiceProvider() {
        return portServiceProvider;
    }

    public void setPortServiceProvider(String portServiceProvider) {
        this.portServiceProvider = portServiceProvider;
    }

    public String getPortCarrierType() {
        return portCarrierType;
    }

    public void setPortCarrierType(String portCarrierType) {
        this.portCarrierType = portCarrierType;
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType;
    }

    public PortAccountDetails getPortPortAccountDetails() {
        return portPortAccountDetails;
    }

    public void setPortPortAccountDetails(PortAccountDetails portPortAccountDetails) {
        this.portPortAccountDetails = portPortAccountDetails;
    }

    public ParsedAddress getPortValidatedAddress() {
        return portValidatedAddress;
    }

    public void setPortValidatedAddress(ParsedAddress portValidatedAddress) {
        this.portValidatedAddress = portValidatedAddress;
    }

    public MoreAddress getPortValidateMoreAddress() {
        return portValidateMoreAddress;
    }

    public void setPortValidateMoreAddress(MoreAddress portValidateMoreAddress) {
        this.portValidateMoreAddress = portValidateMoreAddress;
    }

    public String getPortCurrentSimCardSerialNumber() {
        return portCurrentSimCardSerialNumber;
    }

    public void setPortCurrentSimCardSerialNumber(String portCurrentSimCardSerialNumber) {
        this.portCurrentSimCardSerialNumber = portCurrentSimCardSerialNumber;
    }

    public String getPortFromElectronicSerialNumber() {
        return portFromElectronicSerialNumber;
    }

    public void setPortFromElectronicSerialNumber(String portFromElectronicSerialNumber) {
        this.portFromElectronicSerialNumber = portFromElectronicSerialNumber;
    }

    public String getPortCurrentBrand() {
        return portCurrentBrand;
    }

    public void setPortCurrentBrand(String portCurrentBrand) {
        this.portCurrentBrand = portCurrentBrand;
    }

    public ActivationRequestDataHolder getLastEsnAddDataholder() { return lastEsnAddDataholder; }

    public void setLastEsnAddDataHolder(ActivationRequestDataHolder lastAddActivationReleaseDataholder) {
        this.lastEsnAddDataholder = lastAddActivationReleaseDataholder;
    }




    public ActivationRequestDataHolder() {
    }

    protected ActivationRequestDataHolder(Parcel in) {

        groupNumberOfAddsRequested = in.readInt();
        groupNumberOfAdds = in.readInt();
        groupNumberOfAvailableLines = in.readInt();
        groupNumberOfLines = in.readInt();
        isAddToCurrentGroup = in.readByte() != 0;
        groupGroupId = in.readString();
        groupAccountId = in.readString();
        purchaseType = in.readString();
        purchaseTypeOriginal = in.readString();
        airTimePin = in.readString();
        promoCode = in.readString();
        selectedPlan = in.readParcelable(ResponsePlanList.PlanList.Plan.class.getClassLoader());
        guestCreditCard = in.readParcelable(PaymentMean.class.getClassLoader());
        storedCreditCard = in.readParcelable(ResponseCreditCardList.CreditCardList.CreditCard.class.getClassLoader());
        storedCreditCardCVV = in.readString();
        flowActionType = in.readString();
        flowScenarioPinRequired = in.readString();
        flowScenarioAddToNewGroup = in.readByte() != 0;
        activationSimCardSerialNumber = in.readString();
        activationElectronicSerialNumber = in.readString();
        validatedESN = in.readParcelable(Device.class.getClassLoader());
        validatedFromMin = in.readParcelable(Device.class.getClassLoader());
        activationCurrentMinNumber = in.readString();
        activationCarrier = in.readString();
        activationZipCode = in.readString();
        portCarrierType = in.readString();
        portType = in.readString();
        portServiceProvider = in.readString();
        portPortAccountDetails = in.readParcelable(PortAccountDetails.class.getClassLoader());
        portValidatedAddress = in.readParcelable(RequestValidateAddress.ValidateAddress.class.getClassLoader());
        portValidateMoreAddress = in.readParcelable(MoreAddress.class.getClassLoader());
        portCurrentSimCardSerialNumber = in.readString();
        portFromElectronicSerialNumber = in.readString();
        portCurrentBrand = in.readString();
        deviceStatusForAccountCreation = in.readString();
        lastEsnAddDataholder = in.readParcelable(ActivationRequestDataHolder.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(groupNumberOfAddsRequested);
        dest.writeInt(groupNumberOfAdds);
        dest.writeInt(groupNumberOfAvailableLines);
        dest.writeInt(groupNumberOfLines);
        dest.writeByte((byte) (isAddToCurrentGroup ? 1 : 0));
        dest.writeString(groupGroupId);
        dest.writeString(groupAccountId);
        dest.writeString(purchaseType);
        dest.writeString(purchaseTypeOriginal);
        dest.writeString(airTimePin);
        dest.writeString(promoCode);
        dest.writeParcelable(selectedPlan, flags);
        dest.writeParcelable(guestCreditCard, flags);
        dest.writeParcelable(storedCreditCard, flags);
        dest.writeString(storedCreditCardCVV);
        dest.writeString(flowActionType);
        dest.writeString(flowScenarioPinRequired);
        dest.writeByte((byte) (flowScenarioAddToNewGroup ? 1 : 0));
        dest.writeString(activationSimCardSerialNumber);
        dest.writeString(activationElectronicSerialNumber);
        dest.writeParcelable(validatedESN, flags);
        dest.writeParcelable(validatedFromMin, flags);
        dest.writeString(activationCurrentMinNumber);
        dest.writeString(activationCarrier);
        dest.writeString(activationZipCode);
        dest.writeString(portCarrierType);
        dest.writeString(portType);
        dest.writeString(portServiceProvider);
        dest.writeParcelable(portPortAccountDetails, flags);
        dest.writeParcelable(portValidatedAddress, flags);
        dest.writeParcelable(portValidateMoreAddress,flags);
        dest.writeString(portCurrentSimCardSerialNumber);
        dest.writeString(portFromElectronicSerialNumber);
        dest.writeString(portCurrentBrand);
        dest.writeString(deviceStatusForAccountCreation);
        dest.writeParcelable(lastEsnAddDataholder, flags);
    }

    public static Creator<ActivationRequestDataHolder> CREATOR = new Creator<ActivationRequestDataHolder>() {
        @Override
        public ActivationRequestDataHolder createFromParcel(Parcel source) {
            return new ActivationRequestDataHolder(source);
        }

        @Override
        public ActivationRequestDataHolder[] newArray(int size) {
            return new ActivationRequestDataHolder[size];
        }
    };


    public void clearPurchaseType() {
        purchaseType = "";
    }

    public void clearPurchaseTypeOriginal(){
        purchaseTypeOriginal = "";
    }

    public void clearSelectedPlanInfo() {
        airTimePin = "";
        promoCode = "";
        selectedPlan = null;
    }

    public void clearSesitiveGuestCCData() {
        if (guestCreditCard != null) guestCreditCard.setCreditCard(null);
    }

    public void clearPaymentInfo() {
        storedCreditCard = null;
        storedCreditCardCVV = "";  //Sensitive Data
        clearSesitiveGuestCCData();
    }

    public void clearSensitiveAndTransactionData() {
        groupNumberOfAddsRequested = 0;
        groupNumberOfAdds = 0;
        groupNumberOfAvailableLines = 0;
        groupNumberOfLines = 0;
        groupGroupId = "";

        clearPurchaseType();
        clearPurchaseTypeOriginal();
        clearSelectedPlanInfo();
        clearPaymentInfo();
        guestCreditCard = null;
    }

    public void copyDeviceData(ActivationRequestDataHolder tempActivationReleaseDataHolder) {
        flowActionType = tempActivationReleaseDataHolder.getFlowActionType();
        flowScenarioPinRequired = tempActivationReleaseDataHolder.getFlowScenarioPinRequired();
        flowScenarioAddToNewGroup = tempActivationReleaseDataHolder.getFlowScenarioAddToNewGroup();
        activationSimCardSerialNumber = tempActivationReleaseDataHolder.getActivationSimCardSerialNumber();
        activationElectronicSerialNumber = tempActivationReleaseDataHolder.getActivationElectronicSerialNumber();
        validatedESN = tempActivationReleaseDataHolder.getValidatedESN();
        validatedFromMin = tempActivationReleaseDataHolder.getValidatedFromMin();
        activationCurrentMinNumber = tempActivationReleaseDataHolder.getActivationCurrentMinNumber();
        activationCarrier = tempActivationReleaseDataHolder.getActivationCarrier();
        activationZipCode = tempActivationReleaseDataHolder.getActivationZipCode();
        portCarrierType = tempActivationReleaseDataHolder.getPortCarrierType();
        portServiceProvider = tempActivationReleaseDataHolder.getPortServiceProvider();
        portPortAccountDetails = tempActivationReleaseDataHolder.getPortPortAccountDetails();
        portValidatedAddress = tempActivationReleaseDataHolder.getPortValidatedAddress();
        portValidateMoreAddress = tempActivationReleaseDataHolder.getPortValidateMoreAddress();
        portCurrentSimCardSerialNumber = tempActivationReleaseDataHolder.getPortCurrentSimCardSerialNumber();
        portFromElectronicSerialNumber = tempActivationReleaseDataHolder.getPortFromElectronicSerialNumber();
        portCurrentBrand = tempActivationReleaseDataHolder.getPortCurrentBrand();
    }

    public void clearDeviceData() {
        flowActionType = null;
        flowScenarioPinRequired = ResponseServiceQualification.ServiceQualificationResponse.FLOW_SCENARIO_PIN_REQUIRED;
        flowScenarioAddToNewGroup = false;
        activationSimCardSerialNumber = null;
        activationElectronicSerialNumber = null;
        validatedESN = null;
        validatedFromMin = null;
        activationCurrentMinNumber = "";
        activationCarrier = "";
        activationZipCode = "";
        portCarrierType = "";
        portServiceProvider = "";
        portPortAccountDetails = null;
        portValidatedAddress = null;
        portValidateMoreAddress=null;
        portCurrentSimCardSerialNumber = null;
        portFromElectronicSerialNumber = null;
        portCurrentBrand = null;
    }

}
