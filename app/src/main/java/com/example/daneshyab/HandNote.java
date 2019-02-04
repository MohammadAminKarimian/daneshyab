package com.example.daneshyab;

public class HandNote {
    private int id;
    private int imageID ;
    private String name, author, field, university, date, price;

    HandNote(int id, int imageID, String name, String author, String field, String university, String date, String price) {
        this.id = id;
        this.imageID = imageID;
        this.name = name;
        this.author = author;
        this.field = field;
        this.university = university;
        this.date = date;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
