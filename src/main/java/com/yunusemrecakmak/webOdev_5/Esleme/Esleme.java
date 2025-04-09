package com.yunusemrecakmak.webOdev_5.Esleme;

import com.yunusemrecakmak.webOdev_5.DTO.OgrenciDto;
import com.yunusemrecakmak.webOdev_5.Entity.Ogrenci;

import java.util.Optional;

public class Esleme {
    public static OgrenciDto ogrenciDtoEsle(Ogrenci ogrenci){
        OgrenciDto ogrenciDto= new OgrenciDto(
                ogrenci.getPrimaryKey(),
                ogrenci.getName(),
                ogrenci.getSurname(),
                ogrenci.getAge(),
                ogrenci.getOgrenciParents()
        );
        return ogrenciDto;
    }
    public static Ogrenci ogrenciEsle(OgrenciDto ogrenciDto){
        Ogrenci ogrenci= new Ogrenci(
                ogrenciDto.getPrimaryKey(),
                ogrenciDto.getName(),
                ogrenciDto.getSurname(),
                ogrenciDto.getAge(),
                ogrenciDto.getOgrenciParents()
        );
        return ogrenci;
    }
}
