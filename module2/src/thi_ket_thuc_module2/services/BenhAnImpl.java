package thi_ket_thuc_module2.services;

import thi_ket_thuc_module2.models.BenhAn;
import thi_ket_thuc_module2.models.BenhNhanThuong;
import thi_ket_thuc_module2.models.BenhNhanVip;
import thi_ket_thuc_module2.utils.ReadAndWriter;
import thi_ket_thuc_module2.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BenhAnImpl implements BenhAnServices {
    private static final String REGEX_NGAY = "^([0-2][0-9]|3[0-1])\\/(0[0-9]|1[0-2])\\/([0-9][0-9])?[0-9][0-9]$";
    private static final String REGEX_MABENHAN = "(BA)[-][\\d]{3}";
    private static final String REGEX_MABENHNHAN = "(BN)[-][\\d]{3}";
    private static final String REGEX_LOAIVIP = "(VIP I)|(VIP II)|(VIP III)";

    private static List<BenhAn> benhAnList;
    static Scanner scanner = new Scanner(System.in);
    String pathFile = "D:\\A0321I1-TranMinhKhoa\\module2\\src\\thi_ket_thuc_module2\\data\\medical_records.csv";

    static {
        benhAnList = new ArrayList<>();
    }

    @Override
    public void delete() throws NotFoundMedicalRecordException {
        System.out.println("Bạn có muốn xóa bệnh án ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }
        switch (choose) {
            case 1: {
                System.out.println("Nhập Mã Bệnh án cần xóa: ");
                String id = scanner.nextLine();
                BenhAn benhAn = searchById(id);
                if (benhAn != null) {
                    benhAnList.remove(benhAn);
                    System.out.println("Xóa " + benhAn + " thành công");
                    ReadAndWriter.write(benhAnList, pathFile);
                } else {
                    throw new NotFoundMedicalRecordException("Bệnh án không tồn tại");
                }
                break;
            }
            case 2: {
                System.out.println("Bạn đã hủy thao tác xóa");
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Thất bại! Vui lòng chọn lại! Nhập để tiếp tục.");
            }
        }

    }

    @Override
    public void display() {
        benhAnList = (List<BenhAn>) ReadAndWriter.read(pathFile);
        System.out.println("--Danh sách các bệnh án--\n");
        for (BenhAn benhAn : benhAnList) {
            System.out.println(benhAn);
        }
    }

    @Override
    public void addThuong() {
        System.out.println("nhập số thứ tự: ");
        String soThuTu = scanner.nextLine();
        System.out.println("nhập mã bệnh án: ");
        String maBenhAn = CheckMaBenhAn();
        System.out.println("nhập mã bệnh nhân: ");
        String maBenhNhan = CheckMaBenhNhan();
        System.out.println("nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("nhập ngày nhập viện: ");
        String ngayNhapVien = CheckNgay();
        System.out.println("nhập ngày ra viện: ");
        String ngayRaVien = CheckNgay();
        System.out.println("nhập lý do nhập viện: ");
        String liDo = scanner.nextLine();
        System.out.println("nhập phí nhập viện: ");
        String phi = scanner.nextLine();

        BenhNhanThuong benhNhanThuong = new BenhNhanThuong(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDo, phi);
        benhAnList.add(benhNhanThuong);
        System.out.println("Thêm mới " + benhNhanThuong + " thành công");
        ReadAndWriter.write(benhAnList, pathFile);

    }

    private String CheckMaBenhAn() {
        return RegexData.regexString(scanner.nextLine(), REGEX_MABENHAN, "Nhập sai định dạng, mời bạn nhập lại: ");
    }

    private String CheckMaBenhNhan() {
        return RegexData.regexString(scanner.nextLine(), REGEX_MABENHNHAN, "Nhập sai định dạng, mời bạn nhập lại:");
    }

    private String CheckNgay() {
        return RegexData.regexString(scanner.nextLine(), REGEX_NGAY, "Nhập sai định dạng, mời bạn nhập lại:");
    }

    private String CheckLoaiVip() {
        return RegexData.regexString(scanner.nextLine(), REGEX_LOAIVIP, "Nhập sai định dạng, mời bạn nhập lại:");
    }

    @Override
    public void addVip() {
        System.out.println("nhâp số thứ tự: ");
        String soThuTu = scanner.nextLine();
        System.out.println("nhập mã bệnh án: ");
        String maBenhAn = CheckMaBenhAn();
        System.out.println("nhập mã bệnh nhân: ");
        String maBenhNhan = CheckMaBenhNhan();
        System.out.println("nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.println("nhập ngày nhập viện: ");
        String ngayNhapVien = CheckNgay();
        System.out.println("nhập ngày ra viện: ");
        String ngayRaVien = CheckNgay();
        System.out.println("nhập lý do nhập viện: ");
        String liDo = scanner.nextLine();
        System.out.println("nhập loại Vip: ");
        String loaiVip = CheckLoaiVip();
        System.out.println("nhập thời hạn Vip: ");
        String thoiHan = CheckNgay();

        BenhNhanVip benhNhanVip = new BenhNhanVip(soThuTu, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, liDo, loaiVip, thoiHan);
        benhAnList.add(benhNhanVip);
        System.out.println("Thêm mới " + benhNhanVip + " thành công");
        ReadAndWriter.write(benhAnList, pathFile);
    }

    public BenhAn searchById(String ma) {
        for (BenhAn benhAn : benhAnList) {
            if (benhAn.getMaBenhAn().equals(ma)) {
                return benhAn;
            }
        }
        return null;
    }
}
