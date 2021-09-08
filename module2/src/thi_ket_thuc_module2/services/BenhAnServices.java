package thi_ket_thuc_module2.services;

public interface BenhAnServices {
    void delete() throws NotFoundMedicalRecordException;

    void display();

    void addThuong();

    void addVip();
}
