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

    @Mapping(target = "categoryId", expression = "java(entity.getCategoryId().toString())")
    CategoryDTO entityToModel(Category entity);


    List<CategoryDTO> entityListToModelList(List<Category> categories);


    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "categoryId", expression = "java(UUID.fromString(model.getCategoryId()))")
    })
    Category modelToEntity(CategoryDTO model);
}
