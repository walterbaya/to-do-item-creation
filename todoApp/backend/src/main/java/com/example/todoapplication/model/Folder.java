package com.example.todoapplication.model;

import jakarta.persistence. *;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@jakarta.persistence.Entity
@Data
@jakarta.persistence.Table(name= "folder")
public class Folder implements Serializable {

    public Folder() {

    }

    public Folder(String name, Boolean completed){
        this.name = name;
    }

    @jakarta.persistence.GeneratedValue(strategy = AUTO)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name="folder_id")
    private Integer id;

    private String name;

    @jakarta.persistence.OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @jakarta.persistence.JoinColumn(name="folder_id")
    private List<Item> items;

    public void setId(Integer id) {
        this.id = id;
    }

    @jakarta.persistence.GeneratedValue(strategy = AUTO)
    public Integer getId() {
        return id;
    }
}
