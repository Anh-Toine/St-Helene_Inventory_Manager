package com.depanneur_ste_helene.inventory_system.businesslayer.supplier;

import com.depanneur_ste_helene.inventory_system.datalayer.supplier.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.AlreadyExistsException;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierServiceImpl implements SupplierService{
    private final SupplierRepository supplierRespository;
    private final SupplierMapper supplierMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRespository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
       List<Supplier> suppliers = supplierRespository.findAll();
       List<SupplierDTO> models = supplierMapper.entityListToModelList(suppliers);
       return models;
    }

    @Override
    public SupplierDTO createSupplier(SupplierCreateDTO model) {
        if(model.getSupplierName().isBlank() ||
                model.getRepresentativeName().isBlank() ||
                model.getEmail().isBlank() ||
                model.getPhoneNumber().isBlank()){
            throw new InvalidInputException("Input not valid: one field is blank");
        }

        if(supplierRespository.existsBySupplierName(model.getSupplierName())){
            throw new AlreadyExistsException("Input not valid: supplier already exists!");
        }

        Supplier supplierEntity = supplierMapper.createDTOToEntity(model);
        Supplier newEntity = supplierRespository.save(supplierEntity);

        return supplierMapper.entityToModel(newEntity);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO model) {
        Supplier supplierEntity = supplierMapper.modelToEntity(model);
        Optional<Supplier> returnedEntity =
                supplierRespository.findBySupplierId(model.getSupplierId());

        supplierEntity.setId(returnedEntity.get().getId());

        Supplier updatedSupplier = supplierRespository.save(supplierEntity);

        return  supplierMapper.entityToModel(updatedSupplier);
    }

    @Override
    public void deleteSupplier(String supplierId) {
        supplierRespository.findBySupplierId(supplierId).ifPresent(s -> supplierRespository.delete(s));
    }
}
