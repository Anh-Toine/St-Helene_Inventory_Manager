package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.CategoryService;
import com.depanneur_ste_helene.inventory_system.datalayer.Category;
import com.depanneur_ste_helene.inventory_system.datalayer.CategoryDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.CategoryRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.AlreadyExistsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CategoryServiceImplTests {

    @MockBean
    CategoryRepository categoryRepository;

    @Autowired
    CategoryService categoryService;

    @DisplayName("Get all category")
    @Test
    public void test_GetAllCategory(){
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1,"1",false,0.00));
        categories.add(new Category(2,"2",true,0.15));
        categories.add(new Category(3,"3",false,0.00));

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryModels = categoryService.getAllCategory();

        assertEquals(categoryModels.size(),3);
    }

    @DisplayName("Create new category")
    @Test
    public void test_CreateCategory(){
        CategoryDTO model = new CategoryDTO("1",false,0.00);

        when(categoryRepository.existsByCategoryName(model.getCategoryName())).thenReturn(true);

        assertThrows(AlreadyExistsException.class, ()->{
            categoryService.createCategory(model);
        });
    }
}
