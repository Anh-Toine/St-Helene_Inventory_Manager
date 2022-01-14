package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.CategoryDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
    CategoryDTO createCategory(@RequestBody CategoryDTO model);
}
