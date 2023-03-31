package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="user_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "role")
    private String role;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "phone")
    private String phone;
    @Column(name = "gender")
    private String gender;
    @Column(name = "currAddress")
    private String currentAddress;
    @Column(name = "permAddress")
    private String permanentAddress;

    public UserDetails() {
    }

    public UserDetails(String role, String fullName, LocalDate dob, String phone, String gender, String currentAddress, String permanentAddress) {
        this.role = role;
        this.fullName = fullName;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.currentAddress = currentAddress;
        this.permanentAddress = permanentAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCurrentAddress() {
        return currentAddress;
    }

    public void setCurrentAddress(String currentAddress) {
        this.currentAddress = currentAddress;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "user_id=" + userId +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dob=" + dob +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", currentAddress='" + currentAddress + '\'' +
                ", permanentAddress='" + permanentAddress + '\'' +
                '}';
    }
}
