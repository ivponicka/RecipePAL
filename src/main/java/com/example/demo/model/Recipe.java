package com.example.demo.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name="level")
    private String level;
    @Column(name="time")
    private int time;
    @Column(name = "ingredients")

    private  String ingredients;
    @Column(name = "intructions", length = 350)
    private String instructions;

    @Column(name = "imageName")
    private String imageName;

    @Column(name = "favourite")
    private boolean favourite;

}
