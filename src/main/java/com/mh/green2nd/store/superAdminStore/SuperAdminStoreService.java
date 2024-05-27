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

    // superadmin만 매장 정보 수정 가능
    public Store updateStore(User user, Long storeId, SuperAdminStoreUpdateDto superAdminStoreUpdateDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update stores");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
<<<<<<< HEAD

        if (superAdminStoreUpdateDto.getName() != null) {
            store.setName(superAdminStoreUpdateDto.getName());
        }
        if (superAdminStoreUpdateDto.getAddress() != null) {
            store.setAddress(superAdminStoreUpdateDto.getAddress());
        }
        if (superAdminStoreUpdateDto.getPhone() != null) {
            store.setPhone(superAdminStoreUpdateDto.getPhone());
        }
        if (superAdminStoreUpdateDto.getAdminName() != null) {
            store.setAdminName(superAdminStoreUpdateDto.getAdminName());
        }

        return storeRepository.save(store);
=======

        if (superAdminStoreUpdateDto.getName() != null) {
            store.setName(superAdminStoreUpdateDto.getName());
        }
        if (superAdminStoreUpdateDto.getAddress() != null) {
            store.setAddress(superAdminStoreUpdateDto.getAddress());
        }
        if (superAdminStoreUpdateDto.getPhone() != null) {
            store.setPhone(superAdminStoreUpdateDto.getPhone());
        }
        if (superAdminStoreUpdateDto.getAdminName() != null) {
            store.setAdminName(superAdminStoreUpdateDto.getAdminName());
        }

        return storeRepository.save(store);
    }

    // superadmin만 매장 정보 조회 가능
    public void getStoreInfo(User user, Long storeId) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can get store info");
        }
>>>>>>> jc
    }






}
