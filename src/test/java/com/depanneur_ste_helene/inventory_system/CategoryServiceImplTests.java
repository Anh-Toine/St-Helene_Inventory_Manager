package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.category.CategoryService;
import com.depanneur_ste_helene.inventory_system.datalayer.category.Category;
import com.depanneur_ste_helene.inventory_system.datalayer.category.CategoryCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.category.CategoryDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.category.CategoryRepository;
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
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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

        categories.add(new Category(1, UUID.randomUUID(),"1",false,0.00));
        categories.add(new Category(2,UUID.randomUUID(),"2",true,0.15));
        categories.add(new Category(3,UUID.randomUUID(),"3",false,0.00));

        when(categoryRepository.findAll()).thenReturn(categories);

        List<CategoryDTO> categoryModels = categoryService.getAllCategory();

        assertEquals(categoryModels.size(),3);
    }

    @DisplayName("Create a new category")
    @Test
    public void test_CreateCategory(){
        CategoryCreateDTO newCategory = new CategoryCreateDTO("1",false,0.00);
        Category entity = new Category(1,UUID.randomUUID(),"1",false,0.00);

        when(categoryRepository.save(any(Category.class))).thenReturn(entity);

        CategoryDTO returnedModel = categoryService.createCategory(newCategory);

        assertThat(returnedModel.getCategoryName()).isEqualTo(newCategory.getCategoryName());
    }

    @DisplayName("Create category that already exists")
    @Test
    public void test_CreateCategory_already_exists(){
        CategoryCreateDTO newCategory = new CategoryCreateDTO("1",false,0.00);

        when(categoryRepository.existsByCategoryName(newCategory.getCategoryName())).thenReturn(true);

        assertThrows(AlreadyExistsException.class, ()->{
            categoryService.createCategory(newCategory);
        });
    }

    @DisplayName("Update category")
    @Test
    public void test_UpdateCategory(){
        UUID categoryUUID = UUID.randomUUID();

        Category entity = new Category(1,UUID.randomUUID(),"1",false,0.00);

        Category updateEntity = new Category(1,categoryUUID,"1",true,0.15);
        CategoryDTO updateModel = new CategoryDTO(categoryUUID.toString(),"1",true,0.15);

        when(categoryRepository.findByCategoryId(any(UUID.class))).thenReturn(Optional.of(entity));
        when(categoryRepository.save(any(Category.class))).thenReturn(updateEntity);

        CategoryDTO returnedUpdateModel = categoryService.updateCategory(updateModel);

        assertThat(returnedUpdateModel.getCategoryName()).isEqualTo(updateModel.getCategoryName());
        assertThat(returnedUpdateModel.isTaxable()).isEqualTo(updateModel.isTaxable());
        assertThat(returnedUpdateModel.getTax()).isEqualTo(updateModel.getTax());
    }

    @DisplayName("Delete category")
    @Test
    public void test_DeleteCategory(){
        Category entity = new Category(1,UUID.randomUUID(),"1",false,0.00);

        when(categoryRepository.findByCategoryId(any(UUID.class))).thenReturn(Optional.of(entity));

        categoryService.deleteCategory(entity.getCategoryId().toString());

        verify(categoryRepository, times(1)).delete(entity);
    }
}
