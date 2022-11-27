package com.reljicd.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sanmini")
public class Sanmini {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanmini_id")
    private Long id;


    @Column(name = "name")
    @NotEmpty(message = "*Please provide your name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "loaisan_id", referencedColumnName = "loaisan_id", nullable = false)
    @NotNull
    private Loaisan loaisan;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Loaisan getLoaisan() {
        return loaisan;
    }

    public void setLoaisan(Loaisan loaisan) {
        this.loaisan = loaisan;
    }
}