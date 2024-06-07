package com.mh.green2nd.orders.adminOrder;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderRepository;
import com.mh.green2nd.orders.OrderState;
import com.mh.green2nd.store.Store;
import com.mh.green2nd.store.StoreRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AdminOrderService {

    private final OrderRepository orderRepository;
    private final StoreRepository storeRepository;

    // 매장별 첫번째 주문 상태 조회
    public Order getFirstCompletedOrderByStoreName(User user, String storeName) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get orders by store name");
        }

        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return orderRepository.findFirstByStoreAndStateOrderByCreatedAtAsc(store, OrderState.ORDER_REQUEST)
                .orElseThrow(() -> new RuntimeException("No completed orders found for this store"));
    }

    // 매장별 첫번째 주문 상태 변경
    public void updateFirstCompletedOrderStateByStoreName(User user, String storeName, OrderState newState) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update order state");
        }

        Order order = getFirstCompletedOrderByStoreName(user, storeName);

        order.setState(newState);
        orderRepository.save(order);
    }

    // 매장별 주문 상태별 갯수 조회
    public Map<OrderState, Long> getOrderStateCountByStoreName(User user, String storeName) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get order state counts by store name");
        }

        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        Map<OrderState, Long> orderStateCountMap = new HashMap<>();
        for (OrderState state : OrderState.values()) {
            Long count = orderRepository.countByStoreAndState(store, state);
            orderStateCountMap.put(state, count);
        }

        return orderStateCountMap;
    }

    // 매장별 주문 내역 조회
    public List<Order> getOrdersByStoreName(User user, String storeName) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get orders by store name");
        }

        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        return orderRepository.findByStoreOrderByCreatedAtAsc(store);
    }

    // 모든 매장 주문 내역 조회
    public List<Order> getAllOrderDetails(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can get all order details");
        }

        return orderRepository.findAll();
    }
}