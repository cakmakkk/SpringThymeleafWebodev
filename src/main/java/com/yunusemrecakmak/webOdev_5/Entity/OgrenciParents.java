package com.yunusemrecakmak.webOdev_5.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OgrenciParents {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String motherName;
    private String fatherName;

    public OgrenciParents(Long id, String motherName, String fatherName) {
        this.id = id;
        this.motherName = motherName;
        this.fatherName = fatherName;
    }

    public OgrenciParents() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
