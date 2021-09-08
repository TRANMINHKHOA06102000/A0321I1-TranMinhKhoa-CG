package case_study.models;

import java.io.Serializable;

public class Booking implements Serializable {
    private int idBooking;
    private String startDay;
    private String endDay;
    private String idCustomer;
    private String nameService;
    private String typeService;

    public Booking() {
    }

    public Booking(int idBooking, String startDay, String endDay, String idCustomer, String nameService, String typeService) {
        this.idBooking = idBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.idCustomer = idCustomer;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    /*public Date getStartDayToDate() {
        int day = Integer.parseInt(this.startDay.substring(0, 2));
        int month = Integer.parseInt(this.startDay.substring(3, 5));
        int year = Integer.parseInt(this.startDay.substring(6, 10));
        Date date = new Date(day, month, year);
        return date;
    }

    public Date getEndDayToDate() {
        int day = Integer.parseInt(this.endDay.substring(0, 2));
        int month = Integer.parseInt(this.endDay.substring(3, 5));
        int year = Integer.parseInt(this.endDay.substring(6, 10));
        Date date = new Date(day, month, year);
        return date;
    }*/

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", startDay='" + startDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }
}
