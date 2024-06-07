package com.mh.green2nd.store.superAdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.store.StoreInfo;
import com.mh.green2nd.user.User;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superadmin/store")
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
    @Operation(summary = "매장 정보 수정", description = "superadmin만 매장 정보 수정 가능, name은 매장 이름(중앙로점, 종로점, 범어점, 경대점, 두류점)")
    @PatchMapping("/{name}/update")
    public ResponseEntity<String> updateStore(Authentication authentication, @PathVariable String name, @RequestBody SuperAdminStoreUpdateDto superAdminStoreUpdateDto) {
        User currentUser = (User) authentication.getPrincipal();
        superAdminStoreService.updateStore(currentUser, name, superAdminStoreUpdateDto);
        return ResponseEntity.ok("매장 정보가 수정되었습니다.");
    }

    // Superadmin만 모든 매장 조회 가능
    @Operation(summary = "모든 매장 조회", description = "superadmin만 모든 매장 조회 가능")
    @GetMapping("/allStores")
    public ResponseEntity<List<Store>> getAllStores(Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        List<Store> stores = superAdminStoreService.getAllStores(currentUser);
        return ResponseEntity.ok(stores);
    }

    // Superadmin만 매장 상세 정보 조회 가능
    @Operation(summary = "매장 상세 정보 조회", description = "superadmin만 매장 상세 정보 조회 가능, name은 매장 이름(중앙로점, 종로점, 범어점, 경대점, 두류점)")
    @GetMapping("/storeDetails/{name}")
    public ResponseEntity<StoreInfo> getStoreDetails(Authentication authentication, @PathVariable String name) {
        User currentUser = (User) authentication.getPrincipal();
        StoreInfo storeInfo = superAdminStoreService.getStoreInfo(currentUser, name);
        return ResponseEntity.ok(storeInfo);
    }


}
