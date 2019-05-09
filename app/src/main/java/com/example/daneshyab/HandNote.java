package com.example.daneshyab;

public class HandNote {

    private String name, teacher_name, university;
    private int drawable;

    public HandNote(String name, String teacher_name, String university, int drawable) {
        this.name = name;
        this.teacher_name = teacher_name;
        this.university = university;
        this.drawable = drawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}
