package com.reljicd.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "chusan")
public class Chusan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chusan_id")
    private Long id;


    @Column(name = "ten")
    @NotEmpty(message = "*Please provide your name")
    private String ten;

    @Column(name = "diachi")
    @NotEmpty(message = "*Please provide your name")
    private String diachi;

    @OneToMany(mappedBy = "chusan")
    private Collection<Phieuthue> phieuthues;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public Collection<Phieuthue> getPhieuthues() {
        return phieuthues;
    }

    public void setPhieuthues(Collection<Phieuthue> phieuthues) {
        this.phieuthues = phieuthues;
    }
}