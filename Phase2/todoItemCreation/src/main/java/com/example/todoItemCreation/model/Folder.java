package com.example.todoItemCreation.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@Table(name= "folder")
public class Folder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="folder_id")
    private Integer id;

    @NotNull(message = "name may not be null")
    @Column(nullable = false)
    private String name;

    //@JsonManagedReference
    @OneToMany(cascade=CascadeType.MERGE, orphanRemoval = true)
    @JoinColumn(name="folder_id")
    private List<Item> items;

}
