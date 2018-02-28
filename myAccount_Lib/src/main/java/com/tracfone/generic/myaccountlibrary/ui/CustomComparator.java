package com.tracfone.generic.myaccountlibrary.ui;

import com.tracfone.generic.myaccountlibrary.restpojos.ResponseTransactionPaymentHistory;
import com.tracfone.generic.myaccountlibrary.restpojos.ResponseTransactionPaymentHistory.TransactionPaymentHistory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Locale;

/**
 * Created by mgokhanilhan on 7/30/2015.
 */
public class CustomComparator implements Comparator<TransactionPaymentHistory.Transaction> {
    private String sequence;

    CustomComparator(String sequence){
        this.sequence = sequence;
    }

    @Override
    public int compare(TransactionPaymentHistory.Transaction o1, TransactionPaymentHistory.Transaction o2) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm a", Locale.US);
        //sort by date in increasing
        if(sequence.equals("DATE-INC")) {
            try {
                return sdf.parse(o1.gettTransactionDate()).compareTo(sdf.parse(o2.gettTransactionDate()));
            } catch (ParseException e) {
            }
        }
        //sort by date in decreasing
        else if(sequence.equals("DATE-DEC")) {
            try {
                return  sdf.parse(o2.gettTransactionDate()).compareTo(sdf.parse(o1.gettTransactionDate()));
            } catch (ParseException e) {
            }
        }
        //sort by type in increasing
        else if(sequence.equals("TYPE-INC"))
            return o1.getpPaymentSource().getpPaymentSourceType().compareTo(o2.getpPaymentSource().getpPaymentSourceType());
            //sort by type in decreasing
        else if(sequence.equals("TYPE-DEC"))
            return o2.getpPaymentSource().getpPaymentSourceType().compareTo(o1.getpPaymentSource().getpPaymentSourceType());
            //sort by status in increasing
        else if(sequence.equals("STATUS-INC"))
            return o1.gettTransactionStatus().compareTo(o2.gettTransactionStatus());
        //sort by status in decreasing
        return o2.gettTransactionStatus().compareTo(o1.gettTransactionStatus());
    }
}
