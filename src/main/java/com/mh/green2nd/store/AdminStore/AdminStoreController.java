package com.mh.green2nd.store.AdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/store")
@RequiredArgsConstructor
public class AdminStoreController {

    private final AdminStoreService adminStoreService;

    @PutMapping("/{storeId}/status")
    public Store updateStoreStatus(@PathVariable Long storeId, @RequestBody String status, @ModelAttribute User user) {
        return adminStoreService.updateStoreStatus(user, storeId, status);
    }

    @PutMapping("/{storeId}/address")
    public Store updateStoreAddress(@PathVariable Long storeId, @RequestBody String address, @ModelAttribute User user) {
        return adminStoreService.updateStoreAddress(user, storeId, address);
    }

    @PutMapping("/{storeId}/phone")
    public Store updateStorePhoneNumber(@PathVariable Long storeId, @RequestBody String phoneNumber, @ModelAttribute User user) {
        return adminStoreService.updateStorePhoneNumber(user, storeId, phoneNumber);
    }

    @PutMapping("/{storeId}/holiday")
    public Store updateStoreHoliday(@PathVariable Long storeId, @RequestBody String holiday, @ModelAttribute User user) {
        return adminStoreService.updateStoreHoliday(user, storeId, holiday);
    }

    @PutMapping("/{storeId}/hours")
    public Store updateStoreOperatingHours(@PathVariable Long storeId, @RequestBody String open, @RequestBody String close, @ModelAttribute User user) {
        return adminStoreService.updateStoreOperatingHours(user, storeId, open, close);
    }
}