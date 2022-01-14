package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.Category;
import com.depanneur_ste_helene.inventory_system.datalayer.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO entityToModel(Category entity);

    List<CategoryDTO> entityListToModelList(List<Category> categories);

    @Mapping(target = "categoryId", ignore = true)
    Category modelToEntity(CategoryDTO model);
}
