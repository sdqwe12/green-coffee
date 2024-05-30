package com.mh.green2nd.store.superAdminStore;

import com.mh.green2nd.orders.Order;
import com.mh.green2nd.orders.OrderRepository;
import com.mh.green2nd.store.Store;
import com.mh.green2nd.store.StoreDto;
import com.mh.green2nd.store.StoreRepository;
import com.mh.green2nd.user.Role;
import com.mh.green2nd.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SuperAdminStoreService {

    private final OrderRepository orderRepository;

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
    public Store updateStore(User user, String name, SuperAdminStoreUpdateDto superAdminStoreUpdateDto) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can update stores");
        }
        Store store = storeRepository.findByName(name).orElseThrow(() -> new RuntimeException("Store not found"));
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


    // Superadmin만 모든 매장 조회 가능
    public List<Store> getAllStores(User user) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can get all stores");
        }
        return storeRepository.findAll();
    }

    // Superadmin만 매장 상세 정보 조회 가능
    public StoreInfo getStoreInfo(User user, String name) {
        if (user.getRole() != Role.SUPERADMIN) {
            throw new RuntimeException("Only superadmins can get store info");
        }

        Store store = storeRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Store not found"));

        List<Order> orders = orderRepository.findByStoreName(store.getName());
        Map<LocalDate, Double> salesInfo = orders.stream()
                .collect(Collectors.groupingBy(
                        order -> order.getCreate_date().toLocalDate(),
                        Collectors.reducing(
                                0.0,
                                Order::getTotalOrderPrice,
                                Double::sum
                        )
                ));

        return new StoreInfo(store.getName(), store.getAddress(), store.getPhone(), store.getOpen(), store.getClose(), store.getHoliday(), store.getStatus(), store.getAdminName(), salesInfo);
    }

}
