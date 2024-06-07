package com.mh.green2nd.orders.adminOrder;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderState;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/order")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    @Operation(summary = "매장별 주문상태 조회(ORDER_REQUEST, ORDER_APPROVED, MANUFACTURE_COMPLETED, RECEIPT_COMPLETED)", description = "중앙로점, 종로점, 범어점, 경대점, 두류점 중 택1. " +
            "매장별 첫번째 주문 상태 조회")
    @GetMapping("/GetOrderState/{storeName}")
    public ResponseEntity<Order> getFirstCompletedOrderByStoreName(@PathVariable String storeName, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        Order order = adminOrderService.getFirstCompletedOrderByStoreName(currentUser, storeName);
        return ResponseEntity.ok(order);
    }

    @Operation(summary = "매장별 주문상태(ORDER_REQUEST, ORDER_APPROVED, MANUFACTURE_COMPLETED, RECEIPT_COMPLETED) 변경", description = "중앙로점, 종로점, 범어점, 경대점, 두류점 중 택1. " +
            "매장별 첫번째 주문 상태 변경")
    @PutMapping("/ChangeOrderState/{storeName}")
    public ResponseEntity<String> updateFirstCompletedOrderStateByStoreName(@PathVariable String storeName, @RequestBody OrderState newState, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminOrderService.updateFirstCompletedOrderStateByStoreName(currentUser, storeName, newState);
        return ResponseEntity.ok("The order state has been updated.");
    }

    @Operation(summary = "매장별 주문 상태별 갯수 조회", description = "중앙로점, 종로점, 범어점, 경대점, 두류점 중 택1")
    @GetMapping("/orderStateCount/{storeName}")
    public ResponseEntity<Map<OrderState, Long>> getOrderStateCountByStoreName(@PathVariable String storeName, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        Map<OrderState, Long> orderStateCountMap = adminOrderService.getOrderStateCountByStoreName(currentUser, storeName);
        return ResponseEntity.ok(orderStateCountMap);
    }

    @Operation(summary = "매장별 주문 내역 조회", description = "중앙로점, 종로점, 범어점, 경대점, 두류점 중 택1")
    @GetMapping("/{storeName}")
    public ResponseEntity<List<Order>> getOrdersByStoreName(@PathVariable String storeName, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        List<Order> orders = adminOrderService.getOrdersByStoreName(currentUser, storeName);
        return ResponseEntity.ok(orders);
    }

    @Operation(summary = "모든 매장 주문 내역 조회")
    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrderDetails(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        List<Order> orders = adminOrderService.getAllOrderDetails(currentUser);
        return ResponseEntity.ok(orders);
    }


}
