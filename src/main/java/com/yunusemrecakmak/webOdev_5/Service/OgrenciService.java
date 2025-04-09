package com.yunusemrecakmak.webOdev_5.Service;

import com.yunusemrecakmak.webOdev_5.DTO.OgrenciDto;
import com.yunusemrecakmak.webOdev_5.Entity.PrimaryKey;

import java.util.List;

public interface OgrenciService {
    void OgrenciKaydet(OgrenciDto ogrenciDto);
    List<OgrenciDto> getButunOgr();

    void OgrenciSil(PrimaryKey primaryKey);
    OgrenciDto getOgrenciId(PrimaryKey primaryKey);

    void  guncelleTamamla(OgrenciDto ogrenciDto);

}
