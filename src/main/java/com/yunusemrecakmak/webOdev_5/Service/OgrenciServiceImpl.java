package com.yunusemrecakmak.webOdev_5.Service;
import com.yunusemrecakmak.webOdev_5.DTO.OgrenciDto;
import com.yunusemrecakmak.webOdev_5.Entity.Ogrenci;
import com.yunusemrecakmak.webOdev_5.Entity.PrimaryKey;
import com.yunusemrecakmak.webOdev_5.Esleme.Esleme;
import com.yunusemrecakmak.webOdev_5.Repository.OgrenciRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class OgrenciServiceImpl implements OgrenciService{

    @Autowired
    private OgrenciRepos ogrenciRepos;
    @Override
    public void OgrenciKaydet(OgrenciDto ogrenciDto) {
        Ogrenci ogrenci = Esleme.ogrenciEsle(ogrenciDto);
        ogrenciRepos.save(ogrenci);
    }

    @Override
    public List<OgrenciDto> getButunOgr() {
        List<Ogrenci> ogrenciList = ogrenciRepos.findAll();
        List<OgrenciDto> ogrenciDtoList = ogrenciList.stream().map((ogrenci) -> Esleme.ogrenciDtoEsle(ogrenci)).collect(Collectors.toList());
        return ogrenciDtoList;
    }

    @Override
    public void OgrenciSil(PrimaryKey primaryKey ) {
        PrimaryKey primaryKey1 = new PrimaryKey(primaryKey.getUlkeKod(),primaryKey.getKimlikNo());
        ogrenciRepos.deleteById(primaryKey1);
    }

    @Override
    public OgrenciDto getOgrenciId(PrimaryKey primaryKey) {


        Ogrenci ogrenci = ogrenciRepos.findById(primaryKey).get();
        OgrenciDto ogrenciDto= Esleme.ogrenciDtoEsle(ogrenci);

        return ogrenciDto;
    }

    @Override
    public void guncelleTamamla(OgrenciDto ogrenciDto) {
        ogrenciRepos.save(Esleme.ogrenciEsle(ogrenciDto));
    }
}
