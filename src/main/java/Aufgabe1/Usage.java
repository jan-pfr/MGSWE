package Aufgabe1;
/*
To String einfügen
 */
public class Usage {
    private String customerID;
    private String customerName;
    private String dateOfCall;

    public String getcustomerID() { return customerID; }

    public String getcustomerName() { return customerName; }

    public String getdateOfCall() { return dateOfCall; }

    public void setcustomerID(String customerID) { this.customerID = customerID; }

    public void setcustomerName(String customerName) { this.customerName = customerName; }

    public void setdateOfCall(String dateOfCall) { this.dateOfCall = dateOfCall; }

    @Override
    public String toString() {
        return "Usage{" +
                "customerID='" + customerID + '\'' +
                ", customerName='" + customerName.trim() + '\'' +
                ", dateOfCall='" + dateOfCall + '\'' +
                '}';
    }
}
