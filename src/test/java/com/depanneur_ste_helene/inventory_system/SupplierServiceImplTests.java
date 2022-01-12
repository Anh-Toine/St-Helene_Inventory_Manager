package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.SupplierService;
import com.depanneur_ste_helene.inventory_system.datalayer.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.SupplierDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.SupplierRepository;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SupplierServiceImplTests {
    @MockBean
    SupplierRepository supplierRespository;

    @Autowired
    SupplierService supplierService;

    @DisplayName("Get all suppliers")
    @Test
    public void getAllSuppliers(){
        // Arrange
        final int ID = 1;

        List<Supplier> suppliers = new ArrayList<>();

        Supplier s1 = new Supplier(ID,"John Doe","John Doe","doeemail@gmail.com","111-1111-1111");
        Supplier s2 =  new Supplier(ID+1,"John Doe2","John Doe2","doeemail@gmail.com2","222-2222" +
                "-2222");
        Supplier s3 = new Supplier(ID+2,"John Doe3","John Doe3","doeemail@gmail.com3","333-3333" +
                "-3333");

        // Act
        suppliers.add(s1);
        suppliers.add(s2);
        suppliers.add(s3);

        when(supplierRespository.findAll()).thenReturn(suppliers);

        List<SupplierDTO> supplierModels = supplierService.getAllSuppliers();
        // Assert
        assertEquals(supplierModels.size(),3);
    }
}
