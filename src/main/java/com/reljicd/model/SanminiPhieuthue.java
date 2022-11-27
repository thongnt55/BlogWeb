package com.reljicd.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "sanminiphieuthue")
public class SanminiPhieuthue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sanminiphieuthue_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phieuthue_id", referencedColumnName = "phieuthue_id", nullable = false)
    @NotNull
    private Phieuthue phieuthue;

    @ManyToOne
    @JoinColumn(name = "sanmini_id", referencedColumnName = "sanmini_id", nullable = false)
    @NotNull
    private Sanmini sanmini;
}
