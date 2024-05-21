package com.mh.green2nd.store;

import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StoreService {

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
            throw new RuntimeException("Only superadmins can update store name");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setName(name);
        return storeRepository.save(store);
    }

    // superadmin과 admin 모두 매장 주소 수정 가능
    public Store updateStoreAddress(User user, Long storeId, String address) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update store address");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setAddress(address);
        return storeRepository.save(store);
    }

    // superadmin과 admin 모두 매장 전화번호 수정 가능
    public Store updateStorePhoneNumber(User user, Long storeId, String phoneNumber) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update store phone number");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setPhone(phoneNumber);
        return storeRepository.save(store);
    }

    // admin만 매장 영업시간 수정 가능
    public Store updateStoreTime(User user, Long storeId, StoreDto storeDto) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store time");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setOpen(storeDto.getOpen());
        store.setClose(storeDto.getClose());
        store.setHoliday(storeDto.getHoliday());
        return storeRepository.save(store);
    }

    // admin만 휴무일 수정 가능
    public Store updateStoreHoliday(User user, Long storeId, String holiday) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Only admins can update store holiday");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setHoliday(holiday);
        return storeRepository.save(store);
    }
}