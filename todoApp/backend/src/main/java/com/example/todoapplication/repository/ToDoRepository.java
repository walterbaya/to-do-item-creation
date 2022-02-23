package com.example.todoapplication.repository;

import com.example.todoapplication.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<Item, Long> {

}
