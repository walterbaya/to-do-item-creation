package com.example.todoapplication.model;

import jakarta.persistence. *;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name= "item")
public class Item implements Serializable {

    public Item() {

    }

    public Item(String name, Boolean completed){
        this.name = name;
        this.completed = completed;
    }
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name;

    private Boolean completed;

    public void setId(Long id) {
        this.id = id;
    }

    @jakarta.persistence.Id
    public Long getId() {
        return id;
    }
}
