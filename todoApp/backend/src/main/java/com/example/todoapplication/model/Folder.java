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

    private Integer id;

    private String name;

    private List<Item> items;

    public Folder() {

    }

    @jakarta.persistence.OneToMany(cascade=CascadeType.ALL, orphanRemoval = true)
    @jakarta.persistence.JoinColumn(name="folder_id")
    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Folder(String name){
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @jakarta.persistence.GeneratedValue(strategy = AUTO)
    @jakarta.persistence.Id
    @jakarta.persistence.Column(name="folder_id")
    public Integer getId() {
        return id;
    }
}
