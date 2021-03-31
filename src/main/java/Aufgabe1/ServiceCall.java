package Aufgabe1;

public class ServiceCall {
    private String customerName;
    private String customerID;
    private String serviceCallCode;
    private String dateOfCall;

    public String getCustomerID() { return customerID; }

    public String getServiceCallCode() { return serviceCallCode; }

    public String getDateOfCall() { return dateOfCall; }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public void setCustomerID(String customerID) { this.customerID = customerID; }

    public void setServiceCallCode(String serviceCallCode) { this.serviceCallCode = serviceCallCode; }

    public void setDateOfCall(String dateOfCall) { this.dateOfCall = dateOfCall; }

}
