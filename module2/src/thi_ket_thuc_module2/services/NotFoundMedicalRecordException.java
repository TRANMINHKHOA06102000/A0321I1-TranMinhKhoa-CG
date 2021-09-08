package thi_ket_thuc_module2.services;

public class NotFoundMedicalRecordException extends Exception {
    public NotFoundMedicalRecordException(String massage) {
        super(massage);
    }
}
