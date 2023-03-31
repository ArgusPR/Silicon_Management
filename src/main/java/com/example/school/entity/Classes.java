package com.example.school.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.WhereJoinTable;

@Entity
@Table(name = "classes")
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private int classId;

    @NotFound(action = NotFoundAction.IGNORE)
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="teacher_id",referencedColumnName="teacher_id",insertable=false, updatable=false)
    private Teacher teacher;
    @Column(name = "class_name")
    private int className;

    @Column(name = "teacher_id")
    private int teacherId;

    public Classes() {
    }

    public Classes(int className) {
        this.className = className;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getClassName() {
        return className;
    }

    public void setClassName(int className) {
        this.className = className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "classId=" + classId +
                ", className=" + className +
                ", teacherId=" + teacherId +
                ", teacher=" + teacher +
                '}';
    }
}
