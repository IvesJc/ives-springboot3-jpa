package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public List<Category> findAll(){
        return categoryRespository.findAll();
    }

    public Category finById(Long id){
        Optional<Category> cat = categoryRespository.findById(id);
        return cat.get();
    }
}
