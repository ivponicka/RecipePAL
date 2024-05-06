package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public void addRecipe(Recipe recipe){
        recipeRepository.save(recipe);
    }

    public List<Recipe> getAllRecipies(){
        return recipeRepository.findAll();

    }

    public Optional<Recipe> findRecipe(long id){
        return recipeRepository.findById(id);
    }

    public void deleteRecipe(long id){
         recipeRepository.deleteById(id);
    }
}
