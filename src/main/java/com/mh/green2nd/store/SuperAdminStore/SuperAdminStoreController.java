package com.mh.green2nd.store.SuperAdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/superadmin/store")
@RequiredArgsConstructor
public class SuperAdminStoreController {

    private final SuperAdminStoreService superAdminStoreService;

    @PutMapping("/{storeId}/name")
    public Store updateStoreName(@PathVariable Long storeId, @RequestBody String name, @ModelAttribute User user) {
        return superAdminStoreService.updateStoreName(user, storeId, name);
    }

    @PutMapping("/{storeId}/address")
    public Store updateStoreAddress(@PathVariable Long storeId, @RequestBody String address, @ModelAttribute User user) {
        return superAdminStoreService.updateStoreAddress(user, storeId, address);
    }

    @PutMapping("/{storeId}/phone")
    public Store updateStorePhoneNumber(@PathVariable Long storeId, @RequestBody String phoneNumber, @ModelAttribute User user) {
        return superAdminStoreService.updateStorePhoneNumber(user, storeId, phoneNumber);
    }

}