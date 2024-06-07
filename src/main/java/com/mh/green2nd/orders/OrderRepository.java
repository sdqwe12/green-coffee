package com.mh.green2nd.orders;

import com.mh.green2nd.store.Store;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o JOIN FETCH o.user u WHERE u.user_id = :userId")
    List<Order> findByUserIdWithUser(@Param("userId") Long userId);

    List<Order> findByStoreName(String name);

    List<Order> findByStoreOrderByCreatedAtAsc(Store store);

    Optional<Order> findFirstByStoreAndStateOrderByCreatedAtAsc(Store store, OrderState state);

    Long countByStoreAndState(Store store, OrderState state);


}