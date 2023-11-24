package com.experis.course.springilmiofotoalbum.controller;


import com.experis.course.springilmiofotoalbum.model.Picture;
import com.experis.course.springilmiofotoalbum.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pictures")
public class PictureController {

//    **************************************************************************************************
//    TODO--------------------------------------ATTRIBUTES----------------------------------------------
//    **************************************************************************************************

    @Autowired
    private PictureRepository pictureRepository;

//    **************************************************************************************************
//    TODO----------------------------------END ATTRIBUTES----------------------------------------------
//    **************************************************************************************************

    //**************************************************************************************************
//todo------------------------Metodo che mostra la lista di tutte le immagini---------------------------
//******************************************************************************************************
    @GetMapping
    public String index(Model model) {

//        Attraverso PictureRepository, recuperiamo dal database la lista di tutte le immagini
        List<Picture> pictureList = pictureRepository.findAll();
        model.addAttribute("pictureList", pictureList);
        return "pictures/list";
    }

    ;
}
