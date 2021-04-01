package Aufgabe1;
/*
To String einfügen
 */
public class ServiceCall {
    private String customerName;
    private String customerID;
    private String serviceCallCode;
    private String dateOfCall;

    public String getcustomerID() { return customerID; }

    public String getSsrviceCallCode() { return serviceCallCode; }

    public String getdateOfCall() { return dateOfCall; }

    public String getcustomerName() { return customerName; }

    public void setcustomerName(String customerName) { this.customerName = customerName; }

    public void setcustomerID(String customerID) { this.customerID = customerID; }

    public void setserviceCallCode(String serviceCallCode) { this.serviceCallCode = serviceCallCode; }

    public void setdateOfCall(String dateOfCall) { this.dateOfCall = dateOfCall; }

    @Override
    public String toString() {
        return "ServiceCall{" +
                "customerName='" + customerName + '\'' +
                ", customerID='" + customerID + '\'' +
                ", serviceCallCode='" + serviceCallCode + '\'' +
                ", dateOfCall='" + dateOfCall + '\'' +
                '}';
    }
}
