package dataProvider;

import java.time.LocalDate;

public class Person {
    private String gender;
    public String getGender() {
        return gender;
    }

    private boolean isForeignResidentInRomania;
    public boolean isForeignResidentInRomania() {
        return isForeignResidentInRomania;
    }
    private boolean isNonResident;
    public boolean isNonResident() {
        return isNonResident;
    }

    private LocalDate dateOfBirth;

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    private int areaCode;
    public int getAreaCode() {
        if (areaCode > 52 && areaCode < 1) {
            return 52;
        } else {return areaCode;}
    }
    private String orderNumber;
    public String getOrderNumber() {
        return orderNumber;
    }
    public Person(String gender,LocalDate dateOfBirth, boolean isForeignResidentInRomania, boolean isNonResident,int areaCode, String orderNumber) {
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.isForeignResidentInRomania = isForeignResidentInRomania;
        this.isNonResident = isNonResident;
        this.areaCode = areaCode;
        this.orderNumber = orderNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", isForeignResidentInRomania=" + isForeignResidentInRomania +
                ", isNonResident=" + isNonResident +
                ", dateOfBirth=" + dateOfBirth +
                ", areaCode=" + areaCode +
                ", orderNumber='" + orderNumber + '\'' +
                '}';
    }
}
