package com.example.school.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.WhereJoinTable;


@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private int studId;



    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id",referencedColumnName="user_id",insertable=false, updatable=false)
    @WhereJoinTable(clause = "ROLE = 'student' ")
    private UserDetails userDetails;

    @Column(name = "hobbies")
    private String hobbies;

    @Column(name = "standard")
    private int standard;

    @Column(name = "user_id")
    private int userId;

    public Student() {
    }

    public Student(String hobbies, int standard) {
        this.hobbies = hobbies;
        this.standard = standard;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
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

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stud_id=" + studId +
                ", userDetails=" + userDetails +
                ", hobbies='" + hobbies + '\'' +
                ", standard=" + standard +
                '}';
    }
}
