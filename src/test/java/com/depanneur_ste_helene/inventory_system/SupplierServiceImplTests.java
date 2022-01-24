package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.supplier.SupplierService;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.Supplier;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.supplier.SupplierRepository;
import com.depanneur_ste_helene.inventory_system.exceptions.InvalidInputException;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SupplierServiceImplTests {
    @MockBean
    SupplierRepository supplierRespository;

    @Autowired
    SupplierService supplierService;

    @DisplayName("Get all suppliers")
    @Test
    public void test_GetAllSuppliers(){
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

    @DisplayName("Create supplier valid")
    @Test
    public void test_CreateSupplier_valid(){
        // Arrange
        SupplierDTO dto = new SupplierDTO("FooSuppliers","Nelson Doe","nelson111@gmail.com","111" +
                "-1111-1111");
        Supplier entity = new Supplier(1,"FooSupplier","Nelson Doe","nelson111@gmail.com","111" +
                "-1111-1111");

        // Act
        when(supplierRespository.save(any(Supplier.class))).thenReturn(entity);
        SupplierDTO foundSupplier = supplierService.createSupplier(dto);

        // Assert
        assertThat(foundSupplier.getSupplierName()).isEqualTo(entity.getSupplierName());
        assertThat(foundSupplier.getRepresentativeName()).isEqualTo(entity.getRepresentativeName());
        assertThat(foundSupplier.getEmail()).isEqualTo(entity.getEmail());
        assertThat(foundSupplier.getPhoneNumber()).isEqualTo(entity.getPhoneNumber());
    }

    @DisplayName("Create supplier blank")
    @Test
    public void test_CreateSupplier_blank(){
        // Arrange
        SupplierDTO dto = new SupplierDTO("FooSuppliers","Nelson Doe"," ","111" +
                "-1111-1111");

        // Act
        when(supplierRespository.save(any(Supplier.class))).thenThrow(InvalidInputException.class);

        // Assert
        assertThrows(InvalidInputException.class, ()->{
            supplierService.createSupplier(dto);
        });
    }

    @DisplayName("Update supplier")
    @Test
    public void test_UpdateSupplier(){
        // Arrange
        Supplier entity = new Supplier(1,"Foo","FooRep","foo@email.com","111-111-1111");
        SupplierDTO model = new SupplierDTO("Foo","FooRep","foo@email.com","111-111-1111");
        // Act
        when(supplierRespository.findBySupplierName(any())).thenReturn(Optional.ofNullable(entity));
        when(supplierRespository.save(any(Supplier.class))).thenReturn(entity);
        SupplierDTO capturedSupplier = supplierService.updateSupplier(model);
        // Assert
        assertEquals(capturedSupplier.getSupplierName(), entity.getSupplierName());
        assertEquals(capturedSupplier.getRepresentativeName(), entity.getRepresentativeName());
        assertEquals(capturedSupplier.getEmail(), entity.getEmail());
        assertEquals(capturedSupplier.getPhoneNumber(), entity.getPhoneNumber());
    }

    @DisplayName("Delete supplier")
    @Test
    public void test_deleteSupplier(){
        // Arrange
        Supplier entity = new Supplier(1,"Foo","FooRep","foo@email.com","111-111-1111");
        when(supplierRespository.findBySupplierName(entity.getSupplierName())).thenReturn(Optional.of(entity));
        // Act
        supplierService.deleteSupplier(entity.getSupplierName());
        // Assert
        verify(supplierRespository, times(1)).delete(entity);
    }
}
