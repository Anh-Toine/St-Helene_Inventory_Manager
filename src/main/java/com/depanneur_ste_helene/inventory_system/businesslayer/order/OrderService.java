package com.depanneur_ste_helene.inventory_system.businesslayer.order;

import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    OrderDTO createOrder(@RequestBody OrderCreateDTO order);

    OrderDTO updateOrder(@RequestBody OrderDTO order);
}
