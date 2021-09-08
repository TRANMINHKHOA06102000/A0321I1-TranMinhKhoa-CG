package case_study.utils;

import case_study.models.Booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BookingComparator implements Comparator<Booking>, Serializable {
    @Override
    public int compare(Booking o1, Booking o2) {
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate1= LocalDate.parse(o1.getStartDay(),formatter);
        LocalDate startDate2= LocalDate.parse(o2.getStartDay(),formatter);
        LocalDate endDate1= LocalDate.parse(o1.getStartDay(),formatter);
        LocalDate endDate2= LocalDate.parse(o2.getStartDay(),formatter);

        if (startDate1.compareTo(startDate2)>0){
            return 1;
        }else if (startDate1.compareTo(startDate2)<0){
            return -1; // sắp xếp từ lớn đến bé
        }else {
            if (endDate1.compareTo(endDate2)>0){
                return 1;
            }else if(endDate1.compareTo(endDate2)<0){
                return -1;
            }else {
                return 0;
            }
        }
    }
   /* @Override
    public int compare(KhachHang customer1, KhachHang customer2) {
        int result = customer1.getTenKH().compareTo(customer2.getTenKH());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngaySinh1 = LocalDate.parse(customer1.getNgaysinh(), formatter);
        LocalDate ngaySinh2 = LocalDate.parse(customer2.getNgaysinh(), formatter);
        if (result > 0) {
            return 1;
        } else if (result < 0) {
            return -1;
        } else {
            if (ngaySinh1.compareTo(ngaySinh2) > 0) {
                return 1;
            } else if (ngaySinh1.compareTo(ngaySinh2) < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }*/
}
