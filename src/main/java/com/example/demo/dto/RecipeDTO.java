package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class RecipeDTO {
    private long id;
    private String title;
    private String category;
    private String level;
    private int time;
    private  String ingredients;
    private String instructions;
    private String imageName;
    private boolean favourite;
}
