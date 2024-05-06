package com.example.demo.controller;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.model.Recipe;
import com.example.demo.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Receiver;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class RecipeController {
    public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/images";
    @Autowired
    RecipeService recipeService;
    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("recipes", recipeService.getAllRecipies());
        return "index";
    }

    @GetMapping("/previous-page")
    public String previousPage(){
        return "index";
    }

    @GetMapping ("/addRecipe")
    public String addRecipe(Model model){
        model.addAttribute("recipeDTO", new RecipeDTO());
        return "add_new_recipe";
     }

    @GetMapping("/show-recipe/{id}")
    public  String showRecipe(@PathVariable int id, Model model){
        model.addAttribute("recipe", recipeService.findRecipe(id).get());
        return "view_recipe";

    }

    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable int id, Model model){
        Recipe recipe = recipeService.findRecipe(id).get();
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setTitle(recipe.getTitle());
        recipeDTO.setCategory(recipe.getCategory());
        recipeDTO.setLevel(recipe.getLevel());
        recipeDTO.setTime(recipe.getTime());
        recipeDTO.setIngredients(recipe.getIngredients());
        recipeDTO.setInstructions(recipe.getInstructions());
        recipeDTO.setImageName(recipe.getImageName());
        model.addAttribute("recipeDTO", recipeDTO);
        return "edit_recipe";
    }
    @PostMapping ("/addRecipe")
    public String addRecipePost(@ModelAttribute("recipeDTO") RecipeDTO recipeDTO, @RequestParam("imageRec")MultipartFile file, @RequestParam("imgName") String imgName) throws IOException {
        Recipe recipe = new Recipe();
        recipe.setId(recipeDTO.getId());
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setCategory(recipeDTO.getCategory());
        recipe.setLevel(recipeDTO.getLevel());
        recipe.setTime(recipeDTO.getTime());
        recipe.setIngredients(recipeDTO.getIngredients());
        recipe.setInstructions(recipeDTO.getInstructions());
        String imageUUID;

        if(!file.isEmpty()){
            imageUUID = file.getOriginalFilename();
            Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        } else {
            imageUUID = imgName;

        }
        recipe.setImageName(imageUUID);
        recipeService.addRecipe(recipe);
        return "redirect:/";
        }

        @GetMapping("/delete/{id}")
        public String deleteRecipe(@PathVariable long id){
            recipeService.deleteRecipe(id);
            return "redirect:/";
        }
    }
