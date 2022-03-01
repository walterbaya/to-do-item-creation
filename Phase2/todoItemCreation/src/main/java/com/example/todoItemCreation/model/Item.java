package com.example.todoItemCreation.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Boolean completed;


    @ManyToOne
    @JoinColumn(name = "folder_id")
    //@JsonBackReference

    private Folder folder;


}