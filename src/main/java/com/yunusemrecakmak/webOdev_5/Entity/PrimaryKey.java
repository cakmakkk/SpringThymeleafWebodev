package com.yunusemrecakmak.webOdev_5.Entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PrimaryKey implements Serializable{
    private String ulkeKod;
    private Long kimlikNo;

    public PrimaryKey(String ulkeKod, Long kimlikNo) {
        this.ulkeKod = ulkeKod;
        this.kimlikNo = kimlikNo;
    }

    public PrimaryKey() {
    }

    public String getUlkeKod() {
        return ulkeKod;
    }

    public void setUlkeKod(String ulkeKod) {
        this.ulkeKod = ulkeKod;
    }

    public Long getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(Long kimlikNo) {
        this.kimlikNo = kimlikNo;
    }
}
