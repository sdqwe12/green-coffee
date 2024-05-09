package com.mh.green2nd.orders;

import com.mh.green2nd.cart.CartReqDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/orders")
@RequiredArgsConstructor
@RestController
public class OrdersController {

    private final OrdersService ordersService;

//    @Operation(summary = "주문내역 보기"
//            ,description = "주문 내역을 봅니다")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200",description = "정상적으로 담겼을 때 나오는 코드"),
//            @ApiResponse(responseCode = "500",description = "오류코드")
//    })
//    @GetMapping("/list")
//public ResponseEntity<Orders> orderslist(@RequestBody OrdersReqDto ordersReqDto, Authentication authentication) {
//    User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    Orders orders = ordersService.getList(ordersReqDto.getId());
//    return ResponseEntity.ok(orders);
//}

}
