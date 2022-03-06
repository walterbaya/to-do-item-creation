package com.example.todoItemCreation.repository;

import com.example.todoItemCreation.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Item, Integer> {
}

