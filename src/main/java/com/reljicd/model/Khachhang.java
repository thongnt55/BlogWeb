package com.reljicd.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "khachhang")
public class Khachhang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khachhang_id")
    private Long id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "diachi")
    private String diachi;

    @OneToMany(mappedBy = "khachhang")
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