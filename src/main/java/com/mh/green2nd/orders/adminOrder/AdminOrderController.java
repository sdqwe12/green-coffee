package com.mh.green2nd.orders.adminOrder;

import com.mh.green2nd.orders.OrderState;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/order")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    // 주문 상태 변경
    @Operation(summary = "주문 상태 변경")
    @PutMapping("/state")
    public ResponseEntity<String> updateOrderState(Long orderId, OrderState newState, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminOrderService.updateOrderState(currentUser, orderId, newState);
        return ResponseEntity.ok("주문 상태가 변경되었습니다.");
    }


}
