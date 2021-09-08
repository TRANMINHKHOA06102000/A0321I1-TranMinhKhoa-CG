package thi_ket_thuc_module2.utils;

import thi_ket_thuc_module2.models.BenhAn;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class BenhAnComparator implements Comparator<BenhAn>, Serializable {
    @Override
    public int compare(BenhAn o1, BenhAn o2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ngayNhapVien = LocalDate.parse(o1.getNgayNhapVien(), formatter);
        LocalDate ngayRaVien = LocalDate.parse(o2.getNgayRaVien(), formatter);
        if (ngayNhapVien.compareTo(ngayRaVien) > 0) {
            return 1;
        } else if (ngayNhapVien.compareTo(ngayRaVien) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
