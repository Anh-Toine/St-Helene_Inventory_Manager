package com.depanneur_ste_helene.inventory_system.presentationlayer;

import com.depanneur_ste_helene.inventory_system.businesslayer.CategoryService;
import com.depanneur_ste_helene.inventory_system.datalayer.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE,
            path = "/categories")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryDTO createCategory(@RequestBody CategoryDTO category){return SERVICE.createCategory(category);}

    @CrossOrigin
    @DeleteMapping(path = "/categories/{categoryName}")
    public void deleteCategory(@PathVariable String categoryName){SERVICE.deleteCategory(categoryName);}
}
