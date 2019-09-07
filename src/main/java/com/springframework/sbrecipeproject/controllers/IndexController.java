package com.springframework.sbrecipeproject.controllers;

import com.springframework.sbrecipeproject.models.Category;
import com.springframework.sbrecipeproject.models.UnitOfMeasure;
import com.springframework.sbrecipeproject.repositories.CategoryRepository;
import com.springframework.sbrecipeproject.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public  String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat id = " + categoryOptional.get().getId());
        System.out.println("Unit id = " + unitOfMeasureOptional.get().getId());

        return "index";
    }
}
