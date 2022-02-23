package com.example.todoapplication.repository;

import com.example.todoapplication.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoldersRepository extends CrudRepositor<Folder, Integer> {

}
