package com.experis.course.springilmiofotoalbum.repository;

import com.experis.course.springilmiofotoalbum.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PictureRepository extends JpaRepository<Picture, Integer> {

    //**************************************************************************************************
//todo-------------------------Metodo per la ricerca per titolo-------------------------------------
//***************************************************************************************************
    List<Picture> findByTitleContainingIgnoreCase(String titleKeyword);
}
