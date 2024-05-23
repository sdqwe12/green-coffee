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

    // admin만 매장 영업시간 수정 가능
    public Store updateStoreTime(User user, Long storeId, StoreDto storeDto) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("admins만 매장 영업시간 수정 가능");
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
            throw new RuntimeException("admins만 휴무일 수정 가능");
        }
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        store.setHoliday(holiday);
        return storeRepository.save(store);
    }




}
