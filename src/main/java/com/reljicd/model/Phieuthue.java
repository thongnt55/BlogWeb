package com.reljicd.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "phieuthue")
public class Phieuthue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phieuthue_id")
    private Long id;


    @Column(name = "ten")
    @NotNull
    private String ten;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;

    @ManyToOne
    @JoinColumn(name = "chusan_id", referencedColumnName = "chusan_id", nullable = false)
    @NotNull
    private Chusan chusan;

    @ManyToOne
    @JoinColumn(name = "khachhang_id", referencedColumnName = "khachhang_id", nullable = false)
    @NotNull
    private Khachhang khachhang;

    @ManyToOne
    @JoinColumn(name = "khunggio_id", referencedColumnName = "khunggio_id", nullable = false)
    @NotNull
    private Khunggio khunggio;

    @Column(name = "giamoibuoi")
    @NotNull
    private float giamoibuoi;

    @Column(name = "sobuoidat")
    @NotNull
    private int sobuoidat;

    @Column(name = "tongsotien")
    @NotNull
    private float tongsotien;

    @Column(name = "tiencoc")
    @NotNull
    private float tiencoc;

    @Column(name = "ngaybatdau")
    @NotNull
    private String ngaybatdau;

    @Column(name = "ngayketthuc")
    @NotNull
    private String ngayketthuc;

    @Column(name = "ngaythanhtoancoc")
    @NotNull
    private String ngaythanhtoancoc;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chusan getChusan() {
        return chusan;
    }

    public void setChusan(Chusan chusan) {
        this.chusan = chusan;
    }

    public Khachhang getKhachhang() {
        return khachhang;
    }

    public void setKhachhang(Khachhang khachhang) {
        this.khachhang = khachhang;
    }

    public Khunggio getKhunggio() {
        return khunggio;
    }

    public void setKhunggio(Khunggio khunggio) {
        this.khunggio = khunggio;
    }

    public float getGiamoibuoi() {
        return giamoibuoi;
    }

    public void setGiamoibuoi(float giamoibuoi) {
        this.giamoibuoi = giamoibuoi;
    }

    public int getSobuoidat() {
        return sobuoidat;
    }

    public void setSobuoidat(int sobuoidat) {
        this.sobuoidat = sobuoidat;
    }

    public float getTongsotien() {
        return tongsotien;
    }

    public void setTongsotien(float tongsotien) {
        this.tongsotien = tongsotien;
    }

    public float getTiencoc() {
        return tiencoc;
    }

    public void setTiencoc(float tiencoc) {
        this.tiencoc = tiencoc;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getNgaythanhtoancoc() {
        return ngaythanhtoancoc;
    }

    public void setNgaythanhtoancoc(String ngaythanhtoancoc) {
        this.ngaythanhtoancoc = ngaythanhtoancoc;
    }
}