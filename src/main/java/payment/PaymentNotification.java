package payment;

import org.joda.time.DateTime;

/**
 * Created by Adeola.Ojo on 7/16/2016.
 */
public class PaymentNotification {

    private long paymentLogId;
    private long billerId;
    private long paymentItemId;
    private long institutionId;
    private double initialTotalAmount;
    private String additionalInformation;
    private String cardPan;
    private String paymentReference;
    private String merchantPaymentReference;
    private String ftpUrl;
    private String ftpUrlUsername;
    private String ftpUrlPassword;
    private String collectionsAccountNumber;
    private String channelDescription;
    private String customerNumber;
    private String customerName;
    private String isoFee;
    private String isoFeePercent;
    private String paymentCurrencyCode;
    private String location;
    private DateTime paymentDate;
    private boolean allowServiceNotification;
    private boolean allowBankCode;
    private boolean isDoublePosting;

}
