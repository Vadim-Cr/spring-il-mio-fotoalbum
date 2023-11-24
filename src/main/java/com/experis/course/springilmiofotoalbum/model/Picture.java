package com.experis.course.springilmiofotoalbum.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture {

    //    **************************************************************************************************
//    TODO--------------------------------------ATTRIBUTES----------------------------------------------
//    ******************************************************************************************************
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Lob
    private String description;

    @Lob
    @Column(nullable = false)
    private String url;

    private boolean visibile;

    //  categorie

//    **************************************************************************************************
//    TODO----------------------------------END ATTRIBUTES----------------------------------------------
//    **************************************************************************************************

    //    **************************************************************************************************
//    TODO---------------------------------GETTER & SETTER----------------------------------------------
//    **************************************************************************************************
    private LocalDateTime createdAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
//    **************************************************************************************************
//    TODO--------------------------------END GETTER & SETTER-------------------------------------------
//    **************************************************************************************************


}
