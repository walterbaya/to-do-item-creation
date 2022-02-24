package com.example.todoapplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence. *;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@jakarta.persistence.Entity
@Data
@jakarta.persistence.Table(name= "folder")
public class Folder {

    private Integer id;

    private String name;

    private List<Item> items;

    public Folder() {

    }

    @jakarta.persistence.Column(name = "name",nullable = false)
    public String getName() {
        return name;
    }

    @jakarta.persistence.OneToMany(cascade=CascadeType.MERGE, orphanRemoval = true)
    @jakarta.persistence.JoinColumn(name="folder_id")
    @JsonManagedReference
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
