package com.mh.green2nd.orders;

import com.mh.green2nd.orders.dto.OrderReqDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // 1. 주문 등록하기
    @Operation(summary = "주문 테이블에 담기", description = "name은 매장 이름(중앙로점, 종로점, 범어점, 경대점, 두류점)")
    @PostMapping("/neworder/{name}")
    public ResponseEntity neworder(@RequestBody OrderReqDto[] orderReqDto, Authentication authentication, @PathVariable String name) {
        User jwtUser = (User) authentication.getPrincipal();
        orderService.createNewOrder(orderReqDto, jwtUser, name);
        return ResponseEntity.status(HttpStatus.CREATED).body("주문이 완료되었습니다.");
    }

    // 2. 주문내역 보여주기
    @Operation(summary = "주문내역 보여주기", description = "로그인한 user의 주문내역 보여주기")
    @GetMapping("/list")
    public ResponseEntity<List<Order>> orderlist(Authentication authentication) {
        User jwtUser = (User) authentication.getPrincipal();
        List<Order> orderList = orderService.orderListWithUser(jwtUser);
        return ResponseEntity.status(HttpStatus.OK).body(orderList);
    }

    // 3. 주문내역 간략보기
    @Operation(summary = "주문내역 간략보기", description = "로그인한 user의 주문내역 간략보기")
    @GetMapping("/summary")
    public ResponseEntity<List<String>> orderlistSummary(Authentication authentication) {
        User jwtUser = (User) authentication.getPrincipal();
        List<Order> orderList = orderService.orderListWithUser(jwtUser);
        List<String> orderSummaries = orderList.stream()
                .map(Order::getOrderItemsSummary)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(orderSummaries);
    }
}
