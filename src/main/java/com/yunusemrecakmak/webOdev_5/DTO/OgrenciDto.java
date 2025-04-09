package com.yunusemrecakmak.webOdev_5.DTO;

import com.yunusemrecakmak.webOdev_5.Entity.OgrenciParents;
import com.yunusemrecakmak.webOdev_5.Entity.PrimaryKey;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OgrenciDto {
    private PrimaryKey primaryKey;
    @NotEmpty(message = "Ogrenci adini yaziniz!")
    private String name;
    @NotEmpty (message = "Ogrenci Soyadini yaziniz")
    private String surname;
    private int age;
    private OgrenciParents ogrenciParents;
    public OgrenciDto() {
    }

    public OgrenciDto(PrimaryKey primaryKey, String name, String surname, int age, OgrenciParents ogrenciParents) {
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
