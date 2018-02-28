package com.tracfone.generic.myaccountlibrary.restpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.PaymentMean;
import com.tracfone.generic.myaccountlibrary.restpojos.commonpojos.VasPlans;
import java.util.ArrayList;

/**
 * Created by gmateti on 4/13/2017.
 */

public class RedemptionRequestDataHolder implements Parcelable {

    private String airTimeCardSerialNumber;
    private String customerAccountPin;
    private String promoCode;
    private boolean isMultiLineAccount;
    private String billingAccountId;
    private boolean groupPlanOnly = false;
    private boolean individualPlansOnly = false;
    private boolean isRedeemNow = true;
    private boolean isEnrollNow = false;
    private ResponsePlanList.PlanList.Plan selectedPlan;
    private ArrayList<ResponsePlanList.PlanList.Plan> selectedVasPlansList;
    private ArrayList<VasPlans> selectedVasPlansListRequest;
    private PaymentMean guestCreditCard;
    private ResponseCreditCardList.CreditCardList.CreditCard storedCreditCard;
    private String storedCreditCardCVV = "";
    private String purchaseType = "";
    private String purchaseTypeOriginal = "";
    private ArrayList<RedemptionRequestOrderItem> orderItems;
    private ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan currentEnrollmentPlan;
    private ResponseReservePinCardList.ReservePinCardList.ReservePinCard reservePinCard;
    private LoyaltyRewardsInfo loyaltyRewardsInfo;
    private boolean isloyaltyRewardsEnrolled = false;
    private boolean isRewardPointsPayment = false;
    private int rewardPointsSpent = 0;
    private boolean isEnrollInAutoRefillAction = false;

    public ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan getCurrentEnrollmentPlan() {
        return currentEnrollmentPlan;
    }

    public void setCurrentEnrollmentPlan(ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan currentEnrollmentPlan) {
        this.currentEnrollmentPlan = currentEnrollmentPlan;
    }

    public ResponseReservePinCardList.ReservePinCardList.ReservePinCard getReservePinCard() {
        return reservePinCard;
    }

    public void setReservePinCard(ResponseReservePinCardList.ReservePinCardList.ReservePinCard reservePinCard) {
        this.reservePinCard = reservePinCard;
    }

    public LoyaltyRewardsInfo getLoyaltyRewardsInfo(){
        return loyaltyRewardsInfo;
    }

    public void setLoyaltyRewardsInfo(LoyaltyRewardsInfo loyaltyRewardsInfo){
        this.loyaltyRewardsInfo = loyaltyRewardsInfo;
    }

