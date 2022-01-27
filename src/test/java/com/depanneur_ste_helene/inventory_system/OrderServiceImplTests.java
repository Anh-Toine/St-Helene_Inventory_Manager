package com.depanneur_ste_helene.inventory_system;

import com.depanneur_ste_helene.inventory_system.businesslayer.order.OrderService;
import com.depanneur_ste_helene.inventory_system.datalayer.order.Order;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class OrderServiceImplTests {

    @MockBean
    public OrderRepository repository;

    @Autowired
    public OrderService service;

    @DisplayName("Get all orders")
    @Test
    public void test_GetAllOrders(){
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, UUID.randomUUID(),"29-12-2021",true,true,2));
        orders.add(new Order(2, UUID.randomUUID(),"03-01-2022",true,true,1));
        orders.add(new Order(3, UUID.randomUUID(),"19-01-2022",true,true,1));

        when(repository.findAll()).thenReturn(orders);

        List<OrderDTO> models = service.getAllOrders();
        assertEquals(models.size(),3);
    }

    @DisplayName("Create new order")
    @Test
    public void test_CreateNewOrder(){
        OrderCreateDTO newOrder = new OrderCreateDTO("20-1-2021",false,false,3);
        Order entity = new Order(1,UUID.randomUUID(),"20-1-2021",false,false,3);

        when(repository.save(any(Order.class))).thenReturn(entity);

        OrderDTO returnedModel = service.createOrder(newOrder);

        assertThat(returnedModel.getOrderDate()).isEqualTo(newOrder.getOrderDate());
    }
}
