package com.tracfone.generic.myaccountlibrary.restpojos;

/*******************************************************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department
 *
 * CLASS DESCRIPTION:
 *
 * This class ResponsePlanList defines the POJO for plan list details response for the restful service.
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved.
 * *****************************************************************************************************************/

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponsePlanList {

	public static class PlanList implements Parcelable {

		public static class Plan implements Parcelable {

			public static class EnrollmentPromotion implements Parcelable {
				@JsonProperty("promoUnits")
				private String planPromoUnits;
				@JsonProperty("promoPrice")
				private double planPromoPrice;
				@JsonProperty("promoMessage")
				private String planPromoMessage;

				public void setPlanPromoUnits(String planPromoUnits) { this.planPromoUnits = planPromoUnits; }
				public String getPlanPromoUnits() { return planPromoUnits; }

				public void setPlanPromoPrice(double planPromoPrice) { this.planPromoPrice = planPromoPrice; }
				public String getPlanPromoPrice() {
					String planPromoPriceString = "";
					if(planPromoPrice==(long)planPromoPrice)
						planPromoPriceString=String.format("%d", (long)planPromoPrice);
					else
						planPromoPriceString=String.format("%.2f", planPromoPrice);
					return planPromoPriceString; }
				public double getPlanPromoPriceDouble() { return planPromoPrice; }

				public void setPlanPromoMessage(String planPromoMessage) { this.planPromoMessage = planPromoMessage; }
				public String getPlanPromoMessage() { return planPromoMessage; }

				public EnrollmentPromotion() { }
				protected EnrollmentPromotion(Parcel in) {
					planPromoUnits = in.readString();
					planPromoPrice = in.readDouble();
					planPromoMessage = in.readString();
				}
				public static final Creator<EnrollmentPromotion> CREATOR = new Creator<EnrollmentPromotion>() {
					@Override
					public EnrollmentPromotion createFromParcel(Parcel in) {
						return new EnrollmentPromotion(in);
					}
					@Override
					public EnrollmentPromotion[] newArray(int size) {
						return new EnrollmentPromotion[size];
					}
				};
				@Override
				public int describeContents() {
					return 0;
				}
				@Override
				public void writeToParcel(Parcel parcel, int i) {
					parcel.writeString(planPromoUnits);
					parcel.writeDouble(planPromoPrice);
					parcel.writeString(planPromoMessage);
				}
			}

			@JsonProperty("servicePlanId")
			private String planId;
			@JsonProperty("servicePlanGroup")
			private String planGroup;
			@JsonProperty("servicePlanName")
			private String planName;
			@JsonProperty("servicePlanDescription")
			private String planDescription;
			@JsonProperty("servicePlanDescription2")
			private String planDescription2;
			@JsonProperty("servicePlanDescription3")
			private String planDescription3;
			@JsonProperty("servicePlanDescription4")
			private String planDescription4;
			@JsonProperty("servicePlanType")
			private String planType;
			@JsonProperty("voiceUnits")
			private String planVoiceUnits;
			@JsonProperty("smsUnits")
			private String planSmsUnits;
			@JsonProperty("dataUnits")
			private String planDataUnits;
			@JsonProperty("serviceDays")
			private String planServiceDays;
			@JsonProperty("price")
			private double planPrice;
			@JsonProperty("recurringPlan")
			private String planRecurring;
			@JsonProperty("partNumber")
			private String planPartNumber;
			@JsonProperty("programId")
			private String planProgramId;
			@JsonProperty("voiceConversionFactor")
			private int planVoiceConversionFactor;
			@JsonProperty("isILDVas")
			private boolean ildVasFlag;
			@JsonProperty("ildSupported")
			private boolean ildSupportedFlag;
			@JsonProperty("ildRatesLink")
			private String ildRatesLink;
			@JsonProperty("isLrpRedeemable")
			private boolean isLrpRedeemable;
			@JsonProperty("lrpPoints")
			private int lrpPoints;
			@JsonProperty("enrollmentPromotion")
			private EnrollmentPromotion promo;
			@JsonProperty("isGroupPlan")
			private boolean isGroupPlan;
			@JsonProperty("numberOfLines")
			private int numberOfLines = 0;
			@JsonProperty("recurringPlanId")
			private int recurringPlanId;
			@JsonProperty("partClassNumber")
			private String partClassNumber;

			public void setPlanId(String planId) { this.planId = planId;}
			public String getPlanId() { return planId; }

			public static final String PLAN_GROUP_ADD_ON_ILD = "ADD_ON_ILD";
			public static final String PLAN_GROUP_ADD_ON_DATA = "ADD_ON_DATA";
			public static final String PLAN_GROUP_SMS_ONLY = "SMS_ONLY";
			public void setPlanGroup(String planGroup) { this.planGroup = planGroup;}
			public String getPlanGroup() { return planGroup; }

			public void setPlanName(String planName) { this.planName = planName; }
			public String getPlanName() { return planName; }

			public void setPlanDescription(String planDescription) { this.planDescription = planDescription; }
			public String getPlanDescription() { return planDescription; }

			public void setPlanDescription2(String planDescription2) { this.planDescription2 = planDescription2; }
			public String getPlanDescription2() {
				if (planDescription2 == null) planDescription2 = "";
				return planDescription2; }

			public void setPlanDescription3(String planDescription3) { this.planDescription3 = planDescription3; }
			public String getPlanDescription3() {
				if (planDescription3 == null) planDescription3 = "";
				return planDescription3; }

			public void setPlanDescription4(String planDescription4) { this.planDescription4 = planDescription4; }
			public String getPlanDescription4() {
				if (planDescription4 == null) planDescription4 = "";
				return planDescription4; }

			public void setPlanVoiceUnits(String planVoiceUnits) { this.planVoiceUnits = planVoiceUnits; }
			public String getPlanVoiceUnits() { return planVoiceUnits; }

			public void setPlanSmsUnits(String planSmsUnits) { this.planSmsUnits = planSmsUnits; }
			public String getPlanSmsUnits() { return planSmsUnits; }

			public void setPlanDataUnits(String planDataUnits) { this.planDataUnits = planDataUnits; }
			public String getPlanDataUnits() { return planDataUnits; }

			public void setPlanServiceDays(String planServiceDays) { this.planServiceDays = planServiceDays; }
			public String getPlanServiceDays() { return planServiceDays; }

			public void setPlanPrice(double planPrice) { this.planPrice = planPrice; }
			public String getPlanPrice() {
				String planPriceString = "";
				if(planPrice==(long)planPrice)
					planPriceString=String.format("%d", (long)planPrice);
				else {
					//round off to two decimal places
					planPrice = (double) Math.round(planPrice * 100) / 100;
					//display only two decimal places
					planPriceString = String.format("%.2f", planPrice);
				}
				return planPriceString; }
			public double getPlanPriceDouble() { return planPrice; }

			public String getPromoSavings() {
				double savings = 0;
				if (getEnrollmentPromotion() != null) {
					//round off to two decimal places
					savings = getPlanPriceDouble() -  getEnrollmentPromotion().getPlanPromoPriceDouble();
					savings = (double) Math.round(savings * 100) / 100;
				}
				return  String.format("%.2f", savings); //display only two decimal places
			}

			public void setPlanRecurring(String planRecurring) { this.planRecurring = planRecurring; }
			public boolean getPlanRecurring() {
				if (planRecurring != null)  {
					return (planRecurring.equals("true"))?true:false;
				} else {
					return false;
				}
			}
			public String getPlanRecurringCheck() { return planRecurring; }

			public void setPlanPartNumber(String planPartNumber) { this.planPartNumber = planPartNumber; }
			public String getPlanPartNumber() { return planPartNumber; }

			public String getPlanType() { return planType; }
			public void setPlanType(String planType) { this.planType = planType; }

			public String getPlanProgramId() { return planProgramId; }
			public void setPlanProgramId(String planProgramId) { this.planProgramId = planProgramId;}

			public void setPlanVoiceConversionFactor(int planVoiceConversionFactor) {	this.planVoiceConversionFactor = planVoiceConversionFactor;	}
			public int getPlanVoiceConversionFactor()
            {	if (planVoiceConversionFactor != -1) {
                return planVoiceConversionFactor;}
            else
                return -1;	}

			public boolean isIldVasFlag() {	return ildVasFlag;	}
			public void setIldVasFlag(boolean ildVasFlag) {	this.ildVasFlag = ildVasFlag; }

			public boolean isIldSupportedFlag() { return ildSupportedFlag; }
			public void setIldSupportedFlag(boolean ildSupportedFlag) {	this.ildSupportedFlag = ildSupportedFlag; }

			public String getIldRatesLink() { return ildRatesLink; }
			public void setIldRatesLink(String ildRatesLink) { this.ildRatesLink = ildRatesLink; }

			public boolean getIsLrpRedeemable() {
				return isLrpRedeemable;
			}

			public void setIsLrpRedeemable(boolean isLrpRedeemable) {
				this.isLrpRedeemable = isLrpRedeemable;
			}

			public int getLrpPoints() {
				return lrpPoints;
			}

			public void setLrpPoints(int lrpPoints) {
				this.lrpPoints = lrpPoints;
			}

			public boolean isGroupPlan() {
				return isGroupPlan;
			}

			public void setGroupPlan(boolean groupPlan) {
				isGroupPlan = groupPlan;
			}

			public EnrollmentPromotion getEnrollmentPromotion() {return promo;}
			public void setEnrollmentPromotion(EnrollmentPromotion promo) {this.promo = promo;}

			public int getNumberOfLines() {
				return numberOfLines;
			}

			public void setNumberOfLines(int numberOfLines) {
				this.numberOfLines = numberOfLines;
			}

			public int getRecurringPlanId() {
				return recurringPlanId;
			}

			public void setRecurringPlanId(int recurringPlanId) {
				this.recurringPlanId = recurringPlanId;
			}

			public String getPlanPartClassNumber() {
				return partClassNumber;
			}

			public void setPlanPartClassNumber(String partClassNumber) {
				this.partClassNumber = partClassNumber;
			}


			public void setPlanDefault() {
				this.planId = "0";
				this.planGroup = "";
				this.planName = "";
				this.planDescription = "";
				this.planDescription2 = "";
				this.planDescription3 = "";
				this.planDescription4 = "";
				this.planType = "";
				this.planVoiceUnits = "0";
				this.planSmsUnits = "0";
				this.planDataUnits = "0";
				this.planServiceDays = "0";
				this.planPrice = 0;
				this.planRecurring = "false";
				this.planPartNumber = "0";
				this.planProgramId = "";
				this.planVoiceConversionFactor = 0;
			}

			public Plan() { }
			protected Plan(Parcel in) {
				planId = in.readString();
				planGroup = in.readString();
				planName = in.readString();
				planDescription = in.readString();
				planDescription2 = in.readString();
				planDescription3 = in.readString();
				planDescription4 = in.readString();
				planType = in.readString();
				planVoiceUnits = in.readString();
				planSmsUnits = in.readString();
				planDataUnits = in.readString();
				planServiceDays = in.readString();
				planPrice = in.readDouble();
				planRecurring = in.readString();
				planPartNumber = in.readString();
				planProgramId = in.readString();
				planVoiceConversionFactor = in.readInt();
				ildVasFlag = in.readByte() != 0;
				ildSupportedFlag = in.readByte() != 0;
				ildRatesLink = in.readString();
				isGroupPlan = in.readByte() != 0;
				isLrpRedeemable = in.readByte() != 0;
				lrpPoints = in.readInt();
				promo= in.readParcelable(Plan.class.getClassLoader());
				numberOfLines = in.readInt();
				recurringPlanId = in.readInt();
				partClassNumber = in.readString();
			}
			public static final Creator<Plan> CREATOR = new Creator<Plan>() {
				@Override
				public Plan createFromParcel(Parcel in) {
					return new Plan(in);
				}
				@Override
				public Plan[] newArray(int size) {
					return new Plan[size];
				}
			};
			@Override
			public int describeContents() {
				return 0;
			}
			@Override
			public void writeToParcel(Parcel parcel, int i) {
				parcel.writeString(planId);
				parcel.writeString(planGroup);
				parcel.writeString(planName);
				parcel.writeString(planDescription);
				parcel.writeString(planDescription2);
				parcel.writeString(planDescription3);
				parcel.writeString(planDescription4);
				parcel.writeString(planType);
				parcel.writeString(planVoiceUnits);
				parcel.writeString(planSmsUnits);
				parcel.writeString(planDataUnits);
				parcel.writeString(planServiceDays);
				parcel.writeDouble(planPrice);
				parcel.writeString(planRecurring);
				parcel.writeString(planPartNumber);
				parcel.writeString(planProgramId);
				parcel.writeInt(planVoiceConversionFactor);
				parcel.writeByte((byte) (ildVasFlag ? 1 : 0));
				parcel.writeByte((byte) (ildSupportedFlag ? 1 : 0));
				parcel.writeString(ildRatesLink);
				parcel.writeByte((byte)(isGroupPlan ? 1:0));
				parcel.writeByte((byte)(isLrpRedeemable ? 1:0));
				parcel.writeInt(lrpPoints);
				parcel.writeParcelable(promo,i);
				parcel.writeInt(numberOfLines);
				parcel.writeInt(recurringPlanId);
				parcel.writeString(partClassNumber);
			}

			/**
			 * This method verifies all data returned from service is valid
			 *
			 * @return true if all request data is valid
			 */
			public void validateVasPlanList() throws MyAccountServiceException {
				boolean valid = true;

					if (Integer.valueOf(getPlanId()) == -1) valid = false;
					if (Integer.valueOf(getPlanPrice()) == null) valid = false;
					if (getPlanPartNumber() == null) valid = false;
					if (getPlanType() == null) valid = false;
					if (getPlanName() == null) valid = false;
					if (getIldRatesLink() == null) valid = false;
					if (getPlanDescription() == null) valid = false;
					if (getPlanDescription2() == null) valid = false;
					if (getPlanDescription3() == null) valid = false;
					if (getPlanDescription4() == null) valid = false;

				if(!valid)
					throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
			}
		}

		@JsonProperty("servicePlans")
		private List<Plan> plan = new ArrayList<Plan>();

		public List<Plan> getPlan() { return plan; }
		public void setPlan(List<Plan> p) { plan = p; }

		public PlanList() { }
		protected PlanList(Parcel in) {
			in.readTypedList(plan,Plan.CREATOR);
		}

		public static final Creator<PlanList> CREATOR = new Creator<PlanList>() {
			@Override
			public PlanList createFromParcel(Parcel in) {
				return new PlanList(in);
			}
			@Override
			public PlanList[] newArray(int size) {
				return new PlanList[size];
			}
		};

		@Override
		public int describeContents() {
			return 0;
		}
		@Override
		public void writeToParcel(Parcel parcel, int i) {
			parcel.writeTypedList(plan);
		}
	}

	@JsonProperty("status")
	private ResponseStatus status;
	@JsonProperty("response")
	private PlanList planList;

	public ResponseStatus getCommon() { return status; }
	public void setCommon(ResponseStatus s) { status = s; }

	public PlanList getResponse() { return planList; }
	public void setResponse(PlanList p) { planList = p; }

	/**
	 * This method verifies all data returned from service is valid
	 *
	 * @return  true if all request data is valid
	 */
	public void validatePlanList() throws MyAccountServiceException{
		boolean valid = true;
		String invalidField="";
		for (int i = 0; i < planList.getPlan().size(); i++) {
			if (planList.getPlan().get(i).getPlanId() == null) {
				valid = false;
				invalidField ="plan: "+i+"planid: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanGroup() == null) {
				valid = false;
				invalidField ="plan: "+i+"plangroup: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanName() == null) {
				valid = false;
				invalidField ="plan: "+i+"planname: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanDescription() == null) {
				valid = false;
				invalidField ="plan: "+i+"plandesc: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanDescription2() == null) {
				valid = false;
				invalidField ="plan: "+i+"plandesc2: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanDescription3() == null) {valid = false;
				invalidField ="plan: "+i+"plandesc3: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanDescription4() == null) {
				valid = false;
				invalidField ="plan: "+i+"plandesc4: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanType() == null) {
				valid = false;
				invalidField ="plan: "+i+"plantype: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanVoiceUnits() == null) {
				valid = false;
				invalidField ="plan: "+i+"planvoiceunits: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanSmsUnits() == null) {
				valid = false;
				invalidField ="plan: "+i+"plansmsunits: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanDataUnits() == null) {
				valid = false;
				invalidField ="plan: "+i+"plandataunits: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanServiceDays() == null) {
				valid = false;
				invalidField ="plan: "+i+"planservicedays: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanRecurringCheck() == null) {
				valid = false;
				invalidField ="plan: "+i+"planrecurringcheck: null";
				break;
			}
			if (planList.getPlan().get(i).getPlanVoiceConversionFactor() == -1) {
				valid = false;
				invalidField ="plan: "+i+"planvoiceconvfactor: -1";
				break;
			}
			if(planList.getPlan().get(i).getEnrollmentPromotion()!=null) {
				if (planList.getPlan().get(i).getEnrollmentPromotion().getPlanPromoMessage() == null) {
					valid = false;
					invalidField ="plan: "+i+"planpromomsg: null";
					break;
				}
				if (planList.getPlan().get(i).getEnrollmentPromotion().getPlanPromoPrice() == null) {
					valid = false;
					invalidField ="plan: "+i+"planpromoprice: null";
					break;
				}
				if (planList.getPlan().get(i).getEnrollmentPromotion().getPlanPromoUnits() == null) {
					valid = false;
					invalidField ="plan: "+i+"planpromounits: null";
					break;
				}
			}
			// remove comment below when value added to service
			//			if (planList.getPlan().get(i).getPlanProgramId() == null) valid = false;
			//Added Tflogger to track specific plan that fails validation

		}
		if(!valid) {
			MyAccountServiceException e = new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
			String Enresult = invalidField;
			throw new MyAccountServiceException(Enresult,e);
		}
	}
} 