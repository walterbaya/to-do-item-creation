package com.example.todoItemCreation.repository;

import com.example.todoItemCreation.model.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends CrudRepository<Folder, Integer> {

}
