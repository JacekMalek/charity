package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import pl.coderslab.charity.service.CategoryServiceImpl;

@Controller
public class CategoryController {

    private final CategoryServiceImpl categoryServiceImpl;

    public CategoryController(CategoryServiceImpl categoryServiceImpl) {
        this.categoryServiceImpl = categoryServiceImpl;
    }


}
