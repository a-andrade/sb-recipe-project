package com.springframework.sbrecipeproject.models;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // automatic generation of a sequence
    private Long id; // int limits the amount generated compared to long

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") // target property = recipe
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob // binary long object
    private Byte[] image;

    @Enumerated(value = EnumType.STRING) // override default value of enumerations
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL) // if we delete recipe, delete its note
    private Note note;

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    // build bi-directional association in setter rather than outside of this class
    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

    public void setNote(Note note) {
        if (note != null) {
            this.note = note;
            note.setRecipe(this); // build bi-directional association in setter rather than outside of this class
        }
    }
}
