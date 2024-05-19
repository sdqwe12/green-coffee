package com.mh.green2nd.store.AdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminStoreService {

    private final AdminStoreRepository adminStoreRepository;

    public Store updateStoreStatus(User user, Long storeId, String status) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store status");
        }
        Store store = adminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setStatus(status);
        return adminStoreRepository.save(store);
    }

    public Store updateStoreAddress(User user, Long storeId, String address) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store address");
        }
        Store store = adminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setAddress(address);
        return adminStoreRepository.save(store);
    }

    public Store updateStorePhoneNumber(User user, Long storeId, String phoneNumber) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store phone number");
        }
        Store store = adminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setPhone(phoneNumber);
        return adminStoreRepository.save(store);
    }

    public Store updateStoreHoliday(User user, Long storeId, String holiday) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store holiday");
        }
        Store store = adminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setHoliday(holiday);
        return adminStoreRepository.save(store);
    }

    public Store updateStoreOperatingHours(User user, Long storeId, String open, String close) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store operating hours");
        }
        Store store = adminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setOpen(open);
        store.setClose(close);
        return adminStoreRepository.save(store);
    }
}