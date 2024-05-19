package com.mh.green2nd.store.SuperAdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SuperAdminStoreService {

    private final SuperAdminStoreRepository superAdminStoreRepository;

    public Store updateStoreName(User user, Long storeId, String name) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only superadmins can update store name");
        }
        Store store = superAdminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(name);
        return superAdminStoreRepository.save(store);
    }

    public Store updateStoreAddress(User user, Long storeId, String address) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only superadmins can update store address");
        }
        Store store = superAdminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setAddress(address);
        return superAdminStoreRepository.save(store);
    }

    public Store updateStorePhoneNumber(User user, Long storeId, String phoneNumber) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only superadmins can update store phone number");
        }
        Store store = superAdminStoreRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setPhone(phoneNumber);
        return superAdminStoreRepository.save(store);
    }

}