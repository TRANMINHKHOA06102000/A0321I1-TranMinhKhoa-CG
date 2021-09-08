package thi_ket_thuc_module2.controller;

import thi_ket_thuc_module2.services.NotFoundMedicalRecordException;

public class MainTest {
    public static void main(String[] args) throws NotFoundMedicalRecordException {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }
}
