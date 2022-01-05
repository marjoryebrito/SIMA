package com.marjorye.sima.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(GradeId.class)
public class Grade {

    @Id
    private long student_id;

    @Id
    private long class_id;

    @Id
    private long subject_id;

    private double period1;
    private double period2;
    private double period3;
    private double recovery;

    public Grade() {
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getClass_id() {
        return class_id;
    }

    public void setClass_id(long class_id) {
        this.class_id = class_id;
    }

    public long getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(long subject_id) {
        this.subject_id = subject_id;
    }

    public double getPeriod1() {
        return period1;
    }

    public void setPeriod1(double period1) {
        this.period1 = period1;
    }

    public double getPeriod2() {
        return period2;
    }

    public void setPeriod2(double period2) {
        this.period2 = period2;
    }

    public double getPeriod3() {
        return period3;
    }

    public void setPeriod3(double period3) {
        this.period3 = period3;
    }

    public double getRecovery() {
        return recovery;
    }

    public void setRecovery(double recovery) {
        this.recovery = recovery;
    }
}

