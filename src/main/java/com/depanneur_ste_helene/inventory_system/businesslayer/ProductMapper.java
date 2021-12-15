package com.depanneur_ste_helene.inventory_system.businesslayer;
import com.depanneur_ste_helene.inventory_system.datalayer.Product;
import com.depanneur_ste_helene.inventory_system.datalayer.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO entityToModel(Product entity);
    List<ProductDTO> entityListToModelList(List<Product> products);

    @Mapping(target = "productId", ignore = true)
    Product modelToEntity(ProductDTO model);

}
