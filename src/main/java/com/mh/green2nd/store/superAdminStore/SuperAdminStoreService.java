package com.mh.green2nd.store.superAdminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.store.StoreRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SuperAdminStoreService {

    private final StoreRepository storeRepository;

    // superadmin만 새로운 매장 생성 가능
    public Store createStore(User user, StoreDto storeDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can create store");
        }
        Store store = new Store();
        store.setName(storeDto.getName());
        store.setAddress(storeDto.getAddress());
        store.setPhone(storeDto.getPhone());
        store.setOpen(storeDto.getOpen());
        store.setClose(storeDto.getClose());
        store.setHoliday(storeDto.getHoliday());
        store.setStatus(storeDto.getStatus());
        return storeRepository.save(store);
    }

    // superadmin만 매장 이름 수정 가능
    public Store updateStoreName(User user, Long storeId, String name) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("superadmins만 매장 이름 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(name);
        return storeRepository.save(store);
    }

    // superadmin만 매장 주소 수정 가능
    public Store updateStoreAddress(User user, Long storeId, String address) {
        if (user.getRole() != Role.SUPERADMIN && user.getRole() != Role.ADMIN) {
            throw new RuntimeException("superadmins와 admins만 매장 주소 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setAddress(address);
        return storeRepository.save(store);
    }

    // superadmin만 매장 전화번호 수정 가능
    public Store updateStorePhoneNumber(User user, Long storeId, String phoneNumber) {
        if (user.getRole() != Role.SUPERADMIN && user.getRole() != Role.ADMIN) {
            throw new RuntimeException("superadmins와 admins만 매장 전화번호 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setPhone(phoneNumber);
        return storeRepository.save(store);
    }






}
