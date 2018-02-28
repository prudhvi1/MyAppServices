package com.tracfone.generic.myaccountlibrary.restpojos.commonpojos;

import android.os.Parcel;
import android.os.Parcelable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tax implements Parcelable{


    @JsonProperty("e911Tax")
    private String e911Tax;
    @JsonProperty("rcrfTax")
    private String rcrfTax;
    @JsonProperty("usfTax")
    private String usfTax;
    @JsonProperty("salesTax")
    private String salesTax;
    @JsonProperty("totalTaxes")
    private String totalTaxes;
    @JsonProperty("totalDiscount")
    private String totalDiscount;
    @JsonProperty("totalAmountWithDiscountAndTax")
    private String totalAmountWithDiscountAndTax;


    public double getE911Tax() {
        if(e911Tax!=null){
            return Double.parseDouble(e911Tax);
        } else {
            return -1;
        }

    }
    public void setE911Tax(String e911Tax) {
        this.e911Tax = e911Tax;
    }

    public double getRcrfTax() {
        if(rcrfTax!=null){
            return Double.parseDouble(rcrfTax);
        } else {
            return -1;
        }
    }
    public void setRcrfTax(String rcrfTax) {
        this.rcrfTax = rcrfTax;
    }

    public double getUsfTax() {
        if(usfTax!=null){
            return Double.parseDouble(usfTax);
        } else {
            return -1;
        }
    }
    public void setUsfTax(String usfTax) {
        this.usfTax = usfTax;
    }

    public double getSalesTaxTaxes() {
        if(salesTax!=null){
            return Double.parseDouble(salesTax);
        } else {
            return -1;
        }
    }
    public void setSalesTaxTaxes(String totalTaxes) {
        this.salesTax = totalTaxes;
    }

    public double getTotalTax() {
        if(totalTaxes!=null) {
            return Double.parseDouble(totalTaxes);
        } else {
            return -1;
        }
    }
    public void setTotalTax(String totalDiscount) {
        this.totalTaxes = totalDiscount;
    }

    public double getTotalDiscount() {
        if(totalDiscount!=null){
            return Double.parseDouble(totalDiscount);
        } else {
            return -1;
        }
    }
    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public double getTotalAmountWithDiscountAndTax() {
        if(totalAmountWithDiscountAndTax!=null){
            return Double.parseDouble(totalAmountWithDiscountAndTax);
        } else {
            return -1;
        }
    }
    public void setTotalAmountWithDiscountAndTax(String totalAmountWithDiscountAndTax) {
        this.totalAmountWithDiscountAndTax = totalAmountWithDiscountAndTax;
    }



    protected Tax(Parcel in) {

        e911Tax = in.readString();
        rcrfTax = in.readString();
        usfTax = in.readString();
        salesTax = in.readString();
        totalTaxes = in.readString();
        totalDiscount = in.readString();
        totalAmountWithDiscountAndTax = in.readString();
    }
    
    public Tax() {}
    
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(e911Tax);
        dest.writeString(rcrfTax);
        dest.writeString(usfTax);
        dest.writeString(salesTax);
        dest.writeString(totalTaxes);
        dest.writeString(totalDiscount);
        dest.writeString(totalAmountWithDiscountAndTax);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Tax> CREATOR = new Parcelable.Creator<Tax>() {
        @Override
        public Tax createFromParcel(Parcel in) {
            return new Tax(in);
        }

        @Override
        public Tax[] newArray(int size) {
            return new Tax[size];
        }
    };

    /**
     * This method verifies all data returned from service is valid
     * @return  true if all request data is valid
     */
    public void validatePurchaseTax() throws MyAccountServiceException {
        boolean valid = true;
        if (getE911Tax() == -1) valid = false;
        if (getRcrfTax() == -1) valid = false;
        if (getUsfTax() == -1) valid = false;
        if (getSalesTaxTaxes() == -1) valid = false;
        if (getTotalTax() == -1) valid = false;
        if (getTotalDiscount() == -1) valid = false;
        if (getTotalAmountWithDiscountAndTax() == -1) valid = false;
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);


    }


}
