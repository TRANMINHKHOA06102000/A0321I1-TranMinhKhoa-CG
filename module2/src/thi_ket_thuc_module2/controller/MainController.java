package thi_ket_thuc_module2.controller;

import thi_ket_thuc_module2.services.BenhAnImpl;
import thi_ket_thuc_module2.services.NotFoundMedicalRecordException;

import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    BenhAnImpl benhAn = new BenhAnImpl();

    public void displayMainMenu() throws NotFoundMedicalRecordException {
        System.out.println("---------- CHƯƠNG TRÌNH QUẢN LÝ BỆNH ÁN----------");
        System.out.println("1. Thêm mới");
        System.out.println("2. Xóa");
        System.out.println("3. Xem danh sách các bệnh án ");
        System.out.println("4. Thoát");
        System.out.println("------------------------------");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                themMoi();
                break;
            }
            case 2: {
                benhAn.delete();
                displayMainMenu();
                break;
            }
            case 3: {
                benhAn.display();
                displayMainMenu();
                break;
            }
            case 4: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Thất bại! Vui lòng chọn lại! Nhập để tiếp tục.");
                displayMainMenu();
            }
        }
    }

    private void themMoi() {
        System.out.println("1. Thêm mới bệnh nhân thường");
        System.out.println("2. Thêm mới bệnh nhân vip");
        System.out.println("3. Thoát");
        System.out.println("------------------------------");
        System.out.print("Nhập lựa chọn của bạn: ");
        int choose = 0;
        try {
            choose = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.err.println(ex.getMessage());
        }

        switch (choose) {
            case 1: {
                benhAn.addThuong();
                try {
                    displayMainMenu();
                } catch (NotFoundMedicalRecordException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 2: {
                benhAn.addVip();
                try {
                    displayMainMenu();
                } catch (NotFoundMedicalRecordException e) {
                    e.printStackTrace();
                }
                break;
            }
            case 3: {
                System.exit(0);
                break;
            }
            default: {
                System.out.println("Thất bại! Vui lòng chọn lại! Nhập để tiếp tục.");
                themMoi();
            }
        }
    }
}
