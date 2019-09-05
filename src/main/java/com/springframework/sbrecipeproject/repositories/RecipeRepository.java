package com.springframework.sbrecipeproject.repositories;

import com.springframework.sbrecipeproject.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {



}
