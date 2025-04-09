package com.yunusemrecakmak.webOdev_5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ogrenci {
    @EmbeddedId
    private PrimaryKey primaryKey;
    private String name;
    private String surname;
    private int age;
    @OneToOne(
            orphanRemoval = true,
            cascade = CascadeType.ALL
    )
    private OgrenciParents ogrenciParents = new OgrenciParents();

    public Ogrenci() {
    }

    public Ogrenci(PrimaryKey primaryKey, String name, String surname, int age, OgrenciParents ogrenciParents) {
        this.primaryKey = primaryKey;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.ogrenciParents = ogrenciParents;
    }

    public PrimaryKey getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(PrimaryKey primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public OgrenciParents getOgrenciParents() {
        return ogrenciParents;
    }

    public void setOgrenciParents(OgrenciParents ogrenciParents) {
        this.ogrenciParents = ogrenciParents;
    }
}
