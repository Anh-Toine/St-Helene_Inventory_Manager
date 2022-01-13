package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.CategoryService;
import com.depanneur_ste_helene.inventory_system.datalayer.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryRESTController {
    @Autowired
    private final CategoryService SERVICE;

    public CategoryRESTController(CategoryService SERVICE) {
        this.SERVICE = SERVICE;
    }

    @CrossOrigin
    @GetMapping("/categories")
    public List<CategoryDTO> getAllCategory(){
        return SERVICE.getAllCategory();
    }
}
