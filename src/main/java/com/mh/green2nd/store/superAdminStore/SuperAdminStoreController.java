package com.mh.green2nd.store.superAdminStore;

import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superAdmin/store")
@RequiredArgsConstructor
public class SuperAdminStoreController {
    private final SuperAdminStoreService superAdminStoreService;

    //superadmin만 새로운 매장 생성 가능
    @Operation(summary = "새로운 매장 생성", description = "superadmin만 새로운 매장 생성 가능")
    @PostMapping("/create")
    public ResponseEntity<String> createStore(@RequestBody StoreDto storeDto, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.createStore(currentUser, storeDto);
        return ResponseEntity.ok("새로운 매장이 생성되었습니다.");
    }

    //superadmin만 매장 정보 수정 가능
    @Operation(summary = "매장 정보 수정", description = "superadmin만 매장 정보 수정 가능")
    @PatchMapping("/{storeId}/update")
    public ResponseEntity<String> updateStore(Authentication authentication, @PathVariable Long storeId, @RequestBody SuperAdminStoreUpdateDto superAdminStoreUpdateDto) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.updateStore(currentUser, storeId, superAdminStoreUpdateDto);
        return ResponseEntity.ok("매장 정보가 수정되었습니다.");
    }


}
