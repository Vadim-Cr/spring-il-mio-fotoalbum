package com.experis.course.springilmiofotoalbum.controller;

import com.experis.course.springilmiofotoalbum.model.Picture;
import com.experis.course.springilmiofotoalbum.repository.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
//todo------------------------Metodo che mostra la lista di tutte le immagini-------------------------
//todo--------------------------------------- anche filtrate ----------------------------------------
//******************************************************************************************************
    @GetMapping
    public String index(@RequestParam("search") Optional<String> search,
                        Model model) {
        List<Picture> pictureList;
//        Se il parametro di ricerca è presente, filtro la lista di immagini
        if (search.isPresent()) {
            pictureList = pictureRepository.findByTitleContainingIgnoreCase(search.get());
        } else {

//        Altrimenti prendo i libri non filtrati
//        Attraverso PictureRepository, recuperiamo dal database la lista di tutte le immagini
            pictureList = pictureRepository.findAll();
        }
        model.addAttribute("pictureList", pictureList);
        return "pictures/list";
    }

    //**************************************************************************************************
//todo-----------------Metodo che mostra il DETTAGLIO dell'immagine presa per id------------------------
//******************************************************************************************************

    @GetMapping("/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
//       Chiedo alla repository di recuperarmi tutti i dati del DB
        Optional<Picture> result = pictureRepository.findById(id);
//        Verifico che il risultato sia positivo, ovvero è presente
        if (result.isPresent()) {
//        Passo al template l'oggetto Picture
            model.addAttribute("picture", result.get());

            return "pictures/show";
        } else {
//        Sollevo l'eccezzione nel caso in cui non ho trovvato l'imamgine
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "picture with id " + id + " ,not found.");
        }
    }
}
