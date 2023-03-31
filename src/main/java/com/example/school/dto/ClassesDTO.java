package com.example.school.dto;

public class ClassesDTO {

    private int classId;
    private int className;
    private int teacherId;

    private String Qualification;

    private String subTaught;

    private String classTaught;

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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

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
}
