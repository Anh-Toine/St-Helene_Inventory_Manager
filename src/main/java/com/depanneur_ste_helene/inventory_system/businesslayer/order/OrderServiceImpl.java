package com.depanneur_ste_helene.inventory_system.businesslayer.order;

import com.depanneur_ste_helene.inventory_system.datalayer.order.Order;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderCreateDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderDTO;
import com.depanneur_ste_helene.inventory_system.datalayer.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> models = orderMapper.entityListToModelList(orders);
        return models;
    }

    @Override
    public OrderDTO createOrder(OrderCreateDTO order) {
        Order entity = orderMapper.createModelToEntity(order);
        Order newOrder = orderRepository.save(entity);
        return orderMapper.entityToModel(newOrder);
    }

    @Override
    public OrderDTO updateOrder(OrderDTO order) {
        Order entity = orderMapper.modelToEntity(order);
        Optional<Order> returnedEntity =
                orderRepository.findOrderByOrderId(order.getOrderId());

        if(returnedEntity.isPresent()){
            entity.setId(returnedEntity.get().getId());
        }

        Order updatedOrder = orderRepository.save(entity);
        return orderMapper.entityToModel(updatedOrder);
    }
}
