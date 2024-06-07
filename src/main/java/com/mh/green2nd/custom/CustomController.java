package com.mh.green2nd.custom;

import com.mh.green2nd.cart.CartReqDto;
import com.mh.green2nd.cart.cartMenu.CartMenu;
import com.mh.green2nd.custom.customMenu.CustomMenu;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/custom")
@Tag(name = "커스텀 기능", description = "crud")
public class CustomController {

    private final CustomService customService;

    @Operation(summary = "커스텀 조회"
            , description = "담긴 커스텀 보기")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 작동"),
            @ApiResponse(responseCode = "500", description = "오류 발생")
    })
//    @GetMapping("/search")
//    public ResponseEntity<List<CustomMenu>> searchToCustom(Authentication authentication) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        List<CustomMenu> customMenus = customService.searchToCustom(user);
//
//        return ResponseEntity.status(HttpStatus.OK).body(customMenus);
//
////        return ResponseEntity.ok("조회");
//    }

    @GetMapping("/search")
    public ResponseEntity<org.springframework.data.domain.Page<CustomMenu>> searchToCustom(@RequestParam int page, @RequestParam int size, Authentication authentication) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Page<CustomMenu> result = customService.searchToCustom(user, page, size);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    //    @GetMapping("/search")
//    public ResponseEntity<List<CartMenu>> getCartItems(Authentication authentication) {
//        System.out.println(authentication);
//        // 현재 인증된 사용자의 정보를 가져옵니다.
//        User user = (User) authentication.getPrincipal();
//        System.out.println(user);
//        // 현재 사용자의 장바구니 아이템을 조회합니다.
//        List<CartMenu> cartItems = cartService.getCartItems(user);
//
//        return ResponseEntity.status(HttpStatus.OK).body(cartItems);
//    }
    @Operation(summary = "커스텀에 담기"
            , description = "카트에 담드는 것과 비슷하게 담는데 나만의 이름을 붙일 수 있음")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정상 작동"),
            @ApiResponse(responseCode = "500", description = "오류 발생")
    })
    @PostMapping("/add")
    public ResponseEntity<String> addToCustom(@RequestBody CustomReqDto customReqDto, Authentication authentication) {
        User jwtuser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("컨트롤러 jwt 오냐"+jwtuser);
        System.out.println("컨트롤러 req 오냐" +customReqDto);
        customService.addToCustom(customReqDto, (User) authentication.getPrincipal());

        return ResponseEntity.ok("나만의 메뉴에 담겼습니다. 확인해보세요");
    }

    @Operation(summary = "커스텀 하나 지우기"
            , description = "삭제기능")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "정삭적으로 삭제된 경우 나오는 코드"),
            @ApiResponse(responseCode = "500", description = "뭔가 문제가 있을 때 나오는데 명확하지 않음")
    })
    @DeleteMapping("/customdelete")
    public ResponseEntity<String> removeFromCustom(@RequestBody CustomDeleteDto customDeleteDto, Authentication authentication) {
        // 현재 인증된 사용자의 정보를 가져옵니다.
        User user = (User) authentication.getPrincipal();
        // 해당 사용자의 커스텀 메뉴에서 항목을 삭제합니다.
        customService.removeFromCustom(customDeleteDto, user);
        return ResponseEntity.ok("나만의 메뉴에서 삭제되었습니다");
    }


}
