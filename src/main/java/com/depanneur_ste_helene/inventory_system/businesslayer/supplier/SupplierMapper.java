package com.depanneur_ste_helene.inventory_system.businesslayer.supplier;

import com.depanneur_ste_helene.inventory_system.datalayer.supplier.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring", imports = {UUID.class})
public interface SupplierMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "supplierId", ignore = true)
    })
    Supplier createDTOToEntity(SupplierCreateDTO model);

    SupplierDTO entityToModel(Supplier entity);
    List<SupplierDTO> entityListToModelList(List<Supplier> entities);

    @Mapping(target = "supplierId", ignore = true)
    Supplier modelToEntity(SupplierDTO modelass);
}
