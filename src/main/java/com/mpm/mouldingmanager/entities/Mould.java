package com.mpm.mouldingmanager.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "moldes")
public class Mould {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
    private String client;
    private String name;
    private Integer num;
    private Integer pistonSize;

    public Mould() {
    }

    public Mould(Long id, String client, String name, Integer num, Integer pistonSize) {
        this.id = id;
        this.client = client;
        this.name = name;
        this.num = num;
        this.pistonSize = pistonSize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPistonSize() {
        return pistonSize;
    }

    public void setPistonSize(Integer pistonSize) {
        this.pistonSize = pistonSize;
    }

    @Override
    public String toString() {
        return "Mould{" +
                "id=" + id +
                ", client='" + client + '\'' +
                ", name='" + name + '\'' +
                ", num=" + num +
                ", pistonSize=" + pistonSize +
                '}';
    }
}
