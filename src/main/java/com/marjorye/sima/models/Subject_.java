package com.marjorye.sima.models;


public class Subject_ {
    long id;
    String subject_name;


    public Subject_() {
    }

    public Subject_(long id, String subject_name) {
        this.id = id;
        this.subject_name = subject_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(String subject_name) {
        this.subject_name = subject_name;
    }

}

