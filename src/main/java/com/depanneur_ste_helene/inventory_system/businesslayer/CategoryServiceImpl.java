package com.depanneur_ste_helene.inventory_system.businesslayer;

import com.depanneur_ste_helene.inventory_system.datalayer.*;
import com.depanneur_ste_helene.inventory_system.exceptions.AlreadyExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    private final CategoryMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> models = mapper.entityListToModelList(categories);
        return models;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO model) {
        if(categoryRepository.existsByCategoryName(model.getCategoryName())){
            throw new AlreadyExistsException("A category of the same name already exists");
        }

        Category entity = mapper.modelToEntity(model);
        Category newEntity = categoryRepository.save(entity);

        return mapper.entityToModel(newEntity);
    }
}
