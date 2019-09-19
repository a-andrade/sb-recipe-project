package com.springframework.sbrecipeproject.services;

import com.springframework.sbrecipeproject.commands.RecipeCommand;
import com.springframework.sbrecipeproject.models.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
