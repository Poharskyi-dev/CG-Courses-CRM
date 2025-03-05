package com.opencourse.cgcoursescrm.repository.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "students")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "student_id")
    private UUID studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "second_name")
    private String secondName;
    @Column(name = "lead_status")
    private String leadStatus;
    @Column(name = "email")
    private String email;
    @Column(name = "created_at")
    private String createdAt;
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "added_by")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userEntityId;
    @Column(name = "already_studied")
    private boolean alreadyStudied;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "add_address")
    private String addAddress;
    @Column(name = "zip_code")
    private int zipCode;
    @Column(name = "messenger")
    private String messenger;
    @Column(name = "messenger_nickname")
    private String messengerNickname;

    public UUID getStudentId() {
        return studentId;
    }

    public void setStudentId(UUID studentId) {
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


    public boolean isAlreadyStudied() {
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

    public String getAddAddress() {
        return addAddress;
    }

    public void setAddAddress(String addAddress) {
        this.addAddress = addAddress;
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
}
