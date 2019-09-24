package com.springframework.sbrecipeproject.services;

import com.springframework.sbrecipeproject.commands.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);
}
