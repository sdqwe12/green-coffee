//package com.mh.green2nd.custom;
//
//import com.mh.green2nd.cart.CartReqDto;
//import com.mh.green2nd.user.User;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/custom")
//@Tag(name = "커스텀 기능", description = "crud")
//public class CustomController {
//
//    private final CustomService customService;
//
//    @Operation(summary = "커스텀 담기"
//            , description = "카트에 담드는 것과 비슷하게 담는데 나만의 이름을 정할 수 있음")
//    @ApiResponses({
//            @ApiResponse(responseCode = "200", description = "정상 작동"),
//            @ApiResponse(responseCode = "500", description = "오류 발생")
//    })
//    @PostMapping("/add")
//    public ResponseEntity<String> addToCart(@RequestBody CartReqDto cartReqDTO, Authentication authentication) {
//        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(jwtuser);
//        System.out.println(cartReqDTO);
//        cartService.addToCart(cartReqDTO, (User) authentication.getPrincipal()); // 토큰과 함께 addToCart 메서드 호출
//        return ResponseEntity.ok("장바구니에 담겼습니다. 확인해보세요");
//    }
//}
