package com.example.todoapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence. *;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Entity
@Data
@Table(name= "item")
public class Item {

    public Item() {

    }

    public Item(String name, Boolean completed){
        this.name = name;
        this.completed = completed;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Boolean completed;


    private Folder folder;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    @jakarta.persistence.ManyToOne
    @jakarta.persistence.JoinColumn(name="folder_id")
    @JsonBackReference
    public Folder getFolder() {
        return folder;
    }

    @Id
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }
}
