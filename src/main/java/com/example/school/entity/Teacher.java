package com.example.school.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacherId;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName="user_id",insertable=false, updatable=false)
    @WhereJoinTable(clause = "ROLE = 'teacher' ")
    private UserDetails userDetails;

    @Column(name = "qualification")
    private String Qualification;

    @Column(name = "sub_taught")
    private String subTaught;

    @Column(name = "class_taught")
    private String classTaught;

    @Column(name = "user_id")
    private int userId;

//    @Column(name = "class_id")
//    private int classId;

    public Teacher() {
    }

    public Teacher(String qualification, String subTaught, String classTaught) {
        this.Qualification = qualification;
        this.subTaught = subTaught;
        this.classTaught = classTaught;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public int getClassId() {
//        return classId;
//    }
//
//    public void setClassId(int classId) {
//        this.classId = classId;
//    }

    public String getQualification() {
        return Qualification;
    }

    public void setQualification(String qualification) {
        Qualification = qualification;
    }

    public String getSubTaught() {
        return subTaught;
    }

    public void setSubTaught(String subTaught) {
        this.subTaught = subTaught;
    }

    public String getClassTaught() {
        return classTaught;
    }

    public void setClassTaught(String classTaught) {
        this.classTaught = classTaught;
    }

//    @Override
//    public String toString() {
//        return "Teacher{" +
//                "teacherId=" + teacherId +
//                ", userDetails=" + userDetails +
//                ", Qualification='" + Qualification + '\'' +
//                ", subTaught='" + subTaught + '\'' +
//                ", classTaught='" + classTaught + '\'' +
//                '}';
//    }


    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", userDetails=" + userDetails +
                ", Qualification='" + Qualification + '\'' +
                ", subTaught='" + subTaught + '\'' +
                ", classTaught='" + classTaught + '\'' +
                ", userId=" + userId +
//                ", classId=" + classId +
                '}';
    }
}
