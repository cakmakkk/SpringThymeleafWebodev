package com.yunusemrecakmak.webOdev_5.Controller;
import com.yunusemrecakmak.webOdev_5.DTO.OgrenciDto;
import com.yunusemrecakmak.webOdev_5.Entity.PrimaryKey;
import com.yunusemrecakmak.webOdev_5.Service.OgrenciServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class OgrenciController {
    @Autowired
    private OgrenciServiceImpl ogrenciServiceimpl;

    @GetMapping("/obsGetirHepsi")
    public String getirButunOgrenciler(Model model){
        List<OgrenciDto> ogrenciDtoList = ogrenciServiceimpl.getButunOgr();
        model.addAttribute("ogrenciler",ogrenciDtoList);
        return "getirOBSOgrHepsi";
    }

    @PostMapping("/ogrenciler")
    public String ogrenciKaydet (@Valid @ModelAttribute("ogrenci")OgrenciDto ogrenciDto, BindingResult result ,Model model){
        if (result.hasErrors()){
            model.addAttribute("ogrenci",ogrenciDto);
            return "/yeniOgrSayfasi";
        }
        ogrenciServiceimpl.OgrenciKaydet(ogrenciDto);
        return "redirect:/obsGetirHepsi";
    }
    @GetMapping("/yeniogr")
    public String yeniOgrenci (Model model){
        OgrenciDto ogrenciDto = new OgrenciDto();
        model.addAttribute("ogrenci",ogrenciDto);
        return "yeniOgrSayfasi";
    }
    @GetMapping("/ogrenciler/{ulkeKod}/{kimlikNo}/sil")
    public String silOgrenci(
            @PathVariable ("ulkeKod") String ulkeKod,
            @PathVariable("kimlikNo") Long kimlikNo){
        PrimaryKey key = new PrimaryKey(ulkeKod,kimlikNo);
        ogrenciServiceimpl.OgrenciSil(key);
        return "redirect:/obsGetirHepsi";
    }

    @PostMapping("/ogrenciler/{ulkeKod}/{kimlikNo}")
    public String ogrenciUpdateOk(@PathVariable("kimlikNo") Long kimlikNo ,@PathVariable("ulkeKod") String ulkeKod ,@ModelAttribute("ogrenci") OgrenciDto ogrenciDto,
                                  BindingResult result,Model model){
        if (result.hasErrors()){
            model.addAttribute("ogrenci", ogrenciDto);
        }
        PrimaryKey primaryKey = new PrimaryKey(ulkeKod,kimlikNo);
        ogrenciDto.setPrimaryKey(primaryKey);
        ogrenciServiceimpl.guncelleTamamla(ogrenciDto);
        return "redirect:/obsGetirHepsi";
    }
    @GetMapping("/ogrenciler/{ulkeKod}/{kimlikNo}/guncelle")
    public String ogrenciUpdateOk(@PathVariable("kimlikNo") Long kimlikNo ,@PathVariable("ulkeKod") String ulkeKod,Model model){
        OgrenciDto ogrenciDto = ogrenciServiceimpl.getOgrenciId(new PrimaryKey(ulkeKod,kimlikNo));
        model.addAttribute("ogrenci",ogrenciDto);
        return "ogrenciGuncelle";

    }
    @GetMapping("/ogrenciler/{ulkeKod}/{kimlikNo}/goruntule")
    public String ogrenciGoruntule(@PathVariable("kimlikNo") Long kimlikNo ,@PathVariable("ulkeKod") String ulkeKod,Model model){
        OgrenciDto ogrenciDto = ogrenciServiceimpl.getOgrenciId(new PrimaryKey(ulkeKod,kimlikNo));
        model.addAttribute("ogrenci",ogrenciDto);
        return "goruntuleOgr";
    }



}
