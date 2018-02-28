package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by psamdrala on 11/8/2016.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class PaymentMean implements Parcelable{

    @JsonProperty("id")
    private String id;
    @JsonProperty("isDefault")
    private String isDefault;
    @JsonProperty("savePaymentInfo")
    private boolean savePaymentInfo;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("type")
    private String paymentType;
    @JsonProperty("category")
    private String category;
    @JsonProperty("accountHolderName")
    private AccountHolderName accountHolderName;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("loyaltyAccount")
    private LoyaltyAccount loyaltyAccount;
    @JsonProperty("creditCard")
    private CreditCard creditCard;
    @JsonProperty("billingAddress")
    private BillingAddress billingAddress;

    public PaymentMean(){}
    protected PaymentMean(Parcel in) {
        id = in.readString();
        isDefault = in.readString();
        savePaymentInfo  = in.readByte() != 0;
        nickname = in.readString();
        paymentType = in.readString();
        category = in.readString();
        firstName = in.readString();
        lastName = in.readString();
        accountHolderName = in.readParcelable(AccountHolderName.class.getClassLoader());
        loyaltyAccount = in.readParcelable(LoyaltyAccount.class.getClassLoader());
        creditCard = in.readParcelable(CreditCard.class.getClassLoader());
        billingAddress = in.readParcelable(BillingAddress.class.getClassLoader());
    }

    public static final Creator<PaymentMean> CREATOR = new Creator<PaymentMean>() {
        @Override
        public PaymentMean createFromParcel(Parcel in) {
            return new PaymentMean(in);
        }

        @Override
        public PaymentMean[] newArray(int size) {
            return new PaymentMean[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public boolean getSavePaymentInfo() {
        return savePaymentInfo;
    }

    public void setSavePaymentInfo(boolean savePaymentInfo) {
        this.savePaymentInfo = savePaymentInfo;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public static final String TYPE_CREDIT_CARD = "CREDITCARD";
    public static final String TYPE_BANK_ACCOUNT = "BANKACCOUNT";
    public static final String TYPE_LOYALTYPOINTS = "LOYALTYPOINTS";
    public static final String TYPE_ALTERNATE = "ALTERNATE";
    public static final String CATEGORY_LOYALTY_PTS = "LOYALTY_PTS";

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AccountHolderName getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(AccountHolderName accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public LoyaltyAccount getLoyaltyAccount() {
        return loyaltyAccount;
    }

    public void setLoyaltyAccount(LoyaltyAccount loyaltyAccount) {
        this.loyaltyAccount = loyaltyAccount;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(isDefault);
        dest.writeByte((byte) (savePaymentInfo ? 1 : 0));
        dest.writeString(nickname);
        dest.writeString(paymentType);
        dest.writeString(category);
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeParcelable(accountHolderName, flags);
        dest.writeParcelable(loyaltyAccount, flags);
        dest.writeParcelable(creditCard, flags);
        dest.writeParcelable(billingAddress, flags);
    }
}
