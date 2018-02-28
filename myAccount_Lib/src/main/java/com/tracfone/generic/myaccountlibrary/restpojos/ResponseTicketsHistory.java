package com.tracfone.generic.myaccountlibrary.restpojos;

/***************************************************************************
 * TracFone Wireless, Inc.
 * Engineering Department  
 *
 * CLASS DESCRIPTION:  
 *
 * This class defines the POJO for the response to a restful request to 
 * view the Ticket History.
 *
 *
 * TracFone Engineering Confidential Proprietary
 * Copyright (c) 2014,  All Rights Reserved
 *
 *
 * ****************************************************************************/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tracfone.generic.myaccountlibrary.MyAccountServiceException;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseTicketsHistory {

    @SuppressWarnings("serial")
    public static class TicketsHistory{

        public static class Ticket {

            @JsonProperty("Id")
            private String Id;
            @JsonProperty("status")
            private String status;
            @JsonProperty("type")
            private String type;
            @JsonProperty("creationDatetime")
            private String creationDatetime;

            public static class TrackingInformation{
                @JsonProperty("trackingID")
                private String trackingId;
                @JsonProperty("trackingURL")
                private String trackingURL;

                public String getTrackingId() {
                    return trackingId;
                }

                public void setTrackingId(String trackingId) {
                    this.trackingId = trackingId;
                }

                public String getTrackingURL() {
                    return trackingURL;
                }

                public void setTrackingURL(String trackingURL) {
                    this.trackingURL = trackingURL;
                }
            }

            @JsonProperty("trackingInformation")
            private TrackingInformation trackingInformation;


            public TrackingInformation getTrackingInformation() {
                return trackingInformation;
            }

            public void setTrackingInformation(TrackingInformation trackingInformation) {
                this.trackingInformation = trackingInformation;
            }

            @JsonProperty("description")
            private String description;
            @JsonProperty("title")
            private String title;
            @JsonProperty("deviceNickname")
            private String deviceNickname;

            public String getId() {
                return Id;
            }

            public void setId(String id) {
                Id = id;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCreationDatetime() {
                return creationDatetime;
            }

            public void setCreationDatetime(String creationDatetime) {
                this.creationDatetime = creationDatetime;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDeviceNickname() {
                return deviceNickname;
            }

            public void setDeviceNickname(String deviceNickname) {
                this.deviceNickname = deviceNickname;
            }
        }

        @JsonProperty("tickets")
        private List<Ticket> ticket = new ArrayList<>();

        public List<Ticket> getTicket() {
            return ticket; }
        public void setTicket(List<Ticket> t) { ticket = t;  }

        // method to sort ticket list
        public void sortedTicket(String sequence)
        {
            Collections.sort(ticket, new CustomComparator(sequence));
        }

    }

    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("response")
    private TicketsHistory ticketsHistory;

    public ResponseStatus getCommon() { return status; }
    public void setCommon(ResponseStatus s) { status = s; }

    public TicketsHistory getResponse() { return ticketsHistory; }
    public void setResponse(TicketsHistory th) { ticketsHistory = th; }

    /**
     * This method verifies all data returned from service is valid
     *
     * @return  true if all request data is valid
     */
    public void  validateTicketsHistory() throws MyAccountServiceException{
        boolean valid = true;
        int size = ticketsHistory.getTicket().size();
        for (int i = 0; i < ticketsHistory.getTicket().size(); i++) {
            if (ticketsHistory.getTicket().get(i).getId() == null) valid = false;
            if (ticketsHistory.getTicket().get(i).getStatus() == null) valid = false;
            if (ticketsHistory.getTicket().get(i).getType() == null) valid = false;
            if (ticketsHistory.getTicket().get(i).getCreationDatetime()==null) valid = false;
            if(ticketsHistory.getTicket().get(i).getTrackingInformation()!=null) {
                if (ticketsHistory.getTicket().get(i).getTrackingInformation().getTrackingId() == null)
                    valid = false;
                if (ticketsHistory.getTicket().get(i).getTrackingInformation().getTrackingURL() == null)
                    valid = false;
            }
            if (ticketsHistory.getTicket().get(i).getDescription()==null) valid = false;
            if (ticketsHistory.getTicket().get(i).getTitle() == null) valid = false;
            if (ticketsHistory.getTicket().get(i).getDeviceNickname() == null) valid = false;
        }
        if(!valid)
            throw new MyAccountServiceException(MyAccountServiceException.EXCEPTION_SERVER_RESPONSE_FAILED_VALIDATION);
    }

    /**
     * Custom comparator to sort the ticket ArrayList
     */
    public static class CustomComparator implements Comparator<TicketsHistory.Ticket> {

        private String sequence;

        CustomComparator(String sequence){
            this.sequence = sequence;
        }

        @Override
        public int compare(TicketsHistory.Ticket o1, TicketsHistory.Ticket o2) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
            //sort by date in increasing
            if(sequence.equals("DATE-INC")) {
                try {
                    return sdf.parse(o1.getCreationDatetime()).compareTo(sdf.parse(o2.getCreationDatetime()));
                } catch (ParseException e) {
                }
            }
            //sort by date in decreasing
            else if(sequence.equals("DATE-DEC")) {
                try {
                    return  sdf.parse(o2.getCreationDatetime()).compareTo(sdf.parse(o1.getCreationDatetime()));
                } catch (ParseException e) {
                }
            }
            //sort by type in increasing
            else if(sequence.equals("TYPE-INC"))
                return o1.getType().compareTo(o2.getType());
            //sort by type in decreasing
            else if(sequence.equals("TYPE-DEC"))
                return o2.getType().compareTo(o1.getType());
            //sort by status in increasing
            else if(sequence.equals("STATUS-INC"))
                return o1.getStatus().compareTo(o2.getStatus());
            //sort by status in decreasing
            return o2.getStatus().compareTo(o1.getStatus());
        }
    }

} 
