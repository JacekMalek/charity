package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.charity.service.CategoryServiceImpl;

@Controller
public class CategoryController {

    private final CategoryServiceImpl categoryService;


    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
}
