package com.springframework.sbrecipeproject.models;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic generation of a sequence
    private Long id; // int limits the amount generated compared to long

    @OneToOne // no cascade; it we delete note, we dont want to delete its recipe
    private Recipe recipe;

    @Lob // long object; allow more characters within a string
    private String recipeNotes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public String getRecipeNotes() {
        return recipeNotes;
    }

    public void setRecipeNotes(String recipeNotes) {
        this.recipeNotes = recipeNotes;
    }
}
