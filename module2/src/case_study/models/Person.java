package case_study.models;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String id;
    private String name;
    private String dateOfBirth;
    private String gender;
    private int numberCMND;
    private int phone;
    private String email;

    public Person() {
    }

    public Person(String id, String name, String dateOfBirth, String gender, int numberCMND, int phone, String email) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.numberCMND = numberCMND;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumberCMND() {
        return numberCMND;
    }

    public void setNumberCMND(int numberCMND) {
        this.numberCMND = numberCMND;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", numberCMND=" + numberCMND +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
