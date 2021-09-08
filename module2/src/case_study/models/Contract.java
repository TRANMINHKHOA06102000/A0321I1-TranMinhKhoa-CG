package case_study.models;

import java.io.Serializable;

public class Contract implements Serializable {
    private int numberContracts;
    private String idBooking;
    private double advanceDepositAmount;
    private double totalPaymentAmount;
    private String idCustomer;

    public Contract() {
    }

    public Contract(int numberContracts, String idBooking, double advanceDepositAmount, double totalPaymentAmount, String idCustomer) {
        this.numberContracts = numberContracts;
        this.idBooking = idBooking;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.idCustomer = idCustomer;
    }

    public int getNumberContracts() {
        return numberContracts;
    }

    public void setNumberContracts(int numberContracts) {
        this.numberContracts = numberContracts;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContracts=" + numberContracts +
                ", idBooking='" + idBooking + '\'' +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", idCustomer='" + idCustomer + '\'' +
                '}';
    }
}
