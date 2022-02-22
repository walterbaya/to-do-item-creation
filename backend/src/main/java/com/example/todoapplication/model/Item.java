package com.example.todoapplication.model;

import jakarta.persistence. *;
import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
@Entity
@Table(name= "item")
public class Item {

    @Id
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
