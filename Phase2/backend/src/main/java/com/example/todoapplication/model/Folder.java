package com.example.todoapplication.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence. *;
import lombok.Data;

import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;

@jakarta.persistence.Entity
@Data
@jakarta.persistence.Table(name= "folder")
public class Folder {

    private Integer id;

    @jakarta.validation.constraints.NotNull(message = "name may not be null")
    @Column(nullable = false)
    private String name;

    private List<Item> items;

    public Folder() {

    }

    @jakarta.validation.constraints.NotNull(message = "name may not be null")
    @Column(nullable = false)
    public String getName() {
        return name;
    }

    @Column(nullable = false)
    @jakarta.validation.constraints.NotNull(message = "name may not be null")
    public void setName(String name) {
        this.name = name;
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
