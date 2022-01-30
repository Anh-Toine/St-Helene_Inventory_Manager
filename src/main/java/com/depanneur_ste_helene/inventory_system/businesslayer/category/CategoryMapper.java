package com.depanneur_ste_helene.inventory_system.businesslayer.category;

import com.depanneur_ste_helene.inventory_system.datalayer.category.Category;
import com.depanneur_ste_helene.inventory_system.datalayer.category.CategoryCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.category.CategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "categoryId", ignore = true)
    })
    Category createDTOToEntity(CategoryCreateDTO model);

    CategoryDTO entityToModel(Category entity);

    List<CategoryDTO> entityListToModelList(List<Category> categories);

    @Mapping(target = "id", ignore = true)
    Category modelToEntity(CategoryDTO model);
}
