package com.mh.green2nd.store.adminStore;

import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store/admin")
@RequiredArgsConstructor
public class AdminStoreController {
    private final AdminStoreService adminStoreService;

    // admin만 매장 영업시간 수정 가능
    @Operation(summary = "매장 영업시간 수정", description = "admin만 매장 영업시간 수정 가능")
    @PutMapping("/{storeId}/time")
    public ResponseEntity<String> updateStoreTime(@PathVariable Long storeId, @RequestBody StoreDto storeDto, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreTime(currentUser, storeId, storeDto);
        return ResponseEntity.ok("매장 영업시간이 수정되었습니다.");
    }

    // admin만 휴무일 수정 가능
    @Operation(summary = "매장 휴무일 수정", description = "admin만 휴무일 수정 가능")
    @PutMapping("/{storeId}/holiday")
    public ResponseEntity<String> updateStoreHoliday(@PathVariable Long storeId, @RequestBody String holiday, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        adminStoreService.updateStoreHoliday(currentUser, storeId, holiday);
        return ResponseEntity.ok("매장 휴무일이 수정되었습니다.");
    }




}



