package com.reljicd.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "loaisan")
public class Loaisan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaisan_id")
    private Long id;


    @Column(name = "type")
    @NotNull
    private String type;

    @OneToMany(mappedBy = "loaisan")
    private Collection<Sanmini> sanminis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<Sanmini> getSanminis() {
        return sanminis;
    }

    public void setSanminis(Collection<Sanmini> sanminis) {
        this.sanminis = sanminis;
    }
}