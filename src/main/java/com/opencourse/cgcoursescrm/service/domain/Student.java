package com.opencourse.cgcoursescrm.service.domain;

public class Student {

    private String studentId;
    private String firstName;
    private String secondName;
    private String leadStatus;
    private String email;
    private String createdAt;
    private String description;
    private String addedBy;
    private boolean alreadyStudied;
    private String city;
    private String street;
    private String houseNumber;
    private String addAddress;
    private int zipCode;
    private String messenger;
    private String messengerNickname;

    public Student(){

    }

    public Student(String studentId, String firstName, String secondName, String leadStatus, String email, String createdAt, String description, String addedBy, boolean alreadyStudied, String city, String street, String houseNumber, String addAdress, int zipCode, String messenger, String messengerNickname) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.leadStatus = leadStatus;
        this.email = email;
        this.createdAt = createdAt;
        this.description = description;
        this.addedBy = addedBy;
        this.alreadyStudied = alreadyStudied;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.addAddress = addAdress;
        this.zipCode = zipCode;
        this.messenger = messenger;
        this.messengerNickname = messengerNickname;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public boolean getAlreadyStudied() {
        return alreadyStudied;
    }

    public void setAlreadyStudied(boolean alreadyStudied) {
        this.alreadyStudied = alreadyStudied;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getAddAdress() {
        return addAddress;
    }

    public void setAddAdress(String addAdress) {
        this.addAddress = addAdress;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getMessenger() {
        return messenger;
    }

    public void setMessenger(String messenger) {
        this.messenger = messenger;
    }

    public String getMessengerNickname() {
        return messengerNickname;
    }

    public void setMessengerNickname(String messengerNickname) {
        this.messengerNickname = messengerNickname;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", leadStatus='" + leadStatus + '\'' +
                ", email='" + email + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", description='" + description + '\'' +
                ", addedBy='" + addedBy + '\'' +
                ", alreadyStudied='" + alreadyStudied + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", addAddress='" + addAddress + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", messenger='" + messenger + '\'' +
                ", messengerNickname='" + messengerNickname + '\'' +
                '}';
    }
}
