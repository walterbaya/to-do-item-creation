package com.example.todoapplication.model;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class Item {

    @Id
    private Long id;

    private String name;

    private Boolean completed;

}
