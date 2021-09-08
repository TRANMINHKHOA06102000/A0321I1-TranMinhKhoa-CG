package thi_ket_thuc_module2.models;

public class BenhNhanThuong extends BenhAn {
    private String phiNamVien;

    public BenhNhanThuong() {

    }

    public BenhNhanThuong(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    public BenhNhanThuong(String soThuTu, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String liDo, String phiNamVien) {
        super(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDo);
        this.phiNamVien = phiNamVien;
    }

    public String getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(String phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public String toString() {
        return "BenhNhanThuong{" +
                "phiNamVien='" + phiNamVien + '\'' +
                '}' + super.toString();
    }
}
