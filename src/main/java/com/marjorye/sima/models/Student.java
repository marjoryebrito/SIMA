package com.marjorye.sima.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    String name;
    int sex;
    Date birth_date;
    String cpf;
    String inep;
    String student_rg;
    String phone;
    String resp_name;
    String resp_rg;
    String resp_cpf;
    String resp_occupation;
    String nis;

    public Student(){}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInep() {
        return inep;
    }

    public void setInep(String inep) {
        this.inep = inep;
    }

    public String getStudent_rg() {
        return student_rg;
    }

    public void setStudent_rg(String student_rg) {
        this.student_rg = student_rg;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getResp_name() {
        return resp_name;
    }

    public void setResp_name(String resp_name) {
        this.resp_name = resp_name;
    }

    public String getResp_rg() {
        return resp_rg;
    }

    public void setResp_rg(String resp_rg) {
        this.resp_rg = resp_rg;
    }

    public String getResp_cpf() {
        return resp_cpf;
    }

    public void setResp_cpf(String resp_cpf) {
        this.resp_cpf = resp_cpf;
    }

    public String getResp_occupation() {
        return resp_occupation;
    }

    public void setResp_occupation(String resp_occupation) {
        this.resp_occupation = resp_occupation;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birth_date=" + birth_date +
                ", cpf='" + cpf + '\'' +
                ", inep='" + inep + '\'' +
                ", student_rg='" + student_rg + '\'' +
                ", phone='" + phone + '\'' +
                ", resp_name='" + resp_name + '\'' +
                ", resp_rg='" + resp_rg + '\'' +
                ", resp_cpf='" + resp_cpf + '\'' +
                ", resp_occupation='" + resp_occupation + '\'' +
                ", nis='" + nis + '\'' +
                '}';
    }
}
