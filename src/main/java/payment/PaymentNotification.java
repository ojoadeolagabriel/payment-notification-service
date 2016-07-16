package payment;

import org.joda.time.DateTime;

/**
 * Created by Adeola.Ojo on 7/16/2016.
 */
public class PaymentNotification {

    private long paymentLogId;
    private long billerId;
    private long paymentItemId;
    private long paymentMethodId;
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
    private String receiptNumber;
    private DateTime paymentDate;
    private DateTime settlementDate;
    private boolean allowServiceNotification;
    private boolean allowBankCode;
    private boolean isDoublePosting;

    public long getPaymentLogId() {
        return paymentLogId;
    }

    public void setPaymentLogId(long paymentLogId) {
        this.paymentLogId = paymentLogId;
    }

    public long getBillerId() {
        return billerId;
    }

    public void setBillerId(long billerId) {
        this.billerId = billerId;
    }

    public long getPaymentItemId() {
        return paymentItemId;
    }

    public void setPaymentItemId(long paymentItemId) {
        this.paymentItemId = paymentItemId;
    }

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(long institutionId) {
        this.institutionId = institutionId;
    }

    public double getInitialTotalAmount() {
        return initialTotalAmount;
    }

    public void setInitialTotalAmount(double initialTotalAmount) {
        this.initialTotalAmount = initialTotalAmount;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getCardPan() {
        return cardPan;
    }

    public void setCardPan(String cardPan) {
        this.cardPan = cardPan;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getMerchantPaymentReference() {
        return merchantPaymentReference;
    }

    public void setMerchantPaymentReference(String merchantPaymentReference) {
        this.merchantPaymentReference = merchantPaymentReference;
    }

    public String getFtpUrl() {
        return ftpUrl;
    }

    public void setFtpUrl(String ftpUrl) {
        this.ftpUrl = ftpUrl;
    }

    public String getFtpUrlUsername() {
        return ftpUrlUsername;
    }

    public void setFtpUrlUsername(String ftpUrlUsername) {
        this.ftpUrlUsername = ftpUrlUsername;
    }

    public String getFtpUrlPassword() {
        return ftpUrlPassword;
    }

    public void setFtpUrlPassword(String ftpUrlPassword) {
        this.ftpUrlPassword = ftpUrlPassword;
    }

    public String getCollectionsAccountNumber() {
        return collectionsAccountNumber;
    }

    public void setCollectionsAccountNumber(String collectionsAccountNumber) {
        this.collectionsAccountNumber = collectionsAccountNumber;
    }

    public String getChannelDescription() {
        return channelDescription;
    }

    public void setChannelDescription(String channelDescription) {
        this.channelDescription = channelDescription;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIsoFee() {
        return isoFee;
    }

    public void setIsoFee(String isoFee) {
        this.isoFee = isoFee;
    }

    public String getIsoFeePercent() {
        return isoFeePercent;
    }

    public void setIsoFeePercent(String isoFeePercent) {
        this.isoFeePercent = isoFeePercent;
    }

    public String getPaymentCurrencyCode() {
        return paymentCurrencyCode;
    }

    public void setPaymentCurrencyCode(String paymentCurrencyCode) {
        this.paymentCurrencyCode = paymentCurrencyCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public DateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(DateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public DateTime getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(DateTime settlementDate) {
        this.settlementDate = settlementDate;
    }

    public boolean isAllowServiceNotification() {
        return allowServiceNotification;
    }

    public void setAllowServiceNotification(boolean allowServiceNotification) {
        this.allowServiceNotification = allowServiceNotification;
    }

    public boolean isAllowBankCode() {
        return allowBankCode;
    }

    public void setAllowBankCode(boolean allowBankCode) {
        this.allowBankCode = allowBankCode;
    }

    public boolean isDoublePosting() {
        return isDoublePosting;
    }

    public void setDoublePosting(boolean doublePosting) {
        isDoublePosting = doublePosting;
    }
}