    public RedemptionRequestDataHolder() {
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public String getPurchaseTypeOriginal() {
        return purchaseTypeOriginal;
    }

    public void setPurchaseTypeOriginal(String purchaseTypeOriginal) {
        this.purchaseTypeOriginal = purchaseTypeOriginal;
    }

    public String getStoredCreditCardCVV() {
        return storedCreditCardCVV;
    }

    public void setStoredCreditCardCVV(String storedCreditCardCVV) {
        this.storedCreditCardCVV = storedCreditCardCVV;
    }

    public ResponseCreditCardList.CreditCardList.CreditCard getStoredCreditCard() {
        return storedCreditCard;
    }

    public void setStoredCreditCard(ResponseCreditCardList.CreditCardList.CreditCard storedCreditCard) {
        this.storedCreditCard = storedCreditCard;
    }

    public PaymentMean getGuestCreditCard() {
        return guestCreditCard;
    }

    public void setGuestCreditCard(PaymentMean guestCreditCard) {
        this.guestCreditCard = guestCreditCard;
    }

    public ResponsePlanList.PlanList.Plan getSelectedPlan() {
        return selectedPlan;
    }

    public void setSelectedPlan(ResponsePlanList.PlanList.Plan selectedPlan) {
        this.selectedPlan = selectedPlan;
    }

    public ArrayList<ResponsePlanList.PlanList.Plan> getSelectedVasPlansList() {
        return selectedVasPlansList;
    }

    public void setSelectedVasPlansList(ArrayList<ResponsePlanList.PlanList.Plan> selectedVasPlansList) {
        this.selectedVasPlansList = selectedVasPlansList;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public String getAirTimeCardSerialNumber() {
        return airTimeCardSerialNumber;
    }

    public void setAirTimeCardSerialNumber(String airTimeCardSerialNumber) {
        this.airTimeCardSerialNumber = airTimeCardSerialNumber;
    }

    public String getCustomerAccountPin() {
        return customerAccountPin;
    }

    public void setCustomerAccountPin(String customerAccountPin) {
        this.customerAccountPin = customerAccountPin;
    }

    public boolean isMultiLineAccount() {
        return isMultiLineAccount;
    }

    public void setIsMultiLineAccount(boolean isMultiLineAccount) {
        this.isMultiLineAccount = isMultiLineAccount;
    }

    public String getBillingAccountId() {
        return billingAccountId;
    }

    public void setBillingAccountId(String billingAccountId) {
        this.billingAccountId = billingAccountId;
    }

    public boolean isGroupPlanOnly() {
        return groupPlanOnly;
    }

    public void setGroupPlanOnly(boolean groupPlanOnly) {
        this.groupPlanOnly = groupPlanOnly;
    }

    public boolean isIndividualPlansOnly() {
        return individualPlansOnly;
    }

    public void setIndividualPlansOnly(boolean individualPlansOnly) { this.individualPlansOnly = individualPlansOnly; }

    public boolean isRedeemNow() {
        return isRedeemNow;
    }

    public void setIsRedeemNow(boolean isRedeemNow) {
        this.isRedeemNow = isRedeemNow;
    }

    public boolean isEnrollNow() {
        return isEnrollNow;
    }

    public void setIsEnrollNow(boolean isEnrollNow) {
        this.isEnrollNow = isEnrollNow;
    }

    public boolean isLoyaltyRewardsEnrolled(){
        return isloyaltyRewardsEnrolled;
    }

    public void setIsloyaltyRewardsEnrolled(boolean isloyaltyRewardsEnrolled){
        this.isloyaltyRewardsEnrolled = isloyaltyRewardsEnrolled;
    }

    public boolean getIsRewardPointsPayment(){
        return isRewardPointsPayment;
    }

    public void setIsRewardPointsPayment(boolean isRewardPointsPayment){
        this.isRewardPointsPayment = isRewardPointsPayment;
    }

    public int getRewardPointsSpent(){
        return rewardPointsSpent;
    }

    public void setRewardPointsSpent(int rewardPointsSpent){
        this.rewardPointsSpent = rewardPointsSpent;
    }

    public ArrayList<RedemptionRequestOrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<RedemptionRequestOrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public boolean isEnrollInAutoRefillAction() {
        return isEnrollInAutoRefillAction;
    }

    public void setIsEnrollInAutoRefillAction(boolean enrollInAutoRefillAction) {
        isEnrollInAutoRefillAction = enrollInAutoRefillAction;
    }

    protected RedemptionRequestDataHolder(Parcel in) {
        airTimeCardSerialNumber = in.readString();
        customerAccountPin = in.readString();
        promoCode = in.readString();
        isMultiLineAccount = in.readByte() != 0;
        billingAccountId = in.readString();
        groupPlanOnly = in.readByte() != 0;
        individualPlansOnly = in.readByte() != 0;
        isRedeemNow = in.readByte() != 0;
        isEnrollNow = in.readByte() != 0;
        selectedPlan = in.readParcelable(ResponsePlanList.PlanList.Plan.class.getClassLoader());
        selectedVasPlansList = in.createTypedArrayList(ResponsePlanList.PlanList.Plan.CREATOR);
        selectedVasPlansListRequest = in.createTypedArrayList(VasPlans.CREATOR);
        guestCreditCard = in.readParcelable(PaymentMean.class.getClassLoader());
        storedCreditCard = in.readParcelable(ResponseCreditCardList.CreditCardList.CreditCard.class.getClassLoader());
        storedCreditCardCVV = in.readString();
        purchaseType = in.readString();
        purchaseTypeOriginal = in.readString();
        orderItems = in.createTypedArrayList(RedemptionRequestOrderItem.CREATOR);
        currentEnrollmentPlan = in.readParcelable(ResponseCurrentEnrollmentPlan.CurrentEnrollmentPlan.class.getClassLoader());
        reservePinCard = in.readParcelable(ResponseReservePinCardList.ReservePinCardList.ReservePinCard.class.getClassLoader());
        loyaltyRewardsInfo = in.readParcelable(LoyaltyRewardsInfo.class.getClassLoader());
        isloyaltyRewardsEnrolled = in.readByte() != 0;
        isRewardPointsPayment = in.readByte() != 0;
        rewardPointsSpent = in.readInt();
        isEnrollInAutoRefillAction = in.readByte() !=0;


    }

    public static final Creator<RedemptionRequestDataHolder> CREATOR = new Creator<RedemptionRequestDataHolder>() {
        @Override
        public RedemptionRequestDataHolder createFromParcel(Parcel in) {
            return new RedemptionRequestDataHolder(in);
        }

        @Override
        public RedemptionRequestDataHolder[] newArray(int size) {
            return new RedemptionRequestDataHolder[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(airTimeCardSerialNumber);
        parcel.writeString(customerAccountPin);
        parcel.writeString(promoCode);
        parcel.writeByte((byte) (isMultiLineAccount ? 1 : 0));
        parcel.writeString(billingAccountId);
        parcel.writeByte((byte) (groupPlanOnly ? 1 : 0));
        parcel.writeByte((byte) (individualPlansOnly ? 1 : 0));
        parcel.writeByte((byte) (isRedeemNow ? 1 : 0));
        parcel.writeByte((byte) (isEnrollNow ? 1 : 0));
        parcel.writeParcelable(selectedPlan, i);
        parcel.writeTypedList(selectedVasPlansList);
        parcel.writeTypedList(selectedVasPlansListRequest);
        parcel.writeParcelable(guestCreditCard, i);
        parcel.writeParcelable(storedCreditCard, i);
        parcel.writeString(storedCreditCardCVV);
        parcel.writeString(purchaseType);
        parcel.writeString(purchaseTypeOriginal);
        parcel.writeTypedList(orderItems);
        parcel.writeParcelable(currentEnrollmentPlan, i);
        parcel.writeParcelable(reservePinCard, i);
        parcel.writeParcelable(loyaltyRewardsInfo, i);
        parcel.writeByte((byte) (isloyaltyRewardsEnrolled ? 1 : 0));
        parcel.writeByte((byte) (isRewardPointsPayment ? 1 : 0));
        parcel.writeInt(rewardPointsSpent);
        parcel.writeByte((byte) (isEnrollInAutoRefillAction ? 1 : 0));
    }

    public void clearPurchaseType() {
        purchaseType = "";
    }

    public void clearSelectedPlanInfo() {
        promoCode = "";
        selectedPlan = null;
        airTimeCardSerialNumber = null;
        isRedeemNow = true;
    }

    public void clearSesitiveGuestCCData() {
        if (guestCreditCard != null) guestCreditCard.setCreditCard(null);
    }

    public void clearPaymentInfo() {
        storedCreditCard = null;
        storedCreditCardCVV = "";  //Sensitive Data
        clearSesitiveGuestCCData();
    }

}
