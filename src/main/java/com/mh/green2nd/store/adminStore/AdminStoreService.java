package com.mh.green2nd.store.adminStore;

import com.mh.green2nd.store.Store;
import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.store.StoreRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminStoreService {

    private final StoreRepository storeRepository;

    // admin는 자신이 속한 매장 조회 가능
    public StoreDto getStore(User user) {
        Store store = storeRepository.findByUser(user).orElseThrow(() -> new RuntimeException("Store not found"));
        return new StoreDto(store);
    }

    // admin만 매장 영업시간 수정 가능
    public Store updateStoreTime(User user, Long storeId, String open, String close) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("admins만 매장 영업시간 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setOpen(open);
        store.setClose(close);
        return storeRepository.save(store);
    }

    // admin만 휴무일 수정 가능
    public Store updateStoreHoliday(User user, Long storeId, String holiday) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("admins만 휴무일 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setHoliday(holiday);
        return storeRepository.save(store);
    }




}
