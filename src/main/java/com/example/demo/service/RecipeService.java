package com.example.demo.service;

import com.example.demo.model.Recipe;
import com.example.demo.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
